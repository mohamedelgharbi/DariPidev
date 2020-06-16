package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.BankOffers;
import tn.esprit.spring.entities.InterestType;

import tn.esprit.spring.repositories.BankOffersRepository;
import tn.esprit.spring.repositories.BankRepository;
import tn.esprit.spring.services.IBankOffersService;
import tn.esprit.spring.services.IBankService;

@Scope(value = "session")
@Controller(value = "bankOfferController")
@ELBeanName(value = "bankOfferController")
// @Join(path = "/", to = "/")
public class BankOffersController {
	@Autowired
	IBankOffersService iBankOffersService;
	@Autowired
	BankOffersRepository bankOffersRepository;
	@Autowired
	BankRepository bankRepository;
	@Autowired
	IBankService iBankService;

	public int addBankOffer(BankOffers bankOffers) {
		iBankOffersService.addBankOffer(bankOffers);
		return bankOffers.getId_bo();

	}

	public void deleteBankOfferByID(int bankOfferID) {
		iBankOffersService.deleteBankOfferByID(bankOfferID);
	}

	public void affectBankToBankOffer(int bankID, int bankOfferID) {
		iBankOffersService.affectBankToBankOffer(bankID, bankOfferID);

	}

	public void updateBankOfferNameByID(String bankOfferName, int bankOfferID) {
		iBankOffersService.updateBankOfferNameByID(bankOfferName, bankOfferID);
	}

	public void updateBankOfferDescriptionByID(String description, int bankOfferID) {
		iBankOffersService.updateBankOfferDescriptionByID(description, bankOfferID);
	}

	public List<BankOffers> getAllBankOffers() {
		return iBankOffersService.getAllBankOffers();
	}

	public List<String> getAllBankOffersNamesByBank(int bankID) {
		return iBankOffersService.getAllBankOffersNamesByBank(bankID);
	}

	public String getBankOfferNameByBankOfferID(int bankOfferID) {
		return iBankOffersService.getBankOfferNameByBankOfferID(bankOfferID);

	}

	public int getBankOffersNumberJPQL() {
		return iBankOffersService.getBankOffersNumberJPQL();
	}

	public List<String> getAllBankOffersNamesJPQL() {
		return iBankOffersService.getAllBankOffersNamesJPQL();
	}

	public void deleteAllBankOffersJPQL() {
		iBankOffersService.deleteAllBankOffersJPQL();
	}

	// ----------------------------------JSF-----------------------------------------------------------------------

	private int id_bo;
	private String name_bankoffer;
	private String description_offer;
	private Date start_date;
	private Date end_date;
	InterestType interestType;
	private float additional_fees;
	private float total_insurance;
	private float interest_rate;
	private String rate_bankoffer;
	private Bank bank;
	private int id_bank;
	private BankOffers bankOffer;
	private BankOffers bankOfferSpecial;
	private List<BankOffers> bankOffers;
	private Integer BankOfferToBeUpdated;
	private List<Bank> banks;

	public BankOffers getBankOfferSpecial() {
		return bankOfferSpecial;
	}

	public void setBankOfferSpecial(BankOffers bankOfferSpecial) {
		this.bankOfferSpecial = bankOfferSpecial;
	}

	public IBankOffersService getiBankOffersService() {
		return iBankOffersService;
	}

	public void setiBankOffersService(IBankOffersService iBankOffersService) {
		this.iBankOffersService = iBankOffersService;
	}

	public int getId_bo() {
		return id_bo;
	}

	public void setId_bo(int id_bo) {
		this.id_bo = id_bo;
	}

	public String getDescription_offer() {
		return description_offer;
	}

