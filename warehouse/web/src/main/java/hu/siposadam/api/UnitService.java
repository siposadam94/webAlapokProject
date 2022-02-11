package hu.siposadam.api;

import hu.siposadam.dao.CategoryDAO;
import hu.siposadam.dao.UnitDAO;
import hu.siposadam.entity.Category;
import hu.siposadam.entity.Unit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/UnitService")
public class UnitService {

    private final UnitDAO unitDAO = new UnitDAO();

    @GET
    @Path("/getUnits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unit> getUnits() {
        return unitDAO.getAll();
    }
}

