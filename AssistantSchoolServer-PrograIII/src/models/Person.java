package models;

import enums.TypeId;

public class Person {
	
	private String name;
	private String lastName;
	private TypeId typeId;
	private int numberId;
	
	public Person() {
	}
	
	public Person(String name, String lastName, TypeId typeId, int numberId) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.typeId = typeId;
		this.numberId = numberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public TypeId getTypeId() {
		return typeId;
	}
	public void setTypeId(TypeId typeId) {
		this.typeId = typeId;
	}
	public int getNumberId() {
		return numberId;
	}
	public void setNumberId(int numberId) {
		this.numberId = numberId;
	}
	
	

}
