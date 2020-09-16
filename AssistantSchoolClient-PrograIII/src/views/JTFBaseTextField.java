package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import controller.ControllerClient;

public class JTFBaseTextField extends JTextField{

	private static final long serialVersionUID = 1L;

	public JTFBaseTextField(String text, Font font, Color foreColor, int borderSize, 
			ControllerClient controllerApp) {
		this.setFont(font);
		this.setForeground(foreColor);
		this.setText(text);
		this.setBorder(BorderFactory.createEmptyBorder(0, borderSize, 0, borderSize));
		this.setFocusable(true);
        this.addActionListener(controllerApp);
	}
	
	public JTFBaseTextField( Color foreColor,Font font, int columns) {
		this.setFont(font);
		this.setForeground(foreColor);
		this.setColumns(columns);
	}

}