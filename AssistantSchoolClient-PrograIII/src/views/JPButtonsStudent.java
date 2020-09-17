package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JPButtonsStudent extends JPanel{
	
	private JPHeadName jpHeadName;
	private JBBaseButton jBShowReport;
	private JBBaseButton jBShowLogout;
	
	public JPButtonsStudent(ControllerClient controller) {
		super();
		this.setSize(1000, 150);
		this.setBackground(Constants.BASE_BLUE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, Constants.BORDER_THICKNESS));
		this.setLayout(new BorderLayout());
		init(controller);
	}

	private void init(ControllerClient controller) {
		this.setBorder(BorderFactory.createEmptyBorder(38, 6, 38, 10));
		this.jpHeadName = new JPHeadName("Laura Acevedo", "student");
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.jBShowReport = new JBBaseButton(Constants.SHOW_REPORT_ICON, Constants.SHOW_REPORT_ICON_PRESS, controller, Commands.AC_SHOW_REGISTER_BUTTON);
		this.jBShowLogout = new JBBaseButton(Constants.SHOW_LOGOUT_ICON, Constants.SHOW_LOGOUT_ICON_PRESS, controller, Commands.AC_SHOW_LOGOUT_BUTTON);
		this.add(jpHeadName);
		this.add(new JLabel("                                                                 "));
		this.add(new JLabel("                                                                 "));
		this.add(jBShowReport);
		this.add(jBShowLogout);
		this.setVisible(true);		
	}
	
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		JFrame frame = new JFrame();
		frame.add(new JPButtonsStudent(new ControllerClient()));
		frame.setVisible(true);
		frame.setSize(1000, 200);
	}

}
