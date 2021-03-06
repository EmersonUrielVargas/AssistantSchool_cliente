package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Constants;
import views.JDAsigCourse;
import views.JDAsigSubject;
import views.JDAsigSubjectCourse;
import views.JDLogin;
import views.JDRegisterCourse;
import views.JDRegisterSubject;
import views.JDRegisterUser;
import views.JDSeeStudentsCoursesSubject;
import views.JFAdmin;
import views.JFTeacher;

public class ControllerClient implements ActionListener, ItemListener {

	private final static int PORT = 23575;
	private final static String HOST = "localhost";
	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;

	private JDLogin loginJD;
	private JFAdmin adminJF;
	private JDSeeStudentsCoursesSubject seeCourses;
	private JDRegisterUser registerUserJD;
	private JDRegisterCourse registerCourseJD;
	private JDRegisterSubject registerSubjectJD;
	private JDAsigCourse asigCourseJD;
	private JDAsigSubject asigSubjectJD;
	private JDAsigSubjectCourse subjectCourseJD;
	private JFTeacher teacherJF;

	public ControllerClient() throws FileNotFoundException, IOException {
		socket = new Socket(HOST, PORT);
		output = new DataOutputStream(socket.getOutputStream());
		input = new DataInputStream(socket.getInputStream());
		initLogin();
	}

	public void initLogin() {
		String[] users = { "Admin", "Docente", "Estudiante" };
		loginJD = new JDLogin(this, users);
		loginJD.setVisible(true);
	}

