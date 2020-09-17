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

public class JDRegisterUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private JCBBaseComboBox typeUserJCB, typeDocumentJCB,subjectsJCB,courseStudentJCB;
	private JTextField lastNameJTF, numberIdJTF,nameUserJTF;
	private JButton createJB;

	public JDRegisterUser(ControllerClient controllerApp, String[] typeUsers, String[] typeDocumet,String[] subjects,String[] courses) {
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(8, 1));
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controllerApp, typeUsers, typeDocumet,subjects,courses);
	}

	private void initComponents(ControllerClient controllerApp, String[] typeUsers, String[] typeDocumet,String[] subjects,String[] courses) {

		typeUserJCB = new JCBBaseComboBox(controllerApp, typeUsers, Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		typeUserJCB.setBorder(BorderFactory.createTitledBorder("Tipo de Usuario"));
		this.add(typeUserJCB);

		typeDocumentJCB = new JCBBaseComboBox(controllerApp, typeDocumet, Constants.FONT_LOG_IN,
				Constants.COLOR_DARK_BLUE);
		typeDocumentJCB.setBorder(BorderFactory.createTitledBorder("Tipo de Documento"));
		this.add(typeDocumentJCB);
		
		subjectsJCB = new JCBBaseComboBox(controllerApp, subjects, Constants.FONT_LOG_IN,
				Constants.COLOR_DARK_BLUE);
		subjectsJCB.setBorder(BorderFactory.createTitledBorder("Asignatura del Docente"));
		this.add(subjectsJCB);
		
		courseStudentJCB = new JCBBaseComboBox(controllerApp, courses, Constants.FONT_LOG_IN,
				Constants.COLOR_DARK_BLUE);
		courseStudentJCB.setBorder(BorderFactory.createTitledBorder("Curso del estudiante"));
		this.add(courseStudentJCB);
		
		

		numberIdJTF = new JTextField();
		numberIdJTF.setFont(Constants.FONT_LOG_IN);
		numberIdJTF.setBorder(BorderFactory.createTitledBorder("Número de Documento"));
		this.add(numberIdJTF);

		nameUserJTF = new JTextField();
		nameUserJTF.setFont(Constants.FONT_LOG_IN);
		nameUserJTF.setBorder(BorderFactory.createTitledBorder("Nombre del Usuario"));
		this.add(nameUserJTF);

		lastNameJTF = new JTextField();
		lastNameJTF.setFont(Constants.FONT_LOG_IN);
		lastNameJTF.setBorder(BorderFactory.createTitledBorder("Apellido del usuario"));
		this.add(lastNameJTF);

		createJB = new JButton();
		createJB.setFont(Constants.FONT_LOG_IN);
		createJB.setText("Registrar Usuario");
		createJB.setFocusable(false);
		createJB.setBackground((Constants.COLOR_BLUE));
		createJB.setForeground(Color.WHITE);
		createJB.setActionCommand(Commands.ADD_CLIENT.toString());
		createJB.addActionListener(controllerApp);
		this.add(createJB);
	}

	public String getDatesUser() {
		this.setVisible(false);
		String result =  (String) typeUserJCB.getSelectedItem() +"-"+(String) typeDocumentJCB.getSelectedItem() +"-"+numberIdJTF.getText()
		+"-"+nameUserJTF.getText() + "-"+ lastNameJTF.getText() +"-"+ (String)subjectsJCB.getSelectedItem()+"-"+(String)courseStudentJCB.getSelectedItem() ;
				;
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] subjects = {"Ing","Esp","Mat"};
		String[] courses = {"Sext","Sep","Oct"};
		new JDRegisterUser(new ControllerClient(), Constants.TYPE_USERS_NOT_ADMIN, Constants.TYPE_DOCUMENT, subjects, courses);
	}

}
