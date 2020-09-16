package comparators;

import java.util.Comparator;

import models.Student;

public class ComparatorByStudent implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
		int result = 0;
		if( student1.getNumberId()>student2.getNumberId()) {
			result =  1;
		}
		if(  student1.getNumberId()<student2.getNumberId()) {
			result =  -1;
		}
		if( student1.getNumberId() == student2.getNumberId()) {
			result =  0;
		}
		return result;
	}
	
}

