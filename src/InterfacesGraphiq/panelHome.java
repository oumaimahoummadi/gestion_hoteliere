package InterfacesGraphiq;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;

public class panelHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelHome() {
		setBounds(318, 11, 1000, 769);
		setBackground(new Color(220, 220, 220));
		setForeground(new Color(0, 255, 127));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Interface d'administrateur");
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
		lblNewLabel.setBounds(213, 200, 433, 53);
		add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Gestion h\u00F4tellerie");
		lblNewLabel_3.setForeground(new Color(51, 51, 51));
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 50));
		lblNewLabel_3.setBounds(230, 125, 379, 64);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("______________________");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(223, 238, 442, 31);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(panelHome.class.getResource("/images/icons8-hotel-60.png")));
		lblNewLabel_2.setBounds(162, 119, 110, 70);
		add(lblNewLabel_2);
		setVisible(true);

	}

}
