package frames;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


public class studentView extends JFrame {

   private JComboBox<String> serviceComboBox;
   private JTextField categoryTextField;
   private JTextArea detailsTextArea;
   private JTextArea complaintsTextArea;
   private JTextArea queriesTextArea;
   private Map<String, String> complaints;
   private Map<String, String> queries;

   public studentView() {
       // Set up the main window
       setTitle("Student Dashboard");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setPreferredSize(new Dimension(800, 600));

       // Set up the content pane
       JPanel contentPane = new JPanel(new BorderLayout());
       contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
       setContentPane(contentPane);

       // Set up the top panel for the service selection and input fields
       JPanel topPanel = new JPanel(new GridLayout(3, 2, 10, 10));
       topPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
       contentPane.add(topPanel, BorderLayout.NORTH);

       JLabel serviceLabel = new JLabel("Service:");
       topPanel.add(serviceLabel);

       String[] serviceOptions = {"Complaint", "Query"};
       serviceComboBox = new JComboBox<>(serviceOptions);
       topPanel.add(serviceComboBox);

       JLabel categoryLabel = new JLabel("Category:");
       topPanel.add(categoryLabel);

       categoryTextField = new JTextField();
       topPanel.add(categoryTextField);

       JLabel detailsLabel = new JLabel("Details:");
       topPanel.add(detailsLabel);

       detailsTextArea = new JTextArea();
       detailsTextArea.setLineWrap(true);
       JScrollPane detailsScrollPane = new JScrollPane(detailsTextArea);
       topPanel.add(detailsScrollPane);

       // Set up the center panel for the list of past complaints and queries
       JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 0));
       centerPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
       contentPane.add(centerPanel, BorderLayout.CENTER);

       complaintsTextArea = new JTextArea();
       complaintsTextArea.setEditable(false);
       JScrollPane complaintsScrollPane = new JScrollPane(complaintsTextArea);
       centerPanel.add(complaintsScrollPane);

       queriesTextArea = new JTextArea();
       queriesTextArea.setEditable(false);
       JScrollPane queriesScrollPane = new JScrollPane(queriesTextArea);
       centerPanel.add(queriesScrollPane);

       // Set up the bottom panel for the search field and button
       JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
       contentPane.add(bottomPanel, BorderLayout.SOUTH);

       JLabel searchLabel = new JLabel("Search:");
       bottomPanel.add(searchLabel, BorderLayout.WEST);

       JTextField searchTextField = new JTextField();
       bottomPanel.add(searchTextField, BorderLayout.CENTER);

       JButton searchButton = new JButton("Search");
       bottomPanel.add(searchButton, BorderLayout.EAST);

       // Load the complaints and queries from the database or file
       complaints = new HashMap<>();
       complaints.put("1", "Missing grades, I have not received my grades for last semester yet");
       complaints.put("2", "Tuition fee, I think I have been overcharged for tuition fees");

       queries = new HashMap<>();
       queries.put("1", "Course selection, Can I change my course selection for next semester?");
       queries.put("2", "Graduation, What are the requirements for graduation?");
       queries.put("3", "Advising, Can I talk to an academic advisor about my study plan?");
       updateComplaints();
       updateQueries();

       // Add an action listener to the service combo box
       serviceComboBox.addActionListener(e -> {
           if (serviceComboBox.getSelectedItem().equals("Complaint")) {
               categoryTextField.setText("");
               categoryTextField.setEditable(true);
           } else {
               categoryTextField.setText("Academic");
               categoryTextField.setEditable(false);
           }
       });

       // Add an action listener to the search button
       searchButton.addActionListener(e -> {
           String searchKey = searchTextField.getText().trim();

           if (complaints.containsKey(searchKey)) {
               String complaint = complaints.get(searchKey);
               JOptionPane.showMessageDialog(this, "Complaint #" + searchKey + ":\n" + complaint);
           } else if (queries.containsKey(searchKey)) {
               String query = queries.get(searchKey);
               JOptionPane.showMessageDialog(this, "Query #" + searchKey + ":\n" + query);
           } else {
               JOptionPane.showMessageDialog(this, "No results found.");
           }
       });

       // Pack and display the window
       pack();
       setVisible(true);
   }

   private void updateComplaints() {
       StringBuilder sb = new StringBuilder();

       for (String key : complaints.keySet()) {
           String complaint = complaints.get(key);
           sb.append("#").append(key).append(": ").append(complaint).append("\n");
       }

       complaintsTextArea.setText(sb.toString());
   }

   private void updateQueries() {
       StringBuilder sb = new StringBuilder();

       for (String key : queries.keySet()) {
           String query = queries.get(key);
           sb.append("#").append(key).append(": ").append(query).append("\n");
       }

       queriesTextArea.setText(sb.toString());
   }

   public static void main(String[] args) {
       SwingUtilities.invokeLater(studentView::new);
   }
}