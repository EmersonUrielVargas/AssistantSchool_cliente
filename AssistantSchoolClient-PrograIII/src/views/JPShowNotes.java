package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerClient;

public class JPShowNotes extends JPanel{
	private ArrayList<JPShowPanelNotes> listNotes;
	
	public JPShowNotes(ControllerClient controller,String[] notes) {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(990,( notes.length*70 +300)));
		this.listNotes = new ArrayList<JPShowPanelNotes>();
		chargeNotesStudent(controller, notes);
		initComponents(controller);
		
	}
	
	private void initComponents(ControllerClient controller) {
		int positionY = 0;
		for (int i = 0; i < listNotes.size(); i++) {
			this.listNotes.get(i).setBounds(0, positionY, 1000,70);
			this.add(listNotes.get(i));
			positionY = positionY+70;
		}
		
	}

	public void chargeNotesTeacher(ControllerClient controller, String[] notes) {
		String[] notesData;
		String[] notesLoad;
		String subject;
		JPShowPanelNotes jpanelNote;
		for (int i = 0; i < notes.length; i++) {
			notesData = notes[i].split("/");
			notesLoad = new String[notesData.length-2];
			jpanelNote = new JPShowPanelNotes(controller, notesData[0]);
			jpanelNote.addFinalNote(notesData[1]);
			for (int j = 2; j < notesData.length; j++) {
				notesLoad[j-2] = notesData[j];
			}
			jpanelNote.initToTeacher(notesLoad);
			listNotes.add(jpanelNote);
		}
	}
	
	public void chargeNotesStudent(ControllerClient controller, String[] notes) {
		String[] notesData;
		String[] notesLoad;
		String subject;
		JPShowPanelNotes jpanelNote;
		for (int i = 0; i < notes.length; i++) {
			notesData = notes[i].split("/");
			notesLoad = new String[notesData.length-2];
			jpanelNote = new JPShowPanelNotes(controller, notesData[0]);
			jpanelNote.addFinalNote(notesData[1]);
			for (int j = 2; j < notesData.length; j++) {
				notesLoad[j-2] = notesData[j];
			}
			jpanelNote.initToStudent(notesLoad);
			listNotes.add(jpanelNote);
		}
	}
	

	
	

}
