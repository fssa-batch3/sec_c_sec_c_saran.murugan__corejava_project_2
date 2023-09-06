package com.fssa.movie.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class GetConnection {

	public static Connection getConnection() {
            Connection con = null;

            String url, userName, passWord;
            
//            url = "jdbc:mysql://Localhost:3306/letz_show";
//            userName = "root";
//            passWord = "123456";
//            


            url = System.getenv("DATABASE_HOST");
            userName = System.getenv("DATABASE_USERNAME");
            passWord = System.getenv("DATABASE_PASSWORD");
        	
         
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, passWord);
            System.out.println("Connected");
            
        } catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database");
        }
        return con;             
    }		
	
}
  