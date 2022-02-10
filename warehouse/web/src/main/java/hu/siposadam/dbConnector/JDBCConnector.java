package hu.siposadam.dbConnector;

import java.sql.*;

public class JDBCConnector {

    private static final String DB_URL = "jdbc:h2:mem:product";
    private static final String USER = "sa";
    private static final String PASS = "sa";

    public static Connection createConnection() {
        //Try with resource esetleg?
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
