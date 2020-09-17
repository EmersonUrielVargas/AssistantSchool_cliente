package views;

import java.awt.BorderLayout;
import java.awt.Color;
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
		this.setSize(1000, 150);
		this.setBackground(Constants.BASE_BLUE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, Constants.BORDER_THICKNESS));
		this.setLayout(new BorderLayout());
		init(controller, subjects, courses);
	}

	private void init(ControllerClient controller, String[] subjects, String[] courses) {
		this.setBorder(BorderFactory.createEmptyBorder(38, 6, 38, 10));
		this.jpHeadName = new JPHeadName("Jorge Hoyos", "Teacher");
		this.add(jpHeadName);
		this.add(new JLabel("                                                                 "));
		
		this.subjectsJCB = new JCBBaseComboBox(controller, subjects, Constants.FONT_LOG_IN, Constants.DARK_BLUE);
		this.subjectsJCB.setBounds(600, 230, 200, 100);
		this.coursesJCB = new JCBBaseComboBox(controller, courses, Constants.FONT_LOG_IN, Constants.DARK_BLUE);
		this.coursesJCB.setBounds(600, 230, 300, 50);
		this.add(coursesJCB);
		this.add(subjectsJCB);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.jBShowLogout = new JBBaseButton(Constants.SHOW_LOGOUT_ICON, Constants.SHOW_LOGOUT_ICON_PRESS, controller, Commands.AC_SHOW_LOGOUT_BUTTON);
		this.jBShowNotes = new JBBaseButton(Constants.SHOW_NOTES_ICON, Constants.SHOW_NOTES_ICON_PRESS, controller, Commands.AC_SHOW_NOTES_BUTTON);
		
		this.add(jBShowNotes);
		this.add(jBShowLogout);
		this.setVisible(true);		
	}
	
	public void setNameUser(String nameUser) {
		this.jpHeadName.setNameUser(nameUser);
	}
	
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		JFrame frame = new JFrame();
		String[] subjects = {"Calculo", "fisica"};
		String[] courses = {"Sexto", "septimo", "octavo"};
		frame.add(new JPButtonsTeacher(new ControllerClient(),subjects, courses));
		frame.setVisible(true);
		frame.setSize(1000, 200);
	}

}
