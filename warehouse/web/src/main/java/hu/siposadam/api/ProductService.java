package hu.siposadam.api;

import hu.siposadam.dao.ProductDAO;
import hu.siposadam.entity.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ProductService")
public class ProductService {

    ProductDAO productDAO = new ProductDAO();

    @GET
    @Path("/getProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts(
            @QueryParam("category") int category,
            @QueryParam("unit") int unit,
            @DefaultValue("1") @QueryParam("page") int page
    ) {
        return productDAO.getAll(category, unit, page);
    }

    @PUT
    @Path("/addProduct")
    @Consumes()
    @Produces(MediaType.APPLICATION_JSON)
    public void addProduct(Product product) {
         productDAO.addProduct(product);
    }

    @GET
    @Path("/getProductByName")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductByName(
            @QueryParam("name") String name,
            @DefaultValue("1") @QueryParam("page") int page
    ) {
        return productDAO.findByName(name, page);
    }

}

