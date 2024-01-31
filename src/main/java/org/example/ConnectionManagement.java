package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManagement {

    public static Connection getConn() throws SQLException {

//        String url = "jdbc:postgresql://localhost/postgres";
//        Properties props = new Properties();
//        props.setProperty("user", "postgres");
//        props.setProperty("password", "postgres");
//        Connection conn = DriverManager.getConnection(url, props);
//        return conn;


        try {
            Class.forName("org.postgresql.Driver");
            String user = "postgres";
            String password = "postgres";
            String url = "jdbc:postgresql://localhost/postgres";
            Connection conn ;
            conn = DriverManager.getConnection(url, user, password);

            return conn;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        Connection conn = DriverManager.getConnection(url);



    }

}
