package iuh.fit.Controller;

import iuh.fit.Dao.TinTucDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/quanly")
public class QuanLyFormServlet extends HttpServlet {
    private TinTucDAO tinTucDAO = new TinTucDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("allNews", tinTucDAO.findAll());
        req.getRequestDispatcher("/views/QuanLyForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("delete".equals(req.getParameter("action"))) {
            int maTT = Integer.parseInt(req.getParameter("maTT"));
            tinTucDAO.delete(maTT);
        }
        resp.sendRedirect(req.getContextPath() + "/quanly");
    }
}

