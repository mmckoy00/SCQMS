package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class SearchWindow {

	private JFrame frame;
	private JPanel menu;
	private JPanel dashPanel;
	private JLabel dashboard;
	private JLabel dashIcon;
	private JPanel findPanel;
	private JLabel find;
	private JPanel logoutPanel;
	private JLabel logout;
	private JPanel viewPanel;
	private JLabel viewAllCnQ;
	private JLabel lblNewLabel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchWindow window = new SearchWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setPreferredSize(new Dimension(900, 700));
		frame.setSize(new Dimension(900, 700));
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setResizable(false);
		frame.setVisible(true);
		
		menu = new JPanel();
		menu.setPreferredSize(new Dimension(225, 700));
		menu.setLayout(null);
		menu.setBackground(new Color(153, 0, 204));
		frame.getContentPane().add(menu, BorderLayout.WEST);
		
		dashPanel = new JPanel();
		dashPanel.setLayout(null);
		dashPanel.setBorder(null);
		dashPanel.setBackground(new Color(153, 0, 204));
		dashPanel.setBounds(0, 264, 250, 49);
		menu.add(dashPanel);
		
		dashboard = new JLabel("Dashboard");
		dashboard.setHorizontalAlignment(SwingConstants.CENTER);
		dashboard.setForeground(new Color(240, 255, 240));
		dashboard.setFont(new Font("Tahoma", Font.BOLD, 18));
		dashboard.setBounds(112, 0, 118, 49);
		dashPanel.add(dashboard);
		
		dashIcon = new JLabel("");
		dashIcon.setBounds(10, 0, 92, 49);
		dashPanel.add(dashIcon);
		
		logoutPanel = new JPanel();
		logoutPanel.setLayout(null);
		logoutPanel.setBorder(null);
		logoutPanel.setBackground(new Color(153, 0, 204));
		logoutPanel.setBounds(0, 506, 250, 60);
		menu.add(logoutPanel);
		
		logout = new JLabel("Sign Out");
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setForeground(new Color(240, 255, 240));
		logout.setFont(new Font("Tahoma", Font.BOLD, 20));
		logout.setBounds(107, 0, 143, 60);
		logoutPanel.add(logout);
		
		viewPanel = new JPanel();
		viewPanel.setLayout(null);
		viewPanel.setBorder(null);
		viewPanel.setBackground(new Color(153, 0, 204));
		viewPanel.setBounds(0, 340, 250, 60);
		menu.add(viewPanel);
		
		viewAllCnQ = new JLabel("View All");
		viewAllCnQ.setHorizontalAlignment(SwingConstants.CENTER);
		viewAllCnQ.setForeground(new Color(240, 255, 240));
		viewAllCnQ.setFont(new Font("Tahoma", Font.BOLD, 20));
		viewAllCnQ.setBounds(115, 0, 125, 60);
		viewPanel.add(viewAllCnQ);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 230, 203);
		menu.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 90));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


}
