package Jframes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.util.Objects;

public class Authentication extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentication frame = new Authentication();
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
	public Authentication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 409);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University Of Technology");
		lblNewLabel.setBounds(419, 0, 181, 37);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Magna per atem gesta (Excellence Through Knowledge)");
		lblNewLabel_1.setBounds(140, 356, 342, 14);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		contentPane.add(lblNewLabel_1);
		
		Button button = new Button("Admin");
		button.setBounds(167, 238, 106, 31);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin_login sf =  new Admin_login();
				//sf.show();
				sf.setVisible(true);
				dispose();
			}
		});
		contentPane.add(button);
		
		Button button_1 = new Button("Student");
		button_1.setBounds(167, 177, 106, 31);
		button_1.setBackground(Color.BLACK);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Student_login sf =  new Student_login();
				// sf.show(); show() method is deprecated
				sf.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(0, 0, 610, 370);
		lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(Authentication.class.getResource("/images/Capture.JPG"))));
		contentPane.add(lblNewLabel_2);
	}
}
