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

import tn.esprit.spring.entities.BankOffers;
import tn.esprit.spring.services.IBankOffersService;
import tn.esprit.spring.services.IBankService;

@RestController
public class BankOffersRestController {
	@Autowired
	IBankOffersService iBankOffersService;
	@Autowired
	IBankService iBankService;

	// http://localhost:8181/SpringMVC/servlet/addBankOffer
	@PostMapping("/addBankOffer")
	@ResponseBody
	public BankOffers addBankOffer(@RequestBody BankOffers bankOffers) {

		iBankOffersService.addBankOffer(bankOffers);
		return bankOffers;
	}

	// http://localhost:8181/SpringMVC/servlet/deleteBankOfferByID/2
	@DeleteMapping("/deleteBankOfferByID/{idbankoffer}")
	@ResponseBody
	public void deleteBankOfferByID(@PathVariable("idbankoffer") int bankOfferID) {

		iBankOffersService.deleteBankOfferByID(bankOfferID);

	}

	// http://localhost:8181/SpringMVC/servlet/affectBankToBankOffer/1/1
	@PutMapping(value = "/affectBankToBankOffer/{idbank}/{idbankoffer}")
	public void affectBankToBankOffer(@PathVariable("idbank") int bankID,
			@PathVariable("idbankoffer") int bankOfferID) {
		iBankOffersService.affectBankToBankOffer(bankID, bankOfferID);
	}

	// http://localhost:8181/SpringMVC/servlet/updateBankOfferNameByID/1/BH
	@PutMapping(value = "/updateBankOfferNameByID/{idbankoffer}/{newbankoffername}")
	@ResponseBody
	public void updateBankOfferNameByID(@PathVariable("idbankoffer") int bankOfferID,
			@PathVariable("newbankoffername") String bankOfferName) {
		iBankOffersService.updateBankOfferNameByID(bankOfferName, bankOfferID);

	}

	// http://localhost:8181/SpringMVC/servlet/updateBankOfferDescriptionByID/1/Housing
	// Bank
	@PutMapping(value = "/updateBankOfferDescriptionByID/{idbankoffer}/{newbankofferdescription}")
	@ResponseBody
	public void updateBankOfferDescriptionByID(@PathVariable("idbankoffer") int bankOfferID,
			@PathVariable("newbankofferdescription") String description) {
		iBankOffersService.updateBankOfferDescriptionByID(description, bankOfferID);

	}

	// URL : http://localhost:8181/SpringMVC/servlet/getAllBankOffers
	@GetMapping(value = "/getAllBankOffers")
	@ResponseBody
	public List<BankOffers> getAllBankOffers() {
		return iBankOffersService.getAllBankOffers();
	}

	// http://localhost:8181/SpringMVC/servlet/getAllBankOffersNamesByBank/1
	@GetMapping(value = "getAllBankOffersNamesByBank/{idbank}")
	@ResponseBody
	public List<String> getAllBankOffersNamesByBank(@PathVariable("idbank") int bankID) {

		return iBankOffersService.getAllBankOffersNamesByBank(bankID);

	}

	// http://localhost:8181/SpringMVC/servlet/getBankOfferNameByBankOfferID/3
	@GetMapping(value = "getBankOfferNameByBankOfferID/{idbankoffer}")
	@ResponseBody
	public String getBankOfferNameByBankOfferID(@PathVariable("idbankoffer") int bankOfferID) {
		return iBankOffersService.getBankOfferNameByBankOfferID(bankOfferID);

	}

	// http://localhost:8181/SpringMVC/servlet/getBankOffersNumberJPQL
	@GetMapping(value = "getBankOffersNumberJPQL")
	@ResponseBody
	public int getBankOffersNumberJPQL() {

		return iBankOffersService.getBankOffersNumberJPQL();
	}

	// http://localhost:8181/SpringMVC/servlet/getAllBankOffersNamesJPQL
	@GetMapping(value = "getAllBankOffersNamesJPQL")
	@ResponseBody
	public List<String> getAllBankOffersNamesJPQL() {
		return iBankOffersService.getAllBankOffersNamesJPQL();
	}

	// http://localhost:8181/SpringMVC/servlet/deleteAllBankOffersJPQL
	@DeleteMapping("/deleteAllBankOffersJPQL")
	@ResponseBody
	public void deleteAllBankOffersJPQL() {
		iBankOffersService.deleteAllBankOffersJPQL();

	}

}
