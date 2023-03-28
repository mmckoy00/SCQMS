package frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatMessenger extends JInternalFrame implements ActionListener, KeyListener {

	 private JTextField textField;
	    private JTextArea textArea;
	    private JButton sendButton;

	    public ChatMessenger() {
	        // Set up the internal frame
	        super("Chat", false, false, false, false);
	       setSize(400, 400);

	        // Create the text area
	        textArea = new JTextArea();
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);

	        // Create the scroll pane and add the text area to it
	        JScrollPane scrollPane = new JScrollPane(textArea);

	        // Create the text field and send button
	        textField = new JTextField(20);
	        sendButton = new JButton("Send");
	        sendButton.addActionListener(this);
	        
	        //set the sendButton Mnemonic to enter key
	        sendButton.setMnemonic(KeyEvent.VK_ENTER);
	        
	        //set the sendButton tool tip
	        sendButton.setToolTipText("Click or press enter key to send message");
	        textField.setToolTipText("Enter message");
	        
	        textField.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                sendButton.doClick();
	            }
	        });

	        // Add the components to the content pane
	        Container contentPane = getContentPane();
	        contentPane.setLayout(new BorderLayout());
	        contentPane.add(scrollPane, BorderLayout.CENTER);
	        JPanel inputPanel = new JPanel();
	        inputPanel.setLayout(new BorderLayout());
	        inputPanel.add(textField, BorderLayout.CENTER);
	        inputPanel.add(sendButton, BorderLayout.EAST);
	        contentPane.add(inputPanel, BorderLayout.SOUTH);
	    }

	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == sendButton) {
	            // Get the text from the text field
	            String message = textField.getText();

	            // Append the message to the text area
	            textArea.append("You: " + message + "\n");

	            // Clear the text field
	            textField.setText("");
	        }
	    }
	    

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
