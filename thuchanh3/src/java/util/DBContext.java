package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    public Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/housedb";
        String user = "root";
        String pass = "thtung1411";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }
}