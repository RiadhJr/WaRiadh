package com.java.WaRiadh.DTO;

public class PersonneDTO {
	private String nom;
	private int age;
	
	
	
	public PersonneDTO(String nom, int age) {
		super();
		this.nom = nom;
		this.age = age;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}
	
	
}
