package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.BankOffers;
import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.InterestType;
import tn.esprit.spring.entities.LoanSimulation;
import tn.esprit.spring.entities.RestrictWord;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.SimulatorReview;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.BankOffersRepository;
import tn.esprit.spring.repositories.LoanSimulationRepository;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.services.IBankOffersService;
import tn.esprit.spring.services.IBankService;
import tn.esprit.spring.services.ILoanSimulationService;
import tn.esprit.spring.services.ISimulatorReviewService;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.RestrictWordService;
import tn.esprit.spring.utility.MailSenderToAdministration;

@Scope(value = "session")
@Controller(value = "loanSimulationController")
@ELBeanName(value = "loanSimulationController")
@Join(path = "/", to = "/HomeSimulation.jsf")
@ManagedBean
@RequestScoped
public class LoanSimulationController {
	@Autowired
	IBankService iBankService;
	@Autowired
	IBankOffersService iBankOffersService;
	@Autowired
	ILoanSimulationService iLoansimulationservice;
	@Autowired
	BankOffersRepository bankOffersRepository;
	@Autowired
	IUserService iUserService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ISimulatorReviewService iSimulatorReviewService;
	@Autowired
	RestrictWordService restrictWordService;
	@Autowired
	LoanSimulationRepository loanSimulationRepository;

	public int addLoanSimulation(LoanSimulation loanSimulation) {

		iLoansimulationservice.addLoanSimulation(loanSimulation);
		return loanSimulation.getId_loan();

	}

	public void deleteLoanSimulationByID(int loanSimulationID) {

		iLoansimulationservice.deleteLoanSimulationByID(loanSimulationID);

	}

	public void deleteAllLoanSimulationJPQL() {
		iLoansimulationservice.deleteAllLoanSimulationJPQL();

	}

	public void affectBankOfferTOLoanSimulation(int bankOfferID, int loanSimulationID) {

		iLoansimulationservice.affectBankOfferTOLoanSimulation(bankOfferID, loanSimulationID);

	}

	public void affectUserTOLoanSimulation(int userID, int loanSimulationID) {
		iLoansimulationservice.affectUserTOLoanSimulation(userID, loanSimulationID);

	}

	public void updateLoanSimulationByID(int loanSimulationID) {
		iLoansimulationservice.updateLoanSimulationByID(loanSimulationID);

	}

	public List<Integer> getAllLoanSimulationByBankOffer(int bankOfferID) {

		return iLoansimulationservice.getAllLoanSimulationByBankOffer(bankOfferID);
	}

	public List<Integer> getAllLoanSimulationByUser(int userID) {

		return iLoansimulationservice.getAllLoanSimulationByUser(userID);
	}

	public int getLoanSimulationNumberJPQL() {

		return iLoansimulationservice.getLoanSimulationNumberJPQL();
	}

	public List<String> getAllLoanSimulationAmountsJPQL() {

		return iLoansimulationservice.getAllLoanSimulationAmountsJPQL();
	}

	public LoanSimulation getSimulationByID(int loanSimulationID) {

		return iLoansimulationservice.getSimulationByID(loanSimulationID);
	}

	// -----------------------------------Calcul-----------------------------------------

	public float calculate_Net_Amount_Borrowed(int loanSimulationID) {

		return iLoansimulationservice.calculate_Net_Amount_Borrowed(loanSimulationID);

	}

	public Double calculate_Monthly_Payment(int loanSimulationID) {

		return iLoansimulationservice.calculate_Monthly_Payment(loanSimulationID);
	}

	public Double calculate_Total_Monthly_Payment(int loanSimulationID) {

		return iLoansimulationservice.calculate_Total_Monthly_Payment(loanSimulationID);
	}

	public void calculate_Insurance_Per_Month(int loanSimulationID) {

		iLoansimulationservice.calculate_Insurance_Per_Month(loanSimulationID);
	}

	public Double calculate_TAEG_No_Insurance(int loanSimulationID) {

		return iLoansimulationservice.calculate_TAEG_No_Insurance(loanSimulationID);
	}

	public Double calculate_TAEG_With_Insurance(int loanSimulationID) {

		return iLoansimulationservice.calculate_TAEG_With_Insurance(loanSimulationID);
	}

