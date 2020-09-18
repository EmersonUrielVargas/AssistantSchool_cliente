package models;

import comparators.ComparatorByFinalNoteStudent;
import enums.TypeId;
import structures.AVLTree;

public class Student extends Person {

	private AVLTree<FinalNote> finalNotes;
	private String nameCourse;

	public Student(String name, String lastName, TypeId typeId, int numberId, String nameCourse) {
		super(name, lastName, typeId, numberId);
		this.nameCourse = nameCourse;
		finalNotes = new AVLTree<>(new ComparatorByFinalNoteStudent());
	}
	
	public void addPartialNote(PartialNote partialNote,int subjectId) {
		System.out.println(subjectId);
		FinalNote auxiliar = this.askFinalNote(subjectId);
		auxiliar.addPartialNote(partialNote);
	}
	
	public void addFinalNote(FinalNote fn) {
		finalNotes.insert(fn);
	}

	public void modifyPartialNote(int subjectId, String topic, double value, String notation) {
		FinalNote auxiliar = this.askFinalNote(subjectId);
		auxiliar.modifyPartialNote(topic, value, notation);
	}

	public PartialNote askPartialNote(String topic, int subjectId) {
		FinalNote auxiliar = this.askFinalNote(subjectId);
		return auxiliar.askPartialNote(topic);
	}

	public void addComment(String topic, String comment, int subjectId) {
		FinalNote auxiliar = this.askFinalNote(subjectId);
		PartialNote note = auxiliar.askPartialNote(topic);
		note.setComment(comment);
	}

	public FinalNote askFinalNote(int subjectId) {
		return finalNotes.ask(new FinalNote(subjectId), finalNotes.getRoot()).getData();

	}

	public String getNameCourse() {
		return nameCourse;
	}
	
	





	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}





	public AVLTree<FinalNote> getFinalNotes() {
		return finalNotes;
	}

	public void setFinalNotes(AVLTree<FinalNote> finalNotes) {
		this.finalNotes = finalNotes;
	}

}
