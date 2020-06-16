package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Bank;
import tn.esprit.spring.entity.BankOffers;
import tn.esprit.spring.repository.BankOffersRepository;
import tn.esprit.spring.repository.BankRepository;

@EnableScheduling
@Service
@Component
public class BankOffersService implements IBankOffersService {
	@Autowired
	BankOffersRepository bankOffersRepository;
	@Autowired
	BankRepository bankRepository;

	public int addBankOffer(BankOffers bankOffers) {
		bankOffersRepository.save(bankOffers);
		return bankOffers.getId_bo();
	}

	@Override
	public void deleteBankOfferByID(int bankOfferID) {

		BankOffers bankOffers = bankOffersRepository.findById(bankOfferID).get();

		// Desaffecter l'employe de tous les departements
		// c'est le bout master qui permet de mettre a jour
		// la table d'association
		// for (Bank dep : bankOffers.getBank()) {
		// dep.getBankOffer().remove(bankOffers);

		bankOffersRepository.delete(bankOffers);
	}

	@Override
	public void affectBankToBankOffer(int bankID, int bankOfferID) {
		Bank bankManagedEntity = bankRepository.findById(bankID).get();
		BankOffers bankOffersManagedEntity = bankOffersRepository.findById(bankOfferID).get();
		bankOffersManagedEntity.setBank(bankManagedEntity);
		bankOffersRepository.save(bankOffersManagedEntity);
	}

	@Override
	public void updateBankOfferNameByID(String bankOfferName, int bankOfferID) {
		BankOffers bankOffers = bankOffersRepository.findById(bankOfferID).get();
		bankOffers.setName_bankoffer(bankOfferName);
		bankOffersRepository.save(bankOffers);
	}

	@Override
	public List<BankOffers> getAllBankOffers() {

		return (List<BankOffers>) bankOffersRepository.findAll();
	}

	@Override
	public List<String> getAllBankOffersNamesByBank(int bankID) {
		Bank bankManagedEntity = bankRepository.findById(bankID).get();
		List<String> bankOfferName = new ArrayList<>();
		for (BankOffers bo : bankManagedEntity.getBankOffer()) {
			bankOfferName.add(bo.getName_bankoffer());
		}
		return bankOfferName;
	}

	@Override
	public String getBankOfferNameByBankOfferID(int bankOfferID) {
		BankOffers bankOffersManagedEntity = bankOffersRepository.findById(bankOfferID).get();
		return bankOffersManagedEntity.getName_bankoffer();
	}

	@Override
	public int getBankOffersNumberJPQL() {

		return bankOffersRepository.countemp();
	}

	@Override
	public List<String> getAllBankOffersNamesJPQL() {

		return bankOffersRepository.bankOffersNames();
	}

	@Override
	public void deleteAllBankOffersJPQL() {
		bankOffersRepository.deleteAllbankOffersJPQL();

	}

	@Override
	public void updateBankOfferDescriptionByID(String description, int bankOfferID) {
		BankOffers bankOffersManagedEntity = bankOffersRepository.findById(bankOfferID).get();
		bankOffersManagedEntity.setDescription_offer(description);
		bankOffersRepository.save(bankOffersManagedEntity);

	}

	@Override
	public int addOrUpdateBankOffer(BankOffers bankOffer) {

		bankOffersRepository.save(bankOffer);
		return bankOffer.getId_bo();
	}

	@Override
	public BankOffers getBankOfferByID(int bankOfferID) {

		return bankOffersRepository.findById(bankOfferID).get();

	}

	// @Transactional
	//@Scheduled(cron = "0 * * * * *")
	// @Scheduled(cron = "0 0 10 * * MON-FRI")
	public void specialOffer() {
		List<BankOffers> bkoffers = new ArrayList<BankOffers>();

		bkoffers = (List<BankOffers>) bankOffersRepository.findAll();

		for (BankOffers bk : bkoffers) {

			if (bk.getInterest_rate() > 1.2) {

				float new_interest_rate = (float) ((float) (bk.getInterest_rate()) * 0.80); // 20%
																							// Remise
																							// !!
				float new_additional_fees = (float) ((float) (bk.getAdditional_fees()) * 0.95); // 5%
																								// Remise
																								// !!

				bk.setInterest_rate(new_interest_rate);
				bk.setAdditional_fees(new_additional_fees);
				bk.setSpecial(1);
				bankOffersRepository.save(bk);
				System.out.println("**************************Special Offer******************************\n"
						+ "New Interest Rate: " + bk.getInterest_rate() + "\n New Additional Fees : "
						+ bk.getAdditional_fees());
			} else {

				bk.setSpecial(0);
				bankOffersRepository.save(bk);
			}

		}

	}

	@Override
	public List<BankOffers> specialOffers() {

		return bankOffersRepository.specialOffers();
	}

	@Override
	public List<BankOffers> retrieveAscRate() {

		return bankOffersRepository.retrieveAscRate();
	}

	@Override
	public List<BankOffers> retrieveDescRate() {

		return bankOffersRepository.retrieveDescRate();
	}

	@Override
	public List<BankOffers> retrieveDescInsurance() {

		return bankOffersRepository.retrieveDescInsurance();
	}

	@Override
	public List<BankOffers> retrieveASCInsurance() {

		return bankOffersRepository.retrieveASCInsurance();
	}

}
