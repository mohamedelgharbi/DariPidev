package tn.esprit.spring.service;

import java.util.Date;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.repositories.BankRepository;

//@Scope(value = "session")
@Controller(value = "stockController")
@ELBeanName(value = "stockController")
// @Join(path = "/", to = "/")
public class StockData {
	@Autowired
	BankRepository bankrepository;
	@Autowired
	IBankService iBankService;

	private int id;

	private String name_bank;

	private String description_bank;

	private String adress;

	private String city;

	private String state;

	private String country;

	private Integer zip;

	private Date addedDate;

	private String rateBank;

	public int getId() {
		id = bankrepository.findById(id).get().getId_bank();
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_bank() {
		name_bank = bankrepository.findById(id).get().getName_bank();
		return name_bank;
	}

	public void setName_bank(String name_bank) {
		this.name_bank = name_bank;
	}

	public String getDescription_bank() {
		description_bank = bankrepository.findById(id).get().getDescription_bank();
		return description_bank;
	}

	public void setDescription_bank(String description_bank) {
		this.description_bank = description_bank;
	}

	public String getAdress() {
		adress = bankrepository.findById(id).get().getAdress();
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		city = bankrepository.findById(id).get().getCity();
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		state = bankrepository.findById(id).get().getState();
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		country = bankrepository.findById(id).get().getCountry();
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getZip() {
		zip = bankrepository.findById(id).get().getZip();
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Date getAddedDate() {
		addedDate = bankrepository.findById(id).get().getAddedDate();
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getRateBank() {
		rateBank = bankrepository.findById(id).get().getRateBank();
		return rateBank;
	}

	public void setRateBank(String rateBank) {
		this.rateBank = rateBank;
	}

	public String showBankDetails(int bankID) {
		id = bankID;
		System.out.println("ID Bank:" + id);
		return "/BankDetails.xhtml?faces-redirect=true";
	}
	public String showBankDetailscc(int bankID) {
		id = bankID;
		System.out.println("ID Bank:" + id);
		return "/BankDetailsClient.xhtml?faces-redirect=true";
	}

	public String removeBank(int bankId) {
		id = bankId;
		iBankService.deleteBankByID(bankId);
		return "/DeleteBank.xhtml?faces-redirect=true";
	}

	public String showBankToUpdate(int bankID) {
		id = bankID;
		System.out.println("ID Bank To Update:" + id);
		return "/BankToUpdate.xhtml?faces-redirect=true";
	}
	
	public String updateBank() {
		
		iBankService.addOrUpdateBank(
				new Bank(id, name_bank, description_bank, adress, city, state, country, zip,rateBank));
		return "/UpdateBank.xhtml?faces-redirect=true";
	}
}
