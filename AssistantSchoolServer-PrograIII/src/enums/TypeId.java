package enums;

public enum TypeId {
	
	CC("Cedula de Ciudadania"),
	TI("Tarjeta de Identidad"),
	CE("Cedula de Extranjeria"),
	RC("Registro Civil");
	
	private String text;
	
	TypeId(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	

}
