package InterfacesGraphiq;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ClientLogin extends JFrame {

	private JPanel contentPane1;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientLogin frame = new ClientLogin();
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
	public ClientLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 10, 1090, 830);
		contentPane1 = new JPanel();
		contentPane1.setBackground(new Color(245, 245, 245));
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 128, 128));
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 472, 898);
		contentPane1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("BIENVENUE !");
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(157, 706, 207, 48);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ClientLogin.class.getResource("/images/hotel (1).jpg")));
		lblNewLabel_1.setBounds(0, 0, 472, 683);
		panel.add(lblNewLabel_1);
	   // private Color colorClick;

		JButton connecterAdmin = new JButton("Connecter");
		connecterAdmin.setFocusCycleRoot(true);
		connecterAdmin.setBorderPainted(false);
		connecterAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		connecterAdmin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		connecterAdmin.setForeground(new Color(255, 255, 255));

		connecterAdmin.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		connecterAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		connecterAdmin.setBackground(new Color(0, 128, 128));
		connecterAdmin.setBounds(605, 539, 394, 44);
		contentPane1.add(connecterAdmin);
		
		textField = new JTextField();
		textField.setBounds(605, 365, 394, 44);
		contentPane1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOM D'UTILISATEUR");
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel.setBounds(605, 334, 320, 34);
		contentPane1.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("MOT DE PASSE");
		lblMotDePasse.setForeground(new Color(51, 51, 51));
		lblMotDePasse.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblMotDePasse.setBounds(605, 408, 320, 34);
		contentPane1.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(605, 442, 394, 44);
		contentPane1.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("R\u00E9servation des chambres");
		lblNewLabel_3.setBackground(new Color(255, 127, 80));
		lblNewLabel_3.setForeground(new Color(51, 51, 51));
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 50));
		lblNewLabel_3.setBounds(507, 157, 537, 64);
		contentPane1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("_____Authentification_____");
		lblNewLabel_4.setForeground(new Color(0, 128, 128));
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(636, 244, 289, 49);
		contentPane1.add(lblNewLabel_4);
	}

}
