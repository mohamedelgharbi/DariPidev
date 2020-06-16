package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {
	@Query("SELECT count(*) FROM Bank")
	public int countemp();

	@Query("SELECT name_bank FROM Bank")
	public List<String> getAllbanksNamesJPQL();

	@Modifying
	@Transactional
	@Query("DELETE from Bank")
	public void deleteAllBanksJPQL();

	@Modifying
	@Transactional
	@Query("DELETE from Bank b where b.id like ?1 and fileName like ?2")
	public void deleteBankWithLogo(Integer id, String fileName);

}
