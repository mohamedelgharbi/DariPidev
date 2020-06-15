package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "")
	private String description;

	@Column(name = "")
	private Boolean IsBlocked;

	@ManyToOne
	Users users;
	@ManyToOne
	private Vente vente;

	public Commentaire() {
		super();
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Commentaire(String description, Vente vente, Boolean IsBlocked) {
		super();
		this.description = description;
		this.vente = vente;
		this.IsBlocked = IsBlocked;
	}

	public Commentaire(Long id, String description, Vente vente, Boolean IsBlocked) {
		super();
		this.id = id;
		this.description = description;
		this.vente = vente;
		this.IsBlocked = IsBlocked;

	}

	public Boolean getIsBlocked() {
		return IsBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		IsBlocked = isBlocked;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

}
