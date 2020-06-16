package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BankOffers")
public class BankOffers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id_bo")
	private int id_bo;
	// @NotNull(message = "Name is compulsory")
	// @Column(name = "name_bankoffer", nullable = false)
	private String name_bankoffer;
	// @Column(name = "description_offer", nullable = true)
	private String description_offer;
	@Temporal(TemporalType.DATE)
	private Date start_date;
	@Temporal(TemporalType.DATE)
	private Date end_date;
	// ---------------------------------------Obligatoire pour faire les calculs
	// --------------------------------
	@Enumerated(EnumType.STRING)
	InterestType interestType; // Type d'intérêt (Fixe / Variable)
	// @NotNull(message = "Additional fees is compulsory")
	// @Column(name = "additional_fees", nullable = false) // Frais dossier

	private float additional_fees;

	// @NotNull(message = "Total Insurance is compulsory")
	// @Column(name = "total_insurance", nullable = false) // Montant total
	// d'assurance
	private float total_insurance;

	// @NotNull(message = "Interest Rate is compulsory")
	// @Column(name = "interest_rate", nullable = false) // Taux d'intérêt
	// mensuel
	private float interest_rate;

	private String rate_bankoffer;
	private String img;
	private int special;
	// -----------------------------------------------------------------------------------------------------------

	@ManyToOne
	Bank bank;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bankOffers")
	private Set<LoanSimulation> LoanSimulations;

	public BankOffers() {
		super();
	}

	public BankOffers(int id_bo, String name_bankoffer, String description_offer, Date start_date, Date end_date,
			InterestType interestType, float additional_fees, float total_insurance, float interest_rate,
			String rate_bankoffer, String img, int special, Bank bank, Set<LoanSimulation> loanSimulations) {
		super();
		this.id_bo = id_bo;
		this.name_bankoffer = name_bankoffer;
		this.description_offer = description_offer;
		this.start_date = start_date;
		this.end_date = end_date;
		this.interestType = interestType;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.rate_bankoffer = rate_bankoffer;
		this.img = img;
		this.special = special;
		this.bank = bank;
		LoanSimulations = loanSimulations;
	}

	public BankOffers(String name_bankoffer, String description_offer, Date start_date, Date end_date,
			InterestType interestType, float additional_fees, float total_insurance, float interest_rate,
			String rate_bankoffer, String img, int special, Bank bank, Set<LoanSimulation> loanSimulations) {
		super();
		this.name_bankoffer = name_bankoffer;
		this.description_offer = description_offer;
		this.start_date = start_date;
		this.end_date = end_date;
		this.interestType = interestType;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.rate_bankoffer = rate_bankoffer;
		this.img = img;
		this.special = special;
		this.bank = bank;
		LoanSimulations = loanSimulations;
	}

	public BankOffers(int id_bo, String name_bankoffer, String description_offer, Date start_date, Date end_date,
			InterestType interestType, float additional_fees, float total_insurance, float interest_rate,
			String rate_bankoffer, Bank bank) {
		super();
		this.id_bo = id_bo;
		this.name_bankoffer = name_bankoffer;
		this.description_offer = description_offer;
		this.start_date = start_date;
		this.end_date = end_date;
		this.interestType = interestType;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.rate_bankoffer = rate_bankoffer;
		this.bank = bank;
	}

	public BankOffers(int id_bo, String name_bankoffer, String description_offer, Date start_date, Date end_date,
			InterestType interestType, float additional_fees, float total_insurance, float interest_rate,
			String rate_bankoffer, Bank bank, Set<LoanSimulation> loanSimulations) {
		super();
		this.id_bo = id_bo;
		this.name_bankoffer = name_bankoffer;
		this.description_offer = description_offer;
		this.start_date = start_date;
		this.end_date = end_date;
		this.interestType = interestType;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.rate_bankoffer = rate_bankoffer;
		this.bank = bank;
		LoanSimulations = loanSimulations;
	}

	public BankOffers(String name_bankoffer, String description_offer, Date start_date, Date end_date,
			InterestType interestType, float additional_fees, float total_insurance, float interest_rate,
			String rate_bankoffer, Bank bank, Set<LoanSimulation> loanSimulations) {
		super();
		this.name_bankoffer = name_bankoffer;
		this.description_offer = description_offer;
		this.start_date = start_date;
		this.end_date = end_date;
		this.interestType = interestType;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.rate_bankoffer = rate_bankoffer;
		this.bank = bank;
		LoanSimulations = loanSimulations;
	}

	public BankOffers(int id_bo, String name_bankoffer, String description_offer, Date start_date, Date end_date,
			InterestType interestType, float additional_fees, float total_insurance, float interest_rate,
			String rate_bankoffer) {
		super();
		this.id_bo = id_bo;
		this.name_bankoffer = name_bankoffer;
		this.description_offer = description_offer;
		this.start_date = start_date;
		this.end_date = end_date;
		this.interestType = interestType;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.rate_bankoffer = rate_bankoffer;
	}

	public BankOffers(String name_bankoffer, String description_offer, Date start_date, Date end_date,
			InterestType interestType, float additional_fees, float total_insurance, float interest_rate,
			String rate_bankoffer) {
		super();
		this.name_bankoffer = name_bankoffer;
		this.description_offer = description_offer;
		this.start_date = start_date;
		this.end_date = end_date;
		this.interestType = interestType;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.rate_bankoffer = rate_bankoffer;
	}

	public BankOffers(String name_bankoffer, String description_offer, Date start_date, Date end_date,
			InterestType interestType, float additional_fees, float total_insurance, float interest_rate,
			String rate_bankoffer, Bank bank) {
		super();
		this.name_bankoffer = name_bankoffer;
		this.description_offer = description_offer;
		this.start_date = start_date;
		this.end_date = end_date;
		this.interestType = interestType;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.rate_bankoffer = rate_bankoffer;
		this.bank = bank;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getSpecial() {
		return special;
	}

	public void setSpecial(int special) {
		this.special = special;
	}

	public int getId_bo() {
		return id_bo;
	}

	public void setId_bo(int id_bo) {
		this.id_bo = id_bo;
	}

	public String getName_bankoffer() {
		return name_bankoffer;
	}

	public void setName_bankoffer(String name_bankoffer) {
		this.name_bankoffer = name_bankoffer;
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

	public String getRate_bankoffer() {
		return rate_bankoffer;
	}

	public void setRate_bankoffer(String rate_bankoffer) {
		this.rate_bankoffer = rate_bankoffer;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Set<LoanSimulation> getLoanSimulations() {
		return LoanSimulations;
	}

	public void setLoanSimulations(Set<LoanSimulation> loanSimulations) {
		LoanSimulations = loanSimulations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BankOffers [id_bo=" + id_bo + ", name_bankoffer=" + name_bankoffer + ", description_offer="
				+ description_offer + ", start_date=" + start_date + ", end_date=" + end_date + ", interestType="
				+ interestType + ", additional_fees=" + additional_fees + ", total_insurance=" + total_insurance
				+ ", interest_rate=" + interest_rate + ", rate_bankoffer=" + rate_bankoffer + ", bank=" + bank
				+ ", LoanSimulations=" + LoanSimulations + "]";
	}

}