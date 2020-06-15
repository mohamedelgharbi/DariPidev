package tn.esprit.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.MoveEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

//import tn.esprit.spring.entity.Bonus;
import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Etat;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.Region;
import tn.esprit.spring.entity.State;
import tn.esprit.spring.entity.TypeBien;
import tn.esprit.spring.entity.Users;
import tn.esprit.spring.entity.Vente;
import tn.esprit.spring.repository.UsersRepository;
import tn.esprit.spring.repository.VenteRepository;
//import tn.esprit.spring.service.BonusService;
import tn.esprit.spring.service.CommentaireService;
import tn.esprit.spring.service.NotificationService;
import tn.esprit.spring.service.RatingView;
import tn.esprit.spring.service.ReclamationService;
import tn.esprit.spring.service.UsersService;
import tn.esprit.spring.service.VenteService;
import tn.esprit.spring.service.VenteServiceImpl;
import tn.esprit.spring.utility.MailSender;

@Scope(value = "session")
@Controller(value = "venteController")
@ELBeanName(value = "venteController")
// @Join(path = "/test", to = "/Vente/affichevente.jsf")

public class VenteController {

	@Autowired
	VenteService VenteService;
	@Autowired
	NotificationService NotificationService;
	@Autowired
	CommentaireService CommentaireService;
	@Autowired
	ReclamationService ReclamationService;
	/*
	 * @Autowired BonusService BonusService;
	 */ @Autowired
	UsersService UsersService;
	@Autowired
	UsersController UsersController;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	VenteRepository venteRepository;

	private static final Logger l = LogManager.getLogger(VenteServiceImpl.class);

	///////////////////////////////////////////////////////////////////////////////////////// cote
	///////////////////////////////////////////////////////////////////////////////////////// code
	///////////////////////////////////////////////////////////////////////////////////////// /////////////////////////////////////////////////////////////////////////////////
	// afficher tous les ventes
	// http://localhost:8081/SpringMVC/Servlet/retrieve-all-vente
	@PreAuthorize("hasRole('USER') or hasRole('ADMINISTRATEUR')") // acces user
																	// or admin
	@GetMapping("/retrieve-all-vente")
	@ResponseBody
	public List<Vente> retrieveAllVente() {
		List<Vente> list = VenteService.retrieveAllVente();
		return list;
	}

	// // afficher tous les rating
	// // http://localhost:8081/SpringMVC/Servlet/retrieve-all-rating
	// @GetMapping("/retrieve-all-rating")
	// @ResponseBody
	// public List<Commentaire> retrieveAllRating() {
	// List<Commentaire> list = rs.retrieveAllRating();
	// return list;
	// }

	// afficher les ventes vendus
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/vendu
	@GetMapping("/retrieve-vente/vendu")
	@ResponseBody
	public List<Vente> retrieveAllMaisonVendu() {
		List<Vente> list = VenteService.retrieveAllVenteVendu(Etat.values()[0]);
		return list;
	}

	// afficher les ventes encore disponibles
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/dispo
	@GetMapping("/retrieve-vente/dispo")
	@ResponseBody
	public List<Vente> retrieveAllMaisonDispo() {
		List<Vente> list = VenteService.retrieveAllVenteDispo(Etat.values()[1]);
		return list;
	}

	// afficher les Villas
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/villa
	@GetMapping("/retrieve-vente/villa")
	@ResponseBody
	public List<Vente> retrieveAllVilla() {
		List<Vente> list = VenteService.retrieveAllVilla(TypeBien.values()[0]);
		return list;
	}

	// afficher les Appartements
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/appartement
	@GetMapping("/retrieve-vente/appartement")
	@ResponseBody
	public List<Vente> retrieveAllAppartement() {
		List<Vente> list = VenteService.retrieveAllAppartement(TypeBien.values()[1]);
		return list;
	}

	// afficher les Maisons
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/maison
	@GetMapping("/retrieve-vente/maison")
	@ResponseBody
	public List<Vente> retrieveAllMaison() {
		List<Vente> list = VenteService.retrieveAllMaison(TypeBien.values()[2]);
		return list;
	}

	// afficher les Terrains
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/terrain
	@GetMapping("/retrieve-vente/terrain")
	@ResponseBody
	public List<Vente> retrieveAllTerrain() {
		List<Vente> list = VenteService.retrieveAllTerrain(TypeBien.values()[3]);
		return list;
	}

