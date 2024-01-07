package InterfacesGraphiq;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.DaoGlobal;
import DaoImplementation.ChambreImpl;
import gestion_hoteliere.Chambres;

public class panelGChambre2 extends JPanel {
	ArrayList<Chambres> rv;
	DaoGlobal rvImpl=new ChambreImpl();
	ArrayList<Chambres> adminAr;
	DaoGlobal adminImpl=new ChambreImpl();
	private JTable admins;
	private JTable tAdmin;
	DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public panelGChambre2() {
		setBounds(0, 75, 1064, 691);
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 121, 1090, 115);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Liste des chambres______________");
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setForeground(SystemColor.controlHighlight);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(48, 72, 511, 47);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H\u00F4tel Twinkles");
		lblNewLabel_2.setForeground(SystemColor.control);
		lblNewLabel_2.setBackground(new Color(192, 192, 192));
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(48, 31, 289, 36);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(220,220,220));
		scrollPane.setBounds(37, 293, 906, 387);
		add(scrollPane);
		///===================================JtaaaableDAta======================================================================
		tAdmin = new JTable();
		
		tAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tAdmin.getSelectedRow();
//				idCh.setText(tAdmin.getValueAt(i, 0).toString());
//				nbrP.setText(tAdmin.getValueAt(i, 0).toString());
//				nbrP.setText(tAdmin.getValueAt(i, 1).toString());
//				prix.setText(tAdmin.getValueAt(i,2).toString());
//				boxType.setSelectedItem(tAdmin.getValueAt(i, 3).toString());

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

}
