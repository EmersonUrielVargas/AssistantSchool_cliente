package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JPButtonsAdmin extends JPanel{
	private JPHeadName jpHeadName;
	private JBBaseButton jBShowTeachers,jBShowStudents,jBShowLogin;
	private JPSearch jpSearch;
	
	public JPButtonsAdmin(ControllerClient controller) {
		super();
		this.setSize(1000, 150);
		this.setBackground(Constants.BASE_BLUE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, Constants.BORDER_THICKNESS));
		this.setLayout(new BorderLayout());
		init(controller);
	}

	private void init(ControllerClient controller) {
		this.setBorder(BorderFactory.createEmptyBorder(38, 6, 38, 22));
		this.jpHeadName = new JPHeadName("Administrador", "ADMIN");
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.jpSearch = new JPSearch(controller);
		
		this.jBShowStudents = new JBBaseButton(Constants.ROUTE_ICON_STUDENT, Constants.ROUTE_ICON_STUDENT_PRESS, controller, Commands.AC_SHOW_STUDENTS_BUTTON);
		this.jBShowTeachers = new JBBaseButton(Constants.ROUTE_ICON_TEACHER, Constants.ROUTE_ICON_TEACHER_PRESS, controller, Commands.AC_SHOW_TEACHERS_BUTTON);
		this.jBShowLogin = new JBBaseButton(Constants.ROUTE_ICON_REGISTER, Constants.ROUTE_ICON_REGISTER_PRESS, controller, Commands.REGISTER_CLIENT);
		
		this.add(jpHeadName, new FlowLayout(FlowLayout.LEFT, 10, 20));
		this.add(jpSearch, new FlowLayout(FlowLayout.CENTER, 20, 0));
		this.add(jBShowTeachers, new FlowLayout(FlowLayout.RIGHT, 0, 0));
		this.add(jBShowStudents, new FlowLayout(FlowLayout.RIGHT, 0, 0));
		this.add(jBShowLogin, new FlowLayout(FlowLayout.RIGHT, 0, 0));

		
		this.setVisible(true);		
	}
	
	public String captureSearchText() {
		return jpSearch.captureText();
	}
	
	
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		JFrame frame = new JFrame();
		frame.add(new JPButtonsAdmin(new ControllerClient()));
		frame.setVisible(true);
		frame.setSize(1000, 200);
	}
	
	 
	
	
	

}
