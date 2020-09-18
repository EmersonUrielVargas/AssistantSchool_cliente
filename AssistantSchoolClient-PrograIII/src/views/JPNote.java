package views;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JPNote extends JPanel{
	
	private JTFBaseTextField jtNote;
	private JBBaseButton jbshowcommits;
	private JDialogCommitsNote jdcommentN;
	
	public JPNote(ControllerClient controller) {
		super(new FlowLayout());
		this.setSize(15, 10);
		init(controller);
		this.setBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE));
	}
	
	public JPNote(ControllerClient controller, String title) {
		super(new FlowLayout());
		this.setSize(20, 10);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), title));
		this.jtNote = new JTFBaseTextField(Constants.BASE_BLUE, Constants.TWENTY_BASE_FONT, 3);
		this.jtNote.setEditable(false);
		this.add(jtNote);
	}
	
	private void init(ControllerClient controller) {
		this.jtNote = new JTFBaseTextField(Constants.BASE_BLUE, Constants.TWENTY_BASE_FONT, 3);
		this.jbshowcommits = new JBBaseButton(Constants.SHOW_COMMENTS_ICON, Constants.SHOW_COMMENTS_ICON_PRESS, controller, Commands.AC_SHOW_COMMENTS_BUTTON);
		this.jdcommentN = new JDialogCommitsNote(controller);
		
		this.add(jtNote);
		this.add(jbshowcommits);
	}


	
	private Point calculatePositionJDilog() {
		int xMouse = this.getMousePosition().x;
		int yMouse = this.getMousePosition().y;
		int widthScreen = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightScreen = Toolkit.getDefaultToolkit().getScreenSize().height;
		int x = calculatePositionJDilog(xMouse, widthScreen, (int)jdcommentN.getSize().getWidth());
		int y = calculatePositionJDilog(yMouse, heightScreen, (int)jdcommentN.getSize().getHeight());
		Point point = new Point(x, y);
		return point;
	}
	
	private int calculatePositionJDilog(int position, int sizeScreen,int jDialogSize) {
		int positionFinal = 0;
		if ((position+jDialogSize)>sizeScreen) {
			positionFinal = position-jDialogSize;
		}else {
			positionFinal= position+jDialogSize;
		}
		return positionFinal;
	}
	
	public void setNote(String note) {
		this.jtNote.setText(note);
	}
	
	public void setNoteEditable(boolean isEditable) {
		this.jtNote.setEditable(isEditable);
	}
	
	public void initToTeacher(String valuenote, String achievement, String commentTeacher, String commentStudent) {
		this.jtNote.setText(valuenote);
		this.jdcommentN.initToTeacher(achievement, commentTeacher, commentStudent);
	}
	
	public void initToStudent(String valuenote, String achievement, String commentTeacher, String commentStudent) {
		this.jtNote.setText(valuenote);
		this.jdcommentN.initToStudent(achievement, commentTeacher, commentStudent);
	}
	
	
	

}