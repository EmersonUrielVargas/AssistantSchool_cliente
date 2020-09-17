package models;

import comparators.ComparatorBySubject;
import enums.TypeId;
import structures.AVLTree;
import structures.NodeAVL;

public class Teacher extends Person{
	
	private AVLTree<Subject> subjects;
	private String subjectsString;

	public Teacher(String name, String lastName, TypeId typeId, int numberId) {
		super(name, lastName, typeId, numberId);
		subjects = new AVLTree<Subject>(new ComparatorBySubject());
		subjectsString = "";
	}
	
	public void addSubject(Subject subject) {
		subjects.insert(subject);
	}
	
	public Subject askSubject(int subjectCode) {
		return subjects.ask(new Subject(subjectCode, ""), subjects.getRoot()).getData();
	}
	
	public void removeSubject(int subjectCode) {
		subjects.delete(new Subject(subjectCode, ""));
	}


	public AVLTree<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(AVLTree<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public String toStringTeacher() {
		return this.getName() +"" + this.getLastName() + "-" + this.getTypeId() + "_" + this.getNumberId();
	}
	
	public String toStringSubjects() {
		convertSubjectsToString(subjects.getRoot());
		return subjectsString;
	}
	
	public void resetSubjectsString() {
		subjectsString = "";
	}
	
	
	public String getSubjectsString() {
		toStringSubjects();
		return subjectsString;
	}

	private void convertSubjectsToString(NodeAVL<Subject> auxiliar) {
		if (auxiliar != null) {
			convertSubjectsToString(auxiliar.getLeft());
			subjectsString += ((auxiliar.getData().getSubjectName()) + "-");
			convertSubjectsToString(auxiliar.getRigth());
		}
	}
	
	
	
	
	

}
