package hu.siposadam.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/ProductService/getProducts")
public class ProductService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Product> products = new ArrayList<>();
        products.add(
                new Product("Nintendo Switch", "console", "passz", "box",
                        110.99, 140.99, "current gen console")
        );
        products.add(
                new Product("Iphone", "iphone", "passz", "box",
                        800.99, 899.99, "iphone 12 pro max")
        );
        products.add(
                new Product("Iphone", "iphone", "passz", "box",
                        900.99, 999.99, "iphone 13 pro")
        );

        out.print(gson.toJson(products));
        out.flush();
    }


}
