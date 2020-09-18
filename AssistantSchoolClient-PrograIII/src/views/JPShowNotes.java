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
	
	public JPShowNotes(ControllerClient controller,String[] notes,String typeUser) {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(990,( notes.length*70 +300)));
		this.listNotes = new ArrayList<JPShowPanelNotes>();
		initComponents(controller, notes, typeUser);
		
	}
	
	private void initComponents(ControllerClient controller,String[] notes,String typeUser) {
		chargeNotes(controller, notes, typeUser);
		int positionY = 0;
		for (int i = 0; i < listNotes.size(); i++) {
			this.listNotes.get(i).setBounds(0, positionY, 1000,70);
			this.add(listNotes.get(i));
			positionY = positionY+70;
		}
		
	}
	
	public void chargeNotes(ControllerClient controller, String[] notes,String typeUser) {
		String[] notesData;
		String[] notesLoad;
		String subject;
		JPShowPanelNotes jpanelNote;
		for (int i = 0; i < notes.length; i++) {
			notesData = notes[i].split("/");
			notesLoad = new String[notesData.length-2];
			jpanelNote = new JPShowPanelNotes(controller, notesData[0],typeUser);
			jpanelNote.addFinalNote(notesData[1]);
			for (int j = 2; j < notesData.length; j++) {
				notesLoad[j-2] = notesData[j];
			}
			jpanelNote.initData(notesLoad);
			listNotes.add(jpanelNote);
		}
	}
	
	public String[] getValues() {
		String[] values = new String[listNotes.size()];
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < listNotes.get(i).getValues().length; j++) {
				values[i] = values[i]+ listNotes.get(i).getValues()[j]+"/";
			}
		}
		return values;
	}
	

	
	

}