	// // afficher tous les Maisons
	// // http://localhost:8081/SpringMVC/Servlet/retrieve-all-vente/type/{type}
	// @GetMapping("/retrieve-all-vente/type/{type}")
	// @ResponseBody
	// public List<Vente> retrieveAllVenteMaison(@PathVariable("type") String
	// typeBien) {
	// List<Vente> list = us.retrieveAllVenteMaison(TypeBien.valueOf(typeBien));
	// return list;
	// }

	// afficher une seule vente avec l'id
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/{vente-id}
	@GetMapping("/retrieve-vente/{vente-id}")
	@ResponseBody
	public Vente retrieveVente(@PathVariable("vente-id") String id) {
		return VenteService.retrieveVente(id);
	}

	// ajouter une vente
	// http://localhost:8081/SpringMVC/Servlet/add-vente
	@PostMapping("/add-vente")
	@ResponseBody
	public Vente AddVente(@RequestBody Vente u) {
		Vente Vente = VenteService.addVente(u);
		return Vente;
	}

	// modifier une vente
	// http://localhost:8081/SpringMVC/Servlet/modify-vente
	@PutMapping("/modify-vente")
	@ResponseBody
	public Vente modifyVente(@RequestBody Vente Vente) {
		return VenteService.updateVente(Vente);
	}

	// supprimer une vente
	// http://localhost:8081/SpringMVC/Servlet/remove-vente/{id}
	@DeleteMapping("/remove-vente/{id}")
	@ResponseBody
	public void removeVente(@PathVariable("id") String id) {
		VenteService.deleteVente(id);
	}

	// afficher les nombres des ventes
	// http://localhost:8081/SpringMVC/Servlet/count-vente
	@GetMapping("/count-vente")
	@ResponseBody
	public int countVente() {
		return VenteService.countVente();
	}

	// afficher les nombres des ventes
	// http://localhost:8081/SpringMVC/Servlet/bloque-vente
	@PutMapping("/bloque-vente")
	@ResponseBody
	public void BloqueVente() {
		VenteService.BloqueVente();
	}

	// afficher les nombres des ventes
	// http://localhost:8081/SpringMVC/Servlet/bloque-commentaire
	// @PutMapping("/bloque-commentaire")
	// @ResponseBody
	// public boolean BlockCommentsWithInsultingWords() {
	// return CommentaireService.BlockCommentsWithInsultingWords();
	// }

	///////////////////////////////////////////////////////////////////////////////////////// cote
	///////////////////////////////////////////////////////////////////////////////////////// jsf
	///////////////////////////////////////////////////////////////////////////////////////// /////////////////////////////////////////////////////////////////////////////////

	private List<Vente> ventes;
	private List<Commentaire> commentaire;
	private Vente vente;
	private int id;
	private Region region;
	private String adresse;
	private TypeBien typeBien;
	private Etat etat;
	private Date date;
	private float prix;
	private String photoV;
	private Long surface;
	private int nbPiece;
	private int nbChambre;
	private int nbVues;
	private int nbLikes;
	private int nbDislikes;
	private String Description;
	private String newComment;
	private Integer rating1;
	@Autowired
	RatingView ratingview;
	private State state;
	private String destination = "C:\\Work\\workspace-sts\\decoo\\essai_sahar_dari_template3\\src\\main\\resources\\META-INF\\resources\\upload\\";
	private UploadedFile file;
	private int a;
	private List<Commentaire> comments;
	private List<Reclamation> reclamations;
	private Commentaire comment;
	private Reclamation reclamation;

	// private Bonus bonus;
	private Boolean meuble;
	private Boolean balcon;
	private Boolean jardin;
	private Boolean piscine;
	private Boolean sousSol;
	private Boolean parking;
	private Boolean etage;
	private Boolean ascenseur;
	private List<Users> users;
	private Users user;
	private DonutChartModel donutModel;

	public int getA() {
		return a;
	}

	public ReclamationService getReclamationService() {
		return ReclamationService;
	}

	public void setReclamationService(ReclamationService reclamationService) {
		ReclamationService = reclamationService;
	}

	public UsersService getUsersService() {
		return UsersService;
	}

	public void setUsersService(UsersService usersService) {
		UsersService = usersService;
	}

	public UsersController getUsersController() {
		return UsersController;
	}

