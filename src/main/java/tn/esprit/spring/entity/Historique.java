package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Historique implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany(mappedBy = "historique", cascade = CascadeType.ALL)
	private Set<Vente> vente;
	@ManyToOne
	Users user;

	public Historique() {
		super();
	}

	public Historique(Long id, Set<Vente> vente, Users user) {
		super();
		this.id = id;
		this.vente = vente;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Vente> getVente() {
		return vente;
	}

	public void setVente(Set<Vente> vente) {
		this.vente = vente;
	}

	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
