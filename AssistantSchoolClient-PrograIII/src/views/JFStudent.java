package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ControllerClient;
import utils.Constants;

public class JFStudent extends JFrame{
	
	private JPButtonsStudent jpStudent;
	private JPShowNotes jpShowNotes;
	private JSBaseScroll jScroll;
	
	public JFStudent(ControllerClient controller) {
		this.getContentPane().setBackground(Color.white);
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controller);
	}
	

	private void initComponents(ControllerClient controller) {
		this.jpStudent = new JPButtonsStudent(controller); 
		this.jpShowNotes = new JPShowNotes();
		add(buttonsJP);
		imagePanelJP = new JPImagenForeground();
		imagePanelJP.setBounds(0,200,1000,550);
		add(imagePanelJP);
		seeTeachersJP = new JPSeeTeachers(controller);

	}
	
	

}
