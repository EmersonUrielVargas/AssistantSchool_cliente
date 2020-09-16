package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import enums.TypeId;
import enums.TypeUser;
import models.Manager;
import models.Student;
import models.Subject;
import models.Teacher;
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
		System.out.println(user);
		String[] dataUser = user.split("-");
		if (Utilities.TypeUser(dataUser[0]) == TypeUser.TEACHER) {
			Teacher teacher = new Teacher(dataUser[3], dataUser[4], Utilities.TypeId(dataUser[1]),
					Integer.parseInt(dataUser[2]));
			Subject subjectTeacher = manager.askSubject(new Subject(Integer.parseInt(dataUser[5].split("_")[1]), ""));
			teacher.addSubject(subjectTeacher);
			manager.addTeacher(teacher);
			
		} else if (Utilities.TypeUser(dataUser[0]) == TypeUser.STUDENT) {
			Student student = new Student(dataUser[3], dataUser[4], Utilities.TypeId(dataUser[1]),
					Integer.parseInt(dataUser[2]),dataUser[7]);
			manager.addStudent(student);
		}
	}
}
