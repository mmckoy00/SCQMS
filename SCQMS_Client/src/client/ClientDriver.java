package client;

import java.io.IOException;
import java.rmi.UnknownHostException;

import javax.swing.JOptionPane;

import frames.Dash;
import frames.Login;
import frames.Registration;
import model.User;

public class ClientDriver {

	public static void main(String[] args) {
		Login login = null;
		Dash dash = null;
		
		Registration signUp = null;
		try {
			Client client = new Client();
			login = new Login(client);
			login.setVisible(true);
		} catch(UnknownHostException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "SERVER DOWN ", "Server Status", JOptionPane.ERROR_MESSAGE);

		}
	}

}
