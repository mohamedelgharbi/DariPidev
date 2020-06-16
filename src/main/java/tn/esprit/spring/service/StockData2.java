package tn.esprit.spring.service;

import java.util.Date;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.BankOffers;
import tn.esprit.spring.entities.InterestType;
import tn.esprit.spring.repositories.BankOffersRepository;

//@Scope(value = "session")
@Controller(value = "stockofferController")
@ELBeanName(value = "stockofferController")
// @Join(path = "/", to = "/")
public class StockData2 {
	@Autowired
	BankOffersRepository bankOffersRepository;
	@Autowired
	IBankOffersService iBankOffersService;

	private int id;
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
	private String name_bank;

	public int getId() {
		id = bankOffersRepository.findById(id).get().getId_bo();
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_bankoffer() {
		name_bankoffer = bankOffersRepository.findById(id).get().getName_bankoffer();
		return name_bankoffer;
	}

	public void setName_bankoffer(String name_bankoffer) {
		this.name_bankoffer = name_bankoffer;
	}

	public String getDescription_offer() {
		description_offer = bankOffersRepository.findById(id).get().getDescription_offer();
		return description_offer;
	}

	public void setDescription_offer(String description_offer) {
		this.description_offer = description_offer;
	}

	public Date getStart_date() {
		start_date = bankOffersRepository.findById(id).get().getStart_date();
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		end_date = bankOffersRepository.findById(id).get().getEnd_date();
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public InterestType getInterestType() {
		interestType = bankOffersRepository.findById(id).get().getInterestType();
		return interestType;
	}

	public void setInterestType(InterestType interestType) {
		this.interestType = interestType;
	}

	public float getAdditional_fees() {
		additional_fees = bankOffersRepository.findById(id).get().getAdditional_fees();
		return additional_fees;
	}

	public void setAdditional_fees(float additional_fees) {
		this.additional_fees = additional_fees;
	}

	public float getTotal_insurance() {
		total_insurance = bankOffersRepository.findById(id).get().getTotal_insurance();
		return total_insurance;
	}

	public void setTotal_insurance(float total_insurance) {
		this.total_insurance = total_insurance;
	}

	public float getInterest_rate() {
		interest_rate = bankOffersRepository.findById(id).get().getInterest_rate();
		return interest_rate;
	}

	public void setInterest_rate(float interest_rate) {
		this.interest_rate = interest_rate;
	}

	public String getRate_bankoffer() {
		rate_bankoffer = bankOffersRepository.findById(id).get().getRate_bankoffer();
		return rate_bankoffer;
	}

	public void setRate_bankoffer(String rate_bankoffer) {
		this.rate_bankoffer = rate_bankoffer;
	}

	public Bank getBank() {
		bank = bankOffersRepository.findById(id).get().getBank();
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getName_bank() {
		name_bank = bankOffersRepository.findById(id).get().getBank().getName_bank();
		return name_bank;
	}

	public void setName_bank(String name_bank) {
		this.name_bank = name_bank;
	}

	public String showBankOfferDetails(int bankOfferID) {
		id = bankOfferID;

		System.out.println(" ID Bank Offer :" + id);
		return "/BankOffersDetails.xhtml?faces-redirect=true";

	}

	public String showBankOfferDetailscc(int bankOfferID) {
		id = bankOfferID;
		System.out.println(" ID Bank Offer :" + id);
		return "/BankOffersDetailsClient.xhtml?faces-redirect=true";

	}

	public String removeBankOffer(int bankOfferID) {
		id = bankOfferID;
		iBankOffersService.deleteBankOfferByID(bankOfferID);
		System.out.println("Bank Offer Deleted");
		return "/DeleteBankOffer.xhtml?faces-redirect=true";
	}

	public String showBankOfferToUpdate(int bankOfferID) {
		id = bankOfferID;
		System.out.println("ID Bank Offer To Update:" + id);
		return "/BankOfferToUpdate.xhtml?faces-redirect=true";
	}

	public String updateBankOffer() {

		iBankOffersService.addOrUpdateBankOffer(new BankOffers(id, name_bankoffer, description_offer, start_date,
				end_date, interestType, additional_fees, total_insurance, interest_rate, rate_bankoffer));
		return "/UpdateBankOffer.xhtml?faces-redirect=true";
	}

	public InterestType[] getInterestTypes() {
		return InterestType.values();
	}

}
