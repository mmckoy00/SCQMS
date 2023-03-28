package frames;


import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


//import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

//import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class admin extends JFrame {

	private JPanel contentPane;
	//private JTable table;
	private Connection dbCon;
	private Statement stmt;
	private ResultSet result;
	private DefaultTableModel model;
	private JTextField searchtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 398, 556, -318);
		
		//DefaultTableModel format the data into a tabular form
		// It must know the columnn count in advance. I think the 0 means the number of rows
		model = new DefaultTableModel();
		
		//columnNames not working
		String[] columnNames = {"id", "first name", "last name", "role"};
		model.setColumnIdentifiers(columnNames);
		
		
		
		populateTable();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(384, 177, 556, 326);
		contentPane.add(scrollPane_1);
	
		JTable table1 = new JTable();
		table1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table1);
		table1.setBackground(Color.LIGHT_GRAY);
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"requestId", "studentId", "requestType", "category", "detail", "resolution", "assign"
			}
		));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("view");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "SELECT * FROM queriestable";
				try {
					//get db
					dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqms", "root", "");
					// connect to db to run query
					stmt = dbCon.createStatement();
					result = stmt.executeQuery(sql);
					//execute the query
					
					 model = (DefaultTableModel) table1.getModel();
					while(result.next()) {
						model.addRow(new String[] {result.getString("requestId"), result.getString("studentId"), result.getString("requestType"), result.getString("category"), result.getString("detail"), result.getString("resolution"), result.getString("assign")});
					
					}
					
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(44, 296, 109, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentId = searchtxt.getText();
				 String searchQuery = "SELECT * FROM queriestable WHERE studentId ='"+studentId+"'";
				try {
					
					
					dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqms", "root", "");
					stmt = dbCon.createStatement();
					result = stmt.executeQuery(searchQuery);
		          //  table1.setModel(DbUtils.resultSetToTableModel(result));
		            
		            if(searchtxt.getText().equals(studentId))
					{
		            	model = (DefaultTableModel) table1.getModel();
						while(result.next()) {
							model.addRow(new String[] {result.getString("requestId"), result.getString("studentId"), result.getString("requestType"), result.getString("category"), result.getString("detail"), result.getString("resolution"), result.getString("assign")});
						
						} 
					}
		            
					
				}catch (SQLException ex) {
		          //  Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});
		btnNewButton_1.setBounds(374, 558, 109, 41);
		contentPane.add(btnNewButton_1);
		
		searchtxt = new JTextField();
		searchtxt.setBounds(523, 558, 343, 41);
		contentPane.add(searchtxt);
		searchtxt.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search Category");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(85, 511, 109, 41);
		contentPane.add(btnNewButton_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(36, 376, 139, 32);
		contentPane.add(comboBox);


		

				
				
				
		
		
		
	}
	
	private void populateTable() {
		
	}
}
