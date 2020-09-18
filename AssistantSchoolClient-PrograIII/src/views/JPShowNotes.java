package views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerClient;

public class JPShowNotes extends JPanel{
//	private JBBaseButton jBSaveChanges;
//	private JPanel jpButton;
	private ArrayList<JPShowPanelNotes> listNotes;
	
	public JPShowNotes(ControllerClient controller) {
		super(new GridLayout());
		this.setSize(900, 700);
		this.listNotes = new ArrayList<JPShowPanelNotes>();
		
	}
	
	private void initComponents(ControllerClient controller) {
		for (int i = 0; i < listNotes.size(); i++) {
			this.add(listNotes.get(i));
		}
		
	}

	public void chargeNotes(ControllerClient controller, String[] notes) {
		String[] notesData;
		String[] notesLoad;
		String subject;
		JPShowPanelNotes jpanelNote;
		for (int i = 0; i < notes.length; i++) {
			notesLoad = new String[7];
			notesData = notes[i].split("/");
			jpanelNote = new JPShowPanelNotes(controller, notesData[0]);
			jpanelNote.addFinalNote(notesData[1]);
			for (int j = 0; j < notesLoad.length; j++) {
				notesLoad[0] = notesData[i+2];
			}
			jpanelNote.addNotes(notesLoad);
			listNotes.add(jpanelNote);
		}
		initComponents(controller);
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] note = {"calculo/4.5/4.3|logro dividir numeros|el taller estaba incompleto| /3.2|logro dividir numeros|el taller estaba incompleto| /3.5| | | /2.0| | |",
				"calculo/4.5/4.3|logro dividir numeros|el taller estaba incompleto| /3.2|logro dividir numeros|el taller estaba incompleto| /3.5| | | /2.0| | |"};
		JFrame frame = new JFrame();
		JPShowNotes notes = new JPShowNotes(new ControllerClient());
		notes.chargeNotes(new ControllerClient(), note);
		frame.setLayout(new FlowLayout());
		frame.add(notes);
		frame.setVisible(true);
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

}
