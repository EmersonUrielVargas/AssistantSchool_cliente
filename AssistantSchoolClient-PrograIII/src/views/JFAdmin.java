package views;

import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import controller.ControllerClient;
import utils.Constants;

public class JFAdmin extends JFrame {

	private JPSeeTeachers seeTeachersJP;
	private JSBaseScroll scroll;
	private JPButtonsAdmin buttonsJP;
	private JPImagenForeground imagePanelJP;
	private JPCoursesAndSubjects coursesSubjectsJP;

	public JFAdmin(ControllerClient controller) {
		this.getContentPane().setBackground(Color.white);
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controller);
	}

	private void initComponents(ControllerClient controller) {
		buttonsJP = new JPButtonsAdmin(controller);
		buttonsJP.setBounds(0, 0, 1000, 150);
		add(buttonsJP);
		imagePanelJP = new JPImagenForeground();
		imagePanelJP.setBounds(0,200,1000,550);
		add(imagePanelJP);
		seeTeachersJP = new JPSeeTeachers(controller);

	}

	public void isVisibleImagen(boolean isVisible) {
		imagePanelJP.setVisible(isVisible);
	}
	
	public void isVisiblePanelTeachers(boolean isVisible) {
		
		seeTeachersJP.setVisible(isVisible);
	}
	
	public void initPanelCourses(ControllerClient controller,String[] subjects,String[]courses) {
		coursesSubjectsJP = new JPCoursesAndSubjects(controller, subjects, courses);
		coursesSubjectsJP.setBounds(0, 200, 1000, 550);
		coursesSubjectsJP.setVisible(true);
		this.add(coursesSubjectsJP);
		seeTeachersJP.setVisible(false);
		imagePanelJP.setVisible(false);
		coursesSubjectsJP.setVisible(true);
	}

	public void initPanelTeachers(ControllerClient controller, String[] teachers) {
		seeTeachersJP = new JPSeeTeachers(controller);
		seeTeachersJP.setBounds(0,200,1000,550);
		initPanelUsers(teachers);
		int number = 50;
		JPHeaderUsers headers = new JPHeaderUsers(controller);
		headers.setBounds(0, 0, 1000, 50);
		seeTeachersJP.add(headers);

		for (int i = 1; i < teachers.length ; i+=2) {
			JPViewTeacher teacher = new JPViewTeacher(controller);
			teacher.setBounds(0, number, 1000, 50);
			teacher.fillPanel(teachers[i], teachers[i + 1], controller);
			number += 50;
			seeTeachersJP.add(teacher);
		}
		seeTeachersJP.repaint();
		scroll = new JSBaseScroll(seeTeachersJP);
		add(scroll);
	}
	
	public void visiblePanelTeachers() {
		
	}

	public void initPanelUsers(String[] strings) {
		this.imagePanelJP.setVisible(false);
		seeTeachersJP.setPreferredSize(new Dimension(1000, (strings.length * 501) + 50));
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		new JFAdmin(new ControllerClient());
	}

}
