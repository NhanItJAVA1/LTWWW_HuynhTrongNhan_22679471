package iuh.fit.Controller;

import iuh.fit.Dao.TinTucDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/danhmuc")
public class DanhSachTinTucServlet extends HttpServlet {
    private TinTucDAO tinTucDAO = new TinTucDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maDM = req.getParameter("maDM") != null ? Integer.parseInt(req.getParameter("maDM")) : 1;
        req.setAttribute("list", tinTucDAO.findByDanhMuc(maDM));
        req.setAttribute("currentMaDM", maDM);
        req.getRequestDispatcher("/views/DanhSachTinTuc.jsp").forward(req, resp);
    }
}
