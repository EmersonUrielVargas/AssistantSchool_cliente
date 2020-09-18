package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import controller.ControllerClient;

public class JCBBaseComboBox extends JComboBox<Object>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JCBBaseComboBox(ControllerClient controller,String[] list,Font font,Color textColor) {
		this.setFont(font);
		this.setBackground(Color.WHITE);
		this.setForeground(textColor);
		this.addItemListener(controller);
		this.setModel(new DefaultComboBoxModel<>(list));
		this.setSelectedItem(list[0]);
	}
		
	public JCBBaseComboBox(ControllerClient controller,Font font,Color textColor) {
		this.setFont(font);
		Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
		((JLabel)this.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel)this.getRenderer()).setBorder(line);;
		this.setOpaque(true);
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.setForeground(textColor);
		this.addItemListener(controller);
	}
	
	
	public JCBBaseComboBox(ControllerClient controller) {
		this.addItemListener(controller);
	}
	
	public void updateList(Object[] list) {
		this.setModel(new DefaultComboBoxModel<>(list));
	}
	
	
	
}