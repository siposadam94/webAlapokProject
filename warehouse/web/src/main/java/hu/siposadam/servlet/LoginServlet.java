package hu.siposadam.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginHandler")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if ("admin".equals(name) && "pw".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("authenticated", true);

            response.sendRedirect("secured/profile.html");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
