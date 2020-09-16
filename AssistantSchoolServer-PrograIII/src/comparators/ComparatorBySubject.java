package comparators;

import java.util.Comparator;

import models.Subject;

public class ComparatorBySubject implements Comparator<Subject> {

	@Override
	public int compare(Subject subject1, Subject subject2) {
		int result = 0;
		if (subject1.getSubjectCode() < subject2.getSubjectCode()) {
			result = -1;
		}
		if (subject1.getSubjectCode() > subject2.getSubjectCode()) {
			result = 1;
		}
		if (subject1.getSubjectCode() == subject2.getSubjectCode()) {
			result = 0;
		}
		return result;
	}
}
