package views;

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
		this.setSize(990, 60);
		this.listNotes = new JPNote[7];
		initComponents(controller, namePanel);
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
	
	public void addNotes(String[] listNotes) {
		for (int i = 0; i < 7; i++) {
			this.listNotes[i].setNote(listNotes[i]);
		}
	}
	
	public void addFinalNote(String finalNote) {
		this.jPNoteFinal.setNote(finalNote);
	}
	
	public void initToTeacher(String[] achievement, String[] commentTeacher, String[] commentStudent) {
		for (int i = 0; i < listNotes.length; i++) {
			this.listNotes[i].initToStudent(achievement[i+1], commentTeacher[i+1], commentStudent[i+1]);
		}
		this.jPNoteFinal.initToTeacher(achievement[0], commentTeacher[0], commentStudent[0]);
	}
	
	public void initToStudent(String[] achievement, String[] commentTeacher, String[] commentStudent) {
		for (int i = 0; i < listNotes.length; i++) {
			this.listNotes[i].initToStudent(achievement[i+1], commentTeacher[i+1], commentStudent[i+1]);
		}
		this.jPNoteFinal.initToStudent(achievement[0], commentTeacher[0], commentStudent[0]);
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.add(new JPShowPanelNotes(new ControllerClient(), "Calculo"));
		frame.add(new JPShowPanelNotes(new ControllerClient(), "Matematicas"));
		frame.add(new JPShowPanelNotes(new ControllerClient(), "Fisica"));
		frame.setVisible(true);
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
