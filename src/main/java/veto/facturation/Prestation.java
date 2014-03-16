package veto.facturation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PREST")
public class Prestation {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String intitule;
	@Column(name="CODE")
	private String codePrestation;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getCodePrestation() {
		return codePrestation;
	}
	public void setCodePrestation(String codePrestation) {
		this.codePrestation = codePrestation;
	}
}
