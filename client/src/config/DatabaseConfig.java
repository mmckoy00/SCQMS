package config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DatabaseConfig {
    public static void main(String[] args){
        final String PASSWORD = "@7235Ma@@";
        final String USER = "root";
        final String URL = "jdbc:mysql://localhost:3309/cqmsDB";
        try{
            Connection con = getConnection(URL, USER, PASSWORD);
            if(con!=null){
                JOptionPane.showMessageDialog(null,"Connection Established");
                System.out.println("Connection Established!");
            }
        }catch(SQLException e){
            System.out.println("Connection Not Established because "+e.getMessage());
        }
    }
}
