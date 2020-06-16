package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.LoanSimulation;
import tn.esprit.spring.services.IBankOffersService;
import tn.esprit.spring.services.ILoanSimulationService;

@RestController
public class LoanSimulationRestController {
	@Autowired
	IBankOffersService iBankOffersService;
	@Autowired
	ILoanSimulationService iLoanSimulationService;

	// http://localhost:8181/SpringMVC/servlet/addLoanSimulation
	@PostMapping("/addLoanSimulation")
	@ResponseBody
	public LoanSimulation addLoanSimulation(@RequestBody LoanSimulation loanSimulation) {
		iLoanSimulationService.addLoanSimulation(loanSimulation);
		return loanSimulation;
	}

	// URL : http://localhost:8181/SpringMVC/servlet/deleteLoanSimulationByID/1
	@DeleteMapping("/deleteLoanSimulationByID/{idloansimulation}")
	@ResponseBody
	public void deleteLoanSimulationByID(@PathVariable("idloansimulation") int loanSimulationID) {
		iLoanSimulationService.deleteLoanSimulationByID(loanSimulationID);
	}

	// URL : http://localhost:8181/SpringMVC/servlet/deleteAllLoanSimulationJPQL
	@DeleteMapping("/deleteAllLoanSimulationJPQL")
	@ResponseBody
	public void deleteAllLoanSimulationJPQL() {
		iLoanSimulationService.deleteAllLoanSimulationJPQL();
	}

	// http://localhost:8181/SpringMVC/servlet/affectBankOfferTOLoanSimulation/6/1
	@PutMapping(value = "/affectBankOfferTOLoanSimulation/{idbankoffer}/{idloansimulation}")
	public void affectBankOfferTOLoanSimulation(@PathVariable("idbankoffer") int bankOfferID,
			@PathVariable("idloansimulation") int loanSimulationID) {

		iLoanSimulationService.affectBankOfferTOLoanSimulation(bankOfferID, loanSimulationID);

	}

	// http://localhost:8181/SpringMVC/servlet/affectUserTOLoanSimulation/6/1
	@PutMapping(value = "/affectUserTOLoanSimulation/{iduser}/{idloansimulation}")
	public void affectUserTOLoanSimulation(@PathVariable("iduser") int userID,
			@PathVariable("idloansimulation") int loanSimulationID) {

		iLoanSimulationService.affectUserTOLoanSimulation(userID, loanSimulationID);

	}

	// http://localhost:8181/SpringMVC/servlet/updateLoanSimulationByID/1
	@PutMapping(value = "/updateLoanSimulationByID/{idloansimulation}")
	@ResponseBody
	public void updateLoanSimulationByID(@PathVariable("idloansimulation") int loanSimulationID) {
		iLoanSimulationService.updateLoanSimulationByID(loanSimulationID);
	}

	// http://localhost:8181/SpringMVC/servlet/getAllLoanSimulationByBankOffer/1
	@GetMapping(value = "getAllLoanSimulationByBankOffer/{idbankoffer}")
	@ResponseBody
	public List<Integer> getAllLoanSimulationByBankOffer(@PathVariable("idbankoffer") int bankOfferID) {

		return iLoanSimulationService.getAllLoanSimulationByBankOffer(bankOfferID);
	}

	// http://localhost:8181/SpringMVC/servlet/getAllLoanSimulationByUser/1
	@GetMapping(value = "getAllLoanSimulationByUser/{iduser}")
	@ResponseBody
	public List<Integer> getAllLoanSimulationByUser(@PathVariable("iduser") int userID) {
		return iLoanSimulationService.getAllLoanSimulationByUser(userID);
	}

	// URL : http://localhost:8181/SpringMVC/servlet/getLoanSimulationNumberJPQL
	@GetMapping(value = "getLoanSimulationNumberJPQL")
	@ResponseBody
	public int getLoanSimulationNumberJPQL() {

		return iLoanSimulationService.getLoanSimulationNumberJPQL();
	}

	// URL :
	// http://localhost:8181/SpringMVC/servlet/getAllLoanSimulationAmountsJPQL
	@GetMapping(value = "getAllLoanSimulationAmountsJPQL")
	@ResponseBody
	public List<String> getAllLoanSimulationAmountsJPQL() {
		return iLoanSimulationService.getAllLoanSimulationAmountsJPQL();
	}

	// http://localhost:8181/SpringMVC/servlet/calculate_Net_Amount_Borrowed/1
	@PutMapping(value = "calculate_Net_Amount_Borrowed/{loanSimulationID}")
	@ResponseBody
	public float calculate_Net_Amount_Borrowed(@PathVariable("loanSimulationID") int loanSimulationID) {

		return iLoanSimulationService.calculate_Net_Amount_Borrowed(loanSimulationID);
	}

	// http://localhost:8181/SpringMVC/servlet/calculate_Monthly_Payment/1
	@PutMapping(value = "calculate_Monthly_Payment/{loanSimulationID}")
	@ResponseBody
	public Double calculate_Monthly_Payment(@PathVariable("loanSimulationID") int loanSimulationID) {

		return iLoanSimulationService.calculate_Monthly_Payment(loanSimulationID);
	}

	// http://localhost:8181/SpringMVC/servlet/Simulate_Loan/1
	@PutMapping(value = "Simulate_Loan/{loanSimulationID}")
	@ResponseBody
	public void Simulate_Loan(@PathVariable("loanSimulationID") int loanSimulationID) {
		iLoanSimulationService.Simulate_Loan(loanSimulationID);
	}

}
