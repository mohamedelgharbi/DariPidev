package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.BankOffers;

public interface IBankOffersService {

	public int addBankOffer(BankOffers bankOffers);

	public void deleteBankOfferByID(int bankOfferID);

	public void affectBankToBankOffer(int bankID, int bankOfferID);

	public void updateBankOfferNameByID(String bankOfferName, int bankOfferID);

	public void updateBankOfferDescriptionByID(String description, int bankOfferID);

	public List<BankOffers> getAllBankOffers();

	public List<String> getAllBankOffersNamesByBank(int bankID);

	public String getBankOfferNameByBankOfferID(int bankOfferID);

	public int getBankOffersNumberJPQL();

	public List<String> getAllBankOffersNamesJPQL();

	public void deleteAllBankOffersJPQL();

	public int addOrUpdateBankOffer(BankOffers bankOffer);

	public BankOffers getBankOfferByID(int bankOfferID);

	public void specialOffer();

	List<BankOffers> specialOffers();

	List<BankOffers> retrieveAscRate();

	List<BankOffers> retrieveDescRate();

	List<BankOffers> retrieveDescInsurance();

	List<BankOffers> retrieveASCInsurance();

}
