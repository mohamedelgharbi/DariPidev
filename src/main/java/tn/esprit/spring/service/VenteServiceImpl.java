package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Etat;
import tn.esprit.spring.entity.TypeBien;
import tn.esprit.spring.entity.Vente;
import tn.esprit.spring.repository.CommentaireRepository;
import tn.esprit.spring.repository.VenteRepository;

@Service
public class VenteServiceImpl implements VenteService {

	@Autowired
	VenteRepository VenteRepository;
	CommentaireRepository RatingRepository;

	private static final Logger l = LogManager.getLogger(VenteServiceImpl.class);

	@Override
	public List<Vente> retrieveAllVente() {
		return (List<Vente>) VenteRepository.findAll();
	}

	@Override
	public List<Vente> retrieveAllVenteDispo(Etat etat) {
		return VenteRepository.retrieveAllVenteDispo();
	}

	@Override
	public List<Vente> retrieveAllVenteVendu(Etat etat) {
		return VenteRepository.retrieveAllVenteVendu();
	}

	@Override
	public List<Vente> retrieveAllVenteMaison(TypeBien bien) {
		return VenteRepository.retrieveAllVenteMaisonn(bien);
	}

	@Override
	public List<Vente> retrieveAllVilla(TypeBien typeBien) {
		return VenteRepository.retrieveAllVilla();
	}

	@Override
	public List<Vente> retrieveAllAppartement(TypeBien typeBien) {
		return VenteRepository.retrieveAllAppartement();
	}

	@Override
	public List<Vente> retrieveAllMaison(TypeBien typeBien) {
		return VenteRepository.retrieveAllMaison();
	}

	@Override
	public List<Vente> retrieveAllTerrain(TypeBien typeBien) {
		return VenteRepository.retrieveAllTerrain();
	}

	@Override
	public Vente addVente(Vente v) {
		return VenteRepository.save(v);
	}

	@Override
	public void deleteVente(String id) {
		VenteRepository.deleteById((int) Long.parseLong(id));
	}

	@Override
	public Vente updateVente(Vente v) {
		return VenteRepository.save(v);
	}

	@Override
	public Vente retrieveVente(String id) {
		return VenteRepository.findById((int) Long.parseLong(id)).orElse(null);
	}

	@Override
	public int countVente() {
		int max = 0;
		List<Vente> app = (List<Vente>) VenteRepository.findAll();
		for (Vente vente : app) {
			max++;

		}
		l.info(" you have " + max + "appointments");

		return max;

	}

/*	@Override
	public double AVG_Ads_Year() {
		int A = 0;
		double b = 0;
		List<Vente> ad = (List<Vente>) VenteRepository.findAll();
		for (Vente aa : ad) {
			A++;
		}
		b = (A * 360) / 100;
		l.info(" you have " + b + "ads");

		return b;
	}
*/
	@Override
	public int nbrLike() {
		int like = 0;
		List<Vente> com = (List<Vente>) VenteRepository.findAll();
		for (Vente aa : com) {

			like += aa.getNbLikes();

		}

		l.info(" you have " + like + "comments");

		return like;

	}

	@Override
	public int maxnblike() {
		int k = 0;
		List<Vente> com = (List<Vente>) VenteRepository.findAll();
		for (Vente aa : com) {

			if (aa.getNbLikes() > k) {
				k = aa.getNbLikes();
			}
		}

		l.info(" you have " + k + " comments");
		return k;

	}

	@Override
	public int nbrDislike() {
		int dislike = 0;
		List<Vente> com = (List<Vente>) VenteRepository.findAll();
		for (Vente aa : com) {

			dislike += aa.getNbDislikes();

		}

		l.info(" you have " + dislike + "comments");

		return dislike;
	}

	@Override
	public void BloqueVente() {

		// List<Commentaire> com = (List<Commentaire>)
		// RatingRepository.findAll();
		List<Vente> zz = (List<Vente>) VenteRepository.findAll();

		// for (Commentaire aa : com) {
		for (Vente ee : zz) {
			if (ee.getNbDislikes() >= 2) {
				ee.setEtat(Etat.values()[2]);
				VenteRepository.save(ee);

			}
		}

	}

	@Override
	public Commentaire UpdateComment(Commentaire comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AssignCommentToanAd(int CommentId, int AdId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean incrementdislike(int id) {

		int A = 0;
		int k = 0;

		List<Vente> ads = (List<Vente>) VenteRepository.findAll();

		for (Vente aa : ads) {
			if (aa.getId() == id) {
				A = VenteRepository.getNumberDislike(id);
				A++;
				aa.setNbDislikes(A);
			}
			VenteRepository.save(aa);
		}
		for (Vente aa : ads) {
			if (aa.getNbDislikes() >= 2) {
				aa.setEtat(Etat.values()[2]);
				VenteRepository.save(aa);

			}
		}
		return true;

	}

	@Override
	public int countComments() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vente addOrUpdateVente(Vente vente) {
		return VenteRepository.save(vente);

	}

	@Override
	public void deleteVentejsf(int id) {

		VenteRepository.deleteById(id);
	}

	@Override
	public Vente getAdById(int id) {
		return VenteRepository.findById(id).get();
	}

	@Override
	public boolean incrementlike(int id) {

		int A = 0;
		int k = 0;

		List<Vente> ads = (List<Vente>) VenteRepository.findAll();

		for (Vente aa : ads) {
			if (aa.getId() == id) {
				A = VenteRepository.getNumberLike(id);
				A++;
				aa.setNbLikes(A);
				if (aa.getNbLikes() == 10) {

					k = aa.getRating();
					k++;
					aa.setRating(k);
				}
				VenteRepository.save(aa);
			}
		}
		return true;
	}

	@Override
	public boolean incrementvue(int id) {
		int A = 0;

		List<Vente> ads = (List<Vente>) VenteRepository.findAll();

		for (Vente aa : ads) {
			if (aa.getId() == id) {
				A = VenteRepository.getNumberVue(id);
				A++;
				aa.setNbVues(A);

				VenteRepository.save(aa);
			}
		}
		return true;
	}

}
