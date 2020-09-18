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
	

	private void initComponents(ControllerClient controller, String[] notes,String[] subjects,String[] courses) {
		this.jpButtonsTeacher = new JPButtonsTeacher(controller, subjects, courses);
		this.jpShowNotes = new JPShowNotes(controller, notes,"teacher");
		this.jpButtonsTeacher.setBounds(0, 0, 990, 150);
        this.jScroll = new JSBaseScroll(jpShowNotes);
        this.jScroll.isVisible(true);
		this.jScroll.setBounds(0, 150, 995, 580);
		this.add(jpButtonsTeacher);
		this.add(jScroll);
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] note = {"Laura Acevedo/4.5/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /",
				"Joaquin Vega/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /2.0& & & /",
				"Nomi mars/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /2.0& & & /",
				"lito rodriguez/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /2.0& & & /",
				"raychel ichibinz/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /",
				"euyeni boss/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /",
				"pol rubio/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /",
				"diego rivera/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /"};
		
		String[] subject = {"calculo","algebra", "ecuaciones diferenciales"};
		String[] course = {"sexto","sextoB", "noveno"};
		new JFTeacher(new ControllerClient(), note, subject, course);
	}

}
