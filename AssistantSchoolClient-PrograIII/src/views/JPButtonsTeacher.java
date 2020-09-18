package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JPButtonsTeacher extends JPanel{
	private JPHeadName jpHeadName;
	private JCBBaseComboBox subjectsJCB, coursesJCB;
	private JBBaseButton jBShowNotes, jBShowLogout;
	
	public JPButtonsTeacher(ControllerClient controller, String[] subjects, String[] courses) {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(990, 150));
		this.setBackground(Constants.BASE_BLUE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, Constants.BORDER_THICKNESS));
		init(controller, subjects, courses);
	}

	private void init(ControllerClient controller, String[] subjects, String[] courses) {
		this.jpHeadName = new JPHeadName("Jorge Hoyos", "Teacher");
		this.jpHeadName.setBounds(30, 30, 200, 120);
		this.add(jpHeadName);
//		this.add(new JLabel("                                                                 "));
		
		this.subjectsJCB = new JCBBaseComboBox(controller, subjects, Constants.FONT_LOG_IN, Constants.DARK_BLUE);
		this.subjectsJCB.setBounds(390, 50, 120, 80);
		this.coursesJCB = new JCBBaseComboBox(controller, courses, Constants.FONT_LOG_IN, Constants.DARK_BLUE);
		this.coursesJCB.setBounds(540, 50, 120, 80);
		this.add(coursesJCB);
		this.add(subjectsJCB);
		
		this.jBShowLogout = new JBBaseButton(Constants.SHOW_LOGOUT_ICON, Constants.SHOW_LOGOUT_ICON_PRESS, controller, Commands.AC_SHOW_LOGOUT_BUTTON);
		this.jBShowNotes = new JBBaseButton(Constants.SHOW_NOTES_ICON, Constants.SHOW_NOTES_ICON_PRESS, controller, Commands.AC_SHOW_NOTES_BUTTON);
		this.jBShowNotes.setBounds(690, 30, 120,  120);
		this.jBShowLogout.setBounds(820, 30, 120,  120);
		this.add(jBShowNotes);
		this.add(jBShowLogout);
		this.setVisible(true);		
	}
	
	public void setNameUser(String nameUser) {
		this.jpHeadName.setNameUser(nameUser);
	}


}
