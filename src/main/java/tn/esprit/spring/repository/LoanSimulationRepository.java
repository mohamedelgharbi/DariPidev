package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.LoanSimulation;

public interface LoanSimulationRepository extends CrudRepository<LoanSimulation, Integer> {

	@Query("SELECT count(*) FROM LoanSimulation")
	public int countls();

	@Query("SELECT amount FROM LoanSimulation")
	public List<String> loanSimulationAmounts();

	@Modifying
	@Transactional
	@Query("DELETE from LoanSimulation")
	public void deleteAllLoanSimulationsJPQL();

	@Query(value = "SELECT *  FROM `loan_simulation` WHERE `user_id_user`=?1", nativeQuery = true)
	List<LoanSimulation> findSimulationsByUser(int iduser);

	@Query(value = "SELECT *  FROM `loan_simulation` ORDER BY `amount` ASC", nativeQuery = true)
	List<LoanSimulation> retrieveAsc();

	@Query(value = "SELECT *  FROM `loan_simulation` ORDER BY `amount` DESC", nativeQuery = true)
	List<LoanSimulation> retrieveDesc();

	@Query(value = "SELECT *  FROM `loan_simulation` ORDER BY `simulation_date` DESC", nativeQuery = true)
	List<LoanSimulation> retrieveDescDate();

	@Query(value = "SELECT *  FROM `loan_simulation` WHERE `result`='Accepted'", nativeQuery = true)
	List<LoanSimulation> retrieveAccepted();

	@Query(value = "SELECT *  FROM `loan_simulation` WHERE `result`='Denied'", nativeQuery = true)
	List<LoanSimulation> retrieveDenied();

	@Query("SELECT COUNT(*) FROM LoanSimulation k WHERE k.category =:cat")
	int countByCategory(@Param("cat") Category category);
	
	@Query("SELECT COUNT(*) FROM LoanSimulation k WHERE k.result =:res")
	int countByResult(@Param("res") String result);

	@Query(value = "SELECT * FROM `loan_simulation` WHERE `bank_offers_id_bo`=?1", nativeQuery = true)
	int findByBankOffer(int idboffer);

	@Query("SELECT k FROM LoanSimulation k where k.category =:cat and k.result =:res")
	List<LoanSimulation> findByCategory(@Param("cat") Category category, @Param("res") String result);
	
	
	
	
	
	
	
}
