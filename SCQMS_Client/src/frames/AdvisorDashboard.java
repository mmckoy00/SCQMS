package frame_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.RowFilter;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Student;
import model.Supervisor;
import model.User;

import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;

public class AdvisorDashboard extends JFrame {
    
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JPanel headerPanel;
    private JPanel Home;
    private Connection dbConn;
	private ResultSet rs;
	private PreparedStatement ps;
	private Statement statement;
	private User userObj;
	private Student student;
    
    private JLabel welcomeLabel,userAccount;
    private JToggleButton logout;
    private JToggleButton tglbtnSearch;
    private JSeparator separator;
    private JPanel TblPanel;
    private JScrollPane scrollPaneChat;
    private  JTable table;
    
    boolean flag = true;
    private ChatMessenger chat = new ChatMessenger();
    private JLabel lbl;
    private JTextField txtLName;
    Logger logger = LogManager.getLogger(AdvisorDashboard.class.getName());
    
    
    
    public AdvisorDashboard() {
        super("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main();
        setSize(982, 632);
        setVisible(true);
        setTitle("Advisor View");
        setResizable(true);
        
     
    }
    
    
    public void main() {
    	 mainPanel = new JPanel(new BorderLayout());
         header();
         sideBar();
         content();
         rightPanel();
         searchButton();
         messengerButton();
         logoutButton();
        
         
         //EDIT THE STUDENT VIEW METHOD 
       advisorView();
    }
    
    
    
    public void sideBar() {
   
    	//create sidebar panel uses gridbaglayout
        menuPanel = new JPanel();
        
        //default sidebar panel style
        menuPanel.setPreferredSize(new Dimension(150, 400));
        menuPanel.setBackground(new Color(147, 112, 219));
        
        GridBagLayout gbl_sidebarPanel = new GridBagLayout();
        gbl_sidebarPanel.columnWidths = new int[]{59, 0, 0, 0, 0, 0, 59, 0};
        gbl_sidebarPanel.rowHeights = new int[]{23, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_sidebarPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_sidebarPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        menuPanel.setLayout(gbl_sidebarPanel);
        mainPanel.add(menuPanel, BorderLayout.WEST);
    }
    
    
    public void header() {
    	// create the header
        headerPanel = new JPanel();
        headerPanel.setForeground(new Color(105, 105, 105));
        headerPanel.setPreferredSize(new Dimension(650, 50));
        headerPanel.setBackground(Color.DARK_GRAY);
        headerPanel.setLayout(null);
        
        //welcome message in header
        welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
        welcomeLabel.setBounds(21, 0, 61, 50);
        welcomeLabel.setForeground(Color.WHITE);
        headerPanel.add(welcomeLabel);
        
        //print user who logged in in the header
      /* userAccount = new JLabel(userObj.getFirstName()+" "+ userObj.getLastName());
        userAccount.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
        userAccount.setBounds(21, 0, 61, 50);
        userAccount.setForeground(Color.WHITE);
        headerPanel.add(userAccount);*/
        
        
        // add the main panel and header panel to the frame
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(headerPanel, BorderLayout.NORTH);
        
        
        //online label
        JLabel lblOnline = new JLabel("Online");
        lblOnline.setForeground(new Color(255, 255, 255));
        lblOnline.setBounds(901, 20, 40, 13);
        headerPanel.add(lblOnline);
        lblOnline.setHorizontalAlignment(SwingConstants.CENTER);
        
        JTextPane user = new JTextPane();
        user.setOpaque(false);
        user.setForeground(new Color(255, 255, 255));
        user.setFont(new Font("Tahoma", Font.BOLD, 16));
        user.setBounds(122, 11, 259, 28);
        headerPanel.add(user);
        //user.getString(); show the advisor that is currently logged on to the system
    }
    
    public void content() {
    	// create the main content panel
        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(412, 410));
        contentPanel.setBackground(Color.LIGHT_GRAY);
          
    }
    
    
    public void logoutButton() {
    	 //create Logout button 
        logout = new JToggleButton("Logout");
        
        //show user a confirm dialog
        logout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (JOptionPane.showConfirmDialog(null, "Are yo sure you want to close this application? ", 
						"Logout Confirmation", JOptionPane.YES_NO_OPTION) == 0)
        		{
        			new Login().setVisible(true);
        			dispose();
        			logger.info("[INFO] "+userObj.getFirstName()+ " Logged Out Information" );
        		}
        	}
        });
        
        //button style
        logout.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
        logout.setForeground(new Color(0, 0, 0));
        logout.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbcLogout = new GridBagConstraints();
        gbcLogout.gridwidth = 9;
        gbcLogout.fill = GridBagConstraints.BOTH;
        gbcLogout.insets = new Insets(0, 0, 5, 0);
        gbcLogout.gridx = 0;
        gbcLogout.gridy = 15;
        
        menuPanel.add(logout, gbcLogout);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new CardLayout(0, 0));
        
    }
    
    public void searchButton()
    {
    	JToggleButton tglbtnSearch = new JToggleButton("Find Student");
        tglbtnSearch.setForeground(Color.WHITE);
        tglbtnSearch.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
        tglbtnSearch.setBackground(Color.BLACK);
        GridBagConstraints gbcSearch = new GridBagConstraints();
        gbcSearch.fill = GridBagConstraints.BOTH;
        gbcSearch.gridwidth = 9;
        gbcSearch.insets = new Insets(0, 0, 5, 0);
        gbcSearch.gridx = 0;
        gbcSearch.gridy = 6;
        menuPanel.add(tglbtnSearch, gbcSearch);
        
        JSeparator separator_2 = new JSeparator();
        GridBagConstraints gbc_separator_2 = new GridBagConstraints();
        gbc_separator_2.insets = new Insets(0, 0, 5, 5);
        gbc_separator_2.gridx = 2;
        gbc_separator_2.gridy = 7;
        menuPanel.add(separator_2, gbc_separator_2);
        
        //action be performed when search is selected.
        tglbtnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				while (e.getSource() == tglbtnSearch)
				{
					String stud_id = JOptionPane.showInputDialog( "Enter Student's Id Number to Search: ");
					if(stud_id.length() > 0)
					{
						//save input to IDtextbox
						JTextField txtId = new JTextField(stud_id);
						 txtId.setEditable(false);
				          txtId.setColumns(10);
				          txtId.setBounds(170, 375, 135, 20);
				          Home.add(txtId);
				       
				          while(txtId != null) 
				          {
				         // Student sObj = new Student();
					  		String findStudent = "SELECT * FROM (studenttable) WHERE studId = '"+stud_id+"'";
					  		
					  		try
					  		{
					  			//resultSet
					  			ResultSet rs = dbConn.createStatement().executeQuery(findStudent);
					  			if (rs.next() == true)
					  			{
					  				
					  				logger.info("Student Information found: ");
									//msg to confirm student was found
					  				JOptionPane.showMessageDialog(null, "Student Found!!...");
					  				String sfirstName = rs.getString("firstName");
									String slastName = rs.getString("lastName");
									String semail = rs.getString("email");
									String scontact = rs.getString("contact");
									
									
									JTextField txtFName = new JTextField(sfirstName);
							        txtFName.setEditable(false);
							        txtFName.setColumns(10);
							        txtFName.setBounds(171, 402, 135, 20);
							        Home.add(txtFName);
							        
							        txtLName = new JTextField(slastName);
							        txtLName.setEditable(false);
							        txtLName.setColumns(10);
							        txtLName.setBounds(170, 426, 135, 20);
							        Home.add(txtLName);

							        JTextField txtEmail = new JTextField(semail);
							        txtEmail.setEditable(false);
							        txtEmail.setColumns(10);
							        txtEmail.setBounds(171, 451, 134, 20);
							        Home.add(txtEmail);
							          
							        JTextField txtContact = new JTextField(scontact);
							        txtContact.setEditable(false);
							        txtContact.setColumns(10);
							        txtContact.setBounds(171, 476, 134, 20);
							        Home.add(txtContact);
							        
							        //populate the table with the info found
					  			}
					  			
					  			JOptionPane.showMessageDialog(null, "Student Record Not Found...");
					  		} 
					  		catch(SQLException sql)
					  		{
					  			sql.printStackTrace();
					  			logger.warn("Student Records cannot be located");
					  		}
  
					      }
				           stud_id = JOptionPane.showInputDialog( "Enter Student's Id: Number");   
					}
				}
			}
        	
        });
    }
    
    
    
    public void messengerButton() {
    	  //create messenger button
    	JToggleButton tglbtnMessenger = new JToggleButton("Messenger");
  	  
  	  //shows or hides chat with button click
        tglbtnMessenger.addActionListener(e -> toggleChat());
        
        //button style
        tglbtnMessenger.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
        tglbtnMessenger.setForeground(new Color(255, 255, 255));
        tglbtnMessenger.setBackground(new Color(0, 0, 0));
        GridBagConstraints gbc_tglbtnMessenger = new GridBagConstraints();
        gbc_tglbtnMessenger.fill = GridBagConstraints.BOTH;
        gbc_tglbtnMessenger.gridwidth = 9;
        gbc_tglbtnMessenger.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnMessenger.gridx = 0;
        gbc_tglbtnMessenger.gridy = 14;
        menuPanel.add(tglbtnMessenger, gbc_tglbtnMessenger);
    }
    

    
    public void rightPanel() {
    	//create panel
	    scrollPaneChat = new JScrollPane();
	    scrollPaneChat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneChat.setToolTipText("Recent Chats");
        scrollPaneChat.setPreferredSize(new Dimension(70, 400));
        TblPanel = new JPanel();
        TblPanel.setToolTipText("Recent chat");
        scrollPaneChat.add(TblPanel);
        mainPanel.add(scrollPaneChat, BorderLayout.EAST);
        
        //default label
        lbl = new JLabel("No Chats");
        lbl.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 11));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPaneChat.setColumnHeaderView(lbl);
 
    }
    
    //functions used by toggleChat to show or hide
    public void displayChat() {
    	chat = new ChatMessenger();
		chat.setSize(contentPanel.getSize());
		chat.setVisible(true);
		Home.add(chat);
    }
    
    public void hideChat() {
    	chat.setVisible(false);
    	Home.remove(chat);
    }
    
   
    //function used by actionPerformed in 170
    public void toggleChat() {
    	if(flag == true) {
    		displayChat();
    		flag=false;
    	}else {
    		flag = true;
    		hideChat();
    	}
    }
    
    
    public void advisorView() {
 	   
   	 //advisor menu panel
   	   
   	   //change default menu panel color
   	   menuPanel.setBackground(new Color(0, 191, 255));
   	   
   	   
   	   JLabel  lblIcon = new JLabel("");
         // lblIcon.setIcon(new ImageIcon(AdDash.class.getResource("/images/images 1.jpg")));
          GridBagConstraints gbc_lblIcon = new GridBagConstraints();
          gbc_lblIcon.gridwidth = 9;
          gbc_lblIcon.insets = new Insets(0, 0, 5, 0);
          gbc_lblIcon.gridx = 0;
          gbc_lblIcon.gridy = 0;
          menuPanel.add(lblIcon, gbc_lblIcon);
          
          JLabel lblAdvisor = new JLabel("Advisor");
          lblAdvisor.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
          GridBagConstraints gbc_advisor = new GridBagConstraints();
          gbc_advisor.fill = GridBagConstraints.BOTH;
          gbc_advisor.gridwidth = 9;
          gbc_advisor.insets = new Insets(0, 0, 5, 0);
          gbc_advisor.gridx = 0;
          gbc_advisor.gridy = 1;
          menuPanel.add(lblAdvisor, gbc_advisor);
          
          JSeparator separator_1 = new JSeparator();
          separator_1.setOrientation(SwingConstants.VERTICAL);
          GridBagConstraints gbc_separator_1 = new GridBagConstraints();
          gbc_separator_1.insets = new Insets(0, 0, 5, 5);
          gbc_separator_1.gridx = 6;
          gbc_separator_1.gridy = 2;
          menuPanel.add(separator_1, gbc_separator_1);
          
         JToggleButton dashboard = new JToggleButton("Dashboard");
          dashboard.setSelected(true);
          dashboard.setFocusPainted(false);
          dashboard.setFocusable(false);
          dashboard.setEnabled(true);
          dashboard.setToolTipText("");
          dashboard.setForeground(Color.WHITE);
          dashboard.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
          dashboard.setBackground(Color.BLACK);
          GridBagConstraints gbcDash = new GridBagConstraints();
          gbcDash.fill = GridBagConstraints.HORIZONTAL;
          gbcDash.gridwidth = 9;
          gbcDash.insets = new Insets(0, 0, 5, 0);
          gbcDash.gridx = 0;
          gbcDash.gridy = 4;
          menuPanel.add(dashboard, gbcDash);
          dashboard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == dashboard)
				{
					new AdvisorDashboard();
					dispose();
				}
				
			}
        	  
          });
        	  
          
          
          JSeparator separator_3 = new JSeparator();
          GridBagConstraints gbc_separator_3 = new GridBagConstraints();
          gbc_separator_3.insets = new Insets(0, 0, 5, 5);
          gbc_separator_3.gridx = 1;
          gbc_separator_3.gridy = 5;
          menuPanel.add(separator_3, gbc_separator_3);
          
          JSeparator separator = new JSeparator();
          GridBagConstraints gbc_separator = new GridBagConstraints();
          gbc_separator.gridheight = 5;
          gbc_separator.anchor = GridBagConstraints.SOUTH;
          gbc_separator.insets = new Insets(0, 0, 5, 5);
          gbc_separator.gridx = 5;
          gbc_separator.gridy = 9;
          menuPanel.add(separator, gbc_separator);
          
          /// end of supervisor side bar 
          
          
          //supervisor content panel
          Home = new JPanel();
          contentPanel.add(Home);
          Home.setBackground(new Color(255, 255, 255));
          Home.setLayout(null);
          
          JTextArea EntriesDetails = new JTextArea();
          EntriesDetails.setBackground(SystemColor.controlHighlight);
          EntriesDetails.setEditable(false);
          EntriesDetails.setBounds(338, 402, 398, 91);
          Home.add(EntriesDetails);
          
          JLabel image = new JLabel("");
          //image.setIcon(new ImageIcon(Dash.class.getResource("/images/woman (1).png")));
          image.setBounds(10, 376, 64, 81);
          Home.add(image);
          
          JLabel idlbl = new JLabel("ID");
          idlbl.setBounds(102, 378, 46, 14);
          Home.add(idlbl);
          
          
          JLabel fNamelbl = new JLabel("First Name");
          fNamelbl.setBounds(102, 403, 64, 14);
          Home.add(fNamelbl);
          
          JLabel lNamelbl = new JLabel("Last Name");
          lNamelbl.setBounds(102, 429, 64, 14);
          Home.add(lNamelbl);
          
          JLabel lblNewLabel_6 = new JLabel("Entry Detail");
          lblNewLabel_6.setBounds(407, 377, 88, 14);
          Home.add(lblNewLabel_6);
          
          JLabel lblStudent = new JLabel("Student Details");
          lblStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
          lblStudent.setBounds(13, 343, 135, 14);
          Home.add(lblStudent);
          
         JScrollPane supervisorScrollPane = new JScrollPane();
          supervisorScrollPane.setBounds(145, 53, 591, 179);
          Home.add(supervisorScrollPane);
          
        table = new JTable();
   		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
   		supervisorScrollPane.setViewportView(table);
   		table.setBackground(Color.LIGHT_GRAY);
   		Object[] columns = {"EntryNo","StudentID", "Type", "Details", "Response", "Status"};
   		DefaultTableModel model = new DefaultTableModel();
   		model.setColumnIdentifiers(columns);
   		table.setModel(model);
   		 
          JLabel lblEntriesTitle = new JLabel("Complaints/Query Table");
          lblEntriesTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
          lblEntriesTitle.setBounds(193, 11, 214, 31);
          Home.add(lblEntriesTitle);
          
          JTextArea Response = new JTextArea();
          Response.addFocusListener(new FocusAdapter() {
          	@Override
          	public void focusGained(FocusEvent e) {
          		Response.setText("");
          	}
          	@Override
          	public void focusLost(FocusEvent e) {
          		if(Response.getText().equals("")) {
          			Response.setText("Leave a response");
          		}
          	}
          });
          Response.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
          Response.setText("Leave a response");
          Response.setToolTipText("Write a resolve message");
          Response.setWrapStyleWord(true);
          Response.setLineWrap(true);
          Response.setBackground(SystemColor.controlHighlight);
          Response.setBounds(338, 243, 398, 95);
          Home.add(Response);
          
          JLabel email = new JLabel("Email");
          email.setBounds(102, 454, 57, 14);
          Home.add(email);
          
          JLabel contact = new JLabel("Contact");
          contact.setBounds(102, 479, 46, 14);
          Home.add(contact);
          
          JButton respondBtn = new JButton("Respond");
          respondBtn.setBackground(new Color(30, 144, 255));
          respondBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
          respondBtn.setBounds(647, 349, 89, 23);
          Home.add(respondBtn);
          respondBtn.addActionListener(new ActionListener() {
        	  
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					try {
							DefaultTableModel model = (DefaultTableModel) table.getModel(); 
					    	
					    	if(table.getSelectedRowCount() == 1)
					    	{
					    		//if a col is selected then update
					    		String response = Response.getText();
					    		
					    		//set updated value to table row
					    		model.setValueAt(response, table.getSelectedColumn(), 5);
					    		
					    		JOptionPane.showMessageDialog(null, "Response Successfully Added");
								//adding logging statment
								logger.info("[INFO] Adding Response added to student"+ student.getStudentid()+ "record" );
								Response.setText("");
					    	}
					    	else
								JOptionPane.showMessageDialog(null, "Issues Updating Record",
										"Record Update Status", JOptionPane.ERROR_MESSAGE);
								logger.warn("[WARNING] Response to table Failed");
								Response.setText("");
					}
					catch(ArrayIndexOutOfBoundsException  aiobe) {
						aiobe.printStackTrace();;
					}
					catch(Exception exp)
					{
						logger.warn("[WARNING] Error while adding response");
					}
					
					
						
			}
        	  
          });
          
          JButton submitBtn = new JButton("Submit");
          submitBtn.setBackground(new Color(30, 144, 255));
          submitBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
          submitBtn.setBounds(647, 504, 89, 23);
          Home.add(submitBtn);
         submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
					//writing the hash value to a file
					FileWriter entryDeets;
					try {
						entryDeets = new FileWriter("Reply Messages.txt",true);
						entryDeets.write(String.valueOf(EntriesDetails));
						entryDeets.write(System.getProperty("line.separator"));
						entryDeets.close();
					} catch (IOException ioe) {
						// TODO Auto-generated catch block
						ioe.printStackTrace();
					}	
					
					
			}
		});
         
          
          JButton refreshBtn = new JButton("Refresh");
          refreshBtn.setBackground(new Color(30, 144, 255));
          refreshBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
          refreshBtn.setBounds(10, 125, 108, 31);
          Home.add(refreshBtn);
          
          refreshBtn.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				//create connection
  	   			try {
  					dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
  					
  					//display all records based on who is logged onto the system
  		   			//select all records that was assigned to the user account from the sup table
  		   			ps = dbConn.prepareStatement("SELECT * FROM (supervisortabel) WHERE advisorID = '" +userObj.getUserName());
  		   			ResultSet rs = ps.executeQuery();
  		   			DefaultTableModel	model = (DefaultTableModel) table.getModel();
  		   			while(rs.next())
  		   			{
  		   				model.addRow(new String [] {rs.getString("StudentID"), rs.getString("Details"), rs.getString("Type")});
  		   				//set the entryNo. to automatically generate
  		   			}
  				} 
  	   			catch (SQLException e1) {
  					// TODO Auto-generated catch block
  					e1.printStackTrace();
  				}
  	   			
  	   			
  			
  			}
          	
          });
             
      }
    
    
  
    
    public static void main(String[] args) {
        new AdvisorDashboard();
        
    }
}