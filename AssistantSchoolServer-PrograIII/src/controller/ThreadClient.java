package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import enums.TypeId;
import enums.TypeUser;
import models.Course;
import models.Manager;
import models.Student;
import models.Subject;
import models.Teacher;
import models.User;
import utils.Utilities;

public class ThreadClient extends Thread {

	private Socket socket;
	private Manager manager;
	private DataOutputStream output;
	private DataInputStream input;

	public ThreadClient(Socket socket) {
		this.socket = socket;
		manager = new Manager();
	}

	public void run() {
		try {
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
			System.out.println("Cliente conectado");
			while (true) {
				int option = input.readInt();
				switch (option) {

				case 1:
					String datas = input.readUTF();
					output.writeBoolean(manager.verifyUser(datas.split("-")[0], datas.split("-")[1]));
					break;

				case 2:
					output.writeUTF(manager.getSubjectsString());
					output.writeUTF(manager.getCoursesString());
					break;

				case 3:
					addUser(input.readUTF());
					break;

				case 4:
					addTeachers();
					break;

				case 5:
					int numberId = input.readInt();
					manager.removeStudent(new Student("ab", "ba", TypeId.CC, numberId, "d"));
					manager.removeTeacher(new Teacher("ab", "ba", TypeId.CC, numberId));
					break;

				case 6:
					String[] subjects = manager.getSubjectsString().split("-");
					output.writeInt(subjects.length);
					for (int i = 0; i < subjects.length; i++) {
						output.writeUTF(subjects[i]);
					}
					String[] courses = manager.getCoursesString().split("-");
					output.writeInt(courses.length);
					for (int i = 0; i < courses.length; i++) {
						output.writeUTF(courses[i]);
					}
					manager.resetStrings();
					break;

				case 7:
					String[] teachers = manager.getTeachersStringOutSubjects().split(",");
					output.writeInt(teachers.length);
					for (int i = 0; i < teachers.length; i++) {
						output.writeUTF(teachers[i]);
					}
					String[] subjects1 = manager.getSubjectsString().split("-");
					output.writeInt(subjects1.length);
					for (int i = 0; i < subjects1.length; i++) {
						output.writeUTF(subjects1[i]);
					}
					manager.resetStrings();
					break;
				case 8:
					String course = input.readUTF();
					String[] convert = course.split("#");
					int id = Integer.parseInt(convert[1].split("_")[1]);
					Teacher taux = new Teacher("", "", TypeId.CC, id);
					Course course1 = new Course(convert[0], manager.askTeacher(taux));
					course1.addCodeSubject(Integer.parseInt(convert[2].split("_")[1]));
					manager.addCourse(course1);
					
					break;
				case 9:
					String subject = input.readUTF();
					String[] convertS = subject.split("#");
					manager.addSubject(new Subject(Integer.parseInt(convertS[0]), convertS[1]));
					break;
				case 10:
					String[] asigCourse = input.readUTF().split("#");
					Course courseAsig = manager.askCourse(new Course(asigCourse[0]));
					Teacher teacherAsi = manager.askTeacher(new Teacher("", "", null, Integer.parseInt(asigCourse[1])));
					manager.asigCourseToTeacher(courseAsig, teacherAsi);
					break;
				case 11:
					String[] asigSubject = input.readUTF().split("#");
					System.out.println(asigSubject[0]);
					Subject subjectAsing = manager.askSubject(new Subject(Integer.parseInt(asigSubject[0]), ""));
					Teacher teacherAsiS = manager
							.askTeacher(new Teacher("", "", null, Integer.parseInt(asigSubject[1])));
					manager.asigSubjectToTeacher(subjectAsing, teacherAsiS);
					break;
				case 12:
					String[] teachers1 = manager.getTeachersStringOutSubjects().split(",");
					output.writeInt(teachers1.length);
					for (int i = 0; i < teachers1.length; i++) {
						output.writeUTF(teachers1[i]);
					}
					String[] courses1 = manager.getCoursesString().split("-");
					output.writeInt(courses1.length);
					for (int i = 0; i < courses1.length; i++) {
						output.writeUTF(courses1[i]);
					}
					manager.resetStrings();
					break;
				case 13:
					String[] teachers2 = manager.getTeachersStringOutSubjects().split(",");
					output.writeInt(teachers2.length);
					for (int i = 0; i < teachers2.length; i++) {
						output.writeUTF(teachers2[i]);
					}
					String[] subjects2 = manager.getSubjectsString().split("-");
					output.writeInt(subjects2.length);
					for (int i = 0; i < subjects2.length; i++) {
						output.writeUTF(subjects2[i]);
					}
					manager.resetStrings();
					
					break;
				case 14:
					String dates = input.readUTF();
					String[] notes = dates.split("#");
					System.out.println(notes[0]);
					Course course2 = manager.askCourse(new Course(notes[1]));
					Subject subject1 =  manager.askSubject(new Subject(Integer.parseInt(notes[0].split("_")[1]), ""));
					output.writeUTF(manager.getStudentsToCourse(course2, subject1));
					manager.resetStrings();
					break;
				
				case 15:
					String[] courses3 = manager.getCoursesString().split("-");
					output.writeInt(courses3.length);
					for (int i = 0; i < courses3.length; i++) {
						output.writeUTF(courses3[i]);
					}
					String[] subjects3 = manager.getSubjectsString().split("-");
					output.writeInt(subjects3.length);
					for (int i = 0; i < subjects3.length; i++) {
						output.writeUTF(subjects3[i]);
					}
					manager.resetStrings();
					break;
				case 16:
					String[] datas2 = input.readUTF().split("#");
					Course auxCourse = new Course(datas2[1]);
					manager.addSubjectToCourse(auxCourse, Integer.parseInt(datas2[0]));
					break;
				case 17:
					int code = Integer.parseInt(input.readUTF());
					Teacher teacher = manager.askTeacher(new Teacher("", "", TypeId.CC, code));
					Student student = manager.askStudent(new Student("", "", TypeId.CC, code,""));
					if(manager.getStudents().exist(student,manager.getStudents().getRoot() )) {
						output.writeUTF(teacher.seeTeacher());
					}
					if(manager.getTeachers().exist(teacher,manager.getTeachers().getRoot() )) {
						output.writeUTF(student.seeStudent());

					}else {
						output.writeUTF("El usuario no se encuentra en el sistema");

					}

					break;
				}
		
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void addTeachers() {

		try {
			int result = manager.getTeachersString().split(",").length;
			output.writeInt(result);
			String[] dates = manager.getTeachersString().split(",");
			for (int i = 0; i < result; i++) {
				System.out.println(dates[i]);
				output.writeUTF(dates[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manager.resetStrings();
	}

	private void addUser(String user) {

		try {
			String[] dataUser = user.split("-");
			if (Utilities.TypeUser(dataUser[0]) == TypeUser.TEACHER) {
				Teacher teacher = new Teacher(dataUser[3], dataUser[4], Utilities.TypeId(dataUser[1]),
						Integer.parseInt(dataUser[2]));
				Subject subjectTeacher = manager
						.askSubject(new Subject(Integer.parseInt(dataUser[5].split("_")[1]), ""));
				teacher.addSubject(subjectTeacher);
				manager.addTeacher(teacher);
				User acccesUser = manager.askUser(new User(teacher, TypeUser.TEACHER));
				output.writeUTF("Su nombre de usuario es " + acccesUser.getNickName() + "Su contraseña de acceso es "
						+ acccesUser.getPassword());
			} else if (Utilities.TypeUser(dataUser[0]) == TypeUser.STUDENT) {
				Student student = new Student(dataUser[3], dataUser[4], Utilities.TypeId(dataUser[1]),
						Integer.parseInt(dataUser[2]), dataUser[6]);
				manager.addStudent(student);
				User acccesUser = manager.askUser(new User(student, TypeUser.TEACHER));
				output.writeUTF("Su nombre de usuario es " + acccesUser.getNickName() + "Su contraseña de acceso es "
						+ acccesUser.getPassword());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
