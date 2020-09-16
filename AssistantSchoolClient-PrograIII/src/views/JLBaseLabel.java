package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class JLBaseLabel extends JLabel{

	private static final long serialVersionUID = 1L;
	
	public JLBaseLabel(String imgPath) {
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));
	}
	
	public JLBaseLabel(String text, Font font, Color foregroundColor) {
		super(text);
		this.setFont(font);
		this.setForeground(foregroundColor);
	}
	
	public JLBaseLabel(Font font, Color foregroundColor) {
		Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(line);
		this.setFont(font);
		this.setForeground(foregroundColor);
	}
	
	public JLBaseLabel(String text, Font font, Color foregroundColor, int alignment) {
		super(text);
		this.setFont(font);
		this.setForeground(foregroundColor);
		this.setHorizontalAlignment(alignment);
	}
	
	public JLBaseLabel(String imgPath, String text, Font font, Color foregroundColor) {
		super(text);
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));
		this.setFont(font);
		this.setForeground(foregroundColor);
	}
	
	public JLBaseLabel(String imgPath, String text, Font font, Color foregroundColor, int alignment) {
		super(text);
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));
		this.setFont(font);
		this.setForeground(foregroundColor);
		this.setHorizontalAlignment(alignment);
	}
	
}
