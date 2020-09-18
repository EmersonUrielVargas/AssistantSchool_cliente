package models;

import comparators.ComparatorByStudent;
import structures.AVLTree;

public class Course {

	private String nameCourse;
	private Teacher courseDirector;
	private AVLTree<Student> students;

	public Course(String nameCourse, Teacher director) {
		this.nameCourse = nameCourse;
		this.courseDirector = director;
		students = new AVLTree<Student>(new ComparatorByStudent());
	}

	public Course(String nameCourse) {
		this.nameCourse = nameCourse;
		students = new AVLTree<Student>(new ComparatorByStudent());
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
		students.insert(student);
	}

	public void setStudents(AVLTree<Student> students) {
		this.students = students;
	}
}
