package veto.soins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANI")
public class Animal {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="SPEC",length=50,nullable=false)
	private String espece;
	@ManyToOne
	@JoinColumn(name="PROP_ID")
	private Proprietaire proprietaire;
	@Column(name="NUMA")
	private int numAnimal;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	public int getNumAnimal() {
		return numAnimal;
	}
	public void setNumAnimal(int numAnimal) {
		this.numAnimal = numAnimal;
	}
}
