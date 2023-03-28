package server;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Advisor;
import model.Student;
import model.Supervisor;
import model.User;

public class Server{

	private static final long serialVersionUID = 1L;
	private ServerSocket ss;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket clientSocket;
	//private Set<String> activeUsers = new HashSet<String>();
	//private JPanel contentPane;
	//private JLabel lblIcon;
	//private JLabel lblStatusTitle;
	//private static boolean isServerOn = false;
	//private JToggleButton btnStart;
	
	public static void main(String[] args) {
		new Server();
	}
	
	
	public Server(){
		start();
		requests();
		/*setResizable(false);
		setVisible(true);
		setTitle("Server Connection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 188);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStatusTitle = new JLabel("SERVER DOWN");
		lblStatusTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusTitle.setBounds(53, 30, 143, 23);
		contentPane.add(lblStatusTitle);
		
		btnStart = new JToggleButton("Start");
		btnStart.setBackground(SystemColor.activeCaption);
		btnStart.setBounds(136, 68, 89, 23);
		btnStart.addActionListener(e -> toggle());
		contentPane.add(btnStart);
		
		lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(new ImageIcon(Server.class.getResource("/images/off.png")));
		lblIcon.setBounds(230, 34, 46, 14);
		contentPane.add(lblIcon);
*/


		}
	
	/*
	private void toggle() {
		if(isServerOn == false) {
			isServerOn=true;
			btnStart.setText("Stop");
			lblStatusTitle.setText("SERVER RUNNING...");
			lblIcon.setIcon(new ImageIcon(Server.class.getResource("/images/on.png")));
			start();
		}else {
			isServerOn=false;
			btnStart.setText("Start");
			lblStatusTitle.setText("SERVER DOWN");
			lblIcon.setIcon(new ImageIcon(Server.class.getResource("/images/off.png")));
			//stop();
		}
	}
	*/
	private void configureStreams() {
		try {
			input = new ObjectInputStream(clientSocket.getInputStream());
			output = new ObjectOutputStream(clientSocket.getOutputStream());
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Line 111"+e.getMessage());
		}
	}
	
	private void start() {
		int openPort = 8888;
		try {
			ss = new ServerSocket(openPort);
		}catch(IOException ex) {
			JOptionPane.showMessageDialog(null, " line 112 Server Down "+ex.getMessage(), "Server Status", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void stop() {
		try {
			input.close();
			output.close();
			clientSocket.close();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "line 132 "+e.getMessage());
		}
		
	}	
		
	private void requests() {
		String command = "";
		DatabaseConfiguration.getDBConnection();
		try {
			while(true) {
				try {
					this.ss.accept();
					this.configureStreams();
					command = (String) input.readObject();
					
					if(command.equals("login")) {
						String id = (String) input.readObject();
						String pass = (String) input.readObject();
						String result = login(id,pass);
						output.writeObject(result);
						
						//break of loop --> this is just a test
						//break;
					}
					
				}catch(SocketException ex) {
					JOptionPane.showMessageDialog(null, "line 156 Server Down "+ex.getMessage(), "Server Status", JOptionPane.ERROR_MESSAGE);
				}catch(ClassNotFoundException ex) {
					ex.printStackTrace();
				}catch(ClassCastException ex) {
					ex.printStackTrace();
				}
				this.stop();
			}
		}catch(EOFException ex) {
			System.out.println("Client has terminated the connection");
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	private String login(String id, String password) {
		String role = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			stmt = DatabaseConfiguration.getDBConnection()
					.prepareStatement("SELECT userRole FROM users_tbl WHERE id = ? AND password = ?");
			stmt.setString(1,id);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				 role = rs.getString("userRole");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
	        // Close the database connection and release any resources
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	            
	}
		return role;
	}
	
	

	
	 
}