	public void actionPerformed(ActionEvent actionEvent) {
		switch (Commands.valueOf(actionEvent.getActionCommand())) {


		case C_LOG_IN:
			writeDatesInitSesion();
			break;

		case REGISTER_CLIENT:
			adminJF.setVisible(false);
			adminJF = new JFAdmin(this);
			try {
				output.writeInt(2);
				String[] subjects = input.readUTF().split("-");
				String[] courses = input.readUTF().split("-");
				registerUserJD = new JDRegisterUser(this, Constants.TYPE_USERS_NOT_ADMIN, Constants.TYPE_DOCUMENT,
						subjects, courses);
				registerUserJD.setVisible(true);

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case ADD_CLIENT:
			addClient();
			break;

		case RETURN_LOG_IN:
			adminJF.setVisible(false);
			loginJD = new JDLogin(this, Constants.TYPE_USERS);
			loginJD.setVisible(true);
			break;
		case AC_SHOW_TEACHERS_BUTTON:
			addTeachers();
			break;

		case REMOVE_USER:
			removeUser();
			break;

		case AC_SHOW_STUDENTS_BUTTON:
			coursesAndSubjects();
			break;
		case ADD_COURSE:
			try {
				output.writeInt(7);
				int auxiliarT = input.readInt();
				String[] teachers = new String[auxiliarT];
				for (int i = 0; i < teachers.length; i++) {
					teachers[i] = input.readUTF();
				}
				int auxiliarS = input.readInt();
				String[] subjects = new String[auxiliarS];
				for (int i = 0; i < subjects.length; i++) {
					subjects[i] = input.readUTF();
				}
				registerCourseJD = new JDRegisterCourse(this, teachers, subjects);
				break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case REGISTER_COURSE:
			adminJF.setVisible(false);

			try {
				output.writeInt(8);
				output.writeUTF(registerCourseJD.getDatesUser());
				adminJF = new JFAdmin(this);
				coursesAndSubjects();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case ADD_SUBJECT:
			registerSubjectJD = new JDRegisterSubject(this);
			break;

		case REGISTER_SUBJECT:
			adminJF.setVisible(false);

			try {
				output.writeInt(9);
				output.writeUTF(registerSubjectJD.getDatesUser());
				adminJF = new JFAdmin(this);
				coursesAndSubjects();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case ASIG_COURSE:
			try {
				output.writeInt(12);
				int auxiliarT = input.readInt();
				String[] teachers1 = new String[auxiliarT];
				for (int i = 0; i < teachers1.length; i++) {
					teachers1[i] = input.readUTF();
				}

				int auxiliarC = input.readInt();
				String[] courses1 = new String[auxiliarC];
				for (int i = 0; i < courses1.length; i++) {
					courses1[i] = input.readUTF();
				}

				adminJF.setVisible(false);
				asigCourseJD = new JDAsigCourse(this, courses1, teachers1);
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case ASIG_COURSE_TEACHER:
			try {
				output.writeInt(10);
				output.writeUTF(asigCourseJD.getDatesUser());
				coursesAndSubjects();
				JOptionPane.showMessageDialog(null, "Asignacion ingresada correctamente");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case ASIG_SUBJECT:
			try {
				output.writeInt(13);
				int auxiliarT = input.readInt();
				String[] teachers1 = new String[auxiliarT];
				for (int i = 0; i < teachers1.length; i++) {
					teachers1[i] = input.readUTF();
				}

				int auxiliarS = input.readInt();
				String[] subjects = new String[auxiliarS];
				for (int i = 0; i < subjects.length; i++) {
					subjects[i] = input.readUTF();
				}
				adminJF.setVisible(false);
				asigSubjectJD = new JDAsigSubject(this, subjects, teachers1);
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case ASIG_SUBJECT_TEACHER:
			try {
				output.writeInt(11);
				output.writeUTF(asigSubjectJD.getDatesUser());
				coursesAndSubjects();
				JOptionPane.showMessageDialog(null, "Asignacion ingresada correctamente");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case RETURN_PANEL_1:
			asigSubjectJD.setVisible(false);
			adminJF.setVisible(true);
			break;
		case RETURN_PANEL_2:
			asigCourseJD.setVisible(false);
			adminJF.setVisible(true);
			break;
		case RETURN_PANEL_4:
			registerUserJD.setVisible(false);
			adminJF.setVisible(true);
			break;
		case SEE_COURSES:
			try {
				output.writeInt(14);
				output.writeUTF(adminJF.getDatesAskCourse());
				String datas = input.readUTF();
				System.out.println(datas);
				seeCourses = new JDSeeStudentsCoursesSubject(this, datas.split(","), "Estudiante");
				break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case ASIG_SUBJECT_TO_COURSE:
			try {
				output.writeInt(15);
				int auxiliarT = input.readInt();
				String[] courses = new String[auxiliarT];
				for (int i = 0; i < courses.length; i++) {
					courses[i] = input.readUTF();
				}

				int auxiliarS = input.readInt();
				String[] subjects = new String[auxiliarS];
				for (int i = 0; i < subjects.length; i++) {
					subjects[i] = input.readUTF();
				}
				adminJF.setVisible(false);
				subjectCourseJD = new JDAsigSubjectCourse(this, subjects, courses);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case ADD_SUBJECT_TO_COURSE:
			try {
				output.writeInt(16);
				output.writeUTF(subjectCourseJD.getDatesUser());
				JOptionPane.showMessageDialog(null, "Asignacion ingresada correctamente");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adminJF.setVisible(true);
			break;

		case RETURN_PANEL_3:
			adminJF.setVisible(true);
			subjectCourseJD.setVisible(false);
			break;

		}

	}

	private void coursesAndSubjects() {
		try {
			output.writeInt(15);
			int auxiliarS = input.readInt();
			String[] subjects = new String[auxiliarS];
			for (int i = 0; i < auxiliarS; i++) {
				subjects[i] = input.readUTF();
			}
			int auxiliarT = input.readInt();
			String[] courses = new String[auxiliarT];
			for (int i = 0; i < auxiliarT; i++) {
				courses[i] = input.readUTF();
			}
			adminJF.setVisible(false);
			adminJF = new JFAdmin(this);
			adminJF.initPanelCourses(this, courses, subjects);
			adminJF.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void removeUser() {
		try {
			output.writeInt(5);
			String idText = JOptionPane.showInputDialog("Ingrese el id");
			output.writeInt(Integer.parseInt(idText));
			JOptionPane.showMessageDialog(null, "Usuario Elimiando con �xito");

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.addTeachers();

	}

	private void addClient() {
		adminJF.setVisible(true);
		try {
			output.writeInt(3);
			output.writeUTF(registerUserJD.getDatesUser());
			registerUserJD.setVisible(false);
			JOptionPane.showMessageDialog(null, input.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addTeachers() {
		adminJF.setVisible(false);
		adminJF = new JFAdmin(this);
		ArrayList<String> teachers = new ArrayList<String>();

		try {
			output.writeInt(4);
			int quantityDates = input.readInt();
			if (quantityDates == 1) {
				JOptionPane.showMessageDialog(null, "No hay datos que mostrar");
				adminJF.isVisibleImagen(true);
				adminJF.isVisiblePanelTeachers(false);
				adminJF = new JFAdmin(this);
				adminJF.setVisible(true);
			} else {
				for (int i = 0; i < quantityDates; i++) {
					teachers.add(input.readUTF());
				}
				String[] result = new String[teachers.size()];
				for (int i = 0; i < teachers.size(); i++) {
					result[i] = teachers.get(i);
				}
				adminJF.initPanelTeachers(this, result);
				adminJF.isVisiblePanelTeachers(false);
				adminJF.isVisiblePanelTeachers(true);
				adminJF.setVisible(true);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeDatesInitSesion() {
		try {
			output.writeInt(1);
			String[] datas = loginJD.getDataLogIn();
			String dates = datas[0] + "-" + datas[1] + "-" + datas[2];
			output.writeUTF(dates);
			boolean result = input.readBoolean();
			if (result == true) {
				if (datas[2].equals("Admin")) {
					adminJF = new JFAdmin(this);
					loginJD.setVisible(false);
					adminJF.setVisible(true);
				} else if (datas[2].equals("Estudiante")) {

				} else if (datas[2].equals("Docente")) {
					
//					teacherJF = new JFTeacher(this, subjects, courses);
				}
			} else {
				loginJD.incorrectLogin();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		new ControllerClient();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	}

}
