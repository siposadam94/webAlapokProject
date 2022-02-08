package hu.siposadam.api;



import entity.Product;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Path("/ProductService")
public class ProductService {

    @GET
    @Path("/getProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add(
                new Product("Nintendo Switch", "console", "passz", "box",
                        new BigDecimal("110.99"), new BigDecimal("140.99"), "current gen console")
        );
        products.add(
                new Product("Iphone", "iphone", "passz", "box",
                        new BigDecimal("800.99"), new BigDecimal("850.99"), "iphone 12 pro max")
        );
        products.add(
                new Product("Iphone", "iphone", "passz", "box",
                        new BigDecimal("900.99"), new BigDecimal("999.99"), "iphone 13 pro")
        );

        return products;
    }
}
