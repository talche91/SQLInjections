package org.example;

import java.sql.*;

public class Example {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String user = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://localhost/postgres";
        Connection conn ;
        conn = DriverManager.getConnection(url, user, password);


        CallableStatement hello = conn.prepareCall("{? = call upper( ? ) }");
        hello.registerOutParameter(1, Types.VARCHAR);
        hello.setString(2, "lowercase to uppercase");
        hello.execute();
        String helloString = hello.getString(1);
        System.out.println(helloString);
        hello.close();

//        CallableStatement upperFunc = conn.prepareCall("{CALL hello( ? ) }");
////        upperFunc.registerOutParameter(1, Types.VARCHAR);
//        upperFunc.setString(1, "lowercase to uppercase");
//        upperFunc.execute();
//        String upperCased = upperFunc.getString(1);
//        System.out.println(upperCased);
//        upperFunc.close();


        PreparedStatement preparedStatement = conn.prepareStatement("call changeemail(?,?)");
        preparedStatement.setString(1,"test");
        preparedStatement.setInt(2,1);
        boolean b = preparedStatement.execute();
        System.out.println(b);

    }

}