	public void setUsersController(UsersController usersController) {
		UsersController = usersController;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Commentaire getComment() {
		return comment;
	}

	public void setComment(Commentaire comment) {
		this.comment = comment;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Boolean getMeuble() {
		return meuble;
	}

	public void setMeuble(Boolean meuble) {
		this.meuble = meuble;
	}

	public Boolean getBalcon() {
		return balcon;
	}

	public void setBalcon(Boolean balcon) {
		this.balcon = balcon;
	}

	public Boolean getJardin() {
		return jardin;
	}

	public void setJardin(Boolean jardin) {
		this.jardin = jardin;
	}

	public Boolean getPiscine() {
		return piscine;
	}

	public void setPiscine(Boolean piscine) {
		this.piscine = piscine;
	}

	public Boolean getSousSol() {
		return sousSol;
	}

	public void setSousSol(Boolean sousSol) {
		this.sousSol = sousSol;
	}

	public Boolean getParking() {
		return parking;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Boolean getEtage() {
		return etage;
	}

	public void setEtage(Boolean etage) {
		this.etage = etage;
	}

	public Boolean getAscenseur() {
		return ascenseur;
	}

	public void setAscenseur(Boolean ascenseur) {
		this.ascenseur = ascenseur;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public static Logger getL() {
		return l;
	}

	private Integer adIdToBeUpdated;

	public VenteService getVenteService() {
		return VenteService;
	}

	public String getNewComment() {
		return newComment;
	}

	public void setNewComment(String newComment) {
		this.newComment = newComment;
	}

	public List<Commentaire> getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(List<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}

	/*
	 * public BonusService getBonusService() { return BonusService; }
	 * 
	 * public void setBonusService(BonusService bonusService) { BonusService =
	 * bonusService; }
	 */

	public DonutChartModel getDonutModel() {
		return donutModel;
	}

	public void setDonutModel(DonutChartModel donutModel) {
		this.donutModel = donutModel;
	}

	public void setVenteService(VenteService venteService) {
		VenteService = venteService;
	}

	public CommentaireService getCommentaireService() {
		return CommentaireService;
	}

	public void setCommentaireService(CommentaireService commentaireService) {
		CommentaireService = commentaireService;
	}

	public List<Vente> getVentes() {
		return ventes;
	}

	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
	}

	public Vente getVente() {
		return vente;
	}

	public State getState() {
		return state;
	}

	public State[] getStates() {
		return State.values();
	}

	/*
	 * public Bonus getBonus() { return bonus; }
	 * 
	 * public void setBonus(Bonus bonus) { this.bonus = bonus; }
	 */

	public void setState(State state) {
		this.state = state;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public int getId() {
		return id;
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

	public Region[] getRegions() {
		return Region.values();
	}

	public TypeBien[] getTypebiens() {
		return TypeBien.values();
	}

	public TypeBien getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(TypeBien typeBien) {
		this.typeBien = typeBien;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Etat getEtat() {
		return etat;
	}

	public Etat[] getEtats() {
		return Etat.values();
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
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

	public Integer getRating1() {
		return rating1;
	}

	public void setRating1(Integer rating1) {
		this.rating1 = rating1;
	}

	public RatingView getRatingview() {
		return ratingview;
	}

	public void setRatingview(RatingView ratingview) {
		this.ratingview = ratingview;
	}

	public Integer getAdIdToBeUpdated() {
		return adIdToBeUpdated;
	}

	public void setAdIdToBeUpdated(Integer adIdToBeUpdated) {
		this.adIdToBeUpdated = adIdToBeUpdated;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<Commentaire> getComments() {
		return comments;
	}

	public void setComments(List<Commentaire> comments) {
		this.comments = comments;
	}

	public String addad() {

		Users UserId;
		UserId = UsersController.getAuthenticatedUser();
		Vente tmp = new Vente(date, surface, Description, region, prix, typeBien, adresse, state, nbChambre, nbPiece);

		try {
			upload();
			TransferTile(file.getFileName(), file.getInputStream());
			tmp.setPhotoV(file.getFileName());
			tmp.setEtat(Etat.Disponible);

			tmp.setUsers(UserId);

			l.info("uploaded");
		} catch (Exception e) {
			l.info(e.toString());
		}

		Users currentuser = UsersController.getAuthenticatedUser();
		Date currentdate = new Date();
		Vente ventenotif;

		ventenotif = VenteService.addVente(tmp);
		System.out.println("ededededede " + file.getFileName());

		NotificationService
				.addNotification(new Notification(" added a new property", currentdate, currentuser, ventenotif, 0));
		return "/affichevente.xhtml?faces-redirect=true";

	}

	/*
	 * public String addad() { Vente tmp = new Vente(date, surface, Description,
	 * region, prix, typeBien, adresse, state, nbChambre, nbPiece);
	 * tmp.setEtat(Etat.Disponible); VenteService.addOrUpdateVente(tmp); //
	 * return "/templates/uploadview.xhtml?faces-redirect=true"; return
	 * "/Vente/affichevente.xhtml?faces-redirect=true";
	 * 
	 * }
	 */

	public List<Vente> getventes() {
		ventes = VenteService.retrieveAllVente();
		return ventes;
	}

	public List<Reclamation> getreclamations() {
		reclamations = ReclamationService.retrieveAllReclamations();
		return reclamations;
	}

	public String removeAd(int id) {
		l.info("aaaaaaaaaaaa" + id);
		VenteService.deleteVentejsf(id);
		addMessage("System Error", "Please try again later.");
		return "/affichevente.xhtml?faces-redirect=true";

	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void handleClose(CloseEvent event) {
		addMessage(event.getComponent().getId() + " closed", "So you don't like nature?");
	}

	public void handleMove(MoveEvent event) {
		addMessage(event.getComponent().getId() + " moved", "Left: " + event.getLeft() + ", Top: " + event.getTop());
	}

	public String incrementlike(int id) {
		l.info("aaaaaaaaaaaaaaaaaaaaaaaaa" + id);
		VenteService.incrementlike(id);
		rating1 = ratingview.getRating8(id);
		return "/affichevente.xhtml?faces-redirect=true";

	}

	public Integer getRating8(int id) {
		return ratingview.getRating8(id);
	}

	public String incrementdislike(int id) {
		VenteService.incrementdislike(id);
		return "/affichevente.xhtml?faces-redirect=true";

	}

	public String displayAd(Vente vente) {
		// String navigateTo = "null";
		this.setDate(vente.getDate());
		this.setRegion(vente.getRegion());
		this.setPrix(vente.getPrix());
		this.setDescription(vente.getDescription());
		this.setSurface(vente.getSurface());
		this.setTypeBien(vente.getTypeBien());
		this.setAdIdToBeUpdated(vente.getId());
		this.setState(vente.getState());
		this.setAdresse(vente.getAdresse());
		// return "/Vente/modifvente.xhtml?faces-redirect=true";

		return "/modifvente.xhtml?faces-redirect=true";

	}

	public String updateAd() {

		Users currentuser = UsersController.getAuthenticatedUser();
		Date currentdate = new Date();
		Vente ventenotif;

		ventenotif = VenteService.addOrUpdateVente(new Vente(adIdToBeUpdated, date, surface, Description, region, prix,
				typeBien, adresse, state, currentuser));
		NotificationService
				.addNotification(new Notification(" added a new property", currentdate, currentuser, ventenotif, 1));
		return "/affichevente.xhtml?faces-redirect=true";

	}

	public String openDetail(Vente v) {
		vente = v;
		// setBonus(v.getBonus());
		// int idv = vente.getId();
		// VenteService.incrementvue(idv);

		return "/chaquevente.xhtml?faces-redirect=true";
	}

	public String openDetaildashbord(Vente v) {
		vente = v;
		// setBonus(v.getBonus());
		return "/chaqueventedashbord.xhtml?faces-redirect=true";
	}

	public String openDetailnotification(Vente v) {
		vente = v;
		// setBonus(v.getBonus());
		return "/chaqueventedashbord.xhtml?faces-redirect=true";
	}

	public void upload() {

		if (file != null) {
			FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else
			System.out.println("file is null");
	}

	public void handleFileUpload(FileUploadEvent event) {
		l.info("ddddddddddddddd " + event.getFile().getFileName());
		FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void TransferTile(String fileName, InputStream in) {
		try {
			OutputStream out = new FileOutputStream(new File(destination + fileName));
			int reader = 0;
			byte[] bytes = new byte[(int) file.getSize()];
			while ((reader = in.read(bytes)) != -1) {
				out.write(bytes, 0, reader);
			}
			in.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String addComment() {

		Users UserId;

		UserId = UsersController.getAuthenticatedUser();
		System.out.println("cmnt " + newComment);
		Commentaire cmnt = new Commentaire();
		cmnt.setDescription(newComment);
		cmnt.setIsBlocked(false);
		cmnt.setVente(vente);
		cmnt.setUsers(UserId);
		CommentaireService.addCommentaire(cmnt);
		return "/affichevente.xhtml?faces-redirect=true";

	}

	public List<Commentaire> listCommentaire(Vente v) {
		return v.getCommentaire();
	}

	public String displayComment(Commentaire commentaire) {
		// String navigateTo = "null";
		l.info("afiiichhhhhhhhhh" + commentaire.getDescription());
		comment = commentaire;
		this.setNewComment(commentaire.getDescription());
		return "/chaquevente.xhtml?faces-redirect=true";

	}

	public String reclamerComment(Commentaire commentaire) {
		Reclamation rec = new Reclamation();
		comment = commentaire;
		rec.setCommentaire(commentaire);
		ReclamationService.addReclamation(rec);

		l.info("aaaaaaaaaaaaaaaah" + commentaire.getDescription());
		// ReclamationService.addReclamation(rec);
		// commentaire.setReclamation(rec);
		// CommentaireService.updateCommentaire(commentaire);

		return "/chaquevente.xhtml?faces-redirect=true";

	}

	public String deleteComment(String id) {

		l.info("aaaaaaaaaaaa" + id);
		CommentaireService.deleteCommentaire(id);
		addMessage("System Error", "Please try again later.");
		return "/chaquevente.xhtml?faces-redirect=true";

	}

	public String updateComment() {
		System.out.println("updating..." + comment.getId());
		comment.setDescription(newComment);
		CommentaireService.updateCommentaire(comment);
		return "/chaquevente.xhtml?faces-redirect=true";
	}

	public String barGraph(Model model) {

		donutModel = new DonutChartModel();
		ChartData data = new ChartData();

		DonutChartDataSet dataSet = new DonutChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(VenteService.retrieveAllVilla(typeBien).size());
		values.add(VenteService.retrieveAllAppartement(typeBien).size());
		values.add(VenteService.retrieveAllTerrain(typeBien).size());
		values.add(VenteService.retrieveAllMaison(typeBien).size());

		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(255, 99, 132)");
		bgColors.add("rgb(183, 185, 189)");
		bgColors.add("rgb(255, 205, 86)");
		bgColors.add("rgb(54, 162, 235)");
		dataSet.setBackgroundColor(bgColors);
		data.addChartDataSet(dataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Furnitures");
		labels.add("HomeAppliance");
		labels.add("Chandeliers");
		labels.add("Glass");
		data.setLabels(labels);

		donutModel.setData(data);
		return "/barGraph.xhtml?faces-redirect=true";
	}

	public void addMessage() {

		String summary = ascenseur ? "Checked" : "Unchecked";
		String summary1 = etage ? "Checked" : "Unchecked";
		String summary2 = balcon ? "Checked" : "Unchecked";
		String summary3 = meuble ? "Checked" : "Unchecked";
		String summary4 = jardin ? "Checked" : "Unchecked";
		String summary5 = parking ? "Checked" : "Unchecked";
		String summary6 = piscine ? "Checked" : "Unchecked";
		String summary7 = sousSol ? "Checked" : "Unchecked";

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary1));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary2));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary3));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary4));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary5));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary6));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary7));

	}

