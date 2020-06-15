package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Etat;
import tn.esprit.spring.entity.TypeBien;
import tn.esprit.spring.entity.Vente;

public interface VenteService {

	public List<Vente> retrieveAllVente();

	public Vente addVente(Vente u);

	public void deleteVente(String id);

	public void deleteVentejsf(int id);

	public Vente updateVente(Vente u);

	public Vente retrieveVente(String id);

	public int countVente();

	public List<Vente> retrieveAllVenteMaison(TypeBien bien);

	public List<Vente> retrieveAllVenteVendu(Etat etat);

	public List<Vente> retrieveAllVenteDispo(Etat etat);

	public List<Vente> retrieveAllVilla(TypeBien typeBien);

	public List<Vente> retrieveAllAppartement(TypeBien typeBien);

	public List<Vente> retrieveAllMaison(TypeBien typeBien);

	public List<Vente> retrieveAllTerrain(TypeBien typeBien);

//	public double AVG_Ads_Year();

	public int nbrLike();

	public int nbrDislike();

	public int maxnblike();

	public void BloqueVente();

	Commentaire UpdateComment(Commentaire comment);

	void AssignCommentToanAd(int CommentId, int AdId);

	public boolean incrementdislike(int id);

	public boolean incrementlike(int id);

	public int countComments();

	public Vente addOrUpdateVente(Vente vente);

	public Vente getAdById(int id);

	public boolean incrementvue(int id);

	

}
