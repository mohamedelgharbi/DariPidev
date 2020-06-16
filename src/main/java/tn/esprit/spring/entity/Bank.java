package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Bank")
public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id_bank;
	// @NotNull(message = "Name is compulsory")
	// @Column(name = "Name_Bank", nullable = false, unique = true)
	private String name_bank;
	// @Column(name = "Description_Bank", nullable = true)
	private String description_bank;

	// @Column(name = "Adress", nullable = true)
	private String adress;

	// @Column(name = "City", nullable = true)
	private String city;

	// @Column(name = "State", nullable = true)
	private String state;

	// @Column(name = "Country", nullable = true)
	private String country;

	// @Column(name = "Zip", nullable = true)
	private Integer zip;

	private Date addedDate;
	// @Column(name = "", nullable = true)

	// Upload image...
	private String fileName;

	private String filePath;

	private String fileType;

	private String fileSize;

	private String rateBank;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bank")
	private Set<BankOffers> BankOffer;

	public Bank() {
		super();
	}

	public Bank(String name_bank, String description_bank, String adress, String city, String state, String country,
			Integer zip, Date addedDate, String fileName, String filePath, String fileType, String fileSize,
			String rateBank, Set<BankOffers> bankOffer) {
		super();
		this.name_bank = name_bank;
		this.description_bank = description_bank;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.addedDate = addedDate;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.rateBank = rateBank;
		BankOffer = bankOffer;
	}

	public Bank(String name_bank, String description_bank, String adress, String city, String state, String country,
			Integer zip) {
		super();
		this.name_bank = name_bank;
		this.description_bank = description_bank;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public Bank(String name_bank, String description_bank, String adress, String city, String state, String country,
			Integer zip, String rateBank) {
		super();
		this.name_bank = name_bank;
		this.description_bank = description_bank;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.rateBank = rateBank;
	}

	public Bank(int id_bank, String name_bank, String description_bank, String adress, String city, String state,
			String country, Integer zip) {
		super();
		this.id_bank = id_bank;
		this.name_bank = name_bank;
		this.description_bank = description_bank;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public Bank(int id_bank, String name_bank, String description_bank, String adress, String city, String state,
			String country, Integer zip, String rateBank) {
		super();
		this.id_bank = id_bank;
		this.name_bank = name_bank;
		this.description_bank = description_bank;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.rateBank = rateBank;
	}

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

	public Set<BankOffers> getBankOffer() {
		return BankOffer;
	}

	public void setBankOffer(Set<BankOffers> bankOffer) {
		BankOffer = bankOffer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getRateBank() {
		return rateBank;
	}

	public void setRateBank(String rateBank) {
		this.rateBank = rateBank;
	}

	@Override
	public String toString() {
		return "Bank [id_bank=" + id_bank + ", name_bank=" + name_bank + ", description_bank=" + description_bank
				+ ", adress=" + adress + ", city=" + city + ", state=" + state + ", country=" + country + ", zip=" + zip
				+ ", addedDate=" + addedDate + ", fileName=" + fileName + ", filePath=" + filePath + ", fileType="
				+ fileType + ", fileSize=" + fileSize + ", rateBank=" + rateBank + ", BankOffer=" + BankOffer + "]";
	}

	
}
