package org.example;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class PossibleSQLInjections {

    public static void queryWithPossibleSQLInjectionSelectStmt(String username) throws SQLException {

        Connection connection = ConnectionManagement.getConn();
        String query = "SELECT * FROM users where user_name = '" + username + "'";
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        while (resultSet.next()) {
            String userName = resultSet.getString("user_name");
            String emailCol = resultSet.getString("email");
            System.out.println("Username: " + userName);
            System.out.println("Email: " + emailCol);
        }
    }

    public static void queryWithPossibleSQLInjectionUpdateStmt(String username, String email) throws SQLException {

        Connection connection = ConnectionManagement.getConn();
        String query = "update users set email='" + email + "' where user_name='" + username + "';";
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);

//        while (resultSet.next()) {
//            String userName = resultSet.getString("user_name");
//            String emailCol = resultSet.getString("email");
//            System.out.println("Username: " + userName);
//            System.out.println("Email: " + emailCol);
//        }
    }

}
