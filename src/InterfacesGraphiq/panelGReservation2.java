package InterfacesGraphiq;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelGReservation2 extends JPanel {
	public static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	
	
	public panelGReservation2() {
		setBounds(0, 75, 1064, 691);
		setLayout(null);
		
		lblNewLabel = new JLabel("Acceder au chat avec serveur en cliquant ici :");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		lblNewLabel.setBounds(189, 194, 489, 62);
		add(lblNewLabel);
		
		btnNewButton = new JButton("Lancer chat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client c=new Client();
				c.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 21));
		btnNewButton.setBounds(245, 250, 283, 43);
		add(btnNewButton);
		
		
	}

}
