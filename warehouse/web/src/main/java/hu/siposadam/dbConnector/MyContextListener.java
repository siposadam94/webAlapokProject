package hu.siposadam.dbConnector;

import org.apache.ibatis.jdbc.ScriptRunner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;
import java.sql.Connection;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection connection = JDBCConnector.createConnection();
        ScriptRunner sr = new ScriptRunner(connection);
        try (Reader reader = new BufferedReader(new FileReader("c:\\Users\\Adam\\Desktop\\init_improved.sql"))) {
            sr.runScript(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
