package utils;

import enums.TypeId;
import enums.TypeUser;
import models.Subject;
import models.Teacher;
import structures.NodeAVL;

public class Utilities {

	private static String resultTeachers;
	private static String resultSubjectsForTeacher;

	public static String[] getResultTeachers(NodeAVL<Teacher> auxiliar, NodeAVL<Subject> subjects) {
		resultTeachers = "";
		resultSubjectsForTeacher = "";
		showTreeInOrder(auxiliar, subjects);
		return resultTeachers.split(",");
	}

	public static String subjectForTeacher(Teacher teacher) {

		resultSubjectsForTeacher += teacher.getSubjectsString();

		return resultSubjectsForTeacher;
	}

	public static TypeId TypeId(String text) {
		TypeId result = TypeId.CC;
		if (text.equals("CC")) {
			result = TypeId.CC;
		} else if (text.equals("TI")) {
			result = TypeId.TI;

		} else if (text.equals("CE")) {
			result = TypeId.CE;

		} else if (text.equals("RC")) {
			result = TypeId.RC;

		}
		return result;
	}

	public static TypeUser TypeUser(String text) {
		TypeUser result = TypeUser.STUDENT;
		if (text.equals("Docente")) {
			result = TypeUser.TEACHER;
		} else if (text.equals("Estudiante")) {
			result = TypeUser.STUDENT;

		}
		return result;
	}

	private static void showTreeInOrder(NodeAVL<Teacher> auxiliar, NodeAVL<Subject> subject) {
		if (auxiliar != null) {
			resultTeachers += ((auxiliar.getData().toStringTeacher()) + ",");
			resultTeachers += subjectForTeacher(auxiliar.getData());
			showTreeInOrder(auxiliar.getLeft(), subject);
			showTreeInOrder(auxiliar.getRigth(), subject);
		}
	}
}