	public void setDescription_offer(String description_offer) {
		this.description_offer = description_offer;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public InterestType getInterestType() {
		return interestType;
	}

	public void setInterestType(InterestType interestType) {
		this.interestType = interestType;
	}

	public float getAdditional_fees() {
		return additional_fees;
	}

	public void setAdditional_fees(float additional_fees) {
		this.additional_fees = additional_fees;
	}

	public float getTotal_insurance() {
		return total_insurance;
	}

	public void setTotal_insurance(float total_insurance) {
		this.total_insurance = total_insurance;
	}

	public float getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(float interest_rate) {
		this.interest_rate = interest_rate;
	}

	public BankOffers getBankOffer() {
		return bankOffer;
	}

	public void setBankOffer(BankOffers bankOffer) {
		this.bankOffer = bankOffer;
	}

	public List<BankOffers> getBankOffers() {
		bankOffers = iBankOffersService.getAllBankOffers();
		return bankOffers;
	}

	public void setBankOffers(List<BankOffers> bankOffers) {
		this.bankOffers = bankOffers;
	}

	public Integer getBankOfferToBeUpdated() {
		return BankOfferToBeUpdated;
	}

	public void setBankOfferToBeUpdated(Integer bankOfferToBeUpdated) {
		BankOfferToBeUpdated = bankOfferToBeUpdated;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getName_bankoffer() {
		return name_bankoffer;
	}

	public void setName_bankoffer(String name_bankoffer) {
		this.name_bankoffer = name_bankoffer;
	}

	public String getRate_bankoffer() {
		return rate_bankoffer;
	}

	public void setRate_bankoffer(String rate_bankoffer) {
		this.rate_bankoffer = rate_bankoffer;
	}

	public List<Bank> getBanks() {
		banks = iBankService.getAllBanks();
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public int getId_bank() {
		return id_bank;
	}

	public void setId_bank(int id_bank) {
		this.id_bank = id_bank;
	}

	public String addBankOffer() {
		Bank chosenbank = bankRepository.findById(id_bank).get();
		iBankOffersService.addOrUpdateBankOffer(new BankOffers(name_bankoffer, description_offer, start_date, end_date,
				interestType, additional_fees, total_insurance, interest_rate, rate_bankoffer, chosenbank));

		return "/BankOfferList.xhtml";
	}

	public void removeBankOffer(int bankOfferId) {

		iBankOffersService.deleteBankOfferByID(bankOfferId);
	}

	public InterestType[] getInterestTypes() {
		return InterestType.values();
	}

	public void displayBankOffer(BankOffers bkoffer) {
		this.setName_bankoffer(bkoffer.getName_bankoffer());
		this.setDescription_offer(bkoffer.getDescription_offer());
		this.setStart_date(bkoffer.getStart_date());
		this.setEnd_date(bkoffer.getEnd_date());
		this.setInterestType(bkoffer.getInterestType());
		this.setAdditional_fees(bkoffer.getAdditional_fees());
		this.setTotal_insurance(bkoffer.getTotal_insurance());
		this.setInterest_rate(bkoffer.getInterest_rate());

	}

	public void updateBankOffer() {

		iBankOffersService.addBankOffer(new BankOffers(BankOfferToBeUpdated, name_bankoffer, description_offer,
				start_date, end_date, interestType, additional_fees, total_insurance, interest_rate, rate_bankoffer));

	}

	// ------------------------------------------Filtrage
	// -----------------------------------------
	private List<BankOffers> offersSpecial;
	private List<BankOffers> offersRateASC;
	private List<BankOffers> offersRateDESC;
	private List<BankOffers> offersInsuranceASC;
	private List<BankOffers> offersInsuranceDESC;

	
	public List<BankOffers> getOffersSpecial() {
		offersSpecial = iBankOffersService.specialOffers();
		return offersSpecial;
	}

	public void setOffersSpecial(List<BankOffers> offersSpecial) {
		this.offersSpecial = offersSpecial;
	}

	public List<BankOffers> getOffersRateASC() {
		offersRateASC = iBankOffersService.retrieveAscRate();
		return offersRateASC;
	}

	public void setOffersRateASC(List<BankOffers> offersRateASC) {
		this.offersRateASC = offersRateASC;
	}

	public List<BankOffers> getOffersRateDESC() {
		offersRateDESC =iBankOffersService.retrieveDescRate();
		return offersRateDESC;
	}

	public void setOffersRateDESC(List<BankOffers> offersRateDESC) {
		this.offersRateDESC = offersRateDESC;
	}

	public List<BankOffers> getOffersInsuranceASC() {
		offersInsuranceASC =iBankOffersService.retrieveASCInsurance();
		return offersInsuranceASC;
	}

	public void setOffersInsuranceASC(List<BankOffers> offersInsuranceASC) {
		this.offersInsuranceASC = offersInsuranceASC;
	}

	public List<BankOffers> getOffersInsuranceDESC() {
		offersInsuranceDESC = iBankOffersService.retrieveDescInsurance();
		return offersInsuranceDESC;
	}

	public void setOffersInsuranceDESC(List<BankOffers> offersInsuranceDESC) {
		this.offersInsuranceDESC = offersInsuranceDESC;
	}

}
