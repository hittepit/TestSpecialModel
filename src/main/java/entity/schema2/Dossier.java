package entity.schema2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dossier {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nom;
	private String numDossier;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumDossier() {
		return numDossier;
	}
	public void setNumDossier(String numDossier) {
		this.numDossier = numDossier;
	}
	
	
}
