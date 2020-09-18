package views;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.ControllerClient;

public class JPShowNotes extends JPanel {
	private ArrayList<JPShowPanelNotes> listNotes;

	public JPShowNotes(ControllerClient controller, String[] notes, String typeUser) {
		super();
		this.setLayout(null);
//		this.setBackground(Color.BLUE);
		this.setPreferredSize(new Dimension(990, (notes.length * 70 + 300)));
		this.listNotes = new ArrayList<JPShowPanelNotes>();
		initComponents(controller, notes, typeUser);
		this.setVisible(true);
	}

	private void initComponents(ControllerClient controller, String[] notes, String typeUser) {
		if (typeUser.compareToIgnoreCase("Teacher") == 0) {
			chargeNotesTeacher(controller, notes);
		} else {
//			System.out.println("ENTRO AL PANEL");
			chargeNotesStudent(controller, notes);
		}
		int positionY = 0;
		for (int i = 0; i < listNotes.size(); i++) {
			this.listNotes.get(i).setBounds(0, positionY, 1000, 70);
			this.add(listNotes.get(i));
			positionY = positionY + 70;
		}

	}

	public void chargeNotesTeacher(ControllerClient controller, String[] notes) {
		String[] notesData;
		String[] notesLoad;
		String subject;
		JPShowPanelNotes jpanelNote;
		for (int i = 0; i < notes.length; i++) {
			notesData = notes[i].split("/");
			notesLoad = new String[notesData.length - 2];
			jpanelNote = new JPShowPanelNotes(controller, notesData[0]);
			jpanelNote.addFinalNote(notesData[1]);
			for (int j = 2; j < notesData.length; j++) {
				notesLoad[j - 2] = notesData[j];
			}
			jpanelNote.initToTeacher(notesLoad);
			listNotes.add(jpanelNote);
		}
	}

	public void chargeNotesStudent(ControllerClient controller, String[] notes) {
//		for (int i = 0; i < notes.length; i++) {
//			System.out.println(notes[i]);
//		}

		for (int i = 0; i < notes.length; i++) {
			String[] notesData = notes[i].split("/");
			String[] notesLoad = new String[notesData.length - 2];
			JPShowPanelNotes jpanelNote = new JPShowPanelNotes(controller, notesData[0]);
			jpanelNote.addFinalNote(notesData[1]);
			for (int j = 2; j < notesData.length; j++) {
				notesLoad[j - 2] = notesData[j];
//				System.out.println(notesData[j]);
			}
			jpanelNote.initToStudent(notesLoad);
			listNotes.add(jpanelNote);
		}
	}
}
