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

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField userPassword;



	public Login() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 838, 637);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(428, 0, 435, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(107, 176, 139, 44);
		panel.add(lblNewLabel);
		
		userName = new JTextField();
		userName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		userName.setForeground(Color.WHITE);
		userName.setBackground(Color.DARK_GRAY);
		userName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		userName.setBounds(103, 215, 220, 44);
		panel.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/icons8_Account_50px.png")));
		lblNewLabel_1.setBounds(21, 177, 45, 44);
		panel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPassword.setBounds(107, 296, 139, 44);
		panel.add(lblPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(Login.class.getResource("/images/icons8_Secure_50px.png")));
		lblNewLabel_1_1.setBounds(21, 312, 58, 44);
		panel.add(lblNewLabel_1_1);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String id = userName.getText();
				String password = String.valueOf(userPassword.getPassword()) ;
				
				if(!id.isEmpty() && !password.isEmpty()) {
					Client.sendCommand("login");
					Client.sendCredentials(id, password);
				}else {
					JOptionPane.showMessageDialog(contentPane, "Id and password cannot be empty", "Login", JOptionPane.WARNING_MESSAGE);
				}
			}		
			
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setBackground(new Color(123, 104, 238));
		btnNewButton.setBounds(142, 450, 131, 44);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("South Regional University");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(116, 29, 227, 35);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Student Management System");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3_1.setBounds(99, 74, 282, 35);
		panel.add(lblNewLabel_3_1);
		
		userPassword = new JPasswordField();
		userPassword.setForeground(Color.WHITE);
		userPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		userPassword.setBackground(Color.DARK_GRAY);
		userPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		userPassword.setBounds(107, 334, 227, 35);
		panel.add(userPassword);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(-12, 0, 441, 620);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/images/loginPage.PNG")));
	
		
	}

}