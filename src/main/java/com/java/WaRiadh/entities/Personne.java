package com.java.WaRiadh.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="student")
public class Personne {
	
	
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long personne_id;
	private String personne_nom;
	private String personne_prenom;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date date_de_naissance;


	public Long getPersonne_id() {
		return personne_id;
	}


	public void setPersonne_id(Long personne_id) {
		this.personne_id = personne_id;
	}


	public String getPersonne_nom() {
		return personne_nom;
	}


	public void setPersonne_nom(String personne_nom) {
		this.personne_nom = personne_nom;
	}


	public String getPersonne_prenom() {
		return personne_prenom;
	}


	public void setPersonne_prenom(String personne_prenom) {
		this.personne_prenom = personne_prenom;
	}


	public Date getDate_de_naissance() {
		return date_de_naissance;
	}


	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}
	
	

}
