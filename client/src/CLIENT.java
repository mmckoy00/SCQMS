package controller;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.User;

public class Client 
{
	private Socket connectionSocket;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	private String action;
	private Connection uConn;
	private boolean Connected = false;
	
	public Client()
	{
		createConnection();
		ConfigureStreams();
	}
	
	public void createConnection()
	{
		
		try {
			
			//creating socket to connect to the server
			connectionSocket = new Socket("127.0.0.1",8888);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ConfigureStreams()
	{
		try {
			
			//create an input stream to receive data from the server
			objIs = new ObjectInputStream(connectionSocket.getInputStream());
			
			//create an output stream to send data to the server
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//closing streams and connection
	private void CloseConnections()
	{
		try {
			objOs.close();
			objIs.close();
			connectionSocket.close();
		}
		catch(IOException ex)
		{
			System.err.println("Failure Closing Connections \n"); ex.getMessage();
		}
	}
	
	//advising the server of the type of action to be performed
	public void sendAction(String action)
	{
		this.action = action;
		try {
			objOs.writeObject(action);
		}
		catch(IOException io)
		{
			System.err.println("ACTION COULD NOT BE SENT \n");
			io.printStackTrace();
		}
	}
	
	//sendng the student object with the data to be stored to the server
	public void SendAction(String action)
	{
		try {
			objOs.writeObject(action);
		}
		catch(IOException ioe)
		{
			System.err.println("FAILED TO SEND STUDENT OBJECT TO SERVER "); ioe.getMessage();
			ioe.printStackTrace();
		}
	}
	
	public User receiveUser()
	{
		User uObj = new User();
		String action = " ";
		
		 try 
		 {
			//connection to database
			uConn = DriverManager.getConnection("dbc:mysql://localhost:3307", "root","usbw");
			while(true)
			{
				this.ConfigureStreams();
				try 
				{
					action = (String) objIs.readObject();
					if(action.equalsIgnoreCase("Login"))
					{
						boolean flag = (boolean) objIs.readObject();
						if(flag == true)
						{
							uObj = (User) objIs.readObject();
						}
					}
				} 
				catch(ClassNotFoundException cnfe)
				{
					System.err.println("Class can not be accessed");
					cnfe.printStackTrace();
				}
				catch(ClassCastException cce)
				{
					cce.getMessage();
				}
				this.CloseConnections();
			}
		 }
		 catch(EOFException eof)
		{
			eof.getMessage();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uObj;
		
		
	}

	public boolean Connected() {
		return Connected;
	}
	
	public void  setConnected(boolean Connected) {
		this.Connected = Connected;
	}
	
	
}
S