package server;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerDriver {
	private  static Server server = null;
	private static JButton start;
	private static JButton stop;
	private static JLabel status;
	private static JLabel dot;
	private static boolean flag;
	public static void main(String[] args) {
	
		JFrame frame = new JFrame("Server Connection Status");
		frame.getContentPane().setBackground(new Color(0, 206, 209));
		frame.setSize(320, 247);
		frame.getContentPane().setLayout(null);
		
		
		status = new JLabel("SERVER DOWN");
		status.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		status.setBounds(76, 29, 199, 23);
		frame.getContentPane().add(status);
		
		dot = new JLabel("");
		dot.setHorizontalAlignment(SwingConstants.CENTER);
		dot.setIcon(new ImageIcon(ServerDriver.class.getResource("/images/off.png")));
		dot.setBounds(20, 29, 46, 23);
		frame.getContentPane().add(dot);
		
		start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == start) {
					new Thread(() ->{
						try {
						
							status.setText("SERVER RUNNING...");
							stop.setEnabled(true);
							start.setEnabled(false);
							dot.setIcon(new ImageIcon(ServerDriver.class.getResource("/images/on.png")));
							Thread.sleep(2 * 1000);
							server= new Server();

						
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}).start();
				}
			}
		});
		start.setBounds(102, 76, 105, 36);
		frame.getContentPane().add(start);
		
		stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Thread(() -> {
				if(e.getSource()==stop) {
					try {
						start.setEnabled(true);
						stop.setEnabled(false);
						status.setText("SERVER DOWN");
						dot.setIcon(new ImageIcon(ServerDriver.class.getResource("/images/off.png")));
						Thread.sleep(2*1000);
						if(server!=null) {
							server.closeConnection();
							server = null;
						}
						
					}catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
			}
				
				}).start();
			}
		});
		stop.setBounds(100, 140, 107, 36);
		stop.setEnabled(false);
		frame.getContentPane().add(stop);
		
	
		frame.setVisible(true);
		
		
		

	
	

	}
}
