package veto.facturation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ligne {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="PRIX")
	private double prixUnitaire;
	private int quantite;
	@ManyToOne
	@JoinColumn(name="FACT_ID")
	private Facture facture;
	@ManyToOne
	@JoinColumn(name="PREST_ID")
	private Prestation prestation;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public Prestation getPrestation() {
		return prestation;
	}
	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}
}
