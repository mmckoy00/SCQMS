//Mattania Mckoy 1704278
// Onieka
package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import client.Client;
import model.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField userPassword;
	private Client client1;


	public Login(Client client) {
		setResizable(false);
		setTitle("LOGIN");
	   this.client1 = client;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 677, 414);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 64, 64));
		panel.setBounds(258, 0, 403, 375);
		contentPane.add(panel);
		panel.setLayout(null);
		
		userName = new JTextField();
		userName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		userName.setForeground(Color.WHITE);
		userName.setBackground(Color.DARK_GRAY);
		userName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		userName.setBounds(109, 146, 201, 44);
		panel.add(userName);
		userName.setColumns(10);
		
		JLabel idIcon = new JLabel("");
		idIcon.setIcon(new ImageIcon(Login.class.getResource("/images/icons8_Account_50px.png")));
		idIcon.setBounds(22, 145, 45, 44);
		panel.add(idIcon);
		
		JLabel lockIcon = new JLabel("");
		lockIcon.setIcon(new ImageIcon(Login.class.getResource("/images/icons8_Secure_50px.png")));
		lockIcon.setBounds(22, 221, 58, 60);
		panel.add(lockIcon);
		
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String id = userName.getText();
				String password = String.valueOf(userPassword.getPassword()) ;
				
				if(!id.isEmpty() && !password.isEmpty()) { 
					client1.sendCommand("login");
					client1.loginCredentials(id, password);
					User user = null;
					try {
						user = client1.loginResponse();
						
						if(user.getUserRole() == null) {
							JOptionPane.showMessageDialog(login, "ID or Password is incorrect");
							dispose();
							Login login = new Login(new Client());
							login.setVisible(true);
						}
						
						setVisible(false);
						
						switch(user.getUserRole()) {
						case STUDENT:
							new Dash("STUDENT",user, new Client());
							break;
						case ADVISOR:
							new Dash("ADVISOR",user, new Client());
							break;
						case SUPERVISOR:
							new Dash("SUPERVIOSR",user, new Client());
							break;
					 }
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(login, e1.getMessage());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(login, e1.getMessage());
					}	
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Id and password cannot be empty", "Login", JOptionPane.WARNING_MESSAGE);
				}	
			}
		});
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		login.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		login.setBackground(new Color(123, 104, 238));
		login.setBounds(135, 317, 135, 35);
		panel.add(login);
		
		JLabel lblNewLabel_3 = new JLabel("South Regional University");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel_3.setBounds(81, 26, 254, 35);
		panel.add(lblNewLabel_3);
		
		JLabel title = new JLabel("Student Management System");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		title.setBounds(56, 59, 302, 35);
		panel.add(title);
		
		userPassword = new JPasswordField();
		userPassword.setForeground(Color.WHITE);
		userPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		userPassword.setBackground(Color.DARK_GRAY);
		userPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		userPassword.setBounds(109, 234, 201, 35);
		panel.add(userPassword);
		

		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(-88, -165, 339, 540);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/images/loginPage.PNG")));
	
   }
	
	
}