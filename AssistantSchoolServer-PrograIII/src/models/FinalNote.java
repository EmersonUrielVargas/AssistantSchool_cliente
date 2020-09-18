package models;

import comparators.ComparatorByPartialNote;
import structures.AVLTree;
import structures.NodeAVL;

public class FinalNote {

	private int subjectId;
	private AVLTree<PartialNote> partialNotes;
	private double value;

	public FinalNote(int subjectId) {
		super();
		this.subjectId = subjectId;
		partialNotes = new AVLTree<>(new ComparatorByPartialNote());
		
	}

	private void calculateFinalNote(NodeAVL<PartialNote> auxiliar) {

		if (auxiliar != null) {
			calculateFinalNote(auxiliar.getLeft());
			value += auxiliar.getData().getValue();
			calculateFinalNote(auxiliar.getRigth());
		}
	}

	public void addPartialNote(PartialNote partialNote) {
		partialNotes.insert(partialNote);
	}

	public PartialNote askPartialNote(String topic) {
		return partialNotes.ask(new PartialNote(topic, 0, ""), partialNotes.getRoot()).getData();
	}

	public void modifyPartialNote(String topic, double value, String notation) {
		PartialNote note = this.askPartialNote(topic);
		note.setValue(value);
		note.setNotation(notation);
	}

	public void addComment(String topic, String comment) {
		PartialNote note = this.askPartialNote(topic);
		note.setComment(comment);

	}

	public int getSubject() {
		return subjectId;
	}

	public void setSubject(int subjectId) {
		this.subjectId = subjectId;
	}

	public AVLTree<PartialNote> getPartialNotes() {
		return partialNotes;
	}

	public void setPartialNotes(AVLTree<PartialNote> partialNotes) {
		this.partialNotes = partialNotes;
	}

	public double getValue() {
		calculateFinalNote(partialNotes.getRoot());
		return value / partialNotes.getRoot().getSize();
	}

	public void setValue(double value) {
		this.value = value;
	}

}
