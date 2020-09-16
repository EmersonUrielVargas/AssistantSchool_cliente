package models;

public class Subject {

	private int subjectCode;
	private String subjectName;
	private FinalNote finalNote;

	public Subject(int subjectCode, String subjectName) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}

	public FinalNote getFinalNote() {
		return finalNote;
	}

	public void setFinalNote(FinalNote finalNote) {
		this.finalNote = finalNote;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
