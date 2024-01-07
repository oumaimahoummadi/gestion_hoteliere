//package InterfacesGraphiq;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.ListSelectionModel;
//import javax.swing.border.BevelBorder;
//import javax.swing.border.SoftBevelBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;
//
//import DAO.DaoGlobal;
//import DaoImplementation.AdminImpl;
//import gestion_hoteliere.Administrateurs;
//
//public class panelGChambre extends JPanel {
//	private JTextField textLogin;
//	private JTextField textPw;
//	//Administrateurs admin;
//	ArrayList<Administrateurs> adminAr;
//	DaoGlobal adminImpl=new AdminImpl();
//	private JTable admins;
//	private JTable tAdmin;
//
//	/**
//	 * Create the panel.
//	 */
//	public panelGChambre() {
//		setBackground(SystemColor.inactiveCaptionBorder);
//		setBounds(0,0,1090, 830);
//		setLayout(null);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(51, 51, 51));
//		panel.setBounds(0, 135, 1090, 127);
//		add(panel);
//		panel.setLayout(null);
//		
//		JLabel lblNewLabel_1 = new JLabel("Gestion des administrateurs______________");
//		lblNewLabel_1.setBackground(new Color(192, 192, 192));
//		lblNewLabel_1.setForeground(SystemColor.controlHighlight);
//		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
//		lblNewLabel_1.setBounds(48, 72, 511, 47);
//		panel.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_2 = new JLabel("G\u00E9rer mon h\u00F4tel");
//		lblNewLabel_2.setForeground(SystemColor.control);
//		lblNewLabel_2.setBackground(new Color(192, 192, 192));
//		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
//		lblNewLabel_2.setBounds(48, 40, 289, 36);
//		panel.add(lblNewLabel_2);
//		
//		JLabel lblNewLabel = new JLabel("NOM D'UTILISATEUR");
//		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
//		lblNewLabel.setBounds(42, 306, 143, 35);
//		add(lblNewLabel);
//		
//		textLogin = new JTextField();
//		textLogin.setBounds(42, 342, 195, 28);
//		add(textLogin);
//		textLogin.setColumns(10);
//		
//		JButton btnNewButton = new JButton("Ajouter");
//		btnNewButton.setBorder(null);
//		btnNewButton.setBackground(new Color(102, 153, 153));
//		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
//		btnNewButton.addMouseListener(new panelbtnMouseAdapter(btnNewButton) );
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(textLogin.getText().equals("")||textPw.getText().equals("")) {
//					JOptionPane.showMessageDialog( null,"Veuillez entrer touts les champs!!");
//					
//				}
//
//			}
//		});
//		btnNewButton.setBounds(42, 462, 109, 35);
//		add(btnNewButton);
//		
//		JLabel lblMotDePasse = new JLabel("MOT DE PASSE");
//		lblMotDePasse.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
//		lblMotDePasse.setBounds(42, 378, 143, 35);
//		add(lblMotDePasse);
//		
//		textPw = new JTextField();
//		textPw.setColumns(10);
//		textPw.setBounds(42, 412, 195, 28);
//		add(textPw);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBackground(new Color(220,220,220));
//		scrollPane.setBounds(32, 537, 714, 127);
//		add(scrollPane);
//		
//		tAdmin = new JTable();
//		tAdmin.setSelectionBackground(new Color(102, 153, 153));
//		tAdmin.setGridColor(new Color(153, 204, 204));
//		tAdmin.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		tAdmin.setRowHeight(30);
//		tAdmin.setRowMargin(5);
//		tAdmin.setSelectionForeground(new Color(153, 204, 204));
//		tAdmin.setSurrendersFocusOnKeystroke(true);
//		tAdmin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(102, 153, 153), new Color(51, 102, 102)));
//		tAdmin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
//		tAdmin.setBackground(new Color(220, 220, 220));
//		tAdmin.setForeground(new Color(51, 51, 51));
//		//-------------------header-----------------
//		JTableHeader tHeader=tAdmin.getTableHeader();
//		tHeader.setForeground(new Color(51, 51, 51));
//		tHeader.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
//		tHeader.setBackground(new Color(102, 153, 153));
//
//		
//		tAdmin.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"ID", "login", "pw"
//			}
//		));
//		tAdmin.getColumnModel().getColumn(0).setMinWidth(10);
//		scrollPane.setViewportView(tAdmin);
//		
//		JButton btnModifier = new JButton("Modifier");
//		btnModifier.setBorder(null);
//		btnModifier.setBackground(new Color(102, 153, 153));
//		btnModifier.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
//		btnModifier.setBounds(163, 462, 109, 35);
//		add(btnModifier);
//		
//		JButton btnSupprimer = new JButton("Supprimer");
//		btnSupprimer.setBackground(new Color(102, 153, 153));
//		btnSupprimer.setBorder(null);
//		btnSupprimer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
//		btnSupprimer.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnSupprimer.setBounds(290, 462, 109, 35);
//		add(btnSupprimer);
//		
//		Object[] ob=new Object[3];
//		adminAr=new ArrayList<Administrateurs>();
//		JComboBox jComboBox = new JComboBox();
//		//JComboBox jComboBox = new JComboBox();
//		jComboBox.removeAllItems();
//		String[] col= {"ID","Nom d'utilisateur","Mot de passe"};
//		DefaultTableModel tab=new DefaultTableModel(null,col);
//		adminAr.addAll(adminImpl.get());
//		
//		for(Administrateurs t:adminAr) {
//			ob[0]=t.getId_admin();
//			ob[1]=t.getLogin();
//			ob[2]=t.getPassword();
//			tab.addRow(ob);
//			jComboBox.addItem(ob[0]+"");
//			tAdmin.setModel(tab);
//		
//		//scrollPane.setViewportView(admins);
//		}
//	}
//	private void tHeader() {
//		JTableHeader tHeader=tAdmin.getTableHeader();
//		
//	}
//	private class panelbtnMouseAdapter extends MouseAdapter{
//		JButton btn;
//		public panelbtnMouseAdapter(JButton btn){
//			this.btn =btn;	
//		}
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			btn.setBackground(new Color(0,0,0));	
//
//		}
//		@Override
//		public void mouseExited(MouseEvent e) {
//			btn.setBackground(new Color(102, 153, 153));	
//
//		
//		}
//		
//		@Override
//		public void mousePressed(MouseEvent e) {
//			btn.setBackground(new Color(102, 153, 153));	
//			
//		}
//		
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			btn.setBackground(new Color(102, 153, 153));		
//		}
//
//	}
//
//}
