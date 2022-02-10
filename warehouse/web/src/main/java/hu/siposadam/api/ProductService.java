package hu.siposadam.api;

import entity.ProductCustom;
import hu.siposadam.dbConnector.JDBCConnector;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/ProductService")
public class ProductService {

    @GET
    @Path("/getProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductCustom> getProducts() {
        Connection connection = JDBCConnector.createConnection();
        List<ProductCustom> products = new ArrayList<>();
        ProductCustom tempProduct;

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT");

            while (resultSet.next()) {
                tempProduct = new ProductCustom(
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getString("quantity"),
                        resultSet.getString("unit"),
                        resultSet.getBigDecimal("purchase_price"),
                        resultSet.getBigDecimal("selling_price"),
                        resultSet.getString("description")
                );
                products.add(tempProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @PUT
    @Path("/addProduct")
    public void addProduct() {
        Connection connection = JDBCConnector.createConnection();

        try (Statement statement = connection.createStatement();) {
            statement.executeUpdate("INSERT INTO Product(name, category, quantity, unit, purchase_price, selling_price, description) " +
                    "VALUES('Nintendo', 'console', 'pass', 'box', 110.99, 140.99, 'current gen console' )");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
