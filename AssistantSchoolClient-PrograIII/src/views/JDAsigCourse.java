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

public class JDAsigCourse extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField idSubjectJL,nameSubjectJL;
	private JButton createJB;

	public JDAsigCourse(ControllerClient controllerApp) {
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(3, 1));
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controllerApp);
		this.setVisible(true);
	}

	private void initComponents(ControllerClient controllerApp) {

		idSubjectJL = new JTextField();
		idSubjectJL.setFont(Constants.FONT_LOG_IN);
		idSubjectJL.setBorder(BorderFactory.createTitledBorder("Nombre del curso"));
		this.add(idSubjectJL);

		nameSubjectJL = new JTextField();
		nameSubjectJL.setFont(Constants.FONT_LOG_IN);
		nameSubjectJL.setBorder(BorderFactory.createTitledBorder("Numero de Identificacion del Docente"));
		this.add(nameSubjectJL);
		
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
		String result =  idSubjectJL.getText() + "#" + nameSubjectJL.getText();
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		new JDAsigCourse(new ControllerClient());
	}

}
