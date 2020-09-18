package views;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controller.ControllerClient;
import utils.Constants;

public class JDSeeStudentsCoursesSubject extends JDialog {

	private JPShowNotes showNotesJP;
	private JScrollPane jScroll;

	public JDSeeStudentsCoursesSubject(ControllerClient controller, String[] notes, String typeUser) {
		this.setSize(1000, 400);
		this.setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controller, notes, typeUser);
		this.setVisible(true);
	}

	private void initComponents(ControllerClient controller, String[] notes, String typeUser) {
		this.showNotesJP = new JPShowNotes(controller, notes, "estudiante");
		showNotesJP.setBounds(0, 0, 1000, 700);
		this.jScroll = new JSBaseScroll(showNotesJP);
		this.jScroll.setVisible(true);
		jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
		this.jScroll.setBounds(0, 0, 990, 700);
		this.add(jScroll);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] note = {
				"Laura Acevedo/4.5/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /",
				"Joaquin Vega/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /2.0& & & /",
				"Nomi mars/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /2.0& & & /",
				"lito rodriguez/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /2.0& & & /",
				"raychel ichibinz/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /",
				"euyeni boss/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /",
				"pol rubio/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /",
				"diego rivera/2.0/4.3&logro dividir numeros&el taller estaba incompleto& /3.2&logro dividir numeros&el taller estaba incomplet& /3.5& & & /2.0& & & /" };

		String[] subject = { "calculo", "algebra", "ecuaciones diferenciales" };
		String[] course = { "sexto", "sextoB", "noveno" };
		new JDSeeStudentsCoursesSubject(new ControllerClient(), note, "Estudent");
	}
}
