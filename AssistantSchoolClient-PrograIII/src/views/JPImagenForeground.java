package views;

import java.awt.Color;

import javax.swing.JPanel;

import utils.Constants;

public class JPImagenForeground extends JPanel{
	
	private JLBaseLabel imagePanelJL;
	
	public JPImagenForeground() {
		this.setBackground(Color.WHITE);
		initComponents();
	}
	
	private void initComponents() {
	imagePanelJL = new JLBaseLabel(Constants.ROUTE_IMAGEN_FOREGROUND);
	imagePanelJL.setBounds(200, 200, 600, 400);
	add(imagePanelJL);
	}

}
