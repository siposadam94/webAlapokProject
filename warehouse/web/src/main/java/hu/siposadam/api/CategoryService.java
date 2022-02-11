package hu.siposadam.api;

import hu.siposadam.dao.CategoryDAO;
import hu.siposadam.entity.Category;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/CategoryService")
public class CategoryService {

    CategoryDAO categoryDAO = new CategoryDAO();

    @GET
    @Path("/getCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getProducts(
    ) {
        return categoryDAO.getAll();

    }
}

