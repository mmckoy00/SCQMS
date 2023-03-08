package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;

import model.Student;
import model.Supervisor;
import model.User;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;


public class Registeration extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldID;
	private JTextField textFieldPassword;
	private JTextField textFieldEmail;
	private JComboBox<User.Role> comboBox;
	private JLabel lblEmail;
	private JLabel lblBg, lblID, lblFirstName, lblRole, lblLastName, lblPassword, lblNewLabel;
	private JButton btnCancel, btnSignUp;
	private JLabel lblTitle2;
	private JPanel panel;
	



	public Registeration() {
		initializeComponents();
	    addComponentsToContentPane();
	}
	
	

	private void initializeComponents() {
		
		//FRAME
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 486);
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
		textFieldID = new JTextField();
		textFieldID.setSelectedTextColor(Color.BLACK);
		textFieldID.setBackground(Color.WHITE);
		textFieldID.setForeground(Color.BLACK);
		textFieldID.setBounds(306, 85, 115, 20);
		textFieldID.setColumns(10);

		//ROLE
		lblRole = new JLabel("I am a");
		lblRole.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRole.setForeground(Color.WHITE);
		lblRole.setBounds(463, 204, 50, 14);
		comboBox = new JComboBox<User.Role>();
		comboBox.setBounds(463, 229, 92, 20);
		comboBox.setModel(new DefaultComboBoxModel<User.Role>(User.Role.values()));
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new RoleComboxListener());

		//FIRST NAME
		lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(306, 131, 76, 14);
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(306, 156, 115, 20);
		textFieldFirstName.setColumns(10);

		//LAST NAME
		lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(463, 131, 69, 14);
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(463, 156, 115, 20);
		textFieldLastName.setColumns(10);

		//PASSWORD
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(306, 204, 76, 14);
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(306, 229, 115, 20);
		textFieldPassword.setColumns(10);

		//BUTTONS
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(463, 370, 83, 23);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
		});
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnCancel.setBounds(338, 370, 83, 23);
		
		//EMAIL
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(306, 270, 56, 14);
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(306, 295, 184, 20);
		textFieldEmail.setText("");
		textFieldEmail.setColumns(10);

		
		
		//CREATE ACCOUNT LABEL
	   lblNewLabel= new JLabel("Create Account");
	   lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	   lblNewLabel.setForeground(Color.WHITE);
	   lblNewLabel.setBounds(375, 11, 115, 28);
	   
	   
	   //INNER PANEL
	   panel = new JPanel();
	   panel.setBackground(Color.WHITE);
	   panel.setBounds(0, 0, 282, 447);
	   panel.setLayout(null);
	  
	   //IMAGE
		lblBg = new JLabel("");
		lblBg.setBounds(-60, 107, 394, 341);
		panel.add(lblBg);
		lblBg.setBackground(Color.WHITE);
		lblBg.setForeground(Color.WHITE);
		lblBg.setIcon(new ImageIcon(Registeration.class.getResource("/scqms-assets/Student log in.JPG")));
		
		//TITLES
		JLabel lblTitle = new JLabel("Student Inquires Management System");
		lblTitle.setFont(new Font("UD Digi Kyokasho NK-R", Font.BOLD, 13));
		lblTitle.setBounds(10, 53, 262, 43);
		panel.add(lblTitle);
		
		lblTitle2 = new JLabel("Are you New and have a Query?");
		lblTitle2.setFont(new Font("UD Digi Kyokasho NK-R", Font.BOLD, 13));
		lblTitle2.setBounds(10, 11, 262, 43);
		panel.add(lblTitle2);

	}
	
	
	private void signUp() {
		
		String id = textFieldID.getText();
		String password = textFieldID.getText();
		String fName = textFieldFirstName.getText();
		String lName = textFieldLastName.getText();
		
		
		if(comboBox.getSelectedIndex()==0) {
			String email = textFieldEmail.getText();
			
			Student newStudent = new Student(id, password, fName, lName, User.Role.STUDENT, email);
			Student.create(newStudent);
			new Student_login().setVisible(true);
	        dispose();

		}else if(comboBox.getSelectedIndex()==1) {
			Supervisor newSupervisor = new Supervisor(id, password, fName, lName, User.Role.ADVISOR);
			
		}else {
			//Manager manager = new Manager(id, password, fName, lName, User.Role.MANAGER);
		}

	}


	private void cancel() {
		 new Authentication().setVisible(true);
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
	  contentPane.add(textFieldID); 
	  contentPane.add(textFieldFirstName);
	  contentPane.add(textFieldLastName); 
	  contentPane.add(textFieldEmail);
	  contentPane.add(textFieldPassword); 
	  contentPane.add(btnCancel);
	  contentPane.add(btnSignUp);
	  contentPane.add(lblNewLabel);
	  contentPane.add(panel);  
	 }
	 

	 //class that shows or hides email option base on role
	private class RoleComboxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (comboBox.getSelectedIndex() < 1) {
				textFieldEmail.setVisible(true);
				lblEmail.setVisible(true);
			} else {
				textFieldEmail.setVisible(false);
				lblEmail.setVisible(false);
			}

		}
	}
	
	
	public static void main(String[] args) {
				try {
					Registeration frame = new Registeration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
}
