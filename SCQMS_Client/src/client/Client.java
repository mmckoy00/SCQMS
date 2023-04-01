//Mattania Mckoy 1704278
package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import frames.Dash;
import frames.Login;
import model.Advisor;
import model.Entry;
import model.Student;
import model.Supervisor;
import model.User;

public class Client {
	private Socket connection = null;
	private ObjectInputStream fromServer = null;
	private ObjectOutputStream toServer = null;
	private String action =null;
	
	
	public Client() throws IOException {
		this.start(); 
		this.initializeStreams();
	}
	
	private void start() throws UnknownHostException, IOException {
			this.connection = new Socket("127.0.0.1", 8888);
	}
	
	
	private void closeConnection() {
		try {
			fromServer.close();
			toServer.close();
			connection.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void initializeStreams() throws IOException {
			if(connection != null) {
				this.toServer = new ObjectOutputStream(connection.getOutputStream());
				this.fromServer = new ObjectInputStream(this.connection.getInputStream());
			  }
			
	}
	
	public void sendCommand(String action) {
		this.action = action;
		try {
			toServer.writeObject(this.action);
			JOptionPane.showMessageDialog(null, "SENT :"+action);
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN line 59", "Server Status", JOptionPane.ERROR_MESSAGE);
			System.out.println("Good bye");
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN line 63", "Server Status", JOptionPane.ERROR_MESSAGE);
			System.out.println("Good bye");
			closeConnection();
		}
	}
	
	public void loginCredentials(String id, String password) {
		try {
			toServer.writeObject(id);
			toServer.flush();
			toServer.writeObject(password);
			toServer.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN line 76 ", "Server Status", JOptionPane.ERROR_MESSAGE);
			System.out.println("Good bye");
			closeConnection();
		}
	}
	
	public void addStudent(Student student) {
		try {
			toServer.writeObject(student);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN line 86", "Server Status", JOptionPane.ERROR_MESSAGE);
			System.out.println("Good bye");
			e.printStackTrace();
		}
	}
	
	public void addAdvisor(Advisor advisor) {
		try {
			toServer.writeObject(advisor);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN line 98", "Server Status", JOptionPane.ERROR_MESSAGE);
			System.out.println("Good bye");
			e.printStackTrace();
		}
	}
	
	public void addSupervisor(Supervisor supervisor) {
		try {
			toServer.writeObject(supervisor);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN line 108", "Server Status", JOptionPane.ERROR_MESSAGE);
			System.out.println("Good bye");
			e.printStackTrace();
		}
	}
	
	public void studentResponse() {
		try {
			boolean response = (boolean) fromServer.readObject();
			if(response == true) {
				JOptionPane.showMessageDialog(null, "Successfully", "User Status", JOptionPane.OK_OPTION);
			}else {
				JOptionPane.showMessageDialog(null, "UnSuccessfully","User Status", JOptionPane.WARNING_MESSAGE);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void advisorResponse() {
		try {
			boolean response = (boolean) fromServer.readObject();
			if(response == true) {
				JOptionPane.showMessageDialog(null, "Successfully", "User Status", JOptionPane.OK_OPTION);
			}else {
				JOptionPane.showMessageDialog(null, "UnSuccessfully","User Status", JOptionPane.WARNING_MESSAGE);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void supervisorResponse() {
		try {
			boolean response = (boolean) fromServer.readObject();
			if(response == true) {
				JOptionPane.showMessageDialog(null, "Successfully", "User Status", JOptionPane.OK_OPTION);
			}else {
				JOptionPane.showMessageDialog(null, "UnSuccessfully","User Status", JOptionPane.WARNING_MESSAGE);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addEntryInfo(Entry entry) {
		try {
			toServer.writeObject(entry);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN line 97", "Server Status", JOptionPane.ERROR_MESSAGE);
			System.out.println("Good bye");
			e.printStackTrace();
		}
	}
	
	
	public User loginResponse() throws ClassNotFoundException, IOException {
		User response = new Student();
		response = (User) fromServer.readObject();
		return response;
	}
	
	public void addEntryResponse() {
		try {
			boolean response = (boolean) fromServer.readObject();
			if(response == true) {
				JOptionPane.showMessageDialog(null, "Successfully", "Entry Submission", JOptionPane.OK_OPTION);
			}else {
				JOptionPane.showMessageDialog(null, "UnSuccessfully","Entry Submission", JOptionPane.WARNING_MESSAGE);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
