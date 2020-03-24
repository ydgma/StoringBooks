package DAO;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlTest {

    private static String USERNAME;
    private static  String PASSWORD;
    private static  String CONNURL;
    private static  Logger LOG = LoggerFactory.getLogger(MySqlTest.class);

    private void loadProperties() {
        try (InputStream input = new FileInputStream("src/project.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            USERNAME = prop.getProperty("db.user");
            PASSWORD = prop.getProperty("db.password");
            CONNURL = prop.getProperty("db.url");

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    @Test
    public void testConnection ()  {
        loadProperties();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNURL,USERNAME,PASSWORD);
           LOG.info("Successfully connected");
        } catch (SQLException e) {
            LOG.info("{}",e);
        }
        finally {
            if(connection != null) {
                try {
                    connection.close();
                    LOG.info("Connection closed");
                } catch (SQLException e) {
                  LOG.info("{}",e);
                }
            }
        }

    }
}
