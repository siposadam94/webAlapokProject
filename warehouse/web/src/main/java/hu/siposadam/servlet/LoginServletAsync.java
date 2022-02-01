package hu.siposadam.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServletAsync", value = "/loginAsync")
public class LoginServletAsync extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String loginInfo = gson.toJson(new LoginInfo(Boolean.FALSE));

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(name) && "password".equals(password)) {
            loginInfo = gson.toJson(new LoginInfo(Boolean.TRUE));
            out.print(gson.toJson(loginInfo));
            out.flush();
            return;
        }

        out.print(gson.toJson(loginInfo));
        out.flush();
    }
}