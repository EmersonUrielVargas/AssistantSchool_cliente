package models;

import enums.TypeUser;

public class User {
	
	private String nickName;
	private String password;
	private Person client;
	private TypeUser typeUser;
	
	
	public User(Person client, TypeUser typeUser) {
		super();
		this.client = client;
		this.typeUser = typeUser;
		this.nickName = this.client.getLastName().charAt(0) + "" +  this.client.getLastName().charAt(1)+ "" + client.getNumberId() + "";
		this.password = this.client.getName().charAt(0) +""+this.client.getLastName().charAt(1)+"" + client.getNumberId() + "";
	}
	
	
	
	public User(String nickName, String password) {
		this.nickName = nickName;
		this.password = password;
	}



	public User() {
	}


	public String getNickName() {
		return nickName;
	}
	
	public String getPassword() {
		return password;
	}


	public Person getClient() {
		return client;
	}


	public void setClient(Person client) {
		this.client = client;
	}


	public TypeUser getTypeUser() {
		return typeUser;
	}


	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
