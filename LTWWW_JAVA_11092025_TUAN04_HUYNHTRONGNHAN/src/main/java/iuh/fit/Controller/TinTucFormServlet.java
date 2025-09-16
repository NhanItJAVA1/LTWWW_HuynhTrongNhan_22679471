package iuh.fit.Controller;

import iuh.fit.Dao.DanhMucDAO;
import iuh.fit.Dao.TinTucDAO;
import iuh.fit.Models.TinTuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/themtintuc")
public class TinTucFormServlet extends HttpServlet {
    private TinTucDAO tinTucDAO = new TinTucDAO();
    private DanhMucDAO danhMucDAO = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhmucList", danhMucDAO.findAll());
        req.getRequestDispatcher("/views/TinTucForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tieuDe = req.getParameter("tieuDe");
        String noiDung = req.getParameter("noiDung");
        String lienKet = req.getParameter("lienKet");
        int maDM = Integer.parseInt(req.getParameter("maDM"));

        TinTuc t = new TinTuc();
        t.setTieuDe(tieuDe);
        t.setNoiDungTT(noiDung);
        t.setLienKet(lienKet);
        t.setDanhMuc(danhMucDAO.findById(maDM));

        tinTucDAO.save(t);
        resp.sendRedirect(req.getContextPath() + "/danhmuc?maDM=" + maDM);
    }
}

