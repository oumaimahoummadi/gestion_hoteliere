package InterfacesGraphiq;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.DaoGlobal;
import DaoImplementation.AdminImpl;
import DaoImplementation.ChambreImpl;
import DaoImplementation.ClientsImpl;
import DaoImplementation.RvImpl;
import gestion_hoteliere.Administrateurs;
import gestion_hoteliere.Chambres;
import gestion_hoteliere.Clients;
import gestion_hoteliere.Reservation;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class panelGAdmin extends JPanel {
	ArrayList<Chambres> rv;
	DaoGlobal rvImpl=new ChambreImpl();
	private JTextField nbrP;
	ArrayList<Chambres> adminAr;
	DaoGlobal adminImpl=new ChambreImpl();
	private JTable admins;
	private JTable tAdmin;
	private JTextField prix;
	private JTextField idCh;
	JComboBox boxType;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public panelGAdmin() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(0,0,1090, 830);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 135, 1090, 127);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des chambres______________");
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setForeground(SystemColor.controlHighlight);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(48, 72, 511, 47);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("G\u00E9rer mon h\u00F4tel");
		lblNewLabel_2.setForeground(SystemColor.control);
		lblNewLabel_2.setBackground(new Color(192, 192, 192));
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(48, 40, 289, 36);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(220,220,220));
		scrollPane.setBounds(32, 537, 714, 239);
		add(scrollPane);
		///===================================JtaaaableDAta======================================================================
		tAdmin = new JTable();
		
		tAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tAdmin.getSelectedRow();
				idCh.setText(tAdmin.getValueAt(i, 0).toString());
				nbrP.setText(tAdmin.getValueAt(i, 0).toString());
				nbrP.setText(tAdmin.getValueAt(i, 1).toString());
				prix.setText(tAdmin.getValueAt(i,2).toString());
				boxType.setSelectedItem(tAdmin.getValueAt(i, 3).toString());

			}
		});
		model=new DefaultTableModel();
		Object[] column= {"ID","Nombre des personnes","Prix","Type"};
		model.setColumnIdentifiers(column);
		final Object[] ob=new Object[4];
		rv=new ArrayList<Chambres>();
		rv.addAll(rvImpl.get());
		
		for(Chambres t:rv) {
			ob[0]=t.getId_chambre();
			ob[1]=t.getNombre_personne();
			ob[2]=t.getPrix();
			ob[3]=t.getType();

			model.addRow(ob);
			//boxType.addItem(ob[0]+"");
			tAdmin.setModel(model);
		
		//scrollPane.setViewportView(admins);
		}
		scrollPane.setViewportView(tAdmin);
		
		
		tAdmin.setSelectionBackground(new Color(102, 153, 153));
		tAdmin.setGridColor(new Color(153, 204, 204));
		tAdmin.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tAdmin.setRowHeight(30);
		tAdmin.setRowMargin(5);
		tAdmin.setSelectionForeground(new Color(153, 204, 204));
		tAdmin.setSurrendersFocusOnKeystroke(true);
		tAdmin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(102, 153, 153), new Color(51, 102, 102)));
		tAdmin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		tAdmin.setBackground(new Color(220, 220, 220));
		tAdmin.setForeground(new Color(51, 51, 51));
		
		//-------------------header-----------------
				JTableHeader tHeader=tAdmin.getTableHeader();
				tHeader.setForeground(new Color(51, 51, 51));
				tHeader.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
				tHeader.setBackground(new Color(102, 153, 153));

		//======================================================================================================================
		JLabel lblNewLabel = new JLabel("NOMBRE DES PERSONNES");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel.setBounds(42, 306, 143, 35);
		add(lblNewLabel);
		
		nbrP = new JTextField();
		nbrP.setBounds(183, 310, 195, 28);
		add(nbrP);
		nbrP.setColumns(10);

		 boxType = new JComboBox();
		boxType.addItem("Classique");
		boxType.addItem("Superieure");
		boxType.addItem("Twin");
		boxType.addItem("Familiale");
		boxType.setSelectedItem(null);
		boxType.setBounds(183, 402, 195, 28);
		add(boxType);
		JButton addChambre = new JButton("Ajouter");
		addChambre.setBorder(null);
		addChambre.setBackground(new Color(102, 153, 153));
		addChambre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		//btnNewButton.addMouseListener(new panelbtnMouseAdapter(btnNewButton) );
		addChambre.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(idCh.getText().equals("")||nbrP.getText().equals("")||prix.getText().equals("")||boxType.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog( null,"Veuillez entrer touts les champs!!");
					
				}
				
				else {
					ob[0]=idCh.getText();
					ob[1]=nbrP.getText();
					ob[2]=prix.getText();
					ob[3]=boxType.getSelectedItem();

					model.addRow(ob);
					int ID=Integer.parseInt(idCh.getText());
					int NBRP=Integer.parseInt(nbrP.getText());
					int PRIX=Integer.parseInt(prix.getText());
					String TYPE=(String)boxType.getSelectedItem();
					Chambres chambre=new Chambres(ID,NBRP,PRIX,TYPE);
					DaoGlobal ci=new ChambreImpl();
					ci.add(chambre);
					
					JOptionPane.showMessageDialog( null,"Donnes enregistrer!!");

				}
				idCh.setText(" ");
				nbrP.setText(" ");
				prix.setText(" ");
				boxType.setSelectedItem(" ");
				
		

			}
		});
		addChambre.setBounds(42, 462, 109, 35);
		add(addChambre);
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int i=tAdmin.getSelectedRow();
				model.setValueAt(idCh.getText(), i, 0);
				model.setValueAt(nbrP.getText(), i, 1);
				model.setValueAt(prix.getText(), i, 2);
				model.setValueAt(boxType.getSelectedItem(), i, 3);

				int ID=Integer.parseInt(idCh.getText());
				int NO=Integer.parseInt(nbrP.getText());
				int PRIX=Integer.parseInt(prix.getText());
				String TYPE=(String)boxType.getSelectedItem();

				
				Chambres rv=new Chambres(ID,NO,PRIX,TYPE);
				DaoGlobal c=new ChambreImpl();
				c.update(rv);
				JOptionPane.showMessageDialog( null,"Donnes modifier!!");
				
			}
		});
		btnModifier.setBorder(null);
		btnModifier.setBackground(new Color(102, 153, 153));
		btnModifier.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnModifier.setBounds(163, 462, 109, 35);
		add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(new Color(102, 153, 153));
		btnSupprimer.setBorder(null);
		btnSupprimer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogResult = JOptionPane.showConfirmDialog (null, "Etes-vous sur de vouloir supprimer ces donnes?");
				if(dialogResult == JOptionPane.YES_OPTION){
					int i=tAdmin.getSelectedRow();
	
					if(i>=0) {
						
						
						
					model.removeRow(i);
					int ID=Integer.parseInt(idCh.getText());		
					DaoGlobal c=new ChambreImpl();
					c.delete(ID);				
					
					idCh.setText(" ");
					nbrP.setText(" ");
					prix.setText(" ");
					boxType.setSelectedItem(" ");
	
					}	
					else {
					JOptionPane.showMessageDialog( null,"Supprimer non!!");}
				}
			}
		});
		btnSupprimer.setBounds(290, 462, 109, 35);
		add(btnSupprimer);
		
		JLabel lblPrix = new JLabel("PRIX");
		lblPrix.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblPrix.setBounds(42, 352, 143, 35);
		add(lblPrix);
		
		prix = new JTextField();
		prix.setColumns(10);
		prix.setBounds(183, 356, 195, 28);
		add(prix);
		
		JLabel lblNewLabel_3_1 = new JLabel("TYPE");
		lblNewLabel_3_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(42, 398, 143, 35);
		add(lblNewLabel_3_1);
		
		JLabel id = new JLabel("ID");
		id.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		id.setBounds(42, 269, 143, 35);
		add(id);
		
		idCh = new JTextField();
		idCh.setColumns(10);
		idCh.setBounds(183, 273, 195, 28);
		add(idCh);
		
		
