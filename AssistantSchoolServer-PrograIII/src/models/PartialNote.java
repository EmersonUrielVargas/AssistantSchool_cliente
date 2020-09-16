package models;

public class PartialNote {

	private String topic;
	private double value;
	private String notation;
	private String archivement;
	private String comment;

	public PartialNote(String topic, double value, String archivement) {
		super();
		this.topic = topic;
		this.value = value;
		this.archivement = archivement;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getNotation() {
		return notation;
	}

	public void setNotation(String notation) {
		this.notation = notation;
	}

	public String getArchivement() {
		return archivement;
	}

	public void setArchivement(String archivement) {
		this.archivement = archivement;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Tema" + this.topic + "Nota" + this.value;
	}

}
