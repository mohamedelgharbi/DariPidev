package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Bank;
import tn.esprit.spring.entity.BankOffers;
import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.LoanSimulation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.BankOffersRepository;
import tn.esprit.spring.repository.LoanSimulationRepository;

//@Scope(value = "session")
@Controller(value = "stocksimulationController")
@ELBeanName(value = "stocksimulationController")
// @Join(path = "/", to = "/")
public class StockData3 {
	@Autowired
	LoanSimulationRepository loanSimulationRepository;
	@Autowired
	ILoanSimulationService iLoanSimulationService;
	@Autowired
	BankOffersRepository bankOffersRepository;

	private int id;
	private Integer amount;
	private Integer duration;
	Category category;
	private float salaire_net;
	private float personal_contribution;
	private Date simulation_date;
	private float additional_fees;
	private float total_insurance;
	private float interest_rate;
	private float net_amount_borrowed;
	private Double monthly_payment;
	private Double total_monthly_payment;
	private float insurance_per_month;
	private Double taeg;
	private Double taeg_insurance;
	private Double taea;
	private Double total_paid;
	private Double total_interest_paid;
	private String result;

	private BankOffers bankOffer;
	private User user;
	private Bank bank;
	private List<LoanSimulation> loanSimulations;
	private String name_bankoffer;
	private String name_bank;
	private int id_bo;
	private int id_currentuser;

	public String getName_bank() {
		name_bank = loanSimulationRepository.findById(id).get().getBankOffers().getBank().getName_bank();
		return name_bank;
	}

	public void setName_bank(String name_bank) {
		this.name_bank = name_bank;
	}

	public int getId_bo() {
		id_bo = loanSimulationRepository.findById(id).get().getBankOffers().getId_bo();
		return id_bo;
	}

	public void setId_bo(int id_bo) {
		this.id_bo = id_bo;
	}

	public int getId_currentuser() {
		return id_currentuser;
	}

	public void setId_currentuser(int id_currentuser) {
		this.id_currentuser = id_currentuser;
	}

	public String getName_bankoffer() {
		name_bankoffer = loanSimulationRepository.findById(id).get().getBankOffers().getName_bankoffer();
		return name_bankoffer;
	}

	public void setName_bankoffer(String name_bankoffer) {
		this.name_bankoffer = name_bankoffer;
	}

	public LoanSimulationRepository getLoanSimulationRepository() {
		return loanSimulationRepository;
	}

	public void setLoanSimulationRepository(LoanSimulationRepository loanSimulationRepository) {
		this.loanSimulationRepository = loanSimulationRepository;
	}

