package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.PrixParM2;

public interface PrixParM2Repository extends CrudRepository<PrixParM2, Integer> {

	@Autowired
	@Query(value = "select prix_appart from estimation where ville=? ", nativeQuery = true)
	public float PrixAppart(String Ville);

	@Autowired
	@Query(value = "select prix_maison from estimation where ville=? ", nativeQuery = true)
	public float PrixMaison(String Ville);

	@Autowired
	@Query(value = "select prix_terrain from estimation where ville=? ", nativeQuery = true)
	public float PrixTerrain(String Ville);
	
	@Query(value ="select ville from estimation", nativeQuery = true)
	public List<String> villeList();
	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM `estimation`", nativeQuery = true)
	public void deleteAll();

}
