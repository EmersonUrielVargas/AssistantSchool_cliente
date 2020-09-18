package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JDAsigSubject extends JDialog {

	private static final long serialVersionUID = 1L;
	private JCBBaseComboBox subjectsJCB, teachersJCB;
	private JButton createJB, returnPanel;

	public JDAsigSubject(ControllerClient controllerApp, String[] subjects, String[] teachers) {
		this.setDefaultCloseOperation(0);
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(4, 1));
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controllerApp, subjects, teachers);
		this.setVisible(true);
	}

	private void initComponents(ControllerClient controllerApp, String[] subjects, String[] teachers) {

		subjectsJCB = new JCBBaseComboBox(controllerApp, subjects, Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		subjectsJCB.setBorder(BorderFactory.createTitledBorder("Seleccione la asignatura a agregar"));
		this.add(subjectsJCB);

		teachersJCB = new JCBBaseComboBox(controllerApp, teachers, Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		teachersJCB.setFont(Constants.FONT_LOG_IN);
		teachersJCB.setBorder(BorderFactory.createTitledBorder("Seleccione el docente "));
		this.add(teachersJCB);

		createJB = new JButton();
		createJB.setFont(Constants.FONT_LOG_IN);
		createJB.setText("Asignar Asignatura");
		createJB.setFocusable(false);
		createJB.setBackground((Constants.COLOR_BLUE));
		createJB.setForeground(Color.WHITE);
		createJB.setActionCommand(Commands.ASIG_SUBJECT_TEACHER.toString());
		createJB.addActionListener(controllerApp);
		this.add(createJB);

		returnPanel = new JButton();
		returnPanel.setFont(Constants.FONT_LOG_IN);
		returnPanel.setText("Retornar al panel anterior");
		returnPanel.setFocusable(false);
		returnPanel.setBackground((Constants.COLOR_BLUE));
		returnPanel.setForeground(Color.WHITE);
		returnPanel.setActionCommand(Commands.RETURN_PANEL_1.toString());
		returnPanel.addActionListener(controllerApp);
		this.add(returnPanel);

	}

	public String getDatesUser() {
		this.setVisible(false);
		String aux = (String) teachersJCB.getSelectedItem();
		String subAux = (String) subjectsJCB.getSelectedItem();
		String result = subAux.split("_")[1] + "#" + aux.split("_")[1];
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] teachers = { "Ped", "Mat", "Yes" };
		String[] subjetcs = { "Mat", "Alg" };
		new JDAsigSubject(new ControllerClient(), subjetcs, teachers);
	}

}
