package hu.siposadam.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = "/secured/*")
public class SecurityFilter extends HttpFilter {

    public static final String AUTHENTICATED = "authenticated";

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (Boolean.TRUE.equals(session.getAttribute(AUTHENTICATED))) {
            chain.doFilter(request, response);
            return;
        }
        response.sendRedirect("../login.html");
    }
}
