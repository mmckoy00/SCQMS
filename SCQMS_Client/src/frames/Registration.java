package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.Client;
import model.Advisor;
import model.Student;
import model.Supervisor;
import model.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;


//import model.Supervisor;
//import model.User;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;


public class Registration extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFieldFirstName;
	private JTextField txtFieldLastName;
	private JTextField txtFieldID;
	private JTextField txtFieldPassword;
	private JTextField txtFieldEmail;
	private JComboBox<User.Role> comboBox;
	private JLabel lblEmail;
	private JLabel lblBg, lblID, lblFirstName, lblRole, lblLastName, lblPassword, lblNewLabel,  lblContact;
	private JButton btnCancel, btnSignUp;
	private JLabel lblTitle2;
	private JPanel panel;
	private JTextField txtFieldContact;
	



	public Registration(Client client)  {
		
		//FRAME
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		//ID
		lblID = new JLabel("ID No.");
		lblID.setForeground(UIManager.getColor("Button.highlight"));
		lblID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblID.setBounds(306, 60, 56, 14);
		txtFieldID = new JTextField();
		txtFieldID.setSelectedTextColor(Color.BLACK);
		txtFieldID.setBackground(Color.WHITE);
		txtFieldID.setForeground(Color.BLACK);
		txtFieldID.setBounds(306, 85, 115, 20);
		txtFieldID.setColumns(10);

		//ROLE
		lblRole = new JLabel("I am a");
		lblRole.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRole.setForeground(Color.WHITE);
		lblRole.setBounds(465, 196, 50, 14);
		comboBox = new JComboBox<User.Role>();
		comboBox.setBounds(463, 213, 92, 20);
		comboBox.setModel(new DefaultComboBoxModel<User.Role>(User.Role.values()));
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new RoleComboxListener());

		//FIRST NAME
		lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(306, 131, 76, 14);
		txtFieldFirstName = new JTextField();
		txtFieldFirstName.setBounds(306, 148, 115, 20);
		txtFieldFirstName.setColumns(10);

		//LAST NAME
		lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(458, 132, 69, 14);
		txtFieldLastName = new JTextField();
		txtFieldLastName.setBounds(458, 149, 115, 20);
		txtFieldLastName.setColumns(10);

		//PASSWORD
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(304, 194, 76, 14);
		txtFieldPassword = new JTextField();
		txtFieldPassword.setBounds(304, 215, 115, 20);
		txtFieldPassword.setColumns(10);

		//BUTTONS
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(468, 410, 83, 23);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp(client);
			}
		});
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnCancel.setBounds(320, 411, 83, 23);
		
		//EMAIL
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(306, 263, 56, 14);
		txtFieldEmail = new JTextField();
		txtFieldEmail.setBounds(303, 280, 155, 20);
		txtFieldEmail.setText("");
		txtFieldEmail.setColumns(10);

		
		
		//CREATE ACCOUNT LABEL
	   lblNewLabel= new JLabel("Create Account");
	   lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	   lblNewLabel.setForeground(Color.WHITE);
	   lblNewLabel.setBounds(375, 11, 115, 28);
	   
	   
	   //INNER PANEL
	   panel = new JPanel();
	   panel.setBackground(Color.WHITE);
	   panel.setBounds(0, 0, 282, 492);
	   panel.setLayout(null);
	  
	   //IMAGE
		lblBg = new JLabel("");
		lblBg.setBounds(-60, 107, 394, 341);
		panel.add(lblBg);
		lblBg.setBackground(Color.WHITE);
		lblBg.setForeground(Color.WHITE);
		lblBg.setIcon(new ImageIcon(Registration.class.getResource("/scqms-assets/Student log in.JPG")));
		
		//TITLES
		JLabel lblTitle = new JLabel("Student Inquires Management System");
		lblTitle.setFont(new Font("UD Digi Kyokasho NK-R", Font.BOLD, 13));
		lblTitle.setBounds(10, 53, 262, 43);
		panel.add(lblTitle);
		
		lblTitle2 = new JLabel("Are you New and have a Query?");
		lblTitle2.setFont(new Font("UD Digi Kyokasho NK-R", Font.BOLD, 13));
		lblTitle2.setBounds(10, 11, 262, 43);
		panel.add(lblTitle2);

		 //CONTACT  
	  lblContact = new JLabel("Contact");
	  lblContact.setForeground(new Color(255, 255, 255));
	  lblContact.setFont(new Font("Tahoma", Font.BOLD, 13));
	  lblContact.setBounds(305, 328, 79, 14);	 
	  txtFieldContact = new JTextField();
	  txtFieldContact.setBounds(304, 349, 124, 20);
	  txtFieldContact.setColumns(10);
	  
	  addComponentsToContentPane();
	}
	
	
	private void signUp(Client client) {
		String id = txtFieldID.getText();
		String password = txtFieldID.getText();
		String fName = txtFieldFirstName.getText();
		String lName = txtFieldLastName.getText();
		String contact = txtFieldContact.getText();
		
		if(comboBox.getSelectedIndex()==0) {
			String email = txtFieldEmail.getText();
			Student newStudent = new Student(id, password, fName, lName, User.Role.STUDENT, email, contact);
			client.sendCommand("Add Student");
			client.addStudent(newStudent);	
			client.studentResponse();
	        setVisible(false);

		}
		
		if(comboBox.getSelectedIndex()==1) {
		Advisor advisor = new Advisor(id, password, fName, lName, User.Role.ADVISOR);
		client.sendCommand("Add Advisor");
		client.addAdvisor(advisor);	
		client.advisorResponse();
        setVisible(false);
		}
		
		
		if(comboBox.getSelectedIndex()==2) {
		Supervisor supervisor = new Supervisor(id, password, fName, lName, User.Role.SUPERVISOR);
		client.sendCommand("Add Supervisor");
		client.addSupervisor(supervisor);	
		client.supervisorResponse();
        setVisible(false);
		}

	}


	private void cancel() {
	        dispose();
	}
	
	 private void addComponentsToContentPane() { 
	  contentPane.add(lblID);
	  contentPane.add(lblFirstName); 
	  contentPane.add(lblLastName);
	  contentPane.add(lblPassword); 
	  contentPane.add(lblRole);
	  contentPane.add(lblEmail); 
	  contentPane.add(comboBox);
	  contentPane.add(txtFieldID); 
	  contentPane.add(txtFieldFirstName);
	  contentPane.add(txtFieldLastName); 
	  contentPane.add(txtFieldEmail);
	  contentPane.add(txtFieldPassword); 
	  contentPane.add(btnCancel);
	  contentPane.add(btnSignUp);
	  contentPane.add(lblNewLabel);
	  contentPane.add(panel); 
	  contentPane.add(lblContact);
	  contentPane.add(txtFieldContact);
	
	 }
	 

	 //class that shows or hides email option base on role
	private class RoleComboxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (comboBox.getSelectedIndex() < 1) {
				txtFieldEmail.setVisible(true);
				lblEmail.setVisible(true);
				lblContact.setVisible(true);
				txtFieldContact.setVisible(true);
			} else {
				txtFieldEmail.setVisible(false);
				lblEmail.setVisible(false);
				lblContact.setVisible(false);
				txtFieldContact.setVisible(false);
			}

		}
	}
	
	
}
