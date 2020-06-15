package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Vente;
import tn.esprit.spring.repository.CommentaireRepository;
import tn.esprit.spring.repository.VenteRepository;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	CommentaireRepository RatingRepository;
	@Autowired
	VenteRepository VenteRepository;
	

	private static final Logger l = LogManager.getLogger(CommentaireServiceImpl.class);
	//
	// @Override
	// public List<String> retrieveAllCommentaireByVente(long id) {
	// Vente aa = VenteRepository.findById(id).get();
	// List<String> CommentsDescription = new ArrayList<>();
	//
	// for(Commentaire com : aa.getCommentaire()){
	// CommentsDescription.add(com.getDescription());
	//
	// }
	//
	// return CommentsDescription;
	// }

	public void BlockCommentsWithInsultingWords(int id) {

		List<Commentaire> com = (List<Commentaire>) RatingRepository.findAll();
		for (Commentaire aa : com) {
			if (aa.getId() == id) {
				String input = aa.getDescription();
				String output = Filter.getCensoredText(input);

				if (output.contains("*")) {
					aa.setIsBlocked(true);
					RatingRepository.save(aa);
					// return true;
				} else

					aa.setIsBlocked(false);
			}
			RatingRepository.save(aa);

		}

	}

	@Override
	public Vente addCommentaire(Commentaire u) {
		RatingRepository.save(u);
		return null;
	}

	@Override
	public void deleteCommentaire(String id) {
		RatingRepository.deleteById(Long.parseLong(id));

	}

	@Override
	public Vente updateCommentaire(Commentaire u) {
		RatingRepository.save(u);
		return null;
	}

	@Override
	public List<String> retrieveAllCommentaireByVente(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