	public int getId() {
		id = loanSimulationRepository.findById(id).get().getId_loan();
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getAmount() {
		amount = loanSimulationRepository.findById(id).get().getAmount();
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getDuration() {
		duration = loanSimulationRepository.findById(id).get().getDuration();
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Category getCategory() {
		category = loanSimulationRepository.findById(id).get().getCategory();
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float getSalaire_net() {
		salaire_net = loanSimulationRepository.findById(id).get().getSalaire_net();
		return salaire_net;
	}

	public void setSalaire_net(float salaire_net) {
		this.salaire_net = salaire_net;
	}

	public float getPersonal_contribution() {
		personal_contribution = loanSimulationRepository.findById(id).get().getPersonal_contribution();
		return personal_contribution;
	}

	public void setPersonal_contribution(float personal_contribution) {
		this.personal_contribution = personal_contribution;
	}

	public Date getSimulation_date() {
		simulation_date = loanSimulationRepository.findById(id).get().getSimulation_date();
		return simulation_date;
	}

	public void setSimulation_date(Date simulation_date) {
		this.simulation_date = simulation_date;
	}

	public float getAdditional_fees() {
		additional_fees = loanSimulationRepository.findById(id).get().getAdditional_fees();
		return additional_fees;
	}

	public void setAdditional_fees(float additional_fees) {
		this.additional_fees = additional_fees;
	}

	public float getTotal_insurance() {
		total_insurance = loanSimulationRepository.findById(id).get().getTotal_insurance();
		return total_insurance;
	}

	public void setTotal_insurance(float total_insurance) {
		this.total_insurance = total_insurance;
	}

	public float getInterest_rate() {
		interest_rate = loanSimulationRepository.findById(id).get().getInterest_rate();
		return interest_rate;
	}

	public void setInterest_rate(float interest_rate) {
		this.interest_rate = interest_rate;
	}

	public float getNet_amount_borrowed() {
		net_amount_borrowed = loanSimulationRepository.findById(id).get().getNet_amount_borrowed();
		return net_amount_borrowed;
	}

	public void setNet_amount_borrowed(float net_amount_borrowed) {
		this.net_amount_borrowed = net_amount_borrowed;
	}

	public Double getMonthly_payment() {
		monthly_payment = loanSimulationRepository.findById(id).get().getMonthly_payment();
		return monthly_payment;
	}

	public void setMonthly_payment(Double monthly_payment) {
		this.monthly_payment = monthly_payment;
	}

	public float getInsurance_per_month() {
		insurance_per_month = loanSimulationRepository.findById(id).get().getInsurance_per_month();
		return insurance_per_month;
	}

	public void setInsurance_per_month(float insurance_per_month) {
		this.insurance_per_month = insurance_per_month;
	}

	public Double getTotal_monthly_payment() {
		total_monthly_payment = loanSimulationRepository.findById(id).get().getTotal_monthly_payment();
		return total_monthly_payment;
	}

	public void setTotal_monthly_payment(Double total_monthly_payment) {
		this.total_monthly_payment = total_monthly_payment;
	}

	public Double getTaeg() {
		taeg = loanSimulationRepository.findById(id).get().getTaeg();
		return taeg;
	}

	public void setTaeg(Double taeg) {
		this.taeg = taeg;
	}

	public Double getTaeg_insurance() {
		taeg_insurance = loanSimulationRepository.findById(id).get().getTaeg_insurance();
		return taeg_insurance;
	}

	public void setTaeg_insurance(Double taeg_insurance) {
		this.taeg_insurance = taeg_insurance;
	}

	public Double getTaea() {
		taea = loanSimulationRepository.findById(id).get().getTaea();
		return taea;
	}

	public void setTaea(Double taea) {
		this.taea = taea;
	}

	public Double getTotal_paid() {
		total_paid = loanSimulationRepository.findById(id).get().getTotal_paid();
		return total_paid;
	}

	public void setTotal_paid(Double total_paid) {
		this.total_paid = total_paid;
	}

	public Double getTotal_interest_paid() {
		total_interest_paid = loanSimulationRepository.findById(id).get().getTotal_interest_paid();
		return total_interest_paid;
	}

	public void setTotal_interest_paid(Double total_interest_paid) {
		this.total_interest_paid = total_interest_paid;
	}

	public String getResult() {
		result = loanSimulationRepository.findById(id).get().getResult();
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public BankOffers getBankOffer() {
		bankOffer = loanSimulationRepository.findById(id).get().getBankOffers();
		return bankOffer;
	}

	public void setBankOffer(BankOffers bankOffer) {
		this.bankOffer = bankOffer;
	}

	public User getUser() {
		user = loanSimulationRepository.findById(id).get().getUser();
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<LoanSimulation> getLoanSimulations() {
		return loanSimulations;
	}

	public void setLoanSimulations(List<LoanSimulation> loanSimulations) {
		this.loanSimulations = loanSimulations;
	}

	public String showsimulationDetails(int simulationID) {
		id = simulationID;
		System.out.println(" ID Simulation :" + id);
		iLoanSimulationService.Simulate_Loan(simulationID);
		return "/SimulationsDetails.xhtml?faces-redirect=true";

	}

	public String removeSimulation(int simulationID) {
		id = simulationID;
		iLoanSimulationService.deleteLoanSimulationByID(simulationID);
		System.out.println("simulation Deleted");
		return "/DeleteSimulations.xhtml?faces-redirect=true";
	}

}
