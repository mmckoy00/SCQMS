package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JOptionPane;

import exception.ServerDownException;
import frames.Dash;
import frames.Login;
import model.Student;
import model.User;
import model.User.Role;

public class Client {
	private String command = "";
	private ObjectInputStream input;
	private static ObjectOutputStream output;
	private Socket connectionSocket;
	
	
    private void createConnection() throws NullPointerException, SocketException {
    	int serverPort = 8888;
    	try {
    		this.connectionSocket = new Socket("127.0.0.1", serverPort);
    	}catch(IOException e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
    
    private void configureStreams() throws NullPointerException {
    	try {
    		input = new ObjectInputStream(connectionSocket.getInputStream());
    		output = new ObjectOutputStream(connectionSocket.getOutputStream());
    	}catch(IOException e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
    
    private void stop() throws NullPointerException{
    	try {
    		this.input.close();
    		this.output.close();
    		this.connectionSocket.close();
    	}catch(IOException e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
  
 
    public static void sendCommand(String command) throws NullPointerException{
    	try {
    		output.writeObject(command);
    		output.flush();
    		JOptionPane.showMessageDialog(null, "Just sendCommand");
    	}catch(IOException e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
    
    public static void sendCredentials(String id, String password)throws NullPointerException {
    	try {
    		output.writeObject(id);
    		output.flush();
    		output.writeObject(password);
    		output.flush();
    		JOptionPane.showMessageDialog(null, "Just sendCredentials");
    	}catch(IOException e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
    
    
    public void response() throws NullPointerException, SocketException {
    	try {
    	
			String role = (String) input.readObject();
			JOptionPane.showMessageDialog(null, role.toString());
			
			switch(role) {
			case "ADVISOR":
				new Dash("Advisor").setVisible(true);
				break;
				
			case "STUDENT":
				new Dash("Student");
				break;
				
			case "SUPERVISOR":
				new Dash("Supervisor");
				break;
			
			default:
				JOptionPane.showMessageDialog(null, "Incorrect ID or Password!");
			}
			
    
    	}catch(ClassCastException es) {
    		es.printStackTrace();
    	}catch(ClassNotFoundException ex) {
    		ex.printStackTrace();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	finally {
    		stop();
    	}
    	
    }
    
    public static void main(String[] args) {
    	Client client = new Client();
    	try {
    		client.createConnection();
			client.configureStreams();
			new Login();
			client.response();
			
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN", "Server Connection Status", JOptionPane.ERROR_MESSAGE);
		}catch(SocketException e) {
			JOptionPane.showMessageDialog(null, "SERVER RESET"
					+ "", "Server Connection Status", JOptionPane.ERROR_MESSAGE);
		}
    	
    	
    }
}
