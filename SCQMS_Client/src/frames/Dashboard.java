package frames;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JButton;

public class Dashboard extends JFrame {

	private JPanel contentPane, studentPanel, advisorPanel,managerPanel;
	private JPanel panel;
	private JPanel panel_1;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard("advisor");
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
	public Dashboard(String userRole) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());
		
	/*	
		studentPanel = new JPanel();
        studentPanel.setLayout(null);
        contentPane.add(studentPanel, "student");
        
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 206, 209));
        panel_1.setBounds(0, -12, 101, 581);
        studentPanel.add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(0, 157, 89, 23);
        panel_1.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.setBounds(0, 191, 89, 23);
        panel_1.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("New button");
        btnNewButton_2.setBounds(0, 225, 89, 23);
        panel_1.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("New button");
        btnNewButton_3.setBounds(0, 259, 89, 23);
        panel_1.add(btnNewButton_3);
        
        panel = new JPanel();
        panel.setBounds(413, 12, 0, 0);
        studentPanel.add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0};
        gbl_panel.rowHeights = new int[]{0};
        gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(93, -12, 622, 44);
        studentPanel.add(panel_2);
        panel_2.setLayout(null);
        JLabel studentLabel = new JLabel("Welcome, ");
        studentLabel.setBounds(10, 19, 65, 14);
        panel_2.add(studentLabel);
        
        JButton btnNewButton_4 = new JButton("Logout");
        btnNewButton_4.setBounds(523, 15, 89, 23);
        panel_2.add(btnNewButton_4);
        
        JLabel lblName = new JLabel("Mattania Mckoy");
        lblName.setBounds(71, 19, 154, 14);
        panel_2.add(lblName);
		
        // Add the components to the CardLayout
        
        */
		
        if (userRole.equals("student")) {
        	studentView();
            contentPane.add(studentPanel, "student");
        } 
        if(userRole.equals("advisor")){
        	advisorView();
        	contentPane.add(advisorPanel, "advisor"); 
        }
        if(userRole.equals("manager")) {
        	managerView();
        	contentPane.add(managerPanel, "manager");
        }
       
       
	}
	
	public void studentView() {
		studentPanel = new JPanel();
        JLabel studentLabel = new JLabel("Welcome, Student!");
        studentPanel.add(studentLabel);
	}
	
	public void advisorView() {
        advisorPanel = new JPanel();
        JLabel advisorLabel = new JLabel("Welcome, Advisor!");
        advisorPanel.add(advisorLabel);
	}
	
	public void managerView() {
        managerPanel = new JPanel();
        JLabel managerLabel = new JLabel("Welcome, Manager!");
        managerPanel.add(managerLabel);
	}
}
