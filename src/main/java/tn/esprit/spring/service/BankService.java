package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Bank;
import tn.esprit.spring.repository.BankRepository;

@Service
public class BankService implements IBankService {
	@Autowired
	BankRepository bankRepository;

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Override
	public List<Bank> getAllBanks() {

		return (List<Bank>) bankRepository.findAll();
	}

	@Override
	public int addBank(Bank bank) {

		Date currentDate = new Date(System.currentTimeMillis());

		bank.setAddedDate(currentDate);
		bankRepository.save(bank);
		return bank.getId_bank();
	}

	@Override
	public void deleteBankByID(int bankID) {
		Bank bank = bankRepository.findById(bankID).get();
		bankRepository.delete(bank);

	}

	@Override
	public void updateBankNameByBankID(String bankName, int bankID) {
		Bank bankManagedEntity = bankRepository.findById(bankID).get();
		bankManagedEntity.setName_bank(bankName);
		bankRepository.save(bankManagedEntity);

	}

	@Override
	public void deleteAllBanksJPQL() {
		bankRepository.deleteAllBanksJPQL();

	}

	@Override
	public int getBanksNumberJPQL() {

		return bankRepository.countemp();
	}

	@Override
	public List<String> getAllBanksNamesJPQL() {
		// TODO Auto-generated method stub
		return bankRepository.getAllbanksNamesJPQL();
	}

	@Override
	public void updateBankDescriptionByBankID(String bankDescription, int bankID) {
		Bank bankManagedEntity = bankRepository.findById(bankID).get();
		bankManagedEntity.setDescription_bank(bankDescription);
		bankRepository.save(bankManagedEntity);
	}

	@Override
	public int addOrUpdateBank(Bank bank) {
		Date currentDate = new Date(System.currentTimeMillis());

		bank.setAddedDate(currentDate);
		bankRepository.save(bank);
		return bank.getId_bank();
	}

	@Override
	public boolean deleteLogo(Integer BankID, String bankLogo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bank getBankByID(int bankID) {

		return bankRepository.findById(bankID).get();

	}

}
