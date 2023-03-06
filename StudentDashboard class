import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard {
    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;
    private JButton complaintButton;
    private JButton queryButton;
    private JButton viewComplaintsButton;
    private JButton viewQueriesButton;
    private JButton viewSpecificButton;

    public StudentDashboard() {
        // Create the frame
        frame = new JFrame("Student Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create the panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        // Add the title label
        titleLabel = new JLabel("Welcome to the Student Dashboard");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel);

        // Add the complaint button
        complaintButton = new JButton("File a Complaint");
        complaintButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle the complaint button click event
            }
        });
        panel.add(complaintButton);

        // Add the query button
        queryButton = new JButton("File a Query");
        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle the query button click event
            }
        });
        panel.add(queryButton);

        // Add the view complaints button
        viewComplaintsButton = new JButton("View Complaints");
        viewComplaintsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle the view complaints button click event
            }
        });
        panel.add(viewComplaintsButton);

        // Add the view queries button
        viewQueriesButton = new JButton("View Queries");
        viewQueriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle the view queries button click event
            }
        });
        panel.add(viewQueriesButton);

        // Add the view specific button
        viewSpecificButton = new JButton("View Specific Complaint/Query");
        viewSpecificButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle the view specific button click event
            }
        });
        panel.add(viewSpecificButton);

        // Add the panel to the frame and make it visible
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        StudentDashboard dashboard = new StudentDashboard();
    }
}

