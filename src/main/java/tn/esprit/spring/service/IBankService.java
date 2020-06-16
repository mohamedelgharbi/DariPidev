package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Bank;

public interface IBankService {
	public List<Bank> getAllBanks();

	public int addBank(Bank bank);

	public void deleteBankByID(int bankID);

	public void updateBankNameByBankID(String bankName, int bankID);

	public void updateBankDescriptionByBankID(String bankDescription, int bankID);

	public void deleteAllBanksJPQL();

	public int getBanksNumberJPQL();

	public List<String> getAllBanksNamesJPQL();

	public int addOrUpdateBank(Bank bank);

	public boolean deleteLogo(Integer BankID, String bankLogo);

	public Bank getBankByID(int bankID);
}
