package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Reclamation;

public interface ReclamationService {


	public void addReclamation(Reclamation r);

	public List<Reclamation> retrieveAllReclamations();
	
	void deleteReclamation(String id);


	

}
