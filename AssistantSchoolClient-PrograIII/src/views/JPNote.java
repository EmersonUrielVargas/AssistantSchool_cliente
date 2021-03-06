package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JPNote extends JPanel implements ActionListener{
	
	private JTFBaseTextField jtNote;
	private JBBaseButton jbshowcommits;
	private JDialogCommitsNote jdcommentN;
	
<<<<<<< HEAD
	public JPNote(ControllerClient controller,String TypeUser) {
=======
	public JPNote(ControllerClient controller,String typeUser) {
>>>>>>> branch 'master' of https://github.com/EmersonUrielVargas/AssistantSchool_cliente.git
		super(new FlowLayout());
		this.setSize(15, 10);
<<<<<<< HEAD
		this.setBackground(Color.WHITE);
		init(controller);
=======
		init(controller, typeUser);
>>>>>>> branch 'master' of https://github.com/EmersonUrielVargas/AssistantSchool_cliente.git
		this.setBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE));
	}
	
	public JPNote(String title) {
		super(new FlowLayout());
		this.setSize(20, 10);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), title));
		this.jtNote = new JTFBaseTextField(Constants.BASE_BLUE, Constants.TWENTY_BASE_FONT, 3);
		this.jtNote.setEditable(false);
		this.add(jtNote);
	}
	
	private void init(ControllerClient controller, String typeUser) {
		this.jtNote = new JTFBaseTextField(Constants.BASE_BLUE, Constants.TWENTY_BASE_FONT, 3);
		this.jbshowcommits = new JBBaseButton(Constants.SHOW_COMMENTS_ICON, Constants.SHOW_COMMENTS_ICON_PRESS,this, Commands.AC_SHOW_COMMENTS_BUTTON);
<<<<<<< HEAD
		this.jdcommentN = new JDialogCommitsNote(this);
=======
		this.jdcommentN = new JDialogCommitsNote(this, typeUser);
>>>>>>> branch 'master' of https://github.com/EmersonUrielVargas/AssistantSchool_cliente.git
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
	
	
<<<<<<< HEAD
	public void initToTeacher(String topic,String valuenote, String achievement, String commentTeacher, String commentStudent) {
		this.jdcommentN.initData(topic, valuenote, achievement, commentTeacher, commentStudent);
=======
	public void initToTeacher() {
		this.jdcommentN.initToTeacher();
>>>>>>> branch 'master' of https://github.com/EmersonUrielVargas/AssistantSchool_cliente.git
		this.jtNote.setText(this.jdcommentN.getValues()[1]);
		this.jtNote.setEditable(true);
	}
	public void initToStudent() {
		this.jdcommentN.initToStudent();
		this.jtNote.setText(this.jdcommentN.getValues()[1]);
		this.jtNote.setEditable(false);
	}
	
<<<<<<< HEAD
	public void initToStudent(String topic,String valuenote, String achievement, String commentTeacher, String commentStudent) {
=======
	public void initData(String topic,String valuenote, String achievement, String commentTeacher, String commentStudent) {
>>>>>>> branch 'master' of https://github.com/EmersonUrielVargas/AssistantSchool_cliente.git
		this.jdcommentN.initData(topic, valuenote, achievement, commentTeacher, commentStudent);
		this.jtNote.setText(this.jdcommentN.getValues()[1]);
	}
	
	public String[] getValues() {
		return this.jdcommentN.getValues();
	}
	
	public String getValueNote() {
		return this.jtNote.getText();
	}
	
	public void setVisbleJDialogComments(boolean isVisible) {
		this.jdcommentN.setVisible(isVisible);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		switch (Commands.valueOf(actionEvent.getActionCommand())) {
		case AC_SHOW_COMMENTS_BUTTON:
<<<<<<< HEAD
=======
			this.setNote(this.jtNote.getText());
>>>>>>> branch 'master' of https://github.com/EmersonUrielVargas/AssistantSchool_cliente.git
			this.jdcommentN.setVisible(true);
			break;
		case AC_SAVE_COMMENTS_BUTTON:
			this.jdcommentN.setVisible(false);
			this.jtNote.setText(this.jdcommentN.getValues()[1]);
			break;

		default:
			break;
		}
		
	}

	public void setNoteEditable(boolean isEditable) {
		this.jtNote.setEditable(isEditable);
		
	}
	
	
	

}