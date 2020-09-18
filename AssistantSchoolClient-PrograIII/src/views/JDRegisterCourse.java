package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JDRegisterCourse extends JDialog {

	private static final long serialVersionUID = 1L;
	private JCBBaseComboBox teacherJCB,subjectsJCB;
	private JTextField nameCourseJL;
	private JButton createJB;

	public JDRegisterCourse(ControllerClient controllerApp, String[] teachers,String[]subjects) {
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(4, 1));
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controllerApp,teachers,subjects);
		this.setVisible(true);
	}

	private void initComponents(ControllerClient controllerApp, String[]teachers,String[] subjects) {

		teacherJCB = new JCBBaseComboBox(controllerApp, teachers, Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		teacherJCB.setBorder(BorderFactory.createTitledBorder("Director de Curso"));
		this.add(teacherJCB);
		
		subjectsJCB = new JCBBaseComboBox(controllerApp, subjects, Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		subjectsJCB.setBorder(BorderFactory.createTitledBorder("Asignaturas para el curso"));
		this.add(subjectsJCB);


		nameCourseJL = new JTextField();
		nameCourseJL.setFont(Constants.FONT_LOG_IN);
		nameCourseJL.setBorder(BorderFactory.createTitledBorder("Nombre del curso"));
		this.add(nameCourseJL);

		createJB = new JButton();
		createJB.setFont(Constants.FONT_LOG_IN);
		createJB.setText("Registrar Curso");
		createJB.setFocusable(false);
		createJB.setBackground((Constants.COLOR_BLUE));
		createJB.setForeground(Color.WHITE);
		createJB.setActionCommand(Commands.REGISTER_COURSE.toString());
		createJB.addActionListener(controllerApp);
		this.add(createJB);
	}

	public String getDatesUser() {
		this.setVisible(false);
		String result =  nameCourseJL.getText() + "#" + teacherJCB.getSelectedItem()+ "#" + subjectsJCB.getSelectedItem();
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] teachers = {"Luz","Pablo","Feney"};
		String[] subjects = {"Mat","Esp","Rel"};
		new JDRegisterCourse(new ControllerClient(),teachers,subjects);
	}

}
