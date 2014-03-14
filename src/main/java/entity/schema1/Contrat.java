package entity.schema1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contrat {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String numContrat;
	@ManyToOne
	@JoinColumn(name="TRAV_ID")
	private Travailleur travailleur;
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employeur employeur;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumContrat() {
		return numContrat;
	}
	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
	}
	public Travailleur getTravailleur() {
		return travailleur;
	}
	public void setTravailleur(Travailleur travailleur) {
		this.travailleur = travailleur;
	}
	public Employeur getEmployeur() {
		return employeur;
	}
	public void setEmployeur(Employeur employeur) {
		this.employeur = employeur;
	}
	
	
}
