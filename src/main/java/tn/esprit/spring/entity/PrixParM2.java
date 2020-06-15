package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Estimation")
public class PrixParM2 {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String ville;
	private float prixMaison;
	private float prixAppart;
	private float prixTerrain;


	public PrixParM2() {
		super();

	}

	public PrixParM2(int id, String ville, float prixParM2Maison, float prixParM2Appart, float prixParM2NonConstruit) {
		super();
		Id = id;
		this.ville = ville;
		this.prixMaison = prixParM2Maison;
		this.prixAppart = prixParM2Appart;
		this.prixTerrain = prixParM2NonConstruit;
	}

	public PrixParM2(String ville, float prixMaison, float prixAppart) {
		super();
		this.ville = ville;
		this.prixMaison = prixMaison;
		this.prixAppart = prixAppart;

	}

	public PrixParM2(int id, String ville, float prixMaison, float prixAppart) {
		super();
		Id = id;
		this.ville = ville;
		this.prixMaison = prixMaison;
		this.prixAppart = prixAppart;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public float getPrixMaison() {
		return prixMaison;
	}

	public void setPrixMaison(float prixMaison) {
		this.prixMaison = prixMaison;
	}

	public float getPrixAppart() {
		return prixAppart;
	}

	public void setPrixAppart(float prixAppart) {
		this.prixAppart = prixAppart;
	}

	public float getPrixTerrain() {
		return prixTerrain;
	}

	public void setPrixTerrain(float prixTerrain) {
		this.prixTerrain = prixTerrain;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PrixParM2 [Id=" + Id + ", ville=" + ville + ", prixMaison=" + prixMaison + ", prixAppart=" + prixAppart
				+ ", prixTerrain=" + prixTerrain + "]";
	}

}
