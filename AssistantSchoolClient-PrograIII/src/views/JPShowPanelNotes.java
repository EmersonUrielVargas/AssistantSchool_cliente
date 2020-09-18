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
	
	public JPShowPanelNotes(ControllerClient controller,String namePanel,String typeUser) {
		super(null);
		this.setSize(900, 60);
		this.listNotes = new JPNote[7];
		initComponents(controller, namePanel, typeUser);
	}

	private void initComponents(ControllerClient controller, String namePanel,String typeUser) {
		this.jLNamePanel = new JLBaseLabel(namePanel, Constants.FOURTEEN_BOLD_BASE_FONT, Constants.BASE_BLUE);
		this.jLNamePanel.setBounds(10, 5, 170, 60);
		this.jPNoteFinal = new JPNote("Nota Final");
		this.add(jLNamePanel);
		int positionX = 180;
		for (int i = 0; i < listNotes.length; i++) {
			listNotes[i] = new JPNote(controller, typeUser);
			listNotes[i].setBounds(positionX, 15, 90, 40);
			this.add(listNotes[i]);
			positionX+= 95;
		}
		this.jPNoteFinal.setBounds(positionX, 0, 90, 60);
		this.add(jPNoteFinal);
	}
	
	public void addFinalNote(String finalNote) {
		this.jPNoteFinal.setNote(finalNote);
	}
	
	public void initData(String[] notes) {
		setEditableNotes(true);
		String[] noteOk = new String[notes.length ];
		for (int i = 0; i < notes.length; i++) {
			noteOk = notes[i].split("&");
			this.listNotes[i].initData(noteOk[0], noteOk[1], noteOk[2], noteOk[3], noteOk[4]);
		}
	}
	
	private void setEditableNotes(boolean isEditable) {
		for (int i = 0; i < listNotes.length; i++) {
			listNotes[i].setNoteEditable(isEditable);
		}
	}

	
	public String[] getValues() {
		String[] values = new String[listNotes.length+2];
		values[0] = this.jLNamePanel.getText();
		values[1] = this.jPNoteFinal.getValueNote();
		for (int i = 2; i < values.length; i++) {
			for (int j = 0; j < listNotes[i-2].getValues().length; j++) {
				values[i] = values[i]+ listNotes[i-2].getValues()[j]+"&";
			}
		}
		return values;
	}


}
