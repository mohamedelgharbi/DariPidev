package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entity.ValeurEstim;

public interface ValeurEstimRepository extends JpaRepository<ValeurEstim, Integer> {
	@Query(value = "SELECT count(*) FROM Valeur", nativeQuery = true)
	public int countval();
	
	@Query(value = "SELECT result FROM Valeur", nativeQuery = true)
	public List<String> estimValAll();
}
