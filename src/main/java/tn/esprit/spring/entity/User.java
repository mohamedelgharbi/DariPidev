package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser")
	private int id_user;
	// @Email(message = "Email is invalid")
	// @Column(name = "email", nullable=false, unique= true)
	private String email;

	// @NotNull(message="Password is compulsory")
	// @Length(min=5, message="Password should be at least 5 characters")
	private String password;

	// @NotNull(message="First name is compulsory")
	// @Column(name = "first_name")
	private String firstName;

	// @NotNull(message="Last name is compulsory")
	// @Column(name = "last_name")
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Role role;

	private boolean actif;

	// @Pattern(regexp="(^$|[0-9]{8}",message="Mobile number must be 8 digits")
	private String phone;

	private String bank_user;

	private String state;

	private int banned;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<LoanSimulation> LoanSimulations;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<SimulatorReview> SimulatorReviews;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<RateBankAgent> RateBankAgents;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<RateBankOffer> RateBankOffers;

	public User() {
		super();
	}

	public User(int id_user, String email, String password, String firstName, String lastName, Role role, boolean actif,
			String phone, String bank_user, String state, int banned, Set<LoanSimulation> loanSimulations) {
		super();
		this.id_user = id_user;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.actif = actif;
		this.phone = phone;
		this.bank_user = bank_user;
		this.state = state;
		this.banned = banned;
		LoanSimulations = loanSimulations;
	}

	public User(String email, String password, String firstName, String lastName, Role role, boolean actif,
			String phone, String bank_user, String state, int banned, Set<LoanSimulation> loanSimulations) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.actif = actif;
		this.phone = phone;
		this.bank_user = bank_user;
		this.state = state;
		this.banned = banned;
		LoanSimulations = loanSimulations;
	}

	public User(int id_user, String email, String password, String firstName, String lastName, Role role, String phone,
			String bank_user) {
		super();
		this.id_user = id_user;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.phone = phone;
		this.bank_user = bank_user;
	}

	public User(String email, String password, String firstName, String lastName, Role role, String phone,
			String bank_user) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.phone = phone;
		this.bank_user = bank_user;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Set<LoanSimulation> getLoanSimulations() {
		return LoanSimulations;
	}

	public void setLoanSimulations(Set<LoanSimulation> loanSimulations) {
		LoanSimulations = loanSimulations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", role=" + role + ", actif=" + actif + ", phone=" + phone + ", bank_user="
				+ bank_user + ", state=" + state + ", banned=" + banned + ", LoanSimulations=" + LoanSimulations
				+ ", SimulatorReviews=" + SimulatorReviews + ", RateBankAgents=" + RateBankAgents + ", RateBankOffers="
				+ RateBankOffers + ", getId_user()=" + getId_user() + ", getEmail()=" + getEmail() + ", getPassword()="
				+ getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getRole()=" + getRole() + ", isActif()=" + isActif() + ", getPhone()=" + getPhone()
				+ ", getBank_user()=" + getBank_user() + ", getState()=" + getState() + ", getBanned()=" + getBanned()
				+ ", getLoanSimulations()=" + getLoanSimulations() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
