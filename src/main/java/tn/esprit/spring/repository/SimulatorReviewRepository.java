package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.SimulatorReview;

public interface SimulatorReviewRepository  extends CrudRepository<SimulatorReview, Integer> {
	@Query("SELECT count(*) FROM SimulatorReview")
	public int countreview();
}
