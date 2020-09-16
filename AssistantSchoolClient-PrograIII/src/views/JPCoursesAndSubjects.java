package views;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JPCoursesAndSubjects extends JPanel {

	private JBBaseButton createCourseJB, createSubjectJB, askCourseJB, askSubjectJB;
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
		subjectsJCB.setBounds(200, 230, 300, 50);
		add(subjectsJCB);
		
		coursesJCB = new JCBBaseComboBox(controller, courses, Constants.FONT_LOG_IN, Constants.DARK_BLUE);
		coursesJCB.setBounds(600, 230,300, 50);
		add(coursesJCB);
		
		askCourseJB = new JBBaseButton(Constants.ROUTE_SEE_COURSE, Constants.ROUTE_SEE_COURSE_PRESS, controller,
				Commands.SEE_COURSES);
		askCourseJB.setBounds(150, 330, 350, 50);
		add(askCourseJB);
		
		askSubjectJB = new JBBaseButton(Constants.ROUTE_SEE_SUBJECT, Constants.ROUTE_SEE_SUBJECT_PRESS, controller,
				Commands.SEE_SUBJECTS);
		askSubjectJB.setBounds(600, 330, 350, 50);
		add(askSubjectJB);
		
		

	}
}
