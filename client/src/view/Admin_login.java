package Jframes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

public class Admin_login extends JFrame {

	private final JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login frame = new Admin_login();
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
	public Admin_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 389);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Back");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Authentication sf = new Authentication();
						sf.show();
				dispose();
			}
		});
		button.setBounds(0, 0, 70, 22);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Welcome To");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(96, 25, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("University Of Technology");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(53, 66, 174, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Student Inquires Management System");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(21, 101, 252, 14);
		contentPane.add(lblNewLabel_1);
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(296, 0, 280, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Administrator Portal login");
		lblNewLabel_4.setBounds(52, 11, 187, 18);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("“I never dreamed about success. I worked");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_7.setBounds(10, 54, 270, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel(" for it.” —Estée Lauder");
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_7_1.setBounds(41, 81, 239, 14);
		panel.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_5 = new JLabel("Admin ID");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 165, 70, 22);
		panel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 2, 0,  Color.WHITE));
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(114, 160, 156, 27);
		panel.add(textField);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 223, 70, 27);
		panel.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(114, 223, 156, 27);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(150, 287, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Admin_login.class.getResource("/images/adminLogin.JPG")));
		lblNewLabel_3.setBounds(-11, -11, 308, 361);
		contentPane.add(lblNewLabel_3);
	}
}
