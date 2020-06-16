package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.BankOffers;;

public interface BankOffersRepository extends CrudRepository<BankOffers, Integer> {

	@Query("SELECT count(*) FROM BankOffers")
	public int countemp();

	@Query("SELECT name_bankoffer FROM BankOffers")
	public List<String> bankOffersNames();

	@Modifying
	@Transactional
	@Query("DELETE from BankOffers")
	public void deleteAllbankOffersJPQL();

	@Query(value = "SELECT * FROM `bank_offers` WHERE `special`=1", nativeQuery = true)
	List<BankOffers> specialOffers();

	@Query(value = "SELECT *  FROM `bank_offers` ORDER BY `interest_rate` ASC", nativeQuery = true)
	List<BankOffers> retrieveAscRate();

	@Query(value = "SELECT *  FROM `bank_offers` ORDER BY `interest_rate` DESC", nativeQuery = true)
	List<BankOffers> retrieveDescRate();

	@Query(value = "SELECT *  FROM `bank_offers` ORDER BY `total_insurance` DESC", nativeQuery = true)
	List<BankOffers> retrieveDescInsurance();

	@Query(value = "SELECT *  FROM `bank_offers` ORDER BY `total_insurance` ASC", nativeQuery = true)
	List<BankOffers> retrieveASCInsurance();

	@Query("select Max(b.total_insurance), b.name_bankoffer from BankOffers b")
	public List<?> TopInsurance();
	
	@Query("select Min(b.interest_rate), b.name_bankoffer from BankOffers b")
	public List<?> MinInterestRate();
	
	@Query("select Min(b.additional_fees), b.name_bankoffer from BankOffers b")
	public List<?> MinFees();
}
