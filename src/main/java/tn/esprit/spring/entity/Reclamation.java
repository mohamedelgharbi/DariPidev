package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Reclamation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.REMOVE)
	//@OneToOne

	private Commentaire commentaire;
	public Reclamation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Reclamation(Long id) {
		super();
		this.id = id;

	}

	public Reclamation(Long id, Commentaire commentaire) {
		super();
		this.id = id;
		this.commentaire = commentaire;
	}

}
