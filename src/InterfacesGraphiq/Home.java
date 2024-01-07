package InterfacesGraphiq;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Home extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 10, 1084, 826);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Hotel Twinkles");
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(0, 0, 1068, 776);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton admin = new JButton("Administrateur");
		admin.setBorder(null);
		admin.setBackground(new Color(0, 128, 128));
		admin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
		admin.setBounds(577, 395, 285, 74);
		panel.add(admin);
		
		JButton client = new JButton("Client");
		client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientWindow cw=new ClientWindow();
				cw.setVisible(true);
				close();
				//btnNewButton.addMouseListener(new panelbtnMouseAdapter(btnNewButton));
			}
		});
		client.setBorder(null);
		client.setBackground(new Color(0, 128, 128));
		client.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
		client.setBounds(120, 395, 298, 74);
		panel.add(client);
		
		JLabel lblNewLabel = new JLabel("Bienvenue a notre application ,etes-vous");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(337, 291, 346, 52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Gestion h\u00F4tellerie");
		lblNewLabel_3.setForeground(new Color(51, 51, 51));
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 50));
		lblNewLabel_3.setBounds(329, 107, 379, 64);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/images/icons8-hotel-60.png")));
		lblNewLabel_2.setBounds(261, 101, 110, 70);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Interface d'administrateur");
		lblNewLabel_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(312, 182, 433, 53);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("______________________");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 34));
		lblNewLabel_1_1.setBounds(322, 220, 442, 31);
		panel.add(lblNewLabel_1_1);
		
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminWindow aw=new AdminWindow();
				aw.setVisible(true);
				close();
			}
		});
	}
	
	public void close() {
		WindowEvent closeWindow=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	

}

