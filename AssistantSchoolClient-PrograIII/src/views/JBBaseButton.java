package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.Commands;
import controller.ControllerClient;

public class JBBaseButton extends JButton {

	private static final long serialVersionUID = 1L;

	public JBBaseButton(String imgPath, Color backgroundColor) {
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));
		this.setBackground(backgroundColor);
		this.setBorder(null);
	}

	public JBBaseButton(String imgPath, Color backgroundColor, ControllerClient controllerApp, Commands command) {
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));
		this.setBackground(backgroundColor);
		this.setBorder(null);
		this.setActionCommand(command.toString());
		this.addActionListener(controllerApp);
	}

	public JBBaseButton(String text, String imgPath, Color backgroundColor) {
		this.setText(text);
		this.setIcon(new ImageIcon(getClass().getResource(imgPath)));
		this.setBackground(backgroundColor);
		this.setBorder(null);
	}

	public JBBaseButton(String routeImage, String routeImagePress, ControllerClient controllerApp, Commands command) {
		this.setContentAreaFilled(false);
		this.setFocusable(true);
		this.setBorder(null);
		this.setIcon(new ImageIcon(getClass().getResource(routeImage)));
		this.setPressedIcon(new ImageIcon(getClass().getResource(routeImagePress)));
		this.setActionCommand(command.toString());
		this.addActionListener(controllerApp);
	}
}
