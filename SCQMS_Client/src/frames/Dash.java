package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

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

public class Dash extends JFrame {
    
    private JPanel mainPanel;
    private JPanel sidebarPanel;
    private JPanel contentPanel;
    private JPanel headerPanel;
    private JPanel Home;
    
    private JLabel welcomeLabel;
    private JToggleButton tglbtnLogout;
    private JToggleButton tglbtnMessenger;
    private JSeparator separator;
    private JPanel recentChatPanel;
    private JScrollPane scrollPaneChat;
    
    boolean flag = true;
    private ChatMessenger chat = new ChatMessenger();
    private JLabel lbl;
    
    public Dash(String role) {
        super("Dashboard");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main(role);
        setSize(983, 616);
        setVisible(true);
     
    }
    
    
    public void main(String role) {
    	 mainPanel = new JPanel(new BorderLayout());
         header();
         sideBar();
         content();
         rightPanel();
         messengerButton();
         logoutButton();
         
         if(role.equals("STUDENT")) {
         studentView();
         }
         
         if(role.contains("ADVISOR")) {
        	 advisorView();
         }
         
         if(role.contains("SUPERVISOR")) {
        	 supervisorView();
         }
    }
    
    
    
    public void sideBar() {
   
    	//create sidebar panel uses gridbaglayout
        sidebarPanel = new JPanel();
        
        //default sidebar panel style
        sidebarPanel.setPreferredSize(new Dimension(150, 400));
        sidebarPanel.setBackground(new Color(147, 112, 219));
        
        GridBagLayout gbl_sidebarPanel = new GridBagLayout();
        gbl_sidebarPanel.columnWidths = new int[]{59, 0, 0, 0, 0, 0, 59, 0};
        gbl_sidebarPanel.rowHeights = new int[]{23, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_sidebarPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_sidebarPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        sidebarPanel.setLayout(gbl_sidebarPanel);
        mainPanel.add(sidebarPanel, BorderLayout.WEST);
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
        
        // add the main panel and header panel to the frame
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(headerPanel, BorderLayout.NORTH);
        
        
        //online label
        JLabel lblOnline = new JLabel("Online");
        lblOnline.setForeground(new Color(255, 255, 255));
        lblOnline.setBounds(901, 20, 40, 13);
        headerPanel.add(lblOnline);
        lblOnline.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    public void content() {
    	// create the main content panel
        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(412, 410));
        contentPanel.setBackground(Color.LIGHT_GRAY);
    }
    
    
    public void logoutButton() {
    	 //create Logout button 
        tglbtnLogout = new JToggleButton("Logout");
        
        //show user a confirm dialog
        tglbtnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int choice = JOptionPane.showConfirmDialog(rootPane, "Do you want to logout ?" );
        		if(choice == 0) {
        			new Login().setVisible(true);
        			dispose();
        		}
        	}
        });
        
        //button style
        tglbtnLogout.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
        tglbtnLogout.setForeground(new Color(0, 0, 0));
        tglbtnLogout.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_tglbtnLogout = new GridBagConstraints();
        gbc_tglbtnLogout.gridwidth = 9;
        gbc_tglbtnLogout.fill = GridBagConstraints.HORIZONTAL;
        gbc_tglbtnLogout.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnLogout.gridx = 0;
        gbc_tglbtnLogout.gridy = 15;
        
        sidebarPanel.add(tglbtnLogout, gbc_tglbtnLogout);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new CardLayout(0, 0));
        
    }
    
    
    
    
    
    
    public void messengerButton() {
    	  //create messenger button
    	  tglbtnMessenger = new JToggleButton("Messenger");
    	  
    	  //shows or hides chat with button click
          tglbtnMessenger.addActionListener(e -> toggleChat());
          
          //button style
          tglbtnMessenger.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
          tglbtnMessenger.setForeground(new Color(255, 255, 255));
          tglbtnMessenger.setBackground(new Color(0, 0, 0));
          GridBagConstraints gbc_tglbtnMessenger = new GridBagConstraints();
          gbc_tglbtnMessenger.fill = GridBagConstraints.HORIZONTAL;
          gbc_tglbtnMessenger.gridwidth = 9;
          gbc_tglbtnMessenger.insets = new Insets(0, 0, 5, 0);
          gbc_tglbtnMessenger.gridx = 0;
          gbc_tglbtnMessenger.gridy = 14;
          sidebarPanel.add(tglbtnMessenger, gbc_tglbtnMessenger);
    }
    

    
    public void rightPanel() {
    	//create panel
	    scrollPaneChat = new JScrollPane();
	    scrollPaneChat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneChat.setToolTipText("Recent Chats");
        scrollPaneChat.setPreferredSize(new Dimension(70, 400));
        recentChatPanel = new JPanel();
        recentChatPanel.setToolTipText("Recent chat");
        scrollPaneChat.add(recentChatPanel);
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
 	   
   	 //advisor side bar
   	   
   	   //change default sidebar color
   	   sidebarPanel.setBackground(new Color(0, 191, 255));
   	   
   	   
   	   JLabel  lblIcon = new JLabel("");
          lblIcon.setIcon(new ImageIcon(Dash.class.getResource("/images/operator.png")));
          GridBagConstraints gbc_lblIcon = new GridBagConstraints();
          gbc_lblIcon.gridwidth = 9;
          gbc_lblIcon.insets = new Insets(0, 0, 5, 0);
          gbc_lblIcon.gridx = 0;
          gbc_lblIcon.gridy = 0;
          sidebarPanel.add(lblIcon, gbc_lblIcon);
          
          JLabel lblSupervisor = new JLabel("Advisor");
          lblSupervisor.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
          GridBagConstraints gbc_lblSupervisor = new GridBagConstraints();
          gbc_lblSupervisor.gridwidth = 9;
          gbc_lblSupervisor.insets = new Insets(0, 0, 5, 0);
          gbc_lblSupervisor.gridx = 0;
          gbc_lblSupervisor.gridy = 1;
          sidebarPanel.add(lblSupervisor, gbc_lblSupervisor);
          
          JSeparator separator_1 = new JSeparator();
          separator_1.setOrientation(SwingConstants.VERTICAL);
          GridBagConstraints gbc_separator_1 = new GridBagConstraints();
          gbc_separator_1.insets = new Insets(0, 0, 5, 5);
          gbc_separator_1.gridx = 6;
          gbc_separator_1.gridy = 2;
          sidebarPanel.add(separator_1, gbc_separator_1);
          
          JToggleButton tglbtnHome = new JToggleButton("Home");
          tglbtnHome.setFocusPainted(false);
          tglbtnHome.setFocusable(false);
          tglbtnHome.setEnabled(false);
          tglbtnHome.setToolTipText("");
          tglbtnHome.setForeground(Color.WHITE);
          tglbtnHome.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
          tglbtnHome.setBackground(Color.BLACK);
          GridBagConstraints gbc_tglbtnHome = new GridBagConstraints();
          gbc_tglbtnHome.fill = GridBagConstraints.HORIZONTAL;
          gbc_tglbtnHome.gridwidth = 9;
          gbc_tglbtnHome.insets = new Insets(0, 0, 5, 0);
          gbc_tglbtnHome.gridx = 0;
          gbc_tglbtnHome.gridy = 4;
          sidebarPanel.add(tglbtnHome, gbc_tglbtnHome);
          
          JSeparator separator_3 = new JSeparator();
          GridBagConstraints gbc_separator_3 = new GridBagConstraints();
          gbc_separator_3.insets = new Insets(0, 0, 5, 5);
          gbc_separator_3.gridx = 1;
          gbc_separator_3.gridy = 5;
          sidebarPanel.add(separator_3, gbc_separator_3);
          
          JSeparator separator = new JSeparator();
          GridBagConstraints gbc_separator = new GridBagConstraints();
          gbc_separator.gridheight = 5;
          gbc_separator.anchor = GridBagConstraints.SOUTH;
          gbc_separator.insets = new Insets(0, 0, 5, 5);
          gbc_separator.gridx = 5;
          gbc_separator.gridy = 9;
          sidebarPanel.add(separator, gbc_separator);
          
          /// end of supervisor side bar 
          
          
          //supervisor content panel
          Home = new JPanel();
          contentPanel.add(Home);
          Home.setBackground(new Color(255, 255, 255));
          Home.setLayout(null);
          
          JTextArea EntriesDetails = new JTextArea();
          EntriesDetails.setBackground(SystemColor.controlHighlight);
          EntriesDetails.setEditable(false);
          EntriesDetails.setBounds(421, 402, 315, 91);
          Home.add(EntriesDetails);
          
          JLabel image = new JLabel("");
          image.setIcon(new ImageIcon(Dash.class.getResource("/images/woman (1).png")));
          image.setBounds(10, 376, 64, 81);
          Home.add(image);
          
          JLabel lblNewLabel_3 = new JLabel("ID");
          lblNewLabel_3.setBounds(102, 378, 46, 14);
          Home.add(lblNewLabel_3);
          
          JLabel lblNewLabel_4 = new JLabel("First Name");
          lblNewLabel_4.setBounds(102, 403, 64, 14);
          Home.add(lblNewLabel_4);
          
          JLabel lblNewLabel_5 = new JLabel("Last Name");
          lblNewLabel_5.setBounds(102, 429, 64, 14);
          Home.add(lblNewLabel_5);
          
          JLabel lblNewLabel_6 = new JLabel("Entry Detail");
          lblNewLabel_6.setBounds(407, 377, 88, 14);
          Home.add(lblNewLabel_6);
          
          JLabel lblStudent = new JLabel("Student Details");
          lblStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
          lblStudent.setBounds(13, 343, 135, 14);
          Home.add(lblStudent);
          
          JScrollPane supervisorScrollPane = new JScrollPane();
          supervisorScrollPane.setBounds(195, 53, 541, 167);
          Home.add(supervisorScrollPane);
          
          JTable table1 = new JTable();
   		table1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
   		supervisorScrollPane.setViewportView(table1);
   		table1.setBackground(Color.LIGHT_GRAY);
   		table1.setModel(new DefaultTableModel(
   			new Object[][] {
   			},
   			new String[] {
   				"EntryNo", "Status", "Type", "Category", "Supervisor"
   			}
   		));
   		
          
          JLabel lblEntriesTitle = new JLabel("Entries");
          lblEntriesTitle.setBounds(193, 28, 46, 14);
          Home.add(lblEntriesTitle);
          
          JTextField txtID = new JTextField();
          txtID.setEditable(false);
          txtID.setBounds(171, 426, 134, 20);
          Home.add(txtID);
          txtID.setColumns(10);
          
          JTextField txtFirstName = new JTextField();
          txtFirstName.setEditable(false);
          txtFirstName.setColumns(10);
          txtFirstName.setBounds(170, 375, 135, 20);
          Home.add(txtFirstName);
          
          JTextField txtLastName = new JTextField();
          txtLastName.setEditable(false);
          txtLastName.setColumns(10);
          txtLastName.setBounds(171, 402, 135, 20);
          Home.add(txtLastName);
          
          JTextArea EntriesDetails_1 = new JTextArea();
          EntriesDetails_1.addFocusListener(new FocusAdapter() {
          	@Override
          	public void focusGained(FocusEvent e) {
          		EntriesDetails_1.setText("");
          	}
          	@Override
          	public void focusLost(FocusEvent e) {
          		if(EntriesDetails_1.getText().equals("")) {
          			EntriesDetails_1.setText("Leave a response");
          		}
          	}
          });
          EntriesDetails_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
          EntriesDetails_1.setText("Leave a response");
          EntriesDetails_1.setToolTipText("Write a resolve message");
          EntriesDetails_1.setWrapStyleWord(true);
          EntriesDetails_1.setLineWrap(true);
          EntriesDetails_1.setBackground(SystemColor.controlHighlight);
          EntriesDetails_1.setBounds(421, 243, 315, 95);
          Home.add(EntriesDetails_1);
          
          JLabel lblNewLabel = new JLabel("Email");
          lblNewLabel.setBounds(102, 454, 57, 14);
          Home.add(lblNewLabel);
          
          JLabel lblNewLabel_2 = new JLabel("Contact");
          lblNewLabel_2.setBounds(102, 479, 46, 14);
          Home.add(lblNewLabel_2);
          
          JTextField txtEmail = new JTextField();
          txtEmail.setEditable(false);
          txtEmail.setColumns(10);
          txtEmail.setBounds(171, 451, 134, 20);
          Home.add(txtEmail);
          
          JTextField txtContact = new JTextField();
          txtContact.setEditable(false);
          txtContact.setColumns(10);
          txtContact.setBounds(171, 476, 134, 20);
          Home.add(txtContact);
          
          JComboBox comboBox = new JComboBox();
          comboBox.setBounds(40, 152, 108, 22);
          Home.add(comboBox);
          
          JLabel lblStatus = new JLabel("Status");
          lblStatus.setBounds(40, 127, 74, 14);
          Home.add(lblStatus);
          
          JComboBox comboBox_1 = new JComboBox();
          comboBox_1.setBounds(40, 77, 108, 22);
          Home.add(comboBox_1);
          
          JLabel lblCategory_1 = new JLabel("Category");
          lblCategory_1.setBounds(40, 53, 74, 14);
          Home.add(lblCategory_1);
          
          JButton btnNewButton = new JButton("Submit");
          btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
          btnNewButton.setBounds(647, 349, 89, 23);
          Home.add(btnNewButton);

      }
    
   
   public void supervisorView() {
	   
	 //supervisor side bar
	   
	   //change default sidebar color
	   sidebarPanel.setBackground(new Color(0, 191, 255));
	   
	   //hide messenger button
	   tglbtnMessenger.setVisible(false);
	   
	   
	   JLabel  lblIcon = new JLabel("");
       lblIcon.setIcon(new ImageIcon(Dash.class.getResource("/images/students-cap.png")));
       GridBagConstraints gbc_lblIcon = new GridBagConstraints();
       gbc_lblIcon.gridwidth = 9;
       gbc_lblIcon.insets = new Insets(0, 0, 5, 0);
       gbc_lblIcon.gridx = 0;
       gbc_lblIcon.gridy = 0;
       sidebarPanel.add(lblIcon, gbc_lblIcon);
       
       JLabel lblSupervisor = new JLabel("Supervisor");
       lblSupervisor.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
       GridBagConstraints gbc_lblSupervisor = new GridBagConstraints();
       gbc_lblSupervisor.gridwidth = 9;
       gbc_lblSupervisor.insets = new Insets(0, 0, 5, 0);
       gbc_lblSupervisor.gridx = 0;
       gbc_lblSupervisor.gridy = 1;
       sidebarPanel.add(lblSupervisor, gbc_lblSupervisor);
       
       JSeparator separator_1 = new JSeparator();
       separator_1.setOrientation(SwingConstants.VERTICAL);
       GridBagConstraints gbc_separator_1 = new GridBagConstraints();
       gbc_separator_1.insets = new Insets(0, 0, 5, 5);
       gbc_separator_1.gridx = 6;
       gbc_separator_1.gridy = 2;
       sidebarPanel.add(separator_1, gbc_separator_1);
       
       JToggleButton tglbtnHome = new JToggleButton("Home");
       tglbtnHome.setFocusable(false);
       tglbtnHome.setFocusPainted(false);
       tglbtnHome.setEnabled(false);
       tglbtnHome.setToolTipText("");
       tglbtnHome.setForeground(Color.WHITE);
       tglbtnHome.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
       tglbtnHome.setBackground(Color.BLACK);
       GridBagConstraints gbc_tglbtnHome = new GridBagConstraints();
       gbc_tglbtnHome.fill = GridBagConstraints.HORIZONTAL;
       gbc_tglbtnHome.gridwidth = 9;
       gbc_tglbtnHome.insets = new Insets(0, 0, 5, 0);
       gbc_tglbtnHome.gridx = 0;
       gbc_tglbtnHome.gridy = 4;
       sidebarPanel.add(tglbtnHome, gbc_tglbtnHome);
       
       JSeparator separator_3 = new JSeparator();
       GridBagConstraints gbc_separator_3 = new GridBagConstraints();
       gbc_separator_3.insets = new Insets(0, 0, 5, 5);
       gbc_separator_3.gridx = 1;
       gbc_separator_3.gridy = 5;
       sidebarPanel.add(separator_3, gbc_separator_3);
       
       JSeparator separator = new JSeparator();
       GridBagConstraints gbc_separator = new GridBagConstraints();
       gbc_separator.gridheight = 5;
       gbc_separator.anchor = GridBagConstraints.SOUTH;
       gbc_separator.insets = new Insets(0, 0, 5, 5);
       gbc_separator.gridx = 5;
       gbc_separator.gridy = 9;
       sidebarPanel.add(separator, gbc_separator);
       
       /// end of supervisor side bar 
       
       
       //supervisor content panel
       Home = new JPanel();
       contentPanel.add(Home, "name_70744344513000");
       Home.setBackground(new Color(255, 255, 255));
       Home.setLayout(null);
       
       JTextArea EntriesDetails = new JTextArea();
       EntriesDetails.setBackground(SystemColor.controlHighlight);
       EntriesDetails.setEditable(false);
       EntriesDetails.setBounds(421, 402, 315, 91);
       Home.add(EntriesDetails);
       
       JLabel image = new JLabel("");
       image.setIcon(new ImageIcon(Dash.class.getResource("/images/woman (1).png")));
       image.setBounds(10, 376, 64, 81);
       Home.add(image);
       
       JLabel lblNewLabel_3 = new JLabel("ID");
       lblNewLabel_3.setBounds(102, 378, 46, 14);
       Home.add(lblNewLabel_3);
       
       JLabel lblNewLabel_4 = new JLabel("First Name");
       lblNewLabel_4.setBounds(102, 403, 64, 14);
       Home.add(lblNewLabel_4);
       
       JLabel lblNewLabel_5 = new JLabel("Last Name");
       lblNewLabel_5.setBounds(102, 429, 64, 14);
       Home.add(lblNewLabel_5);
       
       JLabel lblNewLabel_6 = new JLabel("Entry Detail");
       lblNewLabel_6.setBounds(384, 376, 88, 14);
       Home.add(lblNewLabel_6);
       
       JLabel lblStudent = new JLabel("Student Details");
       lblStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
       lblStudent.setBounds(13, 343, 135, 14);
       Home.add(lblStudent);
       
       JScrollPane supervisorScrollPane = new JScrollPane();
       supervisorScrollPane.setBounds(195, 53, 541, 167);
       Home.add(supervisorScrollPane);
       
       JTable table1 = new JTable();
		table1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		supervisorScrollPane.setViewportView(table1);
		table1.setBackground(Color.LIGHT_GRAY);
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"EntryNo", "Status", "Type", "Category", "Advisor"
			}
		));
		
       
       JLabel lblEntriesTitle = new JLabel("Entries");
       lblEntriesTitle.setBounds(193, 28, 46, 14);
       Home.add(lblEntriesTitle);
       
       JTextField txtID = new JTextField();
       txtID.setEditable(false);
       txtID.setBounds(171, 426, 134, 20);
       Home.add(txtID);
       txtID.setColumns(10);
       
       JTextField txtFirstName = new JTextField();
       txtFirstName.setEditable(false);
       txtFirstName.setColumns(10);
       txtFirstName.setBounds(170, 375, 135, 20);
       Home.add(txtFirstName);
       
       JTextField txtLastName = new JTextField();
       txtLastName.setEditable(false);
       txtLastName.setColumns(10);
       txtLastName.setBounds(171, 402, 135, 20);
       Home.add(txtLastName);
       
       JTextArea EntriesDetails_1 = new JTextArea();
       EntriesDetails_1.setEditable(false);
       EntriesDetails_1.setBackground(SystemColor.controlHighlight);
       EntriesDetails_1.setBounds(421, 256, 315, 91);
       Home.add(EntriesDetails_1);
       
       JLabel lblNewLabel_6_1 = new JLabel("Response");
       lblNewLabel_6_1.setBounds(384, 231, 88, 14);
       Home.add(lblNewLabel_6_1);
       
       JLabel lblNewLabel = new JLabel("Email");
       lblNewLabel.setBounds(102, 454, 57, 14);
       Home.add(lblNewLabel);
       
       JLabel lblNewLabel_2 = new JLabel("Contact");
       lblNewLabel_2.setBounds(102, 479, 46, 14);
       Home.add(lblNewLabel_2);
       
       JTextField txtEmail = new JTextField();
       txtEmail.setEditable(false);
       txtEmail.setColumns(10);
       txtEmail.setBounds(171, 451, 134, 20);
       Home.add(txtEmail);
       
       JTextField txtContact = new JTextField();
       txtContact.setEditable(false);
       txtContact.setColumns(10);
       txtContact.setBounds(171, 476, 134, 20);
       Home.add(txtContact);
       
       JComboBox comboBox = new JComboBox();
       comboBox.setBounds(40, 152, 108, 22);
       Home.add(comboBox);
       
       JLabel lblStatus = new JLabel("Status");
       lblStatus.setBounds(40, 127, 74, 14);
       Home.add(lblStatus);
       
       JComboBox comboBox_1 = new JComboBox();
       comboBox_1.setBounds(40, 77, 108, 22);
       Home.add(comboBox_1);
       
       JLabel lblCategory_1 = new JLabel("Category");
       lblCategory_1.setBounds(40, 53, 74, 14);
       Home.add(lblCategory_1);
       
       //right panel
       lbl.setText("Advisors");

   }
    
    
    
   public void studentView(){
	    JLabel  lblIcon = new JLabel("");
        lblIcon.setIcon(new ImageIcon(Dash.class.getResource("/images/students-cap.png")));
        GridBagConstraints gbc_lblIcon = new GridBagConstraints();
        gbc_lblIcon.gridwidth = 9;
        gbc_lblIcon.insets = new Insets(0, 0, 5, 0);
        gbc_lblIcon.gridx = 0;
        gbc_lblIcon.gridy = 0;
        sidebarPanel.add(lblIcon, gbc_lblIcon);
        
        JLabel lblStudent = new JLabel("STUDENT");
        lblStudent.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
        GridBagConstraints gbc_lblStudent = new GridBagConstraints();
        gbc_lblStudent.gridwidth = 9;
        gbc_lblStudent.insets = new Insets(0, 0, 5, 0);
        gbc_lblStudent.gridx = 0;
        gbc_lblStudent.gridy = 1;
        sidebarPanel.add(lblStudent, gbc_lblStudent);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        GridBagConstraints gbc_separator_1 = new GridBagConstraints();
        gbc_separator_1.insets = new Insets(0, 0, 5, 5);
        gbc_separator_1.gridx = 6;
        gbc_separator_1.gridy = 2;
        sidebarPanel.add(separator_1, gbc_separator_1);
        
        JToggleButton tglbtnEntry = new JToggleButton("Entry");
        tglbtnEntry.setToolTipText("Create query or complaint");
        tglbtnEntry.setForeground(Color.WHITE);
        tglbtnEntry.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
        tglbtnEntry.setBackground(Color.BLACK);
        GridBagConstraints gbc_tglbtnEntry = new GridBagConstraints();
        gbc_tglbtnEntry.fill = GridBagConstraints.HORIZONTAL;
        gbc_tglbtnEntry.gridwidth = 9;
        gbc_tglbtnEntry.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnEntry.gridx = 0;
        gbc_tglbtnEntry.gridy = 4;
        sidebarPanel.add(tglbtnEntry, gbc_tglbtnEntry);
        
        JSeparator separator_3 = new JSeparator();
        GridBagConstraints gbc_separator_3 = new GridBagConstraints();
        gbc_separator_3.insets = new Insets(0, 0, 5, 5);
        gbc_separator_3.gridx = 1;
        gbc_separator_3.gridy = 5;
        sidebarPanel.add(separator_3, gbc_separator_3);
        
        JToggleButton tglbtnComplaints = new JToggleButton("Complaint");
        tglbtnComplaints.setToolTipText("Shows previous complaint");
        tglbtnComplaints.setForeground(Color.WHITE);
        tglbtnComplaints.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
        tglbtnComplaints.setBackground(Color.BLACK);
        GridBagConstraints gbc_tglbtnComplaints = new GridBagConstraints();
        gbc_tglbtnComplaints.fill = GridBagConstraints.HORIZONTAL;
        gbc_tglbtnComplaints.gridwidth = 9;
        gbc_tglbtnComplaints.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnComplaints.gridx = 0;
        gbc_tglbtnComplaints.gridy = 6;
        sidebarPanel.add(tglbtnComplaints, gbc_tglbtnComplaints);
        
        JSeparator separator_2 = new JSeparator();
        GridBagConstraints gbc_separator_2 = new GridBagConstraints();
        gbc_separator_2.insets = new Insets(0, 0, 5, 5);
        gbc_separator_2.gridx = 2;
        gbc_separator_2.gridy = 7;
        sidebarPanel.add(separator_2, gbc_separator_2);
        
        JToggleButton tglbtnQueries = new JToggleButton("Queries");
        tglbtnQueries.setToolTipText("Shows previous queries");
        tglbtnQueries.setForeground(Color.WHITE);
        tglbtnQueries.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
        tglbtnQueries.setBackground(Color.BLACK);
        GridBagConstraints gbc_tglbtnQueries = new GridBagConstraints();
        gbc_tglbtnQueries.fill = GridBagConstraints.HORIZONTAL;
        gbc_tglbtnQueries.gridwidth = 9;
        gbc_tglbtnQueries.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnQueries.gridx = 0;
        gbc_tglbtnQueries.gridy = 8;
        sidebarPanel.add(tglbtnQueries, gbc_tglbtnQueries);
        
        
        separator = new JSeparator();
        GridBagConstraints gbc_separator = new GridBagConstraints();
        gbc_separator.gridheight = 5;
        gbc_separator.anchor = GridBagConstraints.SOUTH;
        gbc_separator.insets = new Insets(0, 0, 5, 5);
        gbc_separator.gridx = 5;
        gbc_separator.gridy = 9;
        sidebarPanel.add(separator, gbc_separator);
    }
    
}