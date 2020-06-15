package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Vente")
public class Vente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "")
	@Enumerated(EnumType.STRING)
	private Region region;
	@Column(name = "")
	private String adresse;
	@Column()
	@Enumerated(EnumType.STRING)
	private TypeBien typeBien;
	@Column()
	@Enumerated(EnumType.STRING)
	private Etat etat;
	@Enumerated(EnumType.STRING)
	private State state;
	@Column(name = "")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "")
	private float prix;
	@Column(name = "")
	private String photoV;
	@Column(name = "")
	private Long surface;
	@Column(name = "")
	private int nbPiece;
	@Column(name = "")
	private int nbChambre;
	@Column(name = "")
	private int nbVues;
	@Column(name = "")
	private int nbLikes;
	@Column(name = "")
	private int nbDislikes;
	@Column(name = "")
	private String Description;
	@Column(name = "rating")
	private Integer rating = 0;
	@ManyToOne
	Users users;

	@OneToMany(mappedBy = "vente", cascade = CascadeType.REMOVE)
	private List<Notification> notification = new ArrayList<>();

	@OneToMany(mappedBy = "vente", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Commentaire> commentaire = new ArrayList<>();



	// @OneToMany
	// (cascade = CascadeType.ALL, mappedBy = "vente")
	// private List<Rating> rating = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Favoris> favoris;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Historique> historique;
	
	@OneToMany(mappedBy = "vente")
	@JsonIgnore
	private List<VenteToCartItem> venteToCartItemList;

	public Vente(Region region, String adresse, TypeBien typeBien, Etat etat, Date date, float prix, String photoV,
			Long surface, int nbPiece, int nbChambre, int nbVues, int nbLikes, int nbDislikes, String description,
			Users user, List<Commentaire> commentaire) {
		super();
		this.region = region;
		this.adresse = adresse;
		this.typeBien = typeBien;
		this.etat = etat;
		this.date = date;
		this.prix = prix;
		this.photoV = photoV;
		this.surface = surface;
		this.nbPiece = nbPiece;
		this.nbChambre = nbChambre;
		this.nbVues = nbVues;
		this.nbLikes = nbLikes;
		this.nbDislikes = nbDislikes;
		this.Description = description;
		this.commentaire = commentaire;
	}

	public Vente(Region region, String adresse, TypeBien typeBien, Etat etat, Date date, float prix, String photoV,
			Long surface, int nbPiece, int nbChambre, int nbVues, int nbLikes, int nbDislikes, String description,
			Users user, List<Commentaire> commentaire, Set<Favoris> favoris, Set<Historique> historique) {
		super();
		this.region = region;
		this.adresse = adresse;
		this.typeBien = typeBien;
		this.etat = etat;
		this.date = date;
		this.prix = prix;
		this.photoV = photoV;
		this.surface = surface;
		this.nbPiece = nbPiece;
		this.nbChambre = nbChambre;
		this.nbVues = nbVues;
		this.nbLikes = nbLikes;
		this.nbDislikes = nbDislikes;
		this.Description = description;
		this.commentaire = commentaire;
		this.favoris = favoris;
		this.historique = historique;
	}

	public Vente(int id, Region region, String adresse, TypeBien typeBien, Etat etat, Date date, float prix,
			String photoV, Long surface, int nbPiece, int nbChambre, int nbVues, int nbLikes, int nbDislikes,
			String description, Users user, List<Commentaire> commentaire, Set<Favoris> favoris,
			Set<Historique> historique) {
		super();
		this.id = id;
		this.region = region;
		this.adresse = adresse;
		this.typeBien = typeBien;
		this.etat = etat;
		this.date = date;
		this.prix = prix;
		this.photoV = photoV;
		this.surface = surface;
		this.nbPiece = nbPiece;
		this.nbChambre = nbChambre;
		this.nbVues = nbVues;
		this.nbLikes = nbLikes;
		this.nbDislikes = nbDislikes;
		this.Description = description;
		this.commentaire = commentaire;
		this.favoris = favoris;
		this.historique = historique;
	}

	public Vente() {
		super();
	}

	public Vente(Date date, Long surface, String description, Region region) {
		super();
		this.region = region;
		this.date = date;
		this.surface = surface;
		Description = description;
	}

	public Vente(Date date, Long surface, String description, Region region, float prix, TypeBien typeBien,
			String adresse, State state, int nbPiece, int nbChambre) {
		super();
		this.region = region;
		this.adresse = adresse;
		this.typeBien = typeBien;
		this.state = state;
		this.date = date;
		this.prix = prix;
		this.surface = surface;
		this.Description = description;
		this.nbPiece = nbPiece;
		this.nbChambre = nbChambre;
	}

	public Vente(int id, Date date, Long surface, String description, Region region, float prix, TypeBien typeBien,
			String adresse, State state, Users currentuser) {
		super();
		this.id = id;
		this.region = region;
		this.adresse = adresse;
		this.typeBien = typeBien;
		this.state = state;
		this.date = date;
		this.prix = prix;
		this.surface = surface;
		this.Description = description;
		this.users = currentuser;
	}

	public Vente(int id, Region region, String adresse, TypeBien typeBien, Etat etat, State state, Date date,
			float prix, String photoV, Long surface, int nbPiece, int nbChambre, int nbVues, int nbLikes,
			int nbDislikes, String description, Integer rating, Users users, List<Commentaire> commentaire,
			List<Notification> notification, Set<Favoris> favoris, Set<Historique> historique) {
		super();
		this.id = id;
		this.region = region;
		this.adresse = adresse;
		this.typeBien = typeBien;
		this.etat = etat;
		this.state = state;
		this.date = date;
		this.prix = prix;
		this.photoV = photoV;
		this.surface = surface;
		this.nbPiece = nbPiece;
		this.nbChambre = nbChambre;
		this.nbVues = nbVues;
		this.nbLikes = nbLikes;
		this.nbDislikes = nbDislikes;
		Description = description;
		this.rating = rating;
		this.users = users;
		this.commentaire = commentaire;
		this.notification = notification;
		this.favoris = favoris;
		this.historique = historique;
	}

	public int getId() {
		return id;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public TypeBien getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(TypeBien typeBien) {
		this.typeBien = typeBien;
	}

	@PrePersist
	protected void onCreate() {
		if (date == null) {
			date = new Date();
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getPhotoV() {
		return photoV;
	}

	public void setPhotoV(String photoV) {
		this.photoV = photoV;
	}

	public Set<Favoris> getFavoris() {
		return favoris;
	}

	public void setFavoris(Set<Favoris> favoris) {
		this.favoris = favoris;
	}

	public Set<Historique> getHistorique() {
		return historique;
	}

	public void setHistorique(Set<Historique> historique) {
		this.historique = historique;
	}

	public Long getSurface() {
		return surface;
	}

	public void setSurface(Long surface) {
		this.surface = surface;
	}

	public int getNbPiece() {
		return nbPiece;
	}

	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}

	public int getNbChambre() {
		return nbChambre;
	}

	public void setNbChambre(int nbChambre) {
		this.nbChambre = nbChambre;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public List<Commentaire> getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(List<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}

	public int getNbVues() {
		return nbVues;
	}

	public void setNbVues(int nbVues) {
		this.nbVues = nbVues;
	}

	public int getNbLikes() {
		return nbLikes;
	}

	public void setNbLikes(int nbLikes) {
		this.nbLikes = nbLikes;
	}

	public int getNbDislikes() {
		return nbDislikes;
	}

	public void setNbDislikes(int nbDislikes) {
		this.nbDislikes = nbDislikes;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public List<Notification> getNotification() {
		return notification;
	}

	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}

	

}
