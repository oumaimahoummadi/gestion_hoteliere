package InterfacesGraphiq;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAO.DaoGlobal;
import DaoImplementation.ClientsImpl;
import gestion_hoteliere.Clients;

public class Window extends JFrame {
	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField num_compte;
	private JTextField id;

	public Window(){
	setTitle("Gesstion Hoteliiiiiiiiiiiiiiiiiiiere");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 748, 636);
	contentPane = new JPanel();
	contentPane.setName("Gestion dhotel");
	contentPane.setBackground(new Color(240, 248, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(240, 248, 255));
	panel.setBounds(10, 11, 712, 575);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("nom");
	lblNewLabel.setToolTipText("");
	lblNewLabel.setBounds(101, 7, 126, 22);
	panel.add(lblNewLabel);
	
	nom = new JTextField();
	nom.setBounds(111, 36, 119, 29);
	panel.add(nom);
	nom.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("prenom");
	lblNewLabel_1.setBounds(17, 60, 97, 14);
	panel.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("numero de compte");
	lblNewLabel_2.setBounds(110, 67, 133, 14);
	panel.add(lblNewLabel_2);
	
	prenom = new JTextField();
	prenom.setBounds(10, 85, 86, 20);
	panel.add(prenom);
	prenom.setColumns(10);
	
	num_compte = new JTextField();
	num_compte.setBounds(111, 85, 86, 20);
	panel.add(num_compte);
	num_compte.setColumns(10);
	
	JButton btnNewButton = new JButton("ajouter");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ID=Integer.parseInt(id.getText());
			String NOM=nom.getText();
			String PRENOM=prenom.getText();
			int NUM_COMPTE=Integer.parseInt(num_compte.getText());
			
			Clients client=new Clients(ID,NOM,PRENOM,NUM_COMPTE);
			DaoGlobal ci=new ClientsImpl();
			ci.add(client);
			
		}
	});
	btnNewButton.setBounds(7, 116, 89, 23);
	panel.add(btnNewButton);
	
	JLabel lblNewLabel_3 = new JLabel("id");
	lblNewLabel_3.setBounds(17, 11, 107, 14);
	panel.add(lblNewLabel_3);
	
	id = new JTextField();
	id.setBounds(10, 35, 86, 20);
	panel.add(id);
	id.setColumns(10);
	
	JButton modifier = new JButton("Modifier");
	modifier.setBounds(121, 116, 89, 23);
	panel.add(modifier);
	
	JButton btnNewButton_1 = new JButton("Supprimer");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ID=Integer.parseInt(id.getText());
			//Clients client=new Clients();
			DaoGlobal c=new ClientsImpl();
			c.delete(ID);
		}
	});
	btnNewButton_1.setBounds(238, 116, 89, 23);
	panel.add(btnNewButton_1);
	modifier.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			int ID=Integer.parseInt(id.getText());
			String NOM=nom.getText();
			String PRENOM=prenom.getText();
			int COMPTE=Integer.parseInt(num_compte.getText());
			
			Clients client=new Clients(ID,NOM,PRENOM,COMPTE);
			DaoGlobal c=new ClientsImpl();
			c.update(client);
			
		}
	});
}}
