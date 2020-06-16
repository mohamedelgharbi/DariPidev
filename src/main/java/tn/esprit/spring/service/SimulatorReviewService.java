package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.SimulatorReview;
import tn.esprit.spring.repository.SimulatorReviewRepository;

@Service
public class SimulatorReviewService implements ISimulatorReviewService {
	@Autowired
	SimulatorReviewRepository simulatorReviewRepository;

	@Override
	public int addOrUpdateSimulatorReview(SimulatorReview simulatorReview) {
		Date currentDate = new Date(System.currentTimeMillis());
		simulatorReview.setAddedDate(currentDate);
		simulatorReviewRepository.save(simulatorReview);
		return simulatorReview.getId_review();
	}

	@Override
	public SimulatorReview getSimulatorReviewByID(int simulatorReviewID) {

		return simulatorReviewRepository.findById(simulatorReviewID).get();
	}

	@Override
	public void deleteSimulatorReviewByID(int simulatorReviewID) {
		SimulatorReview simulatorReview = simulatorReviewRepository.findById(simulatorReviewID).get();
		simulatorReviewRepository.delete(simulatorReview);
	}

	@Override
	public int getSimulatorReviewNumberJPQL() {

		return simulatorReviewRepository.countreview();
	}

	@Override
	public List<SimulatorReview> getAllSimulatorReviews() {

		return (List<SimulatorReview>) simulatorReviewRepository.findAll();
	}

}
