package InterfacesGraphiq;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.SystemColor;
public class AdminPanel extends JFrame {

	private JPanel contentPane;
	//private Image homeIcon=new ImageIcon(FrameLogin.class.getRessource("images/home.ico")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private panelHome pHome;
	private panelGAdmin pGAdmin;
	private panelGReservation pGRv;
	private panelGClient pGClient;
//	private panelGChambre pGChambre;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setTitle("Hotel Twinkles");

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 10, 1084, 826);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//-----------toMenuSwitched-----------------------------------------
		pHome=new panelHome();
		pHome.setBounds(0, 0, 908, 791);
		//pHome.setBounds(0, 0, 0, 0);
		pGAdmin=new panelGAdmin();
//		pGAdmin.setBounds(0, 0, 0, 0);
		pGRv=new panelGReservation();
//		pGRv.setBounds(0, 0, 0, 0);
		pGClient=new panelGClient();
//		pGClient.setBounds(0, 0, 0, 0);
		//---------------------------------------------------
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1074, 791);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(0, 0, 308, 801);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel toAdmine = new JPanel();
		toAdmine.addMouseListener(new panelbtnMouseAdapter(toAdmine) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuSwitched(pGAdmin);
			}
		});

		toAdmine.setBackground(new Color(105, 105, 105));
		toAdmine.setForeground(new Color(160, 82, 45));
		toAdmine.setBounds(0, 320, 306, 51);
		panel_1.add(toAdmine);
		toAdmine.setLayout(null);
		
		JLabel lblGestion = new JLabel("GESTION DES CHAMBRES");
		lblGestion.setForeground(Color.LIGHT_GRAY);
		lblGestion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblGestion.setBounds(43, 11, 195, 29);
		toAdmine.add(lblGestion);
		
		JPanel toClients = new JPanel();
		toClients.addMouseListener(new panelbtnMouseAdapter(toClients) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuSwitched(pGClient);
			}
		});

		toClients.setBackground(new Color(105, 105, 105));
		toClients.setForeground(new Color(160, 82, 45));
		toClients.setBounds(0, 469, 306, 51);
		panel_1.add(toClients);
		toClients.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("GESTION DES CLIENTS");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(62, 11, 172, 29);
		toClients.add(lblNewLabel_1_1);
		
		JPanel toReservation = new JPanel();
		toReservation.addMouseListener(new panelbtnMouseAdapter(toReservation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuSwitched(pGRv);
			}
		});

		toReservation.setBackground(new Color(105, 105, 105));
		toReservation.setForeground(new Color(160, 82, 45));
		toReservation.setBounds(0, 395, 306, 51);
		panel_1.add(toReservation);
		toReservation.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("GESTION DES RESERVATIONS");
		lblNewLabel_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(42, 11, 219, 29);
		toReservation.add(lblNewLabel_1_2);
		
		JPanel deconn = new JPanel();
		deconn.addMouseListener(new panelbtnMouseAdapter(deconn) {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Etes-vous sure de deconnecter?")==0) {
					AdminWindow decon=new AdminWindow();
					decon.setVisible(true);
					AdminPanel.this.dispose();
				}
			}
			
		});

		deconn.setBackground(new Color(105, 105, 105));
		deconn.setForeground(new Color(160, 82, 45));
		deconn.setBounds(0, 543, 306, 51);
		panel_1.add(deconn);
		deconn.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("DECONNECTER");
		lblNewLabel_1_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_2_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(86, 11, 121, 29);
		deconn.add(lblNewLabel_1_2_1);
		
		JPanel toHome = new JPanel();
		toHome.addMouseListener(new panelbtnMouseAdapter(toHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuSwitched(pHome);
			}
		});
		toHome.setBackground(new Color(105, 105, 105));
		toHome.setForeground(new Color(160, 82, 45));
		toHome.setBounds(0, 250, 306, 51);
		panel_1.add(toHome);
		toHome.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCUEIL");
		//lblNewLabel.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/home.ico")));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(102, 11, 69, 29);
		toHome.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("H\u00F4tel twinkles");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(27, 81, 138, 57);
		panel_1.add(lblNewLabel_2);
		
		JPanel panelMain2 = new JPanel();
		panelMain2.setBounds(318, 11, 1000, 769);
		panel.add(panelMain2);
		
//		JPanel panelMain = new JPanel();
		panelMain2.setLayout(null);
		panelMain2.add(pHome);
		//pHome.setVisible(true);
		
		panelMain2.add(pGAdmin);

		panelMain2.add(pGRv);
		panelMain2.add(pGClient);


		menuSwitched(pHome);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(167, 107, 60, 78);
		pHome.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/icons8-hotel-60.png")));
		
		panelMain2.setBounds(305, 0, 769, 791);
		//panel.add(pHome);
	}
	public void menuSwitched(JPanel panel) {
		pHome.setVisible(false);
		pGAdmin.setVisible(false);
		pGRv.setVisible(false);
		pGClient.setVisible(false);
//		pGChambre.setVisible(false);
		panel.setVisible(true);
		
	}
	private class panelbtnMouseAdapter extends MouseAdapter{
		JPanel panel;
		public panelbtnMouseAdapter(JPanel panel){
			this.panel =panel;	
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(0, 102, 102));	

		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(105, 105, 105));	

		
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(0, 102, 102));	
			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(105, 105, 105));		
		}
	}
}
