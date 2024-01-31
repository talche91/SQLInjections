package org.example;

import java.sql.*;

public class NoPossibleSQLInjections {

    public static void noPossibleSqlInjectionsSelectStmt(String username) {
        Connection connection = null;
        try {
            connection = ConnectionManagement.getConn();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE user_name =?");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String user_name = resultSet.getString("user_name");
                String email = resultSet.getString("email");
                System.out.println("Username: " + user_name);
                System.out.println("Email: " + email);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void noPossibleSqlInjectionUpdateStmt(String username, String newEmail) {
        Connection connection = null;
        try {
            connection = ConnectionManagement.getConn();
            PreparedStatement preparedStatementUpdate = connection.prepareStatement("update users set email=? where user_name=?;");
            preparedStatementUpdate.setString(1, newEmail);
            preparedStatementUpdate.setString(2, username);

            preparedStatementUpdate.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
