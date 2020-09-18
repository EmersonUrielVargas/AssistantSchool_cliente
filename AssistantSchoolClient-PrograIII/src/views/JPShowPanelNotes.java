package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerClient;
import utils.Constants;

public class JPShowPanelNotes extends JPanel{
	private JLBaseLabel jLNamePanel;
	private JPNote[] listNotes;
	private JPNote jPNoteFinal;
	
	public JPShowPanelNotes(ControllerClient controller,String namePanel) {
		super(new FlowLayout());
		this.setSize(900, 60);
		this.listNotes = new JPNote[7];
		initComponents(controller, formatTitle(namePanel, 20));
	}

	private void initComponents(ControllerClient controller, String namePanel) {
		this.jLNamePanel = new JLBaseLabel(namePanel, Constants.FOURTEEN_BOLD_BASE_FONT, Constants.BASE_BLUE);
		this.jPNoteFinal = new JPNote(controller, "Nota Final");
		this.add(jLNamePanel);
		for (int i = 0; i < listNotes.length; i++) {
			listNotes[i] = new JPNote(controller);
			this.add(listNotes[i]);
		}
		this.add(jPNoteFinal);
	}
	
	public void addFinalNote(String finalNote) {
		this.jPNoteFinal.setNote(finalNote);
	}
	
	public void initToTeacher(String[] notes) {
		setEditableNotes(true);
		String[] noteOk = new String[notes.length ];
		for (int i = 0; i < notes.length; i++) {
			noteOk = notes[i].split("&");
			this.listNotes[i].initToTeacher(noteOk[0], noteOk[1], noteOk[2], noteOk[3]);
		}
	}
	
	private void setEditableNotes(boolean isEditable) {
		for (int i = 0; i < listNotes.length; i++) {
			listNotes[i].setNoteEditable(isEditable);
		}
	}
	
	public void initToStudent(String[] notes) {
		setEditableNotes(false);
		String[] noteOk;
		for (int i = 0; i < notes.length; i++) {
			noteOk = notes[i].split("&");
			this.listNotes[i].initToStudent(noteOk[0], noteOk[1], noteOk[2], noteOk[3]);
		}
	}
	
	private String formatTitle(String text,int sizeMax) {
		String textFormat = text;
		char[] textTochar = new char[sizeMax-text.length()];
		if (textTochar.length < sizeMax) {
			for (int i = 0; i < textTochar.length; i++) {
				textTochar[i] = " ".charAt(0);
			}
		}
		for (int i = 0; i < textTochar.length; i++) {
			textFormat = textFormat +textTochar[i];
		}
		return textFormat;
	}
	
	

}
