package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JDialogCommitsNote extends JDialog{
	private JPanel jPTeacher;
	private JPanel jPStudent;
	private JTFBaseTextField jTFTopic;
	private JTFBaseTextField jTFnote;
	private JTABase jTAachievement;
	private JTABase jTAcommentT;
	private JTABase jTAcommentS;
	private JBBaseButton jBsave;
	
	public JDialogCommitsNote(ActionListener ac) {
		super();
		this.setSize(350, 420);
		initComponent(ac);
		this.setLayout(new FlowLayout());
		
	}

	private void initComponent(ActionListener ac) {
		this.setUndecorated(true);
		this.jTFTopic= new JTFBaseTextField(Constants.BASE_BLUE,Constants.FOURTEEN_BOLD_BASE_FONT, 17);
		this.jTFTopic.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Tema"));
		this.jTFnote = new JTFBaseTextField(Constants.BASE_BLUE,Constants.FOURTEEN_BOLD_BASE_FONT, 7);
		this.jTFnote.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Nota"));
		this.jTAachievement = new JTABase(Constants.FOURTEEN_BOLD_BASE_FONT, Constants.BASE_BLUE, 320, 100);
		this.jTAachievement.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Logros"));
		this.jTAcommentT = new JTABase(Constants.FOURTEEN_BOLD_BASE_FONT, Constants.BASE_BLUE, 320, 60);
		this.jTAcommentT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Comentario"));
		this.jTAcommentS = new JTABase(Constants.FOURTEEN_BOLD_BASE_FONT, Constants.DARK_BLUE, 320, 60);
		this.jTAcommentS.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Comentario"));
		this.jBsave = new JBBaseButton(Constants.SAVE_COMMENTS_ICON, Constants.SAVE_COMMENTS_ICON_PRESS, ac, Commands.AC_SAVE_COMMENTS_BUTTON);
		this.jPTeacher = new JPanel(new FlowLayout());
		this.jPTeacher.setPreferredSize(new Dimension(330, 250));
		this.jPStudent = new JPanel(new FlowLayout());
		this.jPTeacher.setBorder(BorderFactory.createTitledBorder("DOCENTE"));
		this.jPStudent.setBorder(BorderFactory.createTitledBorder("ESTUDIANTE"));
		
		this.jPTeacher.add(jTFTopic);
		this.jPTeacher.add(jTFnote);
		this.jPTeacher.add(jTAachievement);
		this.jPTeacher.add(jTAcommentT);
		this.jPStudent.add(jTAcommentS);
		this.add(jPTeacher);
		this.add(jPStudent);
		this.add(jBsave);
		
		this.setVisible(false);
	}
	
	public void initData(String topic, String note, String achievement, String commentTeacher, String commentStudent) {
		this.jTFTopic.setText(topic);
		this.jTFnote.setText(note);
		this.jTAachievement.setText(achievement);
		this.jTAcommentT.setText(commentTeacher);
		this.jTAcommentT.setText(commentTeacher);
		this.jTFTopic.setEditable(true);
		this.jTFnote.setEditable(true);
		this.jTAcommentS.setEditable(false);
		this.jTAachievement.setEditable(true);
		this.jTAcommentT.setEditable(true);
	}
	
	public void initToTeacher() {
		this.jTFTopic.setEditable(true);
		this.jTFnote.setEditable(true);
		this.jTAcommentS.setEditable(false);
		this.jTAachievement.setEditable(true);
		this.jTAcommentT.setEditable(true);
	}
	
	public void initToStudent() {
		this.jTFTopic.setEditable(false);
		this.jTFnote.setEditable(false);
		this.jTAcommentS.setEditable(true);
		this.jTAachievement.setEditable(false);
		this.jTAcommentT.setEditable(false);
	}
	
	public void setPosition(Point point) {
		this.setPosition(point);
	}
	public String[] getValues() {
		String[] values = new String[5];
		values[0] = this.jTFTopic.getText();
		values[1] = this.jTFnote.getText();
		values[2] = this.jTAachievement.getText();
		values[3] = this.jTAcommentT.getText();
		values[4] = this.jTAcommentS.getText();
		return values;
	}
	
	public void setValueNote(String note) {
		this.jTFnote.setText(note);
	}
	

}
