package tn.esprit.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tn.esprit.spring.entities.Bank;

import tn.esprit.spring.services.IBankService;

@Scope(value = "session")
@Controller(value = "bankController")
@ELBeanName(value = "bankController")
// @Join(path = "/", to = "/")
public class BankController {

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	@Autowired
	IBankService iBankService;

	public int addBank(Bank bank) {
		iBankService.addBank(bank);
		return bank.getId_bank();
	}

	public void deleteBankByID(int bankID) {
		iBankService.deleteBankByID(bankID);
	}

	public void updateBankNameByBankID(String bankName, int bankID) {
		iBankService.updateBankNameByBankID(bankName, bankID);

	}

	public void updateBankDescriptionByBankID(String bankDescription, int bankID)

	{
		iBankService.updateBankDescriptionByBankID(bankDescription, bankID);

	}

	public void deleteAllBanksJPQL() {

		iBankService.deleteAllBanksJPQL();

	}

	public int getBanksNumberJPQL() {

		return iBankService.getBanksNumberJPQL();

	}

	public List<String> getAllBanksNamesJPQL() {
		return iBankService.getAllBanksNamesJPQL();
	}

	public Bank getBankByID(int bankID) {
		return iBankService.getBankByID(bankID);

	}

	// ----------------------------------JSF--------------------------------------------------------
	private int id_bank;
	private String name_bank;
	private String description_bank;
	private String adress;
	private String city;
	private String state;
	private String country;
	private Integer zip;
	private String logo;
	private Date addedDate;
	private String rateBank;
	private Bank bank;
	private List<Bank> banks;
	private Integer BankToBeUpdated;

	public int getId_bank() {
		return id_bank;
	}

	public void setId_bank(int id_bank) {
		this.id_bank = id_bank;
	}

	public String getName_bank() {
		return name_bank;
	}

	public void setName_bank(String name_bank) {
		this.name_bank = name_bank;
	}

	public String getDescription_bank() {
		return description_bank;
	}

	public void setDescription_bank(String description_bank) {
		this.description_bank = description_bank;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Bank> getBanks() {
		banks = iBankService.getAllBanks();
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public Integer getBankToBeUpdated() {
		return BankToBeUpdated;
	}

	public void setBankToBeUpdated(Integer bankToBeUpdated) {
		BankToBeUpdated = bankToBeUpdated;
	}

	public IBankService getiBankService() {
		return iBankService;
	}

	public void setiBankService(IBankService iBankService) {
		this.iBankService = iBankService;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getRateBank() {
		return rateBank;
	}

	public void setRateBank(String rateBank) {
		this.rateBank = rateBank;
	}

	public String addBank() {

		iBankService
				.addOrUpdateBank(new Bank(name_bank, description_bank, adress, city, state, country, zip, rateBank));
		return "/BankList.xhtml";
	}

	public void removeBank(int bankId) {
		iBankService.deleteBankByID(bankId);
	}

	public String displayBank(Bank bk) {
		this.setName_bank(bk.getName_bank());
		this.setDescription_bank(bk.getDescription_bank());
		this.setAdress(bk.getAdress());
		this.setCity(bk.getCity());
		this.setState(bk.getState());
		this.setCountry(bk.getCountry());
		this.setZip(bk.getZip());
		this.setAddedDate(bk.getAddedDate());
		this.setBankToBeUpdated(bk.getId_bank());
		return "/BankDetails.xhtml";
	}

	public void updateBank() {

		iBankService.addOrUpdateBank(
				new Bank(BankToBeUpdated, name_bank, description_bank, adress, city, state, country, zip));
	}

	// -----------------------------------------------Upload Image
	// --------------------------------------------------------------

	@PostMapping("/saveBank")
	public @ResponseBody ResponseEntity<?> createBank(@Valid Bank bank,
			@RequestParam("name_bank") final String name_bank,
			@RequestParam("description_bank") final String description_bank,
			@RequestParam("adress") final String adress, @RequestParam("city") final String city,
			@RequestParam("state") final String state, @RequestParam("country") final String country,
			@RequestParam("zip") final Integer zip, final @RequestParam("file") MultipartFile file) {
		try {

			// HttpHeaders headers = new HttpHeaders();

			if (bank == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			// String[] desc = description_bank.split(",");
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			long size = file.getSize();
			String fileSize = String.valueOf(size);

			// Sive the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			bank.setName_bank(name_bank);
			bank.setDescription_bank(description_bank);
			bank.setAdress(adress);
			bank.setCity(city);
			bank.setCountry(country);
			bank.setState(state);
			bank.setZip(zip);
			bank.setFileName(fileName);
			bank.setFilePath(filePath);
			bank.setFileSize(fileSize);
			bank.setFileType(fileType);

			iBankService.addBank(bank);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/banks")
	public ModelAndView showAllBanks() {
		ModelAndView mav = new ModelAndView("banks");
		List<Bank> bankList = iBankService.getAllBanks();
		mav.addObject("bankList", bankList);
		return mav;
	}
}