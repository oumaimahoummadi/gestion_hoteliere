package InterfacesGraphiq;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class AdminWindow extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow frame = new AdminWindow();
					frame.setUndecorated(true);
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
	public AdminWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 10, 1090, 830);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ToolBar.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Hotel Twinkles");
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 128, 128));
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 472, 898);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("BIENVENUE ADMIN !");
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(120, 707, 207, 48);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminWindow.class.getResource("/images/hotel (1).jpg")));
		lblNewLabel_1.setBounds(0, 0, 472, 667);
		panel.add(lblNewLabel_1);
	   // private Color colorClick;
		JLabel suc = new JLabel("");
		suc.setBounds(10,110,300,25);
		panel.add(suc);
		
		JButton connecterAdmin = new JButton("Connecter");
		connecterAdmin.setFocusCycleRoot(true);
		connecterAdmin.setBorderPainted(false);
		connecterAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		connecterAdmin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		connecterAdmin.setForeground(new Color(255, 255, 255));

		connecterAdmin.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		connecterAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userN=userName.getText();
				String Pw=pw.getText();
				if(userN.equals("usra-ouma")|| Pw.equals("admin123")) {
					suc.setText(("-Vous etes Connecter-!!"));
					(new AdminPanel()).setVisible(true);
				}
				else {
					suc.setText("Veuillez entrer les infos. correcte");
				}
			}
			
		});
		connecterAdmin.setBackground(new Color(0, 128, 128));
		connecterAdmin.setBounds(605, 539, 394, 44);
		contentPane.add(connecterAdmin);
		
		userName = new JTextField();
		userName.setBounds(605, 365, 394, 44);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOM D'UTILISATEUR");
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel.setBounds(605, 334, 320, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("MOT DE PASSE");
		lblMotDePasse.setForeground(new Color(51, 51, 51));
		lblMotDePasse.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblMotDePasse.setBounds(605, 408, 320, 34);
		contentPane.add(lblMotDePasse);
		
		pw = new JPasswordField();
		pw.setBounds(605, 442, 394, 44);
		contentPane.add(pw);
		
		JLabel lblNewLabel_3 = new JLabel("Gestion h\u00F4tellerie");
		lblNewLabel_3.setForeground(new Color(51, 51, 51));
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 50));
		lblNewLabel_3.setBounds(605, 143, 379, 64);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Authentification d'administrateur");
		lblNewLabel_4.setForeground(new Color(102, 102, 102));
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(634, 230, 303, 49);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home aw=new Home();
				aw.setVisible(true);
				close();
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setForeground(new Color(240, 255, 255));
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnNewButton.setBounds(615, 601, 89, 23);
		contentPane.add(btnNewButton);
	}
	public void close() {
		WindowEvent closeWindow=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
