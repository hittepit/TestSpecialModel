package entity.schema1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAV")
public class Travailleur {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String numTrav;
	private String nom;
	private String category;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumTrav() {
		return numTrav;
	}
	public void setNumTrav(String numTrav) {
		this.numTrav = numTrav;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
