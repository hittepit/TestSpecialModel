package entity.schema1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMP")
public class Employeur {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String numDossier;
	private String nom;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumDossier() {
		return numDossier;
	}
	public void setNumDossier(String numDossier) {
		this.numDossier = numDossier;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	
}
