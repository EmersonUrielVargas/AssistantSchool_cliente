package views;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ControllerClient;
import utils.Constants;

public class JFTeacher extends JFrame{

	private JPButtonsTeacher jpButtonsTeacher;
	private JPTopics jpTopics;
	private JPShowNotes jpShowNotes;
	private JSBaseScroll jScroll;
	
	public JFTeacher(ControllerClient controller, String[] notes, String[] subjects, String[] courses) {
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controller,notes, subjects, courses);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private String[] getTopicsNotes(String[] notes) {
		String[] topics = new String[7];
		for (int i = 0; i < notes.length; i++) {
			for (int j = 2; j < notes[i].split("/").length; j++) {
				topics[j-2] = (notes[i].split("/")[j]).split("&")[0];
			}
		}
		return topics;
	}
	

	private void initComponents(ControllerClient controller, String[] notes,String[] subjects,String[] courses) {
		this.jpButtonsTeacher = new JPButtonsTeacher(controller, subjects, courses);
		this.jpShowNotes = new JPShowNotes(controller, notes,"teacher");
		this.jpButtonsTeacher.setBounds(0, 0, 990, 150);
		this.jpTopics = new JPTopics(controller, getTopicsNotes(notes));
		this.jpTopics.setBounds(0, 150, 1000, 60);
        this.jScroll = new JSBaseScroll(jpShowNotes);
        this.jScroll.isVisible(true);
		this.jScroll.setBounds(0, 210, 995, 580);
		this.add(jpButtonsTeacher);
		this.add(jpTopics);
		this.add(jScroll);
	}
	
	public String getValues() {
		String values = "";
		for (int i = 0; i < this.jpShowNotes.getValues().length; i++) {
			values = values + this.jpShowNotes.getValues()[i] + "%";
		}
		return values;
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] note = {"Laura Acevedo-2411241134/4.5/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /",
			"Joaquin Vega-1432114/2.0/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /Tema 5&2.0& & & /",
			"Nomi mars-423412/2.6/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /Tema 5&2.0& & & /",
			"lito rodriguez-42134/2.5/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /Tema 5&2.0& & & /",
			"raychel ichibinz-42151/2.4/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /",
			"euyeni boss-144134/2.3/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /",
			"pol rubio-14342/2.2/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /",
			"diego rivera-124534/2.1/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /"};
		
		String[] subject = {"calculo","algebra", "ecuaciones diferenciales"};
		String[] course = {"sexto","sextoB", "noveno"};
		new JFTeacher(new ControllerClient(), note, subject, course);
	}

}
