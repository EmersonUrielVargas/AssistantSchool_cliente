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

public class JDRegisterSubject extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField idSubjectJL,nameSubjectJL;
	private JButton createJB;

	public JDRegisterSubject(ControllerClient controllerApp) {
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
		idSubjectJL.setBorder(BorderFactory.createTitledBorder("Codigo de la Asignatura"));
		this.add(idSubjectJL);

		nameSubjectJL = new JTextField();
		nameSubjectJL.setFont(Constants.FONT_LOG_IN);
		nameSubjectJL.setBorder(BorderFactory.createTitledBorder("Nombre de la Asignatura"));
		this.add(nameSubjectJL);
		
		createJB = new JButton();
		createJB.setFont(Constants.FONT_LOG_IN);
		createJB.setText("Registrar Asignatura");
		createJB.setFocusable(false);
		createJB.setBackground((Constants.COLOR_BLUE));
		createJB.setForeground(Color.WHITE);
		createJB.setActionCommand(Commands.REGISTER_SUBJECT.toString());
		createJB.addActionListener(controllerApp);
		this.add(createJB);
	}

	public String getDatesUser() {
		this.setVisible(false);
		String result =  idSubjectJL.getText() + "#" + nameSubjectJL.getText();
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		new JDRegisterSubject(new ControllerClient());
	}

}
