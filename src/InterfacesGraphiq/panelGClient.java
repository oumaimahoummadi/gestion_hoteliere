package InterfacesGraphiq;

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
import DaoImplementation.ClientsImpl;
import DaoImplementation.RvImpl;
import gestion_hoteliere.*;


import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLDataException;
import java.util.ArrayList;

public class panelGClient extends JPanel {
	private JTextField prenom;
	ArrayList<Clients> rv;
	DaoGlobal rvImpl=new ClientsImpl();
	DaoGlobal clientsImpl=new ClientsImpl();
//	private JTable admins;
	private JTable tAdmin;
	private JTextField nom;
	private JTextField numCompte;
	private JTextField id;
	DefaultTableModel model;
	private JTable table;
	private JTable tClien;
	ArrayList<Clients> clientar;

	/**
	 * Create the panel.
	 */
	
	public panelGClient() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(0,0,1090, 830);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 135, 1090, 127);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des clients______________");
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
		//TABLE-------------------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 508, 714, 246);
		add(scrollPane);
		
		tClien = new JTable();
		tClien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tClien.getSelectedRow();
				id.setText(model.getValueAt(i, 0).toString());
				nom.setText(model.getValueAt(i,1).toString());
				prenom.setText(model.getValueAt(i, 2).toString());
				numCompte.setText(model.getValueAt(i, 3).toString());

			}
		});
		model=new DefaultTableModel();
		Object[] column= {"ID","Nom","Prénom","N\u00B0 Compte"};
		final Object[] row=new Object[5];
		model.setColumnIdentifiers(column);
		rv=new ArrayList<Clients>();
		
		rv.addAll(rvImpl.get());
		for(Clients t:rv) {
			row[0]=t.getId_client();
			row[1]=t.getNom();
			row[2]=t.getPrenom();
			row[3]=t.getNum_compte();

			model.addRow(row);
//			jComboBox.addItem(ob[0]+"");
			//tRv.setModel(model);
		
		//scrollPane.setViewportView(admins);
		}
		
		tClien.setModel(model);
		scrollPane.setViewportView(tClien);
//		DaoGlobal ci=new ClientsImpl();
//		 clientar=new ArrayList<Clients>();
//		clientar.addAll(ci.get());
//
//		for(Clients t:clientar) {
//			row[0]=t.getId_client();
//			row[1]=t.getNom();
//			row[2]=t.getId_client();
//			row[3]=t.getPrenom();
//			row[4]=t.getNum_compte();
//			//tClien.addRow(row);
//
//		}
		tClien.setSelectionBackground(new Color(102, 153, 153));
		tClien.setGridColor(new Color(153, 204, 204));
		tClien.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tClien.setRowHeight(30);
		tClien.setRowMargin(5);
		tClien.setSelectionForeground(new Color(153, 204, 204));
		tClien.setSurrendersFocusOnKeystroke(true);
		tClien.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(102, 153, 153), new Color(51, 102, 102)));
		tClien.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		tClien.setBackground(new Color(220, 220, 220));
		tClien.setForeground(new Color(51, 51, 51));
		
		JTableHeader tHeader=tClien.getTableHeader();
		tHeader.setForeground(new Color(51, 51, 51));
		tHeader.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		tHeader.setBackground(new Color(102, 153, 153));
		//-----------------------------------------------------------------------
		JLabel lblNewLabel = new JLabel("PRENOM");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel.setBounds(42, 353, 143, 35);
		add(lblNewLabel);
		
		prenom = new JTextField();
		prenom.setBounds(163, 357, 195, 28);
		add(prenom);
		prenom.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBorder(null);
		btnAjouter.setBackground(new Color(102, 153, 153));
		btnAjouter.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		//btnNewButton.addMouseListener(new panelbtnMouseAdapter(btnNewButton) );
		btnAjouter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(nom.getText().equals("")||prenom.getText().equals("")) {
					JOptionPane.showMessageDialog( null,"Veuillez entrer touts les champs!!");
				}
				
				else {
					row[0]=id.getText();
					row[1]=nom.getText();
					row[2]=prenom.getText();
					row[3]=numCompte.getText();
					model.addRow(row);

				int ID=Integer.parseInt(id.getText());
				String NOM=nom.getText();
				String PRENOM=prenom.getText();
				int NUM_COMPTE=Integer.parseInt(numCompte.getText());
				
				Clients client=new Clients(ID,NOM,PRENOM,NUM_COMPTE);
				DaoGlobal ci=new ClientsImpl();
				ci.add(client);

				JOptionPane.showMessageDialog( null,"Donnes enregistrer!!");
				
				
			}
				id.setText(" ");
				nom.setText(" ");
				prenom.setText(" ");
				numCompte.setText(" ");
	}
			
				

		});
		btnAjouter.setBounds(42, 462, 109, 35);
		add(btnAjouter);
		
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=tClien.getSelectedRow();
				model.setValueAt(id.getText(), i, 0);
				model.setValueAt(nom.getText(), i, 1);
				model.setValueAt(prenom.getText(), i, 2);
				model.setValueAt(numCompte.getText(), i, 3);

				int ID=Integer.parseInt(id.getText());
				String NOM=nom.getText();
				String PRENOM=prenom.getText();
				int COMPTE=Integer.parseInt(numCompte.getText());
				
				Clients client=new Clients(ID,NOM,PRENOM,COMPTE);
				DaoGlobal c=new ClientsImpl();
				c.update(client);
				JOptionPane.showMessageDialog( null,"Donnes modifier!!");

			}
		});
		btnModifier.setBorder(null);
		btnModifier.setBackground(new Color(102, 153, 153));
		btnModifier.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnModifier.setBounds(163, 462, 109, 35);
		add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int i=tClien.getSelectedRow();

				if(i>=0) {
					
				model.removeRow(i);
				int ID=Integer.parseInt(id.getText());		
				DaoGlobal c=new ClientsImpl();
				c.delete(ID);				
				JOptionPane.showMessageDialog( null,"Supprimer avec succees!!");
				
				id.setText(" ");
				nom.setText(" ");
				prenom.setText(" ");
				numCompte.setText(" ");

				}
				else {
					JOptionPane.showMessageDialog( null,"Supprimer non!!");

				}
					
			}
		});
		
		btnSupprimer.setBackground(new Color(102, 153, 153));
		btnSupprimer.setBorder(null);
		btnSupprimer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnSupprimer.setBounds(290, 462, 109, 35);
		add(btnSupprimer);
		
		JLabel lblNewLabel_3 = new JLabel("NOM");
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(42, 307, 143, 35);
		add(lblNewLabel_3);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(163, 311, 195, 28);
		add(nom);
		
		JLabel lblNewLabel_3_1 = new JLabel("N\u00B0 COMPTE");
		lblNewLabel_3_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(42, 398, 143, 35);
		add(lblNewLabel_3_1);
		
		numCompte = new JTextField();
		numCompte.setColumns(10);
		numCompte.setBounds(163, 402, 195, 28);
		add(numCompte);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(163, 268, 195, 28);
		add(id);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblId.setBounds(42, 264, 143, 35);
		add(lblId);
		
	
		

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