	public Double calculate_TAEA(int loanSimulationID) {

		return iLoansimulationservice.calculate_TAEA(loanSimulationID);
	}

	public Double calculate_Total_Paid(int loanSimulationID) {

		return iLoansimulationservice.calculate_Total_Paid(loanSimulationID);
	}

	public Double calculate_Total_Interest_Paid(int loanSimulationID) {

		return iLoansimulationservice.calculate_Total_Interest_Paid(loanSimulationID);
	}

	public void Simulate_Loan(int loanSimulationID) {
		iLoansimulationservice.Simulate_Loan(loanSimulationID);
	}

	// -----------------------------------JSF User

	private User authenticatedUser;
	private int id_user;
	private String login;
	private String password;
	private Boolean loggedIn;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private boolean actif;
	private Role role;
	private String bank_user;
	private String state;
	private int banned;

	private List<User> users;
	private List<User> agents;
	private Integer UserIdToBeUpdated;

	public int getId_user() {
		id_user = userRepository.findById(id_user).get().getId_user();
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public User getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getBank_user() {

		return bank_user;
	}

	public void setBank_user(String bank_user) {
		this.bank_user = bank_user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getBanned() {
		return banned;
	}

	public void setBanned(int banned) {
		this.banned = banned;
	}

	public void setAgents(List<User> agents) {
		this.agents = agents;
	}

	public Integer getUserIdToBeUpdated() {
		return UserIdToBeUpdated;
	}

	public void setUserIdToBeUpdated(Integer userIdToBeUpdated) {
		UserIdToBeUpdated = userIdToBeUpdated;
	}

	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser = iUserService.authenticate(login, password);
		if (authenticatedUser != null && authenticatedUser.getRole() == Role.Agent) {
			navigateTo = "/BankAgentHome.xhtml?faces-redirect=true";
			loggedIn = true;
		} else if (authenticatedUser != null && authenticatedUser.getRole() == Role.Client) {
			navigateTo = "/ClientHome.xhtml?faces-redirect=true";
			loggedIn = true;

		} /*
			 * else if (authenticatedUser != null && authenticatedUser.getRole()
			 * == Role.Administrateur) { navigateTo =
			 * "/admin.xhtml?faces-redirect=true"; loggedIn = true; }
			 */

		else {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;
	}

	public String doLogout() {
		int id_authenticatedUser = authenticatedUser.getId_user();
		iUserService.logOut(id_authenticatedUser);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/HomeSimulation.xhtml?faces-redirect=true";
	}

	public Role[] getRoles() {
		return Role.values();
	}

	public String addUser() {

		iUserService.addOrUpdateUser(new User(email, password, firstName, lastName, role, phone, bank_user));
		return "/login.xhtml";
	}

	public List<User> getUsers() {
		users = iUserService.getUserByRole();
		return users;

	}

	public List<User> getAgents() {
		users = iUserService.getUserByRole();
		return agents;

	}

	public void removeUser(int userId) {
		iUserService.deleteUserByID(userId);
	}

	public void displayUser(User user) {

		this.setLastName(user.getLastName());
		this.setFirstName(user.getFirstName());
		this.setActif(user.isActif());
		this.setEmail(user.getEmail());
		this.setRole(user.getRole());
		this.setPassword(user.getPassword());
		this.setPhone(user.getPhone());
		this.setUserIdToBeUpdated(user.getId_user());
	}

	public void updateUser() {
		iUserService.addOrUpdateUser(
				new User(UserIdToBeUpdated, email, password, firstName, lastName, role, phone, bank_user));
	}

	public int getAgentsNumberJPQL() {

		return iUserService.getAgentsNumberJPQL();
	}

	public User getUserById(int userID) {

		return iUserService.getUserById(userID);
	}
	// ----------------------------------JSF Simulation
	// ------------------------------------------------

	private int id_loan;
	private Integer amount;
	private Integer duration;
	Category category;
	private float salaire_net;
	private float personal_contribution;
	private Date simulation_date;
	// -----------------------------------

	private float additional_fees;
	private float total_insurance;
	private float interest_rate;

	// -----------------------------------

	private float net_amount_borrowed;
	private Double monthly_payment;
	private Double total_monthly_payment;
	private float insurance_per_month;

	private Double taeg;
	private Double taeg_insurance;
	private Double taea;

	private Double total_paid;
	private Double total_interest_paid;
	private String result;

	private LoanSimulation loanSimulation;
	private BankOffers bankOffer;
	private Bank bank;
	private User user;

	private List<BankOffers> bankOffers;
	private List<LoanSimulation> loanSimulations;

	private int id_bo;
	private int id_currentuser;

	private Integer SimulationToBeUpdated;

	public IBankService getiBankService() {
		return iBankService;
	}

	public void setiBankService(IBankService iBankService) {
		this.iBankService = iBankService;
	}

	public IBankOffersService getiBankOffersService() {
		return iBankOffersService;
	}

	public void setiBankOffersService(IBankOffersService iBankOffersService) {
		this.iBankOffersService = iBankOffersService;
	}

	public ILoanSimulationService getiLoansimulationservice() {
		return iLoansimulationservice;
	}

	public void setiLoansimulationservice(ILoanSimulationService iLoansimulationservice) {
		this.iLoansimulationservice = iLoansimulationservice;
	}

	public BankOffersRepository getBankOffersRepository() {
		return bankOffersRepository;
	}

	public void setBankOffersRepository(BankOffersRepository bankOffersRepository) {
		this.bankOffersRepository = bankOffersRepository;
	}

	public int getId_loan() {
		return id_loan;
	}

	public void setId_loan(int id_loan) {
		this.id_loan = id_loan;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float getSalaire_net() {
		return salaire_net;
	}

	public void setSalaire_net(float salaire_net) {
		this.salaire_net = salaire_net;
	}

	public float getPersonal_contribution() {
		return personal_contribution;
	}

	public void setPersonal_contribution(float personal_contribution) {
		this.personal_contribution = personal_contribution;
	}

	public Date getSimulation_date() {
		return simulation_date;
	}

	public void setSimulation_date(Date simulation_date) {
		this.simulation_date = simulation_date;
	}

	public float getAdditional_fees() {
		return additional_fees;
	}

	public void setAdditional_fees(float additional_fees) {
		this.additional_fees = additional_fees;
	}

	public float getTotal_insurance() {
		return total_insurance;
	}

	public void setTotal_insurance(float total_insurance) {
		this.total_insurance = total_insurance;
	}

	public float getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(float interest_rate) {
		this.interest_rate = interest_rate;
	}

	public float getNet_amount_borrowed() {
		return net_amount_borrowed;
	}

	public void setNet_amount_borrowed(float net_amount_borrowed) {
		this.net_amount_borrowed = net_amount_borrowed;
	}

	public Double getMonthly_payment() {
		return monthly_payment;
	}

	public void setMonthly_payment(Double monthly_payment) {
		this.monthly_payment = monthly_payment;
	}

	public Double getTotal_monthly_payment() {
		return total_monthly_payment;
	}

	public void setTotal_monthly_payment(Double total_monthly_payment) {
		this.total_monthly_payment = total_monthly_payment;
	}

	public float getInsurance_per_month() {
		return insurance_per_month;
	}

	public void setInsurance_per_month(float insurance_per_month) {
		this.insurance_per_month = insurance_per_month;
	}

	public Double getTaeg() {
		return taeg;
	}

	public void setTaeg(Double taeg) {
		this.taeg = taeg;
	}

	public Double getTaeg_insurance() {
		return taeg_insurance;
	}

	public void setTaeg_insurance(Double taeg_insurance) {
		this.taeg_insurance = taeg_insurance;
	}

	public Double getTaea() {
		return taea;
	}

	public void setTaea(Double taea) {
		this.taea = taea;
	}

	public Double getTotal_paid() {
		return total_paid;
	}

	public void setTotal_paid(Double total_paid) {
		this.total_paid = total_paid;
	}

	public Double getTotal_interest_paid() {
		return total_interest_paid;
	}

	public void setTotal_interest_paid(Double total_interest_paid) {
		this.total_interest_paid = total_interest_paid;
	}

	public BankOffers getBankOffer() {
		return bankOffer;
	}

	public void setBankOffer(BankOffers bankOffer) {
		this.bankOffer = bankOffer;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BankOffers> getBankOffers() {
		bankOffers = iBankOffersService.getAllBankOffers();
		return bankOffers;
	}

	public void setBankOffers(List<BankOffers> bankOffers) {
		this.bankOffers = bankOffers;
	}

	public int getId_bo() {
		return id_bo;
	}

	public void setId_bo(int id_bo) {
		this.id_bo = id_bo;
	}

	public int getId_currentuser() {
		return id_currentuser;
	}

	public void setId_currentuser(int id_currentuser) {
		this.id_currentuser = id_currentuser;
	}

	public List<LoanSimulation> getLoanSimulations() {
		loanSimulations = iLoansimulationservice.getAllSimulations();
		return loanSimulations;
	}

	public void setLoanSimulations(List<LoanSimulation> loanSimulations) {
		this.loanSimulations = loanSimulations;
	}

	public Integer getSimulationToBeUpdated() {
		return SimulationToBeUpdated;
	}

	public void setSimulationToBeUpdated(Integer simulationToBeUpdated) {
		SimulationToBeUpdated = simulationToBeUpdated;
	}

	public LoanSimulation getLoanSimulation() {
		return loanSimulation;
	}

	public void setLoanSimulation(LoanSimulation loanSimulation) {
		this.loanSimulation = loanSimulation;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String addSimulation() {
		BankOffers chosenbankoffer = bankOffersRepository.findById(id_bo).get();

		iLoansimulationservice.addOrUpdateSimulation(new LoanSimulation(amount, duration, category, salaire_net,
				personal_contribution, chosenbankoffer, authenticatedUser));

		return "/MySimulationsList.xhtml?faces-redirect=true";
	}

	public void removeSimulation(int simulationId) {

		iLoansimulationservice.deleteLoanSimulationByID(simulationId);
	}

	public InterestType[] getInterestTypes() {
		return InterestType.values();

	}

	public Category[] getCategories() {

		return Category.values();
	}

	// ----------------------Reviews----------------------

	private int id_review;

	private String content_review;

	private Date addedDate;

	private SimulatorReview simulatorReview;

	private List<SimulatorReview> simulatorReviews;

	public int getId_review() {
		return id_review;
	}

	public void setId_review(int id_review) {
		this.id_review = id_review;
	}

	public String getContent_review() {
		return content_review;
	}

	public void setContent_review(String content_review) {
		this.content_review = content_review;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public SimulatorReview getSimulatorReview() {
		return simulatorReview;
	}

	public void setSimulatorReview(SimulatorReview simulatorReview) {
		this.simulatorReview = simulatorReview;
	}

	public List<SimulatorReview> getSimulatorReviews() {

		simulatorReviews = iSimulatorReviewService.getAllSimulatorReviews();
		return simulatorReviews;
	}

	public void setSimulatorReviews(List<SimulatorReview> simulatorReviews) {
		this.simulatorReviews = simulatorReviews;
	}

	public String addSimulatorReviews() {

		String[] wordsFromText = content_review.split(" ");

		if (badWordsValidation(wordsFromText)) {
			iSimulatorReviewService.addOrUpdateSimulatorReview(new SimulatorReview(content_review, authenticatedUser));

			content_review = "";

		} else {
			String stars = "*** Comment Bloqued ***";
			iSimulatorReviewService.addOrUpdateSimulatorReview(new SimulatorReview(stars, authenticatedUser));
			content_review = "You Wrote A Bad Word !! ";
		}
		return "";

	}

	public void removeSimulatorReviews(int simulatorReviewID) {

		iSimulatorReviewService.deleteSimulatorReviewByID(simulatorReviewID);
	}

	// --------------------------------------BAD
	// WORDS----------------------------------------------
	private Boolean badWordsValidation(String[] wordsFromText) {
		List<RestrictWord> restrictWords = restrictWordService.findAll();
		Boolean thatsOk = true;
		if (!restrictWords.isEmpty())
			for (int i = 0; i < wordsFromText.length; i++) {
				String wordFromText = wordsFromText[i];
				if (restrictWords.stream().filter(word -> word.getWord().equalsIgnoreCase(wordFromText)).count() > 0) {
					thatsOk = false;
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage("somekey", new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erreur le contexte est invalide ", "CONTEXT INVALIDE"));
					break;
				}
			}
		return thatsOk;
	}

	// -------------------------------------------------Mail
	// Administration------------------------------

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void send() {
		try {
			MailSenderToAdministration mailSender = new MailSenderToAdministration();
			mailSender.SendMail(message);
		} catch (Exception e) {
		}
	}

	// -------------------------------------------Filtrage

	public List<LoanSimulation> loanSimulations_asc() {
		return iLoansimulationservice.retrieveAsc();
	}

	public List<LoanSimulation> retrieveDesc() {

		return iLoansimulationservice.retrieveDesc();
	}

	public List<LoanSimulation> retrieveDescDate() {

		return iLoansimulationservice.retrieveDescDate();

	}

	public List<LoanSimulation> retrieveAccepted() {

		return iLoansimulationservice.retrieveAccepted();

	}

	public List<LoanSimulation> retrieveDenied() {

		return iLoansimulationservice.retrieveDenied();
	}

	public int findByBankOffer(int idboffer) {

		return iLoansimulationservice.findByBankOffer(idboffer);
	}

	public List<LoanSimulation> findByCategory(Category category, String result) {

		return iLoansimulationservice.findByCategory(category, result);
	}

	private List<LoanSimulation> simulationsAsc;
	private List<LoanSimulation> simulationsDes;
	private List<LoanSimulation> simulationsDates;
	private List<LoanSimulation> simulationsAccepted;
	private List<LoanSimulation> simulationDenied;

	public List<LoanSimulation> getSimulationsAsc() {

		simulationsAsc = iLoansimulationservice.retrieveAsc();
		return simulationsAsc;
	}

	public void setSimulationsAsc(List<LoanSimulation> simulationsAsc) {
		this.simulationsAsc = simulationsAsc;
	}

	public List<LoanSimulation> getSimulationsDes() {
		simulationsDes = iLoansimulationservice.retrieveDesc();
		return simulationsDes;
	}

	public void setSimulationsDes(List<LoanSimulation> simulationsDes) {
		this.simulationsDes = simulationsDes;
	}

	public List<LoanSimulation> getSimulationsDates() {
		simulationsDates = iLoansimulationservice.retrieveDescDate();
		return simulationsDates;
	}

	public void setSimulationsDates(List<LoanSimulation> simulationsDates) {
		this.simulationsDates = simulationsDates;
	}

	public List<LoanSimulation> getSimulationsAccepted() {
		simulationsAccepted = iLoansimulationservice.retrieveAccepted();
		return simulationsAccepted;
	}

	public void setSimulationsAccepted(List<LoanSimulation> simulationsAccepted) {
		this.simulationsAccepted = simulationsAccepted;
	}

	public List<LoanSimulation> getSimulationDenied() {
		simulationDenied = iLoansimulationservice.retrieveDenied();
		return simulationDenied;
	}

	public void setSimulationDenied(List<LoanSimulation> simulationDenied) {
		this.simulationDenied = simulationDenied;
	}

	public List<User> top;

	// ----------------------------------------- Score Agent ----------------

	public List<User> getTop() {
		top = iUserService.topscore();
		top = iUserService.getUserByRole();

		return top;
	}

	public void setTop(List<User> top) {
		this.top = top;
	}

	public void scorePlus(int userID) {

		iUserService.scorePlus(userID);

	}

	public void scoreMoins(int userID) {

		iUserService.scoreMoins(userID);
	}
	// ---------------------------------------------Simulation number by
	// category --------------------

	public int countByHouse() {

		return iLoansimulationservice.countByHouse();
	}

	public int countByApartment() {

		return iLoansimulationservice.countByApartment();
	}

	public int countByLand() {

		return iLoansimulationservice.countByLand();
	}

	public int countByLocalCommercial() {

		return iLoansimulationservice.countByLocalCommercial();
	}

	// ---------------------------------------------------charts-----------------------------------
	public void alert() {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("swal('Success !! log in is done')");
	}
}
