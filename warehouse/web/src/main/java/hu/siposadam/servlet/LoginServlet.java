package hu.siposadam.servlet;

import entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginHandler")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(name) && "password".equals(password)) {

            List<Product> products = new ArrayList<>();
            products.add(
                    new Product("Playstation", "console", "passz", "box",
                            200.99, 289.99, "nextgen console")
            );
            products.add(
                    new Product("Xbox", "console", "passz", "box",
                            189.99, 259.99, "nextgen console")
            );

            HttpSession session = request.getSession();
            session.setAttribute("authenticated", Boolean.TRUE);
            session.setAttribute("products", products);

            response.sendRedirect("secured/products.jsp");
            //response.sendRedirect("secured/profile.html");
            return;
        }

        request.setAttribute("loginError", Boolean.FALSE);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }
}
