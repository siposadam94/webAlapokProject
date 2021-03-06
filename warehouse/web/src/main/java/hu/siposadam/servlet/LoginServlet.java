package hu.siposadam.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginHandler")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(name) && "password".equals(password)) {
            request.getSession().setAttribute("authenticated", Boolean.TRUE);

            response.sendRedirect("secured/profile.html");
            return;
        }
        response.sendRedirect("login.html");
    }
}