	public String BlockComments(int id) {

		CommentaireService.BlockCommentsWithInsultingWords(id);

		// Users currentuser = UsersController.getAuthenticatedUser();
		// mails.sendEmail(comment.getUsers().getEmail());
		// mails.sendEmail(comment.getUsers().getEmail(),
		// comment.getDescription(), comment.getUsers().getNom());

		return "/dashbordvente.xhtml?faces-redirect=true";
	}

	public String deleteReclamation(String id) {

		l.info("aaaaaaaaaaaa" + id);
		ReclamationService.deleteReclamation(id);
		addMessage("System Error", "Please try again later.");
		return "/dashbordvente.xhtml?faces-redirect=true";

	}

	public boolean openDetailacc(int id) {
		vente = VenteService.getAdById(id);
		l.info("mmmmmmm" + id);
		return VenteService.incrementvue(id);

	}

	// -----------------------------------------Mail

	private String subject = "Appointment To Buy";
	private String messageMail = "I'm willing to buy your product.Please text me back";

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageMail() {
		return messageMail;
	}

	public void setMessageMail(String messageMail) {
		this.messageMail = messageMail;
	}

	public void send() {

		try {
			MailSender mailSender = new MailSender();
			mailSender.SendMail(vente.getUsers().getEmail(), subject, messageMail);
		} catch (Exception e) {
			System.out.println("Error Mail");
		}
	}
}
