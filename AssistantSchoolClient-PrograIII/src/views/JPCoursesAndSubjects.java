package views;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JPCoursesAndSubjects extends JPanel {

	private JBBaseButton createCourseJB, createSubjectJB, askCourseJB, asigSubjecJB,
	asigCourseJB;
	private JCBBaseComboBox subjectsJCB, coursesJCB;

	public JPCoursesAndSubjects(ControllerClient controller, String[] subjects, String[] courses) {
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		initComponents(controller,subjects,courses);
		this.setVisible(true);
	}

	private void initComponents(ControllerClient controller, String[] subjects, String[] courses) {
		createCourseJB = new JBBaseButton(Constants.ROUTE_ADD_COURSE, Constants.ROUTE_ADD_COURSE_PRESS, controller,
				Commands.ADD_COURSE);
		createCourseJB.setBounds(250, 100, 150, 80);

		
		createSubjectJB = new JBBaseButton(Constants.ROUTE_ADD_SUBJECT, Constants.ROUTE_ADD_SUBJECT_PRESS, controller,
				Commands.ADD_SUBJECT);
		createSubjectJB.setBounds(650, 100, 150, 80);
		add(createCourseJB);
		add(createSubjectJB);
		
		subjectsJCB = new JCBBaseComboBox(controller, subjects, Constants.FONT_LOG_IN, Constants.DARK_BLUE);
		subjectsJCB.setBounds(600, 230, 300, 50);
		subjectsJCB.setBorder(BorderFactory.createTitledBorder("Asignaturas dictadas en la Institución"));
		add(subjectsJCB);
		
		coursesJCB = new JCBBaseComboBox(controller, courses, Constants.FONT_LOG_IN, Constants.DARK_BLUE);
		coursesJCB.setBounds(200, 230,300, 50);
		coursesJCB.setBorder(BorderFactory.createTitledBorder("Cursos de la Institución"));
		add(coursesJCB);
		
		askCourseJB = new JBBaseButton(Constants.ROUTE_SEE_COURSE, Constants.ROUTE_SEE_COURSE_PRESS, controller,
				Commands.SEE_COURSES);
		askCourseJB.setBounds(250, 330, 150, 80);
		add(askCourseJB);
		
		asigSubjecJB = new JBBaseButton(Constants.ROUTE_ASIG_SUBJECT, Constants.ROUTE_ASIG_SUBJECT_PRESS, controller,
				Commands.ASIG_SUBJECT);
		asigSubjecJB.setBounds(600, 330, 150, 80);
		add(asigSubjecJB);
		
		asigCourseJB = new JBBaseButton(Constants.ROUTE_ASIG_COURSE, Constants.ROUTE_ASIG_COURSE_PRESS, controller,
				Commands.ASIG_COURSE);
		asigCourseJB.setBounds(760, 330, 150, 80);
		add(asigCourseJB);
	}
	
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		JFrame frame = new JFrame();
		String[] subjects = {"mat","esp","rel"};
		String[] courses = {"1","2"}; 
		frame.add(new JPCoursesAndSubjects(new ControllerClient(), subjects, courses));
		frame.setVisible(true);
		frame.setSize(1000, 500);
	}
	
}
