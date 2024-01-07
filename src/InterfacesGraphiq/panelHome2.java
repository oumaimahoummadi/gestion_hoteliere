package InterfacesGraphiq;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;

public class panelHome2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelHome2() {
		setBounds(0, 75, 1064, 691);
		setBackground(new Color(220, 220, 220));
		setForeground(new Color(0, 255, 127));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue chez notre hotel ...vous pouvez consulter la liste des chambres ici");
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(65, 179, 922, 53);
		add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("HOTEL TWINKLES");
		lblNewLabel_3.setForeground(new Color(51, 51, 51));
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 50));
		lblNewLabel_3.setBounds(383, 102, 453, 55);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("______________________");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(420, 210, 442, 31);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(panelHome2.class.getResource("/images/pic02.jpg")));
		lblNewLabel_2.setBounds(156, 337, 355, 228);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(panelHome2.class.getResource("/images/pic04.jpg")));
		lblNewLabel_4.setBounds(528, 345, 361, 220);
		add(lblNewLabel_4);
		setVisible(true);

	}

}
