package iuh.fit.Controller;

import iuh.fit.Dao.ProductDAO;
import iuh.fit.Models.Product;
import iuh.fit.Models.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        @SuppressWarnings("unchecked")
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        String action = req.getParameter("action");
        String idStr = req.getParameter("id");
        if (action == null) {
            req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
            return;
        }

        switch (action) {
            case "add" -> {
                int id = Integer.parseInt(idStr);
                Product p = productDAO.findById(id);
                if (p != null) addToCart(session, p);
                resp.sendRedirect(req.getContextPath() + "/cart");
                return;
            }
            case "remove" -> {
                int id = Integer.parseInt(idStr);
                removeFromCart(session, id);
                resp.sendRedirect(req.getContextPath() + "/cart");
                return;
            }
            case "decrease" -> {
                int id = Integer.parseInt(idStr);
                decreaseQuantity(session, id);
                resp.sendRedirect(req.getContextPath() + "/cart");
                return;
            }
            case "clear" -> {
                session.removeAttribute("cart");
                resp.sendRedirect(req.getContextPath() + "/cart");
                return;
            }
        }


        req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
    }

    private void addToCart(HttpSession session, Product p) {
        @SuppressWarnings("unchecked")
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        List<CartItem> finalCart = cart;
        cart.stream()
                .filter(it -> it.getProductId() == p.getId())
                .findFirst()
                .ifPresentOrElse(
                        it -> it.setQuantity(it.getQuantity() + 1),
                        () -> finalCart.add(new CartItem(p.getId(), p.getName(), p.getPrice(), 1))
                );
    }

    private void removeFromCart(HttpSession session, int productId) {
        @SuppressWarnings("unchecked")
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(it -> it.getProductId() == productId);
        }
    }

    private void decreaseQuantity(HttpSession session, int productId) {
        @SuppressWarnings("unchecked")
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.stream()
                    .filter(it -> it.getProductId() == productId)
                    .findFirst()
                    .ifPresent(it -> {
                        int q = it.getQuantity() - 1;
                        if (q <= 0) cart.remove(it);
                        else it.setQuantity(q);
                    });
        }
    }

}
