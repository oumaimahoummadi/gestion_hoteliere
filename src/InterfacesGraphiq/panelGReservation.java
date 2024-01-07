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
import DaoImplementation.AdminImpl;
import DaoImplementation.ClientsImpl;
import DaoImplementation.RvImpl;
import gestion_hoteliere.Administrateurs;
import gestion_hoteliere.Clients;
import gestion_hoteliere.Reservation;

public class panelGReservation extends JPanel {
	//Administrateurs admin;
	ArrayList<Reservation> rv;
	DaoGlobal rvImpl=new RvImpl();
	private JTable tRv;
	private JTextField noCH;
	private JTextField dateD;
	private JTextField noCl;
	private JTextField dateF;
	private JTextField id_rv;
	DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public panelGReservation() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(0,0,1090, 830);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 135, 1090, 127);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des r\u00E9servations______________");
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
		//-----------------------------------------------------------------------------------------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(220,220,220));
		scrollPane.setBounds(25, 526, 714, 245);
		add(scrollPane);
		
		tRv = new JTable();
		tRv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tRv.getSelectedRow();
				id_rv.setText(tRv.getValueAt(i, 0).toString());
				noCH.setText(tRv.getValueAt(i,1).toString());
				noCl.setText(tRv.getValueAt(i, 2).toString());
				dateD.setText(tRv.getValueAt(i, 3).toString());
				dateF.setText(tRv.getValueAt(i, 3).toString());

			}
		});
		model=new DefaultTableModel();
		Object[] column= {"ID","ID chambre","ID client","Date debut","Date fin"};
		model.setColumnIdentifiers(column);
		final Object[] ob=new Object[5];
		rv=new ArrayList<Reservation>();
		rv.addAll(rvImpl.get());
		for(Reservation t:rv) {
			ob[0]=t.getId_reservation();
			ob[1]=t.getId_chambre();
			ob[2]=t.getId_client();
			ob[3]=t.getDate_debut();
			ob[4]=t.getDate_fin();

			model.addRow(ob);
//			jComboBox.addItem(ob[0]+"");
			//tRv.setModel(model);
		
		//scrollPane.setViewportView(admins);
		}
		
		tRv.setModel(model);
		scrollPane.setViewportView(tRv);
		tRv.setSelectionBackground(new Color(102, 153, 153));
		tRv.setGridColor(new Color(153, 204, 204));
		tRv.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tRv.setRowHeight(30);
		tRv.setRowMargin(5);
		tRv.setSelectionForeground(new Color(153, 204, 204));
		tRv.setSurrendersFocusOnKeystroke(true);
		tRv.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(102, 153, 153), new Color(51, 102, 102)));
		tRv.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		tRv.setBackground(new Color(220, 220, 220));
		tRv.setForeground(new Color(51, 51, 51));
		//-------------------header-----------------
		JTableHeader tHeader=tRv.getTableHeader();
		tHeader.setForeground(new Color(51, 51, 51));
		tHeader.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		tHeader.setBackground(new Color(102, 153, 153));
		//----------------------------------------------------------------------------------------------------------------------------------------------
		JButton addRv = new JButton("Ajouter");
		addRv.setBorder(null);
		addRv.setBackground(new Color(102, 153, 153));
		addRv.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		addRv.addMouseListener(new panelbtnMouseAdapter(addRv) );
		addRv.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(noCH.getText().equals("")||dateD.getText().equals("")||noCl.getText().equals("")||dateF.getText().equals("")) {
					JOptionPane.showMessageDialog( null,"Veuillez entrer touts les champs!!");
					
				}
				
				else {
					ob[0]=id_rv.getText();
					ob[1]=noCH.getText();
					ob[2]=noCl.getText();
					ob[3]=dateD.getText();
					ob[3]=dateF.getText();

					model.addRow(ob);
					int id=Integer.parseInt(id_rv.getText());
					int noChambre=Integer.parseInt(noCH.getText());
					int noClient=Integer.parseInt(noCl.getText());
					String DateD=dateD.getText();
					String DateF=dateF.getText();
					
					Reservation rv=new Reservation(id,noChambre,noClient,DateD,DateF);
					DaoGlobal ci=new RvImpl();
					ci.add(rv);
					JOptionPane.showMessageDialog( null,"Donnes enregistrer!!");

				}
				id_rv.setText(" ");
				noCH.setText(" ");
				noCl.setText(" ");
				dateD.setText(" ");
				dateF.setText(" ");


			}
		});
		addRv.setBounds(25, 475, 109, 35);
		add(addRv);
		

		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int i=tRv.getSelectedRow();
				model.setValueAt(id_rv.getText(), i, 0);
				model.setValueAt(noCH.getText(), i, 1);
				model.setValueAt(noCl.getText(), i, 2);
				model.setValueAt(dateD.getText(), i, 3);
				model.setValueAt(dateF.getText(), i, 4);

				int ID=Integer.parseInt(id_rv.getText());
				int NO=Integer.parseInt(noCH.getText());
				int NOCL=Integer.parseInt(noCl.getText());
				String DATED=dateD.getText();
				String DATEF=dateF.getText();
				
				Reservation rv=new Reservation(ID,NO,NOCL,DATED,DATEF);
				DaoGlobal c=new RvImpl();
				c.update(rv);
				JOptionPane.showMessageDialog( null,"Donnes modifier!!");
			}
		});
		btnModifier.setBorder(null);
		btnModifier.setBackground(new Color(102, 153, 153));
		btnModifier.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnModifier.setBounds(146, 475, 109, 35);
		add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(new Color(102, 153, 153));
		btnSupprimer.setBorder(null);
		btnSupprimer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogResult = JOptionPane.showConfirmDialog (null, "Etes-vous sur de vouloir supprimer ces donnes?");
				if(dialogResult == JOptionPane.YES_OPTION){
					int i=tRv.getSelectedRow();
	
					if(i>=0) {
						
					model.removeRow(i);
					int ID=Integer.parseInt(id_rv.getText());		
					DaoGlobal c=new RvImpl();
					c.delete(ID);				
					
					id_rv.setText(" ");
					noCH.setText(" ");
					noCl.setText(" ");
					dateD.setText(" ");
					dateF.setText(" ");
	
					}	
					else {
					JOptionPane.showMessageDialog( null,"Supprimer non!!");}
				}
			
					
			}
		});
		btnSupprimer.setBounds(273, 475, 109, 35);
		add(btnSupprimer);
		
		noCH = new JTextField();
		noCH.setColumns(10);
		noCH.setBounds(153, 309, 195, 28);
		add(noCH);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00B0 DE CHAMBRE");
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(42, 305, 143, 35);
		add(lblNewLabel_3);
		
		dateD = new JTextField();
		dateD.setColumns(10);
		dateD.setBounds(153, 390, 195, 28);
		add(dateD);
		
		JLabel lblNewLabel_3_1 = new JLabel("DATE DE DEBUT");
		lblNewLabel_3_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(42, 386, 143, 35);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00B0 DE CLIENT");
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(42, 348, 143, 35);
		add(lblNewLabel_4);
		
		noCl = new JTextField();
		noCl.setColumns(10);
		noCl.setBounds(153, 352, 195, 28);
		add(noCl);
		
		JLabel lblNewLabel_4_1 = new JLabel("DATE DE FIN");
		lblNewLabel_4_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(42, 429, 143, 35);
		add(lblNewLabel_4_1);
		
		dateF = new JTextField();
		dateF.setColumns(10);
		dateF.setBounds(153, 433, 195, 28);
		add(dateF);
		
		id_rv = new JTextField();
		id_rv.setColumns(10);
		id_rv.setBounds(153, 267, 195, 28);
		add(id_rv);
		
		JLabel lblNewLabel_3_2 = new JLabel("ID");
		lblNewLabel_3_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(42, 263, 143, 35);
		add(lblNewLabel_3_2);

	}
	private void tHeader() {
		JTableHeader tHeader=tRv.getTableHeader();
		
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


