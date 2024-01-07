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
public class ClientWindow extends JFrame {

	private JPanel contentPane;
	private panelHome2 pHome;
//	private panelGAdmin pGAdmin;
	private panelGReservation2 pGRv;
//	private panelGClient pGClient;
	private panelGChambre2 pGChambre;
	


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
	public ClientWindow() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 10, 1084, 826);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Hotel Twinkles");

//-------------------------------------------
		pHome=new panelHome2();
		pHome.setLocation(0, 11);
//		pHome.setBounds(0, 0, 908, 791);
		//pHome.setBounds(0, 0, 0, 0);
		pGChambre=new panelGChambre2();
		pGChambre.setLocation(0, 11);
//		pGAdmin.setBounds(0, 0, 0, 0);
		pGRv=new panelGReservation2();
		pGRv.setLocation(0, 11);
//		pGRv.setBounds(0, 0, 0, 0);
//		pGClient=new panelGClient();
//		pGClient.setBounds(0, 0, 0, 0);
		//---------------------------------------------------
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1074, 791);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(0, 0, 1064, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel toAdmine = new JPanel();
		toAdmine.addMouseListener(new panelbtnMouseAdapter(toAdmine) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuSwitched(pGChambre);
			}
		});

		toAdmine.setBackground(new Color(105, 105, 105));
		toAdmine.setForeground(new Color(160, 82, 45));
		toAdmine.setBounds(252, 11, 256, 51);
		panel_1.add(toAdmine);
		toAdmine.setLayout(null);
		
		JLabel lblGestion = new JLabel("LISTE DES CHAMBRES");
		lblGestion.setForeground(Color.LIGHT_GRAY);
		lblGestion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblGestion.setBounds(41, 11, 174, 29);
		toAdmine.add(lblGestion);
		
		JPanel toReservation = new JPanel();
		toReservation.addMouseListener(new panelbtnMouseAdapter(toReservation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuSwitched(pGRv);
			}
		});

		toReservation.setBackground(new Color(105, 105, 105));
		toReservation.setForeground(new Color(160, 82, 45));
		toReservation.setBounds(518, 11, 283, 51);
		panel_1.add(toReservation);
		toReservation.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("CONTACTER SERVEUR");
		lblNewLabel_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(56, 11, 194, 29);
		toReservation.add(lblNewLabel_1_2);
		
		JPanel deconn = new JPanel();
		deconn.addMouseListener(new panelbtnMouseAdapter(deconn) {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Etes-vous sure de deconnecter?")==0) {
					AdminWindow decon=new AdminWindow();
					decon.setVisible(true);
					ClientWindow.this.dispose();
				}
			}
			
		});

		deconn.setBackground(new Color(105, 105, 105));
		deconn.setForeground(new Color(160, 82, 45));
		deconn.setBounds(811, 11, 232, 51);
		panel_1.add(deconn);
		deconn.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("DECONNECTER");
		lblNewLabel_1_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_2_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(70, 11, 121, 29);
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
		toHome.setBounds(10, 11, 232, 51);
		panel_1.add(toHome);
		toHome.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCUEIL");
		//lblNewLabel.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/home.ico")));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(91, 11, 69, 29);
		toHome.add(lblNewLabel);
		
		JPanel panelMain2 = new JPanel();
		panelMain2.setLayout(null);
		panelMain2.setBounds(0, 75, 1064, 691);
		panel.add(panelMain2);
		
	
		panelMain2.add(pHome);
		
		
		panelMain2.add(pGChambre);
		
		
		panelMain2.add(pGRv);
//		panel.add(pHome);
	}
	public void menuSwitched(JPanel panel) {
		pHome.setVisible(false);
//		pGAdmin.setVisible(false);
		pGRv.setVisible(false);
//		pGClient.setVisible(false);
		pGChambre.setVisible(false);
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
			panel.setBackground(new Color(102, 153, 153));	
			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(105, 105, 105));		
		}
	}
	
	
}
