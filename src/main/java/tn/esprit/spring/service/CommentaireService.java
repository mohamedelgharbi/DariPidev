package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Vente;

public interface CommentaireService {

	public Vente addCommentaire(Commentaire u);

	public Vente updateCommentaire(Commentaire u);

	public List<String> retrieveAllCommentaireByVente(long id);

	public void BlockCommentsWithInsultingWords(int id);

	void deleteCommentaire(String id);

}
