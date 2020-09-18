package models;

import java.util.ArrayList;

import comparators.ComparatorByStudent;
import structures.AVLTree;

public class Course {

	private String nameCourse;
	private Teacher courseDirector;
	private AVLTree<Student> students;
	private ArrayList<Integer> idsSubjects;

	public Course(String nameCourse, Teacher director) {
		this.nameCourse = nameCourse;
		this.courseDirector = director;
		idsSubjects = new ArrayList<Integer>();
		students = new AVLTree<Student>(new ComparatorByStudent());
	}
	
	public void addCodeSubject(int codeSubject) {
		idsSubjects.add(codeSubject);
	}

	public Course(String nameCourse) {
		this.nameCourse = nameCourse;
		students = new AVLTree<Student>(new ComparatorByStudent());
		idsSubjects = new ArrayList<Integer>();
	}

	public void remoteCourseDirector() {
		courseDirector = null;
	}

	public void reeplaceCourseDirector(Teacher courseDirector) {
		this.courseDirector = courseDirector;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public Teacher getCourseDirector() {
		return courseDirector;
	}

	public void setCourseDirector(Teacher courseDirector) {
		this.courseDirector = courseDirector;
	}

	public AVLTree<Student> getStudents() {
		return students;
	}
	
	public void addStudent(Student student) {
		
		for (int i = 0; i < idsSubjects.size(); i++) {
			FinalNote auxiliar = new FinalNote(idsSubjects.get(i));
			for (int j = 0; j < 7; j++) {
				auxiliar.addPartialNote(new PartialNote("Tema" + i));
			}
			student.addFinalNote(auxiliar);
		}
		students.insert(student);
	}

	public void setStudents(AVLTree<Student> students) {
		this.students = students;
	}
}
