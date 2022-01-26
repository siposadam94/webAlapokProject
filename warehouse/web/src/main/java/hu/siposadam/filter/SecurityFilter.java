package hu.siposadam.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = "/secured/*")
public class SecurityFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        if (session.getAttribute("authenticated") != null) {
            Boolean authenticated = (Boolean) session.getAttribute("authenticated");

            if (authenticated) {
                chain.doFilter(request, response);
            } else {
                httpResponse.sendRedirect("../login.html");
            }
        } else {
            httpResponse.sendRedirect("../login.html");
        }

    }
}