package server;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import static java.sql.DriverManager.getConnection;

public class DatabaseConfig {
	private static Connection conn = null;
	
	private static Connection getDBConnection() {
        final String PASSWORD = "@7235Ma@@";
        final String USER = "root";
        final String URL = "jdbc:mysql://localhost:3309/cqmsDB";
        
        try {
        	if(conn == null) {
        		conn =  getConnection(URL, USER, PASSWORD);
        		JOptionPane.showMessageDialog(null, "Connection Established");
        	}
        }catch(SQLException e) {
        	JOptionPane.showMessageDialog(null, "Connection Not Established");
        	e.printStackTrace();
        }
        return conn;
	}
	
}
