package views;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;

import controller.ControllerClient;
import utils.Constants;

public class JDReportStudent extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLBaseLabel nameStudentTextJL, courseStudentTextJL, idStudentTextJL, imagenJL;

	private JLBaseLabel nameStudentJL, courseStudentJL, idStudentJL;
	private JPTablePanel datesSubjectJP;

	public JDReportStudent(ControllerClient controlleClient, String dateStudent, String datesSubject) {
		this.setSize(1000, 700);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controlleClient, dateStudent, datesSubject);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void initComponents(ControllerClient controllerClient, String dateStudent, String datesSubjects) {

		nameStudentJL = new JLBaseLabel(dateStudent.split("-")[0], Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		nameStudentJL.setBackground(Color.WHITE);
		courseStudentJL = new JLBaseLabel(dateStudent.split("-")[1], Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		idStudentJL = new JLBaseLabel(dateStudent.split("-")[2], Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		nameStudentTextJL = new JLBaseLabel("NOMBRE DEL ESTUDIANTE : ", Constants.FONT_LOG_IN,
				Constants.COLOR_DARK_BLUE);
		courseStudentTextJL = new JLBaseLabel("CURSO DEL ESTUDIANTE : ", Constants.FONT_LOG_IN,
				Constants.COLOR_DARK_BLUE);
		idStudentTextJL = new JLBaseLabel("NUMERO DE DOCUMENTO : ", Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		imagenJL = new JLBaseLabel(Constants.ROUTE_IMAGEN_REPORT_STUDENT);
		datesSubjectJP = new JPTablePanel();

		nameStudentTextJL.setBounds(10, 20, 270, 50);
		courseStudentTextJL.setBounds(10, 60, 250, 50);
		idStudentTextJL.setBounds(10, 100, 250, 50);

		nameStudentJL.setBounds(270, 20, 250, 50);
		courseStudentJL.setBounds(260, 60, 250, 50);
		idStudentJL.setBounds(260, 100, 250, 50);

		imagenJL.setBounds(450, 10, 400, 200);
		datesSubjectJP.setBounds(0, 160, 990, 500);
		this.add(nameStudentJL);
		this.add(courseStudentJL);
		this.add(idStudentJL);
		this.add(nameStudentTextJL);
		this.add(courseStudentTextJL);
		this.add(idStudentTextJL);
		this.add(datesSubjectJP);
		this.add(imagenJL);
		addSubjects(datesSubjects);

	}

	private void addSubjects(String datesSubjects) {
		String[] aux = new String[3];
		System.out.println(datesSubjects.split("-").length);
		for (int i = 0; i < datesSubjects.split("-").length; i+=3) {
				aux[0] = datesSubjects.split("-")[i];
				aux[1] = datesSubjects.split("-")[i+1];
				aux[2] = datesSubjects.split("-")[i+2];

				this.addElementToTable(aux);
			}
		}

	

	private void addElementToTable(Object[] vector) {
		datesSubjectJP.addElementToTable(vector);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String dateStudent = "Mario Rodriguez -Primero-1234";
		String subjects = "Calculo-es buen estudiante-4,5-Mat-Es piloo-3.4";
		JDReportStudent jd = new JDReportStudent(new ControllerClient(), dateStudent, subjects);
		jd.setVisible(true);

	}

}
