package comparators;

import java.util.Comparator;

import models.Course;

public class ComparatorByCourse implements Comparator<Course> {

	@Override
	public int compare(Course course1, Course course2) {
		int result = 0;
		if( course1.getNameCourse().compareTo(course2.getNameCourse()) > 0) {
			result =  1;
		}
		if( course1.getNameCourse().compareTo(course2.getNameCourse()) < 0) {
			result =  -1;
		}
		if( course1.getNameCourse().compareTo(course2.getNameCourse()) == 0) {
			result =  0;
		}
		return result;

	}

}
