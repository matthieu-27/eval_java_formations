package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {

    private static String url = "jdbc:mysql://localhost:3306/buymy_course";

    private static String user = "tp_java";

    private static String password = "java8";

    private static Connection connect;

    public static Connection getInstance() {
        try {
            connect = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace(); // Call to 'printStackTrace()' should probably be replaced with more robust logging
        }
        return connect;
    }
}
