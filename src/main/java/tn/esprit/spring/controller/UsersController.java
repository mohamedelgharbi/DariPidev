package tn.esprit.spring.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.Users;
import tn.esprit.spring.service.UsersService;
import tn.esprit.spring.service.VenteServiceImpl;

@Scope(value = "session")
@Controller(value = "UsersController")
@ELBeanName(value = "UsersController")
// @Join(path = "/", to = "/Login/accueil.jsf")
@Join(path = "/", to = "/ajoutvente.jsf")

public class UsersController {

	private static final Logger l = LogManager.getLogger(VenteServiceImpl.class);

	@Autowired
	UsersService usersservice;
	private String login;
	private String name;
	private String password;
	private Users users;
	private Boolean loggedIn;
	private Users authenticatedUser;
	private Role role;
	private Integer adIdToBeUpdated;

	private List<Users> user;

	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser = usersservice.authenticate(login, password);
		if (authenticatedUser != null && authenticatedUser.getRoles() == Role.USER) {

			navigateTo = "/affichevente.xhtml?faces-redirect=true";
			loggedIn = true;
		}
		if (authenticatedUser != null && authenticatedUser.getRoles() == Role.ADMINISTRATEUR) {

			navigateTo = "/dashbordvente.xhtml?faces-redirect=true";
			loggedIn = true;
		}

		else {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login/signin.xhtml?faces-redirect=true";
	}

	public UsersService getUsersservice() {
		return usersservice;
	}

	public void setUsersservice(UsersService usersservice) {
		this.usersservice = usersservice;
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Users getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(Users authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role[] getRoles() {
		return Role.values();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Users> getUser() {
		user = usersservice.retrieveAllVente();
		return user;
	}

	
	
	public Integer getAdIdToBeUpdated() {
		return adIdToBeUpdated;
	}

	public void setAdIdToBeUpdated(Integer adIdToBeUpdated) {
		this.adIdToBeUpdated = adIdToBeUpdated;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	public String addUsers() {

		Users u = new Users(name, login, password, role);
		usersservice.addUser(u);
		return "/login.xhtml?faces-redirect=true";

	}
	
	public String removeUser(String id) {
		l.info("aaaaaaaaaaaa" + id);
		usersservice.deleteUser(id);
		return "/dashbordUsers.xhtml?faces-redirect=true";

	}

	public String displayUser(Users user) {
		// String navigateTo = "null";
		this.setName(user.getNom());
		this.setLogin(user.getEmail());
		this.setPassword(user.getPassword());
		this.setRole(user.getRoles());
		return "/modifUsers.xhtml?faces-redirect=true";

	}
	
	public String updateUser() {

		

		 //usersservice.addOrUpdateUser(new Users(adIdToBeUpdated, name, login, password, role));
		usersservice.addOrUpdateUser(new Users(adIdToBeUpdated, name, login, password, role));
		return "/dashbordUsers.xhtml?faces-redirect=true";

	}
	
}
