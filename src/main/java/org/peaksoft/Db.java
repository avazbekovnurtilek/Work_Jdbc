package org.peaksoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String userName = "postgres";
    private static final String password = "nur0880";

    public static Connection connection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL,userName,password);
            System.out.println("postgresSQL подключен, работай!!!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
