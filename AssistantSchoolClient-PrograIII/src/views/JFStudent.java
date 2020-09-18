package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ControllerClient;
import utils.Constants;

public class JFStudent extends JFrame{
	
	private JPButtonsStudent jpStudent;
	private JPShowNotes jpShowNotes;
	private JSBaseScroll jScroll;
	
	public JFStudent(ControllerClient controller, String[] notes) {
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controller,notes);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

	private void initComponents(ControllerClient controller, String[] notes) {
		this.jpStudent = new JPButtonsStudent(controller); 
		this.jpShowNotes = new JPShowNotes(controller, notes, "st");
		this.jpStudent.setBounds(0, 0, 1000, 150);
        this.jScroll = new JSBaseScroll(jpShowNotes);
        this.jScroll.isVisible(true);
		this.jScroll.setBounds(0, 150, 995, 580);
		this.add(jpStudent);
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
		String[] note = {"calculo/4.5/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /",
				"programacion/2.0/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /Tema 5&2.0& & & /",
				"matematicas/2.6/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /Tema 5&2.0& & & /",
				"español/2.5/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /Tema 5&2.0& & & /",
				"sociales/2.4/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /",
				"etica/2.3/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /",
				"religion/2.2/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /",
				"ed.fisica/2.1/Tema 1&4.3&logro dividir numeros&el taller estaba incompleto& /Tema 2&3.2&logro dividir numeros&el taller estaba incomplet& /Tema 3&3.5& & & /Tema 4&2.0& & & /"};
		JFStudent jfStudent = new JFStudent(new ControllerClient(), note);
	}
	
	

}
