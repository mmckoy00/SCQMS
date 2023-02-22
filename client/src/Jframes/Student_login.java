package Jframes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Student_login extends JFrame {
    JPanel StudentLoginPage;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_login frame = new Student_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 397);
		StudentLoginPage = new JPanel();
		StudentLoginPage.setBackground(Color.WHITE);
		StudentLoginPage.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(StudentLoginPage);
		StudentLoginPage.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(92, 22, 95, 14);
		StudentLoginPage.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Inquires Management System");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(10, 94, 252, 14);
		StudentLoginPage.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("University Of Technology");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(47, 57, 174, 14);
		StudentLoginPage.add(lblNewLabel_2);
		
		Panel panel = new Panel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(307, 10, 301, 358);
		StudentLoginPage.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Student Portal Login");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(74, 25, 165, 42);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Student ID");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 163, 70, 22);
		panel.add(lblNewLabel_5);
		
		JTextField textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		textField.setBounds(119, 158, 156, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 227, 70, 27);
		panel.add(lblNewLabel_6);
		
		JTextField textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(119, 227, 156, 27);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(159, 302, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("You will Achieve, We will Assist'. ");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_7.setBounds(56, 78, 219, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("studentloginpageicon");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setIcon(new ImageIcon(Objects.requireNonNull(Student_login.class.getResource("/images/Student log in.JPG"))));
		lblNewLabel_3.setBounds(0, 110, 301, 248);
		StudentLoginPage.add(lblNewLabel_3);
		
		JButton StudentLoginBackButton = new JButton("Back");
		StudentLoginBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Authentication jf = new Authentication();
				//jf.show(); deprecated
				jf.setVisible(true);
				dispose();
			}
		});
		StudentLoginBackButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		StudentLoginBackButton.setBounds(0, 0, 67, 23);
		StudentLoginPage.add(StudentLoginBackButton);
	}
}
