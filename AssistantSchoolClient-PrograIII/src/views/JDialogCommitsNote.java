package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JDialogCommitsNote extends JDialog{
	private JPanel jPTeacher;
	private JPanel jPStudent;
	private JTABase jTAachievement;
	private JTABase jTAcommentT;
	private JTABase jTAcommentS;
	private JBBaseButton jBsave;
	
	public JDialogCommitsNote(ControllerClient controller) {
		super();
		this.setSize(350, 380);
		initComponent(controller);
		this.setLayout(new FlowLayout());
		
	}

	private void initComponent(ControllerClient controller) {
		this.setUndecorated(true);
		this.jTAachievement = new JTABase(Constants.FOURTEEN_BOLD_BASE_FONT, Constants.BASE_BLUE, 320, 100);
		this.jTAachievement.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Logros"));
		this.jTAcommentT = new JTABase(Constants.FOURTEEN_BOLD_BASE_FONT, Constants.BASE_BLUE, 320, 60);
		this.jTAcommentT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Comentario"));
		this.jTAcommentS = new JTABase(Constants.FOURTEEN_BOLD_BASE_FONT, Constants.DARK_BLUE, 320, 60);
		this.jTAcommentS.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Comentario"));
		this.jBsave = new JBBaseButton(Constants.SAVE_COMMENTS_ICON, Constants.SAVE_COMMENTS_ICON_PRESS, controller, Commands.AC_SAVE_COMMENTS_BUTTON);
		this.jPTeacher = new JPanel(new FlowLayout());
		this.jPTeacher.setPreferredSize(new Dimension(330, 200));
		this.jPStudent = new JPanel(new FlowLayout());
		this.jPTeacher.setBorder(BorderFactory.createTitledBorder("DOCENTE"));
		this.jPStudent.setBorder(BorderFactory.createTitledBorder("ESTUDIANTE"));
		
		this.jPTeacher.add(jTAachievement);
		this.jPTeacher.add(jTAcommentT);
		this.jPStudent.add(jTAcommentS);
		this.add(jPTeacher);
		this.add(jPStudent);
		this.add(jBsave);
		
		this.setVisible(false);
	}
	
	public void initToTeacher(String achievement, String commentTeacher, String commentStudent) {
		this.jTAachievement.setText(achievement);
		this.jTAcommentT.setText(commentTeacher);
		this.jTAcommentT.setText(commentTeacher);
		this.jTAcommentS.setEditable(false);
		this.jTAachievement.setEditable(true);
		this.jTAcommentT.setEditable(true);
	}
	
	public void initToStudent(String achievement, String commentTeacher, String commentStudent) {
		this.jTAachievement.setText(achievement);
		this.jTAcommentT.setText(commentTeacher);
		this.jTAcommentT.setText(commentTeacher);
		this.jTAcommentS.setEditable(true);
		this.jTAachievement.setEditable(false);
		this.jTAcommentT.setEditable(false);
	}
	
	public void setPosition(Point point) {
		this.setPosition(point);
	}

}
