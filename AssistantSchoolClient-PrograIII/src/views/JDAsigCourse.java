package views;

import java.awt.Color;
import java.awt.Font;
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

public class JDAsigCourse extends JDialog {

	private static final long serialVersionUID = 1L;
	private JCBBaseComboBox coursesJCB,teachersJCB;
	private JButton createJB;

	public JDAsigCourse(ControllerClient controllerApp,String[] courses , String[]teachers) {
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(3, 1));
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controllerApp,courses,teachers);
		this.setVisible(true);
	}

	private void initComponents(ControllerClient controllerApp,String[]courses , String[]teachers) {

		coursesJCB = new JCBBaseComboBox(controllerApp,courses,Constants.FONT_LOG_IN,Constants.DARK_BLUE);
		coursesJCB.setFont(Constants.FONT_LOG_IN);
		coursesJCB.setBorder(BorderFactory.createTitledBorder("Seleccione el curso para asignarlo al docente"));
		this.add(coursesJCB);

		teachersJCB = new JCBBaseComboBox(controllerApp,teachers,Constants.FONT_LOG_IN,Constants.DARK_BLUE);
		teachersJCB.setFont(Constants.FONT_LOG_IN);
		teachersJCB.setBorder(BorderFactory.createTitledBorder("Seleccione el docente que será director de curso"));
		this.add(teachersJCB);
		
		createJB = new JButton();
		createJB.setFont(Constants.FONT_LOG_IN);
		createJB.setText("Asignar Curso");
		createJB.setFocusable(false);
		createJB.setBackground((Constants.COLOR_BLUE));
		createJB.setForeground(Color.WHITE);
		createJB.setActionCommand(Commands.ASIG_COURSE_TEACHER.toString());
		createJB.addActionListener(controllerApp);
		this.add(createJB);
	}

	public String getDatesUser() {
		this.setVisible(false);
		String aux = (String) teachersJCB.getSelectedItem();
		String result =  coursesJCB.getSelectedItem() + "#" + aux.split("_")[1];
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		new JDAsigCourse(new ControllerClient());
	}

}
