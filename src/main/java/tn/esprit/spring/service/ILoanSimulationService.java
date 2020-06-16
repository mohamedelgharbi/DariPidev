package tn.esprit.spring.service;

import java.util.List;

import org.springframework.ui.Model;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.LoanSimulation;

public interface ILoanSimulationService {

	public int addLoanSimulation(LoanSimulation loanSimulation);

	public void deleteLoanSimulationByID(int loanSimulationID);

	public void deleteAllLoanSimulationJPQL();

	public void affectBankOfferTOLoanSimulation(int bankOfferID, int loanSimulationID);

	public void affectUserTOLoanSimulation(int userID, int loanSimulationID);

	public void updateLoanSimulationByID(int loanSimulationID);

	public List<Integer> getAllLoanSimulationByBankOffer(int bankOfferID);

	public List<Integer> getAllLoanSimulationByUser(int userID);

	public int getLoanSimulationNumberJPQL();

	public List<String> getAllLoanSimulationAmountsJPQL();

	public List<LoanSimulation> getAllSimulations();

	public int addOrUpdateSimulation(LoanSimulation loanSimulation);

	public LoanSimulation getSimulationByID(int loanSimulationID);

	// Simulation d'un crédit bancaire (Calculs)

	public float calculate_Net_Amount_Borrowed(int loanSimulationID);

	public Double calculate_Monthly_Payment(int loanSimulationID);

	public Double calculate_Total_Monthly_Payment(int loanSimulationID);

	public float calculate_Insurance_Per_Month(int loanSimulationID);

	public Double calculate_TAEG_No_Insurance(int loanSimulationID);

	public Double calculate_TAEG_With_Insurance(int loanSimulationID);

	public Double calculate_TAEA(int loanSimulationID);

	public Double calculate_Total_Paid(int loanSimulationID);

	public Double calculate_Total_Interest_Paid(int loanSimulationID);

	public String decision_loan(int loanSimulationID);

	public void Simulate_Loan(int loanSimulationID);

	// Filtage des simulations

	public List<LoanSimulation> findSimulationsByUser(int iduser);

	public List<LoanSimulation> retrieveAsc();

	public List<LoanSimulation> retrieveDesc();

	public List<LoanSimulation> retrieveDescDate();

	public List<LoanSimulation> retrieveAccepted();

	public List<LoanSimulation> retrieveDenied();

	public int countByHouse();

	public int countByApartment();

	public int countByLand();

	public int countByLocalCommercial();

	public int findByBankOffer(int idboffer);

	public List<LoanSimulation> findByCategory(Category category, String result);

	int countByResult();
	
	int countByResultDenied();

	public void barGraph(Model model);

	public void pieChart(Model model);
}
