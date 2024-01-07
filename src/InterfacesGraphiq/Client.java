package InterfacesGraphiq;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Client extends JFrame {
	private JTextField msg;

	/**
	 * Create the panel.
	 */
	static JTextArea txtMsg;
	public static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		try {
			s=new Socket("127.0.0.1",1201);
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			String msgin="";
			while(!msgin.equals("exit")) {
				msgin=din.readUTF();
				txtMsg.setText(txtMsg.getText().trim()+"\n Serveur: \t" +msgin);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Client main"+e);
		}
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		getContentPane().setBackground(new Color(51, 51, 51));
		getContentPane().setForeground(new Color(51, 51, 51));
		setBounds(0, 75, 825, 631);
		getContentPane().setLayout(null);
		setTitle("Client-Chat");
		 txtMsg = new JTextArea();
		txtMsg.setBounds(55, 60, 668, 450);
		getContentPane().add(txtMsg);
		
		msg = new JTextField();
		msg.setBounds(55, 521, 410, 51);
		getContentPane().add(msg);
		msg.setColumns(10);
		
		JButton envoyer = new JButton("Envoyer");
		envoyer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 24));
		envoyer.setBorder(null);
		envoyer.setBackground(new Color(0, 128, 128));
		envoyer.setForeground(new Color(255, 255, 255));
		envoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msgout="";

				try {
					
					msgout=msg.getText().trim();
					dout.writeUTF(msgout);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Envoyer client"+e);
				}
			}
		});
		envoyer.setBounds(534, 521, 164, 47);
		getContentPane().add(envoyer);
		
		lblNewLabel = new JLabel("CHAT:  C\u00F4t\u00E9 client");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 29));
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setBounds(239, 11, 252, 51);
		getContentPane().add(lblNewLabel);
		
		
	
	}

}
