import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlTest {

    private static final String USERNAME = "yasiru";
    private static final String PASSWORD = "randompassword";
    private static final String CONN = "jdbc:mysql://localhost";
    private static final Logger LOG = LoggerFactory.getLogger(MySqlTest.class);

    @Test
    public void testConnection ()  {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONN,USERNAME,PASSWORD);
            System.out.println("Successfully connected");
        } catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if(connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                  System.out.println(e);
                }
            }
        }

    }
}
