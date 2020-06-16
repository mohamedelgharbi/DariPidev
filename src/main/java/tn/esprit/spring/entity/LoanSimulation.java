package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LoanSimulation")
public class LoanSimulation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_loan")
	private int id_loan;

	// @NotNull(message = "Amount is compulsory")
	// @Column(name = "amount", nullable = false)
	private Integer amount; // Montant du crédit banquaire

	// @NotNull(message = "Duration is compulsory")
	// @Column(name = "duration", nullable = false)
	private Integer duration;// Durée de remboursement

	@Enumerated(EnumType.STRING)
	Category category; // (House,Apartment,Land,LocalCommercial)

	// @Column(name = "salaire_net", nullable = true) // Salaire_Net
	private float salaire_net;

	// @Column(name = "personal_contribution", nullable = true) // Apport
	// Personnel
	private float personal_contribution;

	@Temporal(TemporalType.DATE) // Date de simulation
	private Date simulation_date;
	// --------------------------------------------simulation Libre
	// ----------------------------
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

	////////////////// NULL/////////////////////////////////////////////////////
	// Montant net emprunté..

	// @Column(name = "net_amount_borrowed", nullable = true)
	// @Formula(value = "Amount - Additional_Fees")
	private float net_amount_borrowed;

	// Mensualité (paiment)

	// @Column(name = "monthly_payment", nullable = true)
	// @Formula(value =
	// "(Amount*(Interest_Rate/12))/POWER(1-(1+Interest_Rate/12),-12*Duration)")
	private Double monthly_payment;

	private Double total_monthly_payment;

	// Asuarnce obligatoire par mois

	// @Column(name = "insurance_per_month", nullable = true)
	// @Formula(value = "Total_Insurance/Duration")
	private float insurance_per_month;

	// Le taux annuel effectif global
	// @Column(name = "taeg", nullable = true)
	private Double taeg;

	private Double taeg_insurance;

	// Le taux annuel effectif d'assurance (TAEA)
	// @Column(name = "taea", nullable = true)
	private Double taea;

	// Total versé (Cout total du crédit)
	// @Column(name = "total_paid", nullable = true)
	// @Formula(value = "")
	private Double total_paid;

	// Total interet versé
	// @Column(name = "total_interest_paid", nullable = true)
	// @Formula(value = "12*Duration*Monthly_Payment-Amount")
	private Double total_interest_paid;
	
	private String result;

	// ---------------------------------------------------------------------------------------------

	@ManyToOne
	BankOffers bankOffers;
	@ManyToOne
	User user;

	// ----------------------------------------------------------------------------------------------
	public LoanSimulation() {
		super();
	}

	
	
	
	public LoanSimulation(Integer amount, Integer duration, Category category, float salaire_net,
			float personal_contribution, BankOffers bankOffers, User user) {
		super();
		this.amount = amount;
		this.duration = duration;
		this.category = category;
		this.salaire_net = salaire_net;
		this.personal_contribution = personal_contribution;
		this.bankOffers = bankOffers;
		this.user = user;
	}




	public LoanSimulation(int id_loan, Integer amount, Integer duration, Category category, float salaire_net,
			float personal_contribution, float additional_fees, float total_insurance, float interest_rate, User user) {
		super();
		this.id_loan = id_loan;
		this.amount = amount;
		this.duration = duration;
		this.category = category;
		this.salaire_net = salaire_net;
		this.personal_contribution = personal_contribution;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.user = user;
	}




	public LoanSimulation(Integer amount, Integer duration, Category category, float salaire_net,
			float personal_contribution, float additional_fees, float total_insurance, float interest_rate, User user) {
		super();
		this.amount = amount;
		this.duration = duration;
		this.category = category;
		this.salaire_net = salaire_net;
		this.personal_contribution = personal_contribution;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.user = user;
	}




	public LoanSimulation(int id_loan, Integer amount, Integer duration, Category category, float salaire_net,
			float personal_contribution, Date simulation_date, float additional_fees, float total_insurance,
			float interest_rate, float net_amount_borrowed, Double monthly_payment, Double total_monthly_payment,
			float insurance_per_month, Double taeg, Double taeg_insurance, Double taea, Double total_paid,
			Double total_interest_paid, String result, BankOffers bankOffers, User user) {
		super();
		this.id_loan = id_loan;
		this.amount = amount;
		this.duration = duration;
		this.category = category;
		this.salaire_net = salaire_net;
		this.personal_contribution = personal_contribution;
		this.simulation_date = simulation_date;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.net_amount_borrowed = net_amount_borrowed;
		this.monthly_payment = monthly_payment;
		this.total_monthly_payment = total_monthly_payment;
		this.insurance_per_month = insurance_per_month;
		this.taeg = taeg;
		this.taeg_insurance = taeg_insurance;
		this.taea = taea;
		this.total_paid = total_paid;
		this.total_interest_paid = total_interest_paid;
		this.result = result;
		this.bankOffers = bankOffers;
		this.user = user;
	}




	public LoanSimulation(Integer amount, Integer duration, Category category, float salaire_net,
			float personal_contribution, Date simulation_date, float additional_fees, float total_insurance,
			float interest_rate, float net_amount_borrowed, Double monthly_payment, Double total_monthly_payment,
			float insurance_per_month, Double taeg, Double taeg_insurance, Double taea, Double total_paid,
			Double total_interest_paid, String result, BankOffers bankOffers, User user) {
		super();
		this.amount = amount;
		this.duration = duration;
		this.category = category;
		this.salaire_net = salaire_net;
		this.personal_contribution = personal_contribution;
		this.simulation_date = simulation_date;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.net_amount_borrowed = net_amount_borrowed;
		this.monthly_payment = monthly_payment;
		this.total_monthly_payment = total_monthly_payment;
		this.insurance_per_month = insurance_per_month;
		this.taeg = taeg;
		this.taeg_insurance = taeg_insurance;
		this.taea = taea;
		this.total_paid = total_paid;
		this.total_interest_paid = total_interest_paid;
		this.result = result;
		this.bankOffers = bankOffers;
		this.user = user;
	}




	public LoanSimulation(int id_loan, Integer amount, Integer duration, Category category, float salaire_net,
			float personal_contribution, float additional_fees, float total_insurance, float interest_rate,
			BankOffers bankOffers, User user) {
		super();
		this.id_loan = id_loan;
		this.amount = amount;
		this.duration = duration;
		this.category = category;
		this.salaire_net = salaire_net;
		this.personal_contribution = personal_contribution;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.bankOffers = bankOffers;
		this.user = user;
	}

	public LoanSimulation(Integer amount, Integer duration, Category category, float salaire_net,
			float personal_contribution, float additional_fees, float total_insurance, float interest_rate,
			BankOffers bankOffers, User user) {
		super();
		this.amount = amount;
		this.duration = duration;
		this.category = category;
		this.salaire_net = salaire_net;
		this.personal_contribution = personal_contribution;
		this.additional_fees = additional_fees;
		this.total_insurance = total_insurance;
		this.interest_rate = interest_rate;
		this.bankOffers = bankOffers;
		this.user = user;
	}

	public int getId_loan() {
		return id_loan;
	}

	public void setId_loan(int id_loan) {
		this.id_loan = id_loan;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float getSalaire_net() {
		return salaire_net;
	}

	public void setSalaire_net(float salaire_net) {
		this.salaire_net = salaire_net;
	}

	public float getPersonal_contribution() {
		return personal_contribution;
	}

	public void setPersonal_contribution(float personal_contribution) {
		this.personal_contribution = personal_contribution;
	}

	public Date getSimulation_date() {
		return simulation_date;
	}

	public void setSimulation_date(Date simulation_date) {
		this.simulation_date = simulation_date;
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

	public float getNet_amount_borrowed() {
		return net_amount_borrowed;
	}

	public void setNet_amount_borrowed(float net_amount_borrowed) {
		this.net_amount_borrowed = net_amount_borrowed;
	}

	public Double getMonthly_payment() {
		return monthly_payment;
	}

	public void setMonthly_payment(Double monthly_payment) {
		this.monthly_payment = monthly_payment;
	}

	public Double getTotal_monthly_payment() {
		return total_monthly_payment;
	}

	public void setTotal_monthly_payment(Double total_monthly_payment) {
		this.total_monthly_payment = total_monthly_payment;
	}

	public float getInsurance_per_month() {
		return insurance_per_month;
	}

	public void setInsurance_per_month(float insurance_per_month) {
		this.insurance_per_month = insurance_per_month;
	}

	public Double getTaeg() {
		return taeg;
	}

	public void setTaeg(Double taeg) {
		this.taeg = taeg;
	}

	public Double getTaeg_insurance() {
		return taeg_insurance;
	}

	public void setTaeg_insurance(Double taeg_insurance) {
		this.taeg_insurance = taeg_insurance;
	}

	public Double getTaea() {
		return taea;
	}

	public void setTaea(Double taea) {
		this.taea = taea;
	}

	public Double getTotal_paid() {
		return total_paid;
	}

	public void setTotal_paid(Double total_paid) {
		this.total_paid = total_paid;
	}

	public Double getTotal_interest_paid() {
		return total_interest_paid;
	}

	public void setTotal_interest_paid(Double total_interest_paid) {
		this.total_interest_paid = total_interest_paid;
	}

	public BankOffers getBankOffers() {
		return bankOffers;
	}

	public void setBankOffers(BankOffers bankOffers) {
		this.bankOffers = bankOffers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getResult() {
		return result;
	}




	public void setResult(String result) {
		this.result = result;
	}




	@Override
	public String toString() {
		return "LoanSimulation [id_loan=" + id_loan + ", amount=" + amount + ", duration=" + duration + ", category="
				+ category + ", salaire_net=" + salaire_net + ", personal_contribution=" + personal_contribution
				+ ", simulation_date=" + simulation_date + ", additional_fees=" + additional_fees + ", total_insurance="
				+ total_insurance + ", interest_rate=" + interest_rate + ", net_amount_borrowed=" + net_amount_borrowed
				+ ", monthly_payment=" + monthly_payment + ", total_monthly_payment=" + total_monthly_payment
				+ ", insurance_per_month=" + insurance_per_month + ", taeg=" + taeg + ", taeg_insurance="
				+ taeg_insurance + ", taea=" + taea + ", total_paid=" + total_paid + ", total_interest_paid="
				+ total_interest_paid + ", bankOffers=" + bankOffers + ", user=" + user + "]";
	}

}
