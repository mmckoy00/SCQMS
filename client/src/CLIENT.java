package frame_view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;


import model.User;

public class GeneralLogin extends JFrame
{
	
	//Class Description: General Login View

		private JPanel contentPane;
		private JPasswordField userPassword; //formally JPasswordField
		private JTextField userName;
		
	//	Client client = new Client();
		User user = new User();
		
		//Default Const.
		public GeneralLogin() 
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(100, 100, 789, 465);
			this.setVisible(true);
			this.setResizable(false);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setBorder(new MatteBorder(3,3,3,3, (new Color(255, 204, 0))));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel topPanel = new JPanel();
			topPanel.setBackground(new Color(0, 0, 153));
			topPanel.setBounds(0, 0, 773, 35);
			contentPane.add(topPanel);
			
			JLabel SystemLabel = new JLabel("Student Management System");
			SystemLabel.setForeground(new Color(255, 204, 0));
			SystemLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			topPanel.add(SystemLabel);
			
			JPanel bottomPanel = new JPanel();
			bottomPanel.setBackground(new Color(0, 0, 153));
			bottomPanel.setBounds(0, 392, 773, 34);
			contentPane.add(bottomPanel);
			bottomPanel.setLayout(null);
			
			/*JLabel userLabel = new JLabel("User:");
			userLabel.setForeground(new Color(0, 0, 0));
			userLabel.setBounds(10, 0, 376, 34);
			userLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			bottomPanel.add(userLabel);
			
			JLabel deptLabel = new JLabel("Role: ");
			deptLabel.setForeground(new Color(0, 0, 0));
			deptLabel.setBounds(386, 0, 386, 34);
			deptLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			bottomPanel.add(deptLabel);*/
			
			JPanel loginPanel = new JPanel();
			loginPanel.setBackground(Color.WHITE);
			loginPanel.setBounds(180, 169, 379, 200);
			contentPane.add(loginPanel);
			loginPanel.setLayout(new GridBagLayout());
			
			
			//userName Label properties
			JLabel user = new JLabel("User Id: ");
			user.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			
			//userName TextField properties
			userName = new JTextField();
			userName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			userName.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
			userName.setColumns(20);
			
			//password label properties
			JLabel password = new JLabel("Password: ");
			password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			
			//passwordfield properties 
			userPassword = new JPasswordField(); 
			userPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			userPassword.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
			userPassword.setColumns(20);
			
			
			JButton login = new JButton("Login");
			login.setFont(new Font("Tahoma", Font.PLAIN, 16));
			login.setForeground(new Color(255, 204, 0));
			login.setBackground(new Color(0, 0, 153));
			
			GridBagConstraints gb = new GridBagConstraints();
			gb.insets = new Insets(10, 10, 15 , 15);
			gb.anchor = GridBagConstraints.LINE_START;
			gb.gridwidth = 4;
			gb.gridx = 0;gb.gridy = 2;loginPanel.add(user,gb);
			gb.gridx = 1;gb.gridy = 2;loginPanel.add(userName, gb);
			
			gb.gridx = 0;gb.gridy = 3;loginPanel.add(password, gb);
			gb.gridx = 1;gb.gridy = 3;loginPanel.add(userPassword, gb);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(10, 20, 15 , 15);
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.gridx = 0;gbc.gridy = 4;loginPanel.add(login, gbc);
			
			//Adding action listener to login button
			/*login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//acceppting an instance of the user class
					User user = new User();
					user.setUserName(userName.getText());
					user.setPassword(userPassword.getText());
					System.out.println("[LOGIN] : Login Credentials Verified.");
					
					//client.setAction("Login");
					client.sendAction("Login");
					client.sendAction(user.getUserName());
					client.sendAction(user.getPassword());
					
					user = client.receiveUser();
					
					if (client.Connected()) 
					{
						user.setUserName(user.getUserName());
						user.setPassword(user.getPassword());
						user.setFirstName(user.getFirstName());
						user.setLastName(user.getLastName());
						user.setUserType(user.getUserType());
						
						if(user.getUserType().equalsIgnoreCase("Student")) 
						{
							StudentDashboardView studentview = new StudentDashboardView(client, user);
							studentview.setVisible(true);
							disposeFrame();
						}
						if(user.getUserType().equalsIgnoreCase("Supervisor")) 
						{
							SupervisorDashboardView supervisorview = new SupervisorDashboardView(client, user);
							supervisorview.setVisible(true);
							disposeFrame();
							
						}
						
						else if(user.getUserType().equalsIgnoreCase("Advisor")) 
						{
							AdvisorDashboardView advisorview = new AdvisorDashboardView(client, user);
							advisorview.setVisible(true);
							disposeFrame();
						}
					}
					else {
						JOptionPane.showMessageDialog(login, "Login Unsuccessful: ID/Password Incorrect.");
					}
				}
			});*/
			
			
			
			JLabel utech = new JLabel("University of Technology");
			utech.setHorizontalAlignment(SwingConstants.CENTER);
			utech.setFont(new Font("Tahoma", Font.BOLD, 30));
			utech.setForeground(new Color(0, 0, 153));
			utech.setBounds(180, 85, 400, 51);
			contentPane.add(utech);

	}
		
		public void disposeFrame() 
		{
			this.setVisible(false);
		}
		
		
		
		
		//main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralLogin frame = new GeneralLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
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
