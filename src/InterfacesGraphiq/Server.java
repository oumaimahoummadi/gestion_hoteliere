package InterfacesGraphiq;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class Server extends JFrame {
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	private JPanel contentPane;
	private static JTextField msg;
	static JTextArea txtMsg;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		String msgin="";
		try {
			ss=new ServerSocket(1201);
			s=ss.accept();
			
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			
			while(!msgin.equals("exit")) {
				msgin=din.readUTF();
				txtMsg.setText(txtMsg.getText().trim()+"\n" +msgin); 
				
			}
		}
		
		catch(Exception e)
		{
			System.out.println("Server main"+e);
		}
	}

	/**
	 * Create the frame.
	 */
	public Server() {
		setTitle("Serveur-chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 75, 825, 631);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 txtMsg = new JTextArea();
		txtMsg.setText("");
		txtMsg.setBounds(90, 53, 601, 452);
		contentPane.add(txtMsg);
		
		msg = new JTextField();
		msg.setBounds(90, 516, 431, 42);
		contentPane.add(msg);
		msg.setColumns(10);
		
		JButton envoyer = new JButton("Envoyer");
		envoyer.setForeground(new Color(255, 255, 255));
		envoyer.setBackground(new Color(51, 51, 51));
		envoyer.setBorder(null);
		envoyer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		envoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String msgout="";
					msgout=msg.getText().trim();
					dout.writeUTF(msgout);
				} 
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("SErver envoyer prblm");
				}
			}
		});
		envoyer.setBounds(569, 516, 190, 37);
		contentPane.add(envoyer);
		
		lblNewLabel = new JLabel("CHAT: C\u00F4t\u00E9 serveur");
		lblNewLabel.setBackground(new Color(51, 51, 51));
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 29));
		lblNewLabel.setBounds(257, 11, 274, 42);
		contentPane.add(lblNewLabel);
		
		
	}
}
