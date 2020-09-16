package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import utils.Constants;

public class JPHeadName extends JPanel{
	private JLBaseLabel jLNameUser;
	private JLBaseLabel jLTypeUser;
	
	public JPHeadName(String nameUser, String typeUser) {
		super();
		this.setSize(100, 50);
		this.setBackground(Constants.BASE_BLUE);
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		this.setLayout(new GridLayout(2, 1));
		this.jLNameUser = new JLBaseLabel(nameUser, Constants.TWENTY_EIGHT_BASE_FONT, Color.WHITE);
		this.jLTypeUser = new JLBaseLabel(typeUser, Constants.TWENTY_BASE_FONT, Constants.ALTERNATIVE_LIGHT_GRAY);
		this.add(jLNameUser);
		this.add(jLTypeUser);
		this.setVisible(true);
	}
	

}
