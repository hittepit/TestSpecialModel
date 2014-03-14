package entity.schema2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="P")
public class Prestataire {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String numTrav;
	private String name;
	@ManyToOne
	@JoinColumn(name="DOSSIER_ID")
	private Dossier dossier;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	
	
}
