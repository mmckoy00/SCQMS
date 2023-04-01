package server;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import static java.sql.DriverManager.getConnection;

public class DatabaseConfiguration {
	private static Connection conn = null;
	
	public static Connection getDBConnection() {
        final String PASSWORD = "@7235Ma@@";
        final String USER = "root";
        final String URL = "jdbc:mysql://localhost:3306/cqms_db";
        
        try {
        	if(conn == null) {
        		conn =  getConnection(URL, USER, PASSWORD);
        		System.out.println("Connection Established");
        	}
        }catch(SQLException e) {
        	System.out.println("Connection Not Established");
        	e.printStackTrace();
        }
        return conn;
	}
	
}

