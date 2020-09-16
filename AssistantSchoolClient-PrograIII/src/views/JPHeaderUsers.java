package views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.ControllerClient;
import utils.Constants;

public class JPHeaderUsers extends JPanel{
	
	private JLBaseLabel nameUserJL,documentUserJL,subjectsJL,removeUserJL;

	public JPHeaderUsers(ControllerClient controller) {
		this.setBackground(Color.white);
		this.setLayout(null);
		initComponents(controller);
		this.setVisible(true);
	}

	private void initComponents(ControllerClient controller) {
		nameUserJL = new JLBaseLabel(Constants.FONT_LOG_IN,Constants.COLOR_DARK_BLUE);
		nameUserJL.setText("NOMBRE DE USUARIO");
		nameUserJL.setHorizontalAlignment(SwingConstants.CENTER);

		documentUserJL = new JLBaseLabel(Constants.FONT_LOG_IN,Constants.COLOR_DARK_BLUE);
		documentUserJL.setText("DOCUMENTO");
		documentUserJL.setHorizontalAlignment(SwingConstants.CENTER);

		subjectsJL = new JLBaseLabel(Constants.FONT_LOG_IN,Constants.COLOR_DARK_BLUE);
		subjectsJL.setText("ASIGNATURAS");
		subjectsJL.setHorizontalAlignment(SwingConstants.CENTER);
		
		removeUserJL = new JLBaseLabel(Constants.FONT_LOG_IN,Constants.COLOR_DARK_BLUE);
		removeUserJL.setText("ELIMINAR USUARIO");
		removeUserJL.setHorizontalAlignment(SwingConstants.CENTER);
		
		

		nameUserJL.setBounds(0, 0, 250, 50);
		documentUserJL.setBounds(250, 0, 250, 50);
		subjectsJL.setBounds(500, 0,250, 50);
		removeUserJL.setBounds(750, 0, 250, 50);
		this.add(nameUserJL);
		this.add(documentUserJL);
		this.add(subjectsJL);
		this.add(removeUserJL);
	}
}
