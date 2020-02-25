package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection connect;
    private final String url = "jdbc.postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "tilly";

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgres.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return conn;
    }
}