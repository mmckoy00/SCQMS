package Jframes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serial;
import java.util.Objects;

public class Splash extends JFrame {
    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;
    private static JProgressBar progressBar;
    private static JLabel lblCount;
    private static int mouseX, mouseY;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        int x;

        Splash frame = new Splash();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        for(x=0; x<=100;x++) {
            try {
                Splash.progressBar.setValue(x);
                Thread.sleep(100);
                Splash.lblCount.setText(Integer.toString(x) + "%");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        new Authentication().setVisible(true);
        frame.dispose();

    }

    /**
     * Create the frame.
     */
    public Splash() {
        setUndecorated(true);
        setBackground(new Color(32, 178, 170));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 540, 260);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        contentPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(getX() + e.getX() - mouseX, getY() + e.getY()- mouseY);
            }
        });

        //Subtitle
        JLabel lblSubtitle = new JLabel("Complaints and Queries Management System");
        lblSubtitle.setForeground(Color.WHITE);
        lblSubtitle.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
        lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubtitle.setBounds(93, 119, 350, 23);
        contentPane.add(lblSubtitle);

        //Title
        JLabel lblNewLabel = new JLabel("UTech Ja. Student Services");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(211, 211, 211));
        lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 27));
        lblNewLabel.setBounds(64, 68, 450, 48);
        contentPane.add(lblNewLabel);

        //Progress Bar
        progressBar = new JProgressBar();
        progressBar.setForeground(new Color(112, 128, 144));
        progressBar.setBackground(new Color(255, 255, 255));
        progressBar.setBounds(70, 170, 430, 10);
        contentPane.add(progressBar);

        //Progress Bar loading modules
        JLabel lblLoading = new JLabel("Loading Modules...");
        lblLoading.setForeground(new Color(0, 0, 0));
        lblLoading.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblLoading.setBounds(43, 211, 110, 14);
        contentPane.add(lblLoading);

        //Background Image
        JLabel lblBackground = new JLabel("");
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(Splash.class.getResource("/images/splash.jpg")));

        //Progress Bar numbers
        lblCount = new JLabel("");
        lblCount.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblCount.setForeground(new Color(0, 0, 0));
        lblCount.setBounds(480, 211, 46, 14);
        contentPane.add(lblCount);
        lblBackground.setIcon(icon);
        lblBackground.setBounds(0, 0, 545, 260);
        contentPane.add(lblBackground);
    }
}
