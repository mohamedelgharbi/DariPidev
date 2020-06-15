package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService {

	@Autowired
	ReclamationRepository ReclamationRepository;

	private static final Logger l = LogManager.getLogger(ReclamationServiceImpl.class);

	@Override
	public void addReclamation(Reclamation r) {
		ReclamationRepository.save(r);
	}

	@Override
	public List<Reclamation> retrieveAllReclamations() {
		return (List<Reclamation>) ReclamationRepository.findAll();
	}

	@Override
	public void deleteReclamation(String id) {
		ReclamationRepository.deleteById(Long.parseLong(id));
	}
}
