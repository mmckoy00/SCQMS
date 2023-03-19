package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Server {
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private static Connection dbCon = null;
	private Statement statement;
	private ResultSet rs = null;
	private Socket connectionSocket;
	private ServerSocket ss;
	
	
	public Server() {
		createConnection();
		configureConnectionStreams();
	}
	
	
	private void createConnection() {
		try {
			ss = new ServerSocket(9000);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	private void configureConnectionStreams() {
		try {
			output = new ObjectOutputStream(connectionSocket.getOutputStream());
			input = new ObjectInputStream(connectionSocket.getInputStream());
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void closeConnectionAndStreams() {
		try {
			output.close();
			input.close();
			connectionSocket.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
