package org.example;

import java.sql.*;

public class StoredProcedures {
    /*
    
     */

    public static void callStoredProcedures(int userId, String eMail) {
        Connection connection = null;
        try {
            connection = ConnectionManagement.getConn();

            PreparedStatement preparedStatement = connection.prepareStatement("call changeemail(?,?)");
            preparedStatement.setString(1, eMail);
            preparedStatement.setInt(2, 1);
            preparedStatement.execute();

            PreparedStatement preparedStatementSelect = connection.prepareStatement("SELECT * FROM users WHERE id =?");
            preparedStatementSelect.setInt(1, userId);

            ResultSet resultSet = preparedStatementSelect.executeQuery();

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
}
