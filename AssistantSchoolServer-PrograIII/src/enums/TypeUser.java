package enums;

public enum TypeUser {
		TEACHER("Profesor"),
		STUDENT("Estudiante"),
		ADMIN("Administrador");
	
	private String text;
	
	TypeUser(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
		
		

}
