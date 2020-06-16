package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.SimulatorReview;

public interface ISimulatorReviewService {

	public int addOrUpdateSimulatorReview(SimulatorReview simulatorReview);

	public SimulatorReview getSimulatorReviewByID(int simulatorReviewID);

	public void deleteSimulatorReviewByID(int simulatorReviewID);

	public int getSimulatorReviewNumberJPQL();

	public List<SimulatorReview> getAllSimulatorReviews();

}
