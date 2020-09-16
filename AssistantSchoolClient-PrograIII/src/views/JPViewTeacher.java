package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JPViewTeacher extends JPanel {
	
	private JLBaseLabel nameUserJL,documentJL;
	private JCBBaseComboBox subjectsJCB;
	private JBBaseButton removeJB;

	public JPViewTeacher(ControllerClient controller) {
		this.setBackground(Color.WHITE);
		Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(line);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public String fillPanel(String teacher, String subjects,ControllerClient controller) {
		nameUserJL = new JLBaseLabel(Constants.FONT_LOG_IN,Constants.COLOR_DARK_BLUE);
		documentJL = new JLBaseLabel(Constants.FONT_LOG_IN,Constants.COLOR_DARK_BLUE);
		subjectsJCB = new JCBBaseComboBox(controller,Constants.FONT_LOG_IN,Constants.COLOR_DARK_BLUE);	
		removeJB = new JBBaseButton(Constants.ROUTE_REMOVE, Constants.ROUTE_REMOVE_PRESS, controller, Commands.REMOVE_USER);
		String[] auxiliar = teacher.split("-");
		nameUserJL.setText("  " + auxiliar[0]);
		documentJL.setText("  " + auxiliar[1]);
		subjectsJCB.setModel(new DefaultComboBoxModel<>(subjects.split("-")));
		nameUserJL.setBounds(0, 0, 250, 50);
		documentJL.setBounds(250, 0, 250, 50);
		subjectsJCB.setBounds(500, 0,250, 50);
		removeJB.setBounds(750, 0, 250, 50);
		this.add(nameUserJL);
		this.add(documentJL);
		this.add(subjectsJCB);
		this.add(removeJB);
		this.setVisible(true);
		return auxiliar[1].split(" ")[1];

	}
}
