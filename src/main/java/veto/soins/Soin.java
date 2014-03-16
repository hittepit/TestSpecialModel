package veto.soins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Soin {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nom;
	@Column(name="CODE")
	private String codeSoin;
	@ManyToOne
	@JoinColumn(name="ANI_ID")
	private Animal animal;
	
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
	public String getCodeSoin() {
		return codeSoin;
	}
	public void setCodeSoin(String codeSoin) {
		this.codeSoin = codeSoin;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
}
