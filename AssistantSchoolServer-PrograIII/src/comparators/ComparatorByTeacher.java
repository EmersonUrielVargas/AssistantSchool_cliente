package comparators;

import java.util.Comparator;

import models.Teacher;

public class ComparatorByTeacher implements Comparator<Teacher> {

	public int compare(Teacher teacher1, Teacher teacher2) {
		int result = 0;
		if (teacher1.getNumberId() > teacher2.getNumberId()) {
			result = 1;
		}
		if (teacher1.getNumberId() < teacher2.getNumberId()) {
			result = -1;
		}
		if (teacher1.getNumberId() == teacher2.getNumberId()) {
			result = 0;
		}
		return result;
	}
}
