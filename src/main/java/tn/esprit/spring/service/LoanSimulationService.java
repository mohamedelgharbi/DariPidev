package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import tn.esprit.spring.entity.BankOffers;
import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.LoanSimulation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.BankOffersRepository;
import tn.esprit.spring.repository.LoanSimulationRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class LoanSimulationService implements ILoanSimulationService {
	@Autowired
	LoanSimulationRepository loanSimulationRepository;
	@Autowired
	BankOffersRepository bankOffersRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public int addLoanSimulation(LoanSimulation loanSimulation) {

		loanSimulation.setSimulation_date(new Date(System.currentTimeMillis()));
		loanSimulationRepository.save(loanSimulation);
		return loanSimulation.getId_loan();

	}

	@Override
	public void deleteLoanSimulationByID(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		loanSimulationRepository.delete(loanSimulation);

	}

	@Override
	public void deleteAllLoanSimulationJPQL() {
		loanSimulationRepository.deleteAllLoanSimulationsJPQL();

	}

	@Override
	public void affectBankOfferTOLoanSimulation(int bankOfferID, int loanSimulationID) {
		BankOffers bankOffersManagedEntity = bankOffersRepository.findById(bankOfferID).get();
		LoanSimulation loanSimulationManagedEntity = loanSimulationRepository.findById(loanSimulationID).get();

		loanSimulationManagedEntity.setBankOffers(bankOffersManagedEntity);
		loanSimulationRepository.save(loanSimulationManagedEntity);

	}

	@Override
	public void affectUserTOLoanSimulation(int userID, int loanSimulationID) {
		User userManagedEntity = userRepository.findById(userID).get();
		LoanSimulation loanSimulationManagedEntity = loanSimulationRepository.findById(loanSimulationID).get();

		loanSimulationManagedEntity.setUser(userManagedEntity);
		loanSimulationRepository.save(loanSimulationManagedEntity);
	}

	@Override
	public void updateLoanSimulationByID(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		loanSimulationRepository.save(loanSimulation);
	}

	@Override
	public List<Integer> getAllLoanSimulationByBankOffer(int bankOfferID) {
		BankOffers bankOffers = bankOffersRepository.findById(bankOfferID).get();
		List<Integer> LoanSimulationAmounts = new ArrayList<>();
		for (LoanSimulation loanSimulation : bankOffers.getLoanSimulations()) {
			LoanSimulationAmounts.add(loanSimulation.getAmount());

		}
		return LoanSimulationAmounts;
	}

	@Override
	public List<Integer> getAllLoanSimulationByUser(int userID) {
		User userManagedEntity = userRepository.findById(userID).get();
		List<Integer> LoanSimulationAmounts = new ArrayList<>();
		for (LoanSimulation loanSimulation : userManagedEntity.getLoanSimulations()) {

			LoanSimulationAmounts.add(loanSimulation.getAmount());

		}

		return LoanSimulationAmounts;
	}

	// -----------------------------------Calcul-----------------------------------------

	@Override
	public float calculate_Net_Amount_Borrowed(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		Integer amount = loanSimulation.getAmount();
		float additional_fees = loanSimulation.getAdditional_fees();
		float personal_contributaion = loanSimulation.getPersonal_contribution();
		float net_amount_borrowed = amount - (personal_contributaion + additional_fees);
		loanSimulation.setNet_amount_borrowed(net_amount_borrowed);
		loanSimulationRepository.save(loanSimulation);
		System.out.println("Net Amount Borrowed:" + net_amount_borrowed);
		return net_amount_borrowed;
	}

	@Override
	public float calculate_Insurance_Per_Month(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		float total_insurance = loanSimulation.getTotal_insurance();
		float duration_year = loanSimulation.getDuration();
		float duration_month = duration_year * 12;
		float insurance_per_month = total_insurance / duration_month;
		loanSimulation.setInsurance_per_month(insurance_per_month);
		loanSimulationRepository.save(loanSimulation);
		System.out.println("Insurance Per Month :" + insurance_per_month);
		return insurance_per_month;

	}

	@Override
	public Double calculate_Monthly_Payment(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		float amount = loanSimulation.getAmount();
		// float net_amount_borrowed = loanSimulation.getNet_amount_borrowed();
		// float additional_fees = loanSimulation.getAdditional_fees();
		float personal_contributaion = loanSimulation.getPersonal_contribution();

		float amount_borrowed = amount - personal_contributaion;

		float interest_rate = loanSimulation.getInterest_rate();
		float duration_year = loanSimulation.getDuration();
		float duration_month = duration_year * 12;

		double monthly_payment = (amount_borrowed * ((interest_rate*0.1) / 12)
				/ (1 - (Math.pow((1 / (1 + ((interest_rate*0.1) / 12))), duration_month))));

		// DecimalFormat df = new DecimalFormat("0.00");
		double res = (double) Math.round(monthly_payment * 100) / 100;

		loanSimulation.setMonthly_payment(res);
		loanSimulationRepository.save(loanSimulation);
		System.out.println("Monthly Payment :" + res);
		return res;
	}

	@Override
	public Double calculate_Total_Monthly_Payment(int loanSimulationID) {

		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		Double monthly_payment = loanSimulation.getMonthly_payment();
		float duration_year = loanSimulation.getDuration();
		float duration_month = duration_year * 12;
		float additional_fees = loanSimulation.getAdditional_fees();

		Double total_monthly_payment = (monthly_payment * duration_month) + additional_fees;
		loanSimulation.setTotal_monthly_payment(total_monthly_payment);
		loanSimulationRepository.save(loanSimulation);
		System.out.println("Total Monthly Payment :" + total_monthly_payment);
		return total_monthly_payment;
	}

	@Override
	public Double calculate_TAEG_With_Insurance(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		float amount = loanSimulation.getAmount();
		float additional_fees = loanSimulation.getAdditional_fees();
		float personal_contributaion = loanSimulation.getPersonal_contribution();
		float amount_borrowed = (amount + additional_fees) - personal_contributaion;

		Double total_monthly_payment = loanSimulation.getTotal_monthly_payment(); // No
																					// Insurance
		float insurance_per_month = loanSimulation.getInsurance_per_month();
		float duration_year = loanSimulation.getDuration();
		float duration_month = duration_year * 12;

		Double total_monthly_payment_insurance = total_monthly_payment + (insurance_per_month * duration_month);

		Double taeg_insurance = (total_monthly_payment_insurance - amount_borrowed) / (amount_borrowed * 12);

		double res = (double) Math.round(taeg_insurance * 100) / 100;

		loanSimulation.setTaeg_insurance(res);
		loanSimulationRepository.save(loanSimulation);
		System.out.println("TARG With Insurance:" + res);
		return res;
	}

	@Override
	public Double calculate_TAEG_No_Insurance(int loanSimulationID) {

		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		float amount = loanSimulation.getAmount();
		float additional_fees = loanSimulation.getAdditional_fees();
		float personal_contributaion = loanSimulation.getPersonal_contribution();
		float amount_borrowed = (amount + additional_fees) - personal_contributaion;

		Double total_monthly_payment = loanSimulation.getTotal_monthly_payment(); // No
																					// Insurance

		Double taeg_no_insurance = (total_monthly_payment - amount_borrowed) / (amount_borrowed * 12);

		double res = (double) Math.round(taeg_no_insurance * 100) / 100;

		loanSimulation.setTaeg(res);
		loanSimulationRepository.save(loanSimulation);
		System.out.println("TARG No Insurance:" + res);

		return res;

	}

	@Override
	public Double calculate_TAEA(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		Double taeg_no_insurance = loanSimulation.getTaeg();
		Double taeg_with_insurance = loanSimulation.getTaeg_insurance();
		Double taea = taeg_with_insurance - taeg_no_insurance;
		double res = (double) Math.round(taea * 100) / 100;
		loanSimulation.setTaea(res);
		loanSimulationRepository.save(loanSimulation);
		System.out.println("TAEA:" + res);
		return taea;
	}

	@Override
	public Double calculate_Total_Paid(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();

		Double total_monthly_payment = loanSimulation.getTotal_monthly_payment();
		float amount = loanSimulation.getAmount();

		Double total_paid = total_monthly_payment - amount;
		loanSimulation.setTotal_paid(total_paid);
		loanSimulationRepository.save(loanSimulation);
		System.out.println("Total Paid :" + total_paid);
		return total_paid;
	}

	@Override
	public Double calculate_Total_Interest_Paid(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		float duration_year = loanSimulation.getDuration();
		float amount = loanSimulation.getAmount();
		float personal_contributaion = loanSimulation.getPersonal_contribution();
		Double monthly_Payment = loanSimulation.getMonthly_payment();

		Double total_interest_paid = (12 * duration_year * monthly_Payment) - (amount - personal_contributaion);

		loanSimulation.setTotal_interest_paid(total_interest_paid);
		loanSimulationRepository.save(loanSimulation);
		System.out.println("Total Interest Paid :" + total_interest_paid);
		return total_interest_paid;
	}

	@Override
	public String decision_loan(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();
		String result = "";
		Category category = loanSimulation.getCategory();
		Double k = 0.0;
		Double max = 0.0;
		Double monthly_payment = loanSimulation.getMonthly_payment();
		Double net_salary = (double) loanSimulation.getSalaire_net();
		if (category == Category.Apartment) {
			k = 0.65;
			max = net_salary * k;

			if (monthly_payment <= max) {
				result = "Accepted";
			} else {
				result = "Denied";

			}

		} else if (category == Category.House) {

			k = 0.70;
			max = net_salary * k;
			if (monthly_payment <= max) {
				result = "Accepted";
			} else {
				result = "Denied";

			}

		} else if (category == Category.Land) {
			k = 0.50;
			max = net_salary * k;
			if (monthly_payment <= max) {
				result = "Accepted";
			} else {
				result = "Denied";

			}

		} else if (category == Category.LocalCommercial) {

		} else {
			k = 0.69;
			max = net_salary * k;
			if (monthly_payment <= max) {
				result = "Accepted";
			} else {
				result = "Denied";

			}

		}

		loanSimulation.setResult(result);

		loanSimulationRepository.save(loanSimulation);
		System.out.println("Result:" + result);
		return result;
	}

	@Override
	public void Simulate_Loan(int loanSimulationID) {
		LoanSimulation loanSimulation = loanSimulationRepository.findById(loanSimulationID).get();

		BankOffers offer = loanSimulation.getBankOffers();

		float offer_additional_fees = offer.getAdditional_fees();
		float offer_total_insurance = offer.getTotal_insurance();
		float offer_interest_rate = offer.getInterest_rate();
		// Offer Data
		loanSimulation.setAdditional_fees(offer_additional_fees);
		loanSimulation.setTotal_insurance(offer_total_insurance);
		loanSimulation.setInterest_rate(offer_interest_rate);
		loanSimulationRepository.save(loanSimulation);
		System.out.println("Offer Details Affected to simulation!!");
		// Start Simulation

		calculate_Net_Amount_Borrowed(loanSimulationID);
		calculate_Insurance_Per_Month(loanSimulationID);

		calculate_Monthly_Payment(loanSimulationID);
		calculate_Total_Monthly_Payment(loanSimulationID);

		calculate_Total_Paid(loanSimulationID);
		calculate_Total_Interest_Paid(loanSimulationID);

		calculate_TAEG_With_Insurance(loanSimulationID);
		calculate_TAEG_No_Insurance(loanSimulationID);
		calculate_TAEA(loanSimulationID);

		decision_loan(loanSimulationID);

		System.out.println("Simulation Done !!");

	}

	@Override
	public List<LoanSimulation> getAllSimulations() {

		return (List<LoanSimulation>) loanSimulationRepository.findAll();
	}

	@Override
	public int addOrUpdateSimulation(LoanSimulation loanSimulation) {
		loanSimulation.setSimulation_date(new Date(System.currentTimeMillis()));
		loanSimulationRepository.save(loanSimulation);
		return loanSimulation.getId_loan();
	}

	@Override
	public LoanSimulation getSimulationByID(int loanSimulationID) {

		return loanSimulationRepository.findById(loanSimulationID).get();
	}

	// -------------------------------Filtre Affichage ------------------------
	@Override
	public List<LoanSimulation> findSimulationsByUser(int iduser) {

		return loanSimulationRepository.findSimulationsByUser(iduser);
	}

	@Override
	public List<LoanSimulation> retrieveAsc() {

		return loanSimulationRepository.retrieveAsc();
	}

	@Override
	public List<LoanSimulation> retrieveDesc() {

		return loanSimulationRepository.retrieveDesc();

	}

	@Override
	public List<LoanSimulation> retrieveDescDate() {

		return loanSimulationRepository.retrieveDescDate();
	}

	@Override
	public List<LoanSimulation> retrieveAccepted() {
		return loanSimulationRepository.retrieveAccepted();
	}

	@Override
	public List<LoanSimulation> retrieveDenied() {

		return loanSimulationRepository.retrieveDenied();
	}

	@Override
	public int countByHouse() {
		return loanSimulationRepository.countByCategory(Category.House);
	}

	@Override
	public int countByApartment() {
		return loanSimulationRepository.countByCategory(Category.Apartment);
	}

	@Override
	public int countByLand() {
		return loanSimulationRepository.countByCategory(Category.Land);
	}

	@Override
	public int countByLocalCommercial() {
		return loanSimulationRepository.countByCategory(Category.LocalCommercial);
	}

	@Override
	public int findByBankOffer(int idboffer) {

		return loanSimulationRepository.findByBankOffer(idboffer);
	}

	@Override
	public List<LoanSimulation> findByCategory(Category category, String result) {

		return loanSimulationRepository.findByCategory(category, result);
	}

	@Override
	public int getLoanSimulationNumberJPQL() {

		return loanSimulationRepository.countls();
	}

	@Override
	public List<String> getAllLoanSimulationAmountsJPQL() {

		return loanSimulationRepository.loanSimulationAmounts();
	}

	@Override
	public void barGraph(Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pieChart(Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public int countByResult() {

		return loanSimulationRepository.countByResult("Accepted");
	}

	@Override
	public int countByResultDenied() {
		// TODO Auto-generated method stub
		return loanSimulationRepository.countByResult("Denied");
	}

}
