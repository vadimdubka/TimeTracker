package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// возможно, надо убравлять тредами для соединения

public class DBConnection {
    private static Connection connection;

    private DBConnection() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/arrCompany";
                String user = "root";
                String passwd = "int1984";

                Class.forName("com.mysql.jdbc.Driver");

                connection = DriverManager.getConnection(url, user, passwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
