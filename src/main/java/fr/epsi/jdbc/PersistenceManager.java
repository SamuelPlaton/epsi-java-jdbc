package fr.epsi.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PersistenceManager {
    /*private static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/compta";
    private static final String DB_USER_LOGIN = "root";
    private static final String DB_USER_PASSWORD = "";*/

    private static Connection connection;
    private PersistenceManager() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || !connection.isValid(2)){
            Properties props = new Properties();
            ResourceBundle bundle = ResourceBundle.getBundle("db");

            String url = bundle.getString("db.url");
            String user = bundle.getString("db.user");
            String password = bundle.getString("db.password");
            connection = DriverManager.getConnection(url, user, password);

        }
        return connection;
    }

    public static Connection closeConnection() throws SQLException {
        if (connection != null || connection.isValid(2)){
            connection.close();
        }
        return connection;
    }
}
