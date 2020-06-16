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

import tn.esprit.spring.entity.Bank;
import tn.esprit.spring.service.IBankService;

@RestController
public class BankRestController {

	@Autowired
	IBankService iBankService;

	// http://localhost:8181/SpringMVC/servlet/addBank
	/*
	 * { "name_bank":"Amen", "description_bank":"Amen Bank",
	 * "adress":"Avenue XYZA","city":"Ariana", "state":"Ariana",
	 * "country":"Tunsia", "zip":"3030", "rateBank":"4" }
	 */
	@PostMapping("/addBank")
	@ResponseBody
	public Bank addBank(@RequestBody Bank bank) {

		iBankService.addBank(bank);
		return bank;

	}

	// http://localhost:8181/SpringMVC/servlet/deleteBankByID/1
	@DeleteMapping("/deleteBankByID/{idbank}")
	@ResponseBody
	public void deleteBankByID(@PathVariable("idbank") int bankID) {

		iBankService.deleteBankByID(bankID);

	}

	// http://localhost:8181/SpringMVC/servlet/updateBankNameByBankID/1/BH
	@PutMapping(value = "/updateBankNameByBankID/{idbank}/{newbankname}")
	@ResponseBody
	public void updateBankNameByBankID(@PathVariable("newbankname") String bankName,
			@PathVariable("idbank") int bankID) {
		iBankService.updateBankNameByBankID(bankName, bankID);

	}

	// http://localhost:8181/SpringMVC/servlet/updateBankDescriptionByBankID/1/Banque
	// d'habitat
	@PutMapping(value = "/updateBankDescriptionByBankID/{idbank}/{newbankdescription}")
	@ResponseBody
	public void updateBankDescriptionByBankID(@PathVariable("newbankdescription") String bankDescription,
			@PathVariable("idbank") int bankID) {

		iBankService.updateBankDescriptionByBankID(bankDescription, bankID);

	}

	// http://localhost:8181/SpringMVC/servlet/deleteAllBanksJPQL
	@DeleteMapping("/deleteAllBanksJPQL")
	@ResponseBody
	public void deleteAllBanksJPQL() {

		iBankService.deleteAllBanksJPQL();

	}

	// http://localhost:8181/SpringMVC/servlet/getBanksNumberJPQL
	@GetMapping(value = "getBanksNumberJPQL")
	@ResponseBody
	public int getBanksNumberJPQL() {

		return iBankService.getBanksNumberJPQL();

	}

	// http://localhost:8181/SpringMVC/servlet/getAllBanksNamesJPQL
	@GetMapping(value = "getAllBanksNamesJPQL")
	@ResponseBody
	public List<String> getAllBanksNamesJPQL() {
		return iBankService.getAllBanksNamesJPQL();
	}
}
