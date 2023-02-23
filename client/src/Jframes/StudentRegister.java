package Jframes;

import model.Student;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRegister extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField id;
    private JTextField christianName;
    private JTextField surname;
    private JTextField email;
    private JTextField password;

    public StudentRegister() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final String PASSWORD = "@7235Ma@@";
                final String USER = "root";
                final String URL = "jdbc:mysql://localhost:3306/cqms_db";
                try {
                    Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO student(id,password,firstName,lastName,email) VALUES(?,?,?,?)");
                    String idValue = id.getText();
                    String passwordValue = password.getText();
                    String firstNameValue = christianName.getText();
                    String lastNameValue = surname.getText();
                    String emailValue = email.getText();
                    //create student object
                    Student student = new Student(idValue,passwordValue,firstNameValue,lastNameValue,emailValue);
                    //save object in db using preparedstatement
                    stmt.setString(1, student.getId());
                    stmt.setString(2, student.getPassword());
                    stmt.setString(3, student.getFirstName());
                    stmt.setString(4, student.getLastName());
                    stmt.setString(5, student.getEmail());
                    stmt.executeUpdate();

                    //close db
                    con.close();

                } catch (SQLException ex) {
                    System.out.println("Connection Not Established because "+ex.getMessage());
                }
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        StudentRegister dialog = new StudentRegister();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
