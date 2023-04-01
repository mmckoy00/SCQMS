package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import model.Advisor;
import model.Entry;
import model.Student;
import model.Supervisor;
import model.User;
import model.User.Role;



public class Server {
	private Socket client = null;
	private ServerSocket ss = null;
	private ObjectInputStream inputFromClient = null;
	private ObjectOutputStream outputToClient = null;
	private Calendar date;
	private int clientCount;
	
	
	public Server() {
	start();
	}
	
	private void start() {
		int listeningPort = 8888;
		
		try {
			this.ss = new ServerSocket(listeningPort);
			this.date = Calendar.getInstance();
			this.clientCount = 0;
			System.out.println("Server has started at "+date.getTime());
			requests();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN "+e.getMessage(), "Server Status", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void closeConnection() {
		try {
			if (inputFromClient !=null) {
				inputFromClient.close();
			}
			if(outputToClient !=null) {
				outputToClient.close();
			}
			if(client != null) {
				client.close();
			}
			
			ss.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	private void initializeStreams() {
		try {
			this.inputFromClient =
					new ObjectInputStream(client.getInputStream());
			
			this.outputToClient = 
					new ObjectOutputStream(client.getOutputStream());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN "+e.getMessage(), "Server Status", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
  private void requests() {
	  String action = "";
	  User result = null;
	  try {
		  System.out.println("Attempting to connect to client...");
			while(true) {
				
				client = ss.accept();
				System.out.println("Now Connected to client: "+client.getInetAddress());
				this.initializeStreams();
				
				try {
					action = (String) inputFromClient.readObject();
					if(action.equalsIgnoreCase("login")) {
						String id = (String) inputFromClient.readObject();
						String pass = (String) inputFromClient.readObject();
						result = login(id,pass);
						outputToClient.writeObject(result);
						  }
					
					if(action.equalsIgnoreCase("Add Entry")) {
						JOptionPane.showMessageDialog(null, "in add entry");
						Entry entry = (Entry) inputFromClient.readObject();
						boolean entryResult = addEntry(entry);
						outputToClient.writeObject(entryResult);
						JOptionPane.showMessageDialog(null, entryResult);
					}
				}catch(ClassCastException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//this.closeConnection();
			}
		}catch(EOFException e) {
			
		}catch(IOException e) {
			e.printStackTrace();
		}
  }
  

private boolean addEntry(Entry entry) {
	boolean flag = false;
	if(entry !=null) {
	Entry.logNewEntry(entry);
	flag = true;
	}
	return flag;
}
	
 
  private User login(String id, String password) {
	  User user = new Student();
	  try {
		PreparedStatement stmt = DatabaseConfiguration.getDBConnection().prepareStatement("SELECT * FROM users_tbl WHERE id = ? AND password = ?");
		stmt.setString(1, id);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			
		     switch(rs.getString("userRole")) {
		     case "STUDENT":
		    	 user.setId(rs.getString("id"));
				 user.setFirstName(rs.getString("first_name"));
				 user.setLastName(rs.getString("last_name"));
		    	 user.setUserRole(Role.STUDENT);
		    	 break;
		    	 
		     case "ADVISOR":
		    	 user.setId(rs.getString("id"));
				 user.setFirstName(rs.getString("first_name"));
				 user.setLastName(rs.getString("last_name"));
		    	 user.setUserRole(Role.ADVISOR);
		    	 break;
		    	 
		     case "SUPERVISOR":
		    	 user.setId(rs.getString("id"));
				 user.setFirstName(rs.getString("first_name"));
				 user.setLastName(rs.getString("last_name"));
		    	 user.setUserRole(Role.SUPERVISOR);
		    	 break;
		     }
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return user;
	  
  }
}
