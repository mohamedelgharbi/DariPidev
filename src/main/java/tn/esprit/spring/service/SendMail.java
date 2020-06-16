package tn.esprit.spring.service;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.utility.MailSender;

//@Scope(value = "session")
@Controller(value = "sendMailController")
@ELBeanName(value = "sendMailController")
// @Join(path = "/", to = "/")
public class SendMail {
	@Autowired
	UserRepository userRepository;
	@Autowired
	IUserService iUserService;

	private int id_user;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private boolean actif;
	private Role role;
	private String bank_user;
	private String state;
	private int banned;
	private User user;

	private String data_save;

	public String getData_save() {
		return data_save;
	}

	public void setData_save(String data_save) {
		this.data_save = data_save;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
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

	public String goToMailForm(int userID) {
		userID = id_user;
		System.out.println(" ID Agent To Send Mail :" + id_user);

		return "/MailToAgent.xhtml?faces-redirect=true";

	}

	public String displayAgent(User u) {
		this.setFirstName(u.getFirstName());
		this.setLastName(u.getLastName());
		this.setEmail(u.getEmail());
		this.setPhone(u.getPhone());
		this.setBank_user(u.getBank_user());
		this.setState(u.getState());

		return "/MailToAgent.xhtml?faces-redirect=true";

	}

	// -----------------------------------------Mail

	private String subject;
	private String messageMail;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageMail() {
		return messageMail;
	}

	public void setMessageMail(String messageMail) {
		this.messageMail = messageMail;
	}

	public void send() {

		try {
			MailSender mailSender = new MailSender();
			mailSender.SendMail(email, subject, messageMail);
		} catch (Exception e) {
			System.out.println("Error Mail");
		}
	}

	public void scorePlus(int userID) {
		
		iUserService.scorePlus(userID);

	}

	public void scoreMoins(int userID) {
	
		iUserService.scoreMoins(userID);
	}

}
