package views;

import java.awt.Component;

import javax.swing.JScrollPane;

public class JSBaseScroll extends JScrollPane{
	
	public JSBaseScroll(Component componet) {
		this.setViewportView(componet);
		this.setBounds(0, 200, 990, 500);
	}
	
	public void isVisible(boolean isVisible) {
		this.setVisible(isVisible);
	}

}