//		Object[] ob=new Object[4];
//		adminAr=new ArrayList<Chambres>();
//		JComboBox jComboBox = new JComboBox();
//		//JComboBox jComboBox = new JComboBox();
//		jComboBox.removeAllItems();
//		String[] col= {"ID","Nombre des personnes","Prix","Type"};
//		DefaultTableModel tab=new DefaultTableModel(null,col);
//		adminAr.addAll(adminImpl.get());
//		
//		for(Chambres t:adminAr) {
//			ob[0]=t.getId_chambre();
//			ob[1]=t.getNombre_personne();
//			ob[2]=t.getPrix();
//			ob[2]=t.getType();
//
//			tab.addRow(ob);
//			jComboBox.addItem(ob[0]+"");
//			tAdmin.setModel(tab);
		
		//scrollPane.setViewportView(admins);
		
	}
	private void tHeader() {
		JTableHeader tHeader=tAdmin.getTableHeader();
		
	}
	private class panelbtnMouseAdapter extends MouseAdapter{
		JButton btn;
		public panelbtnMouseAdapter(JButton btn){
			this.btn =btn;	
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btn.setBackground(new Color(0,0,0));	

		}
		@Override
		public void mouseExited(MouseEvent e) {
			btn.setBackground(new Color(102, 153, 153));	

		
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			btn.setBackground(new Color(102, 153, 153));	
			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			btn.setBackground(new Color(102, 153, 153));		
		}
	}
}