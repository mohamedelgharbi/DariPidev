package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RateBankAgent")
public class RateBankAgent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_rate_agent;
	
	private int value_rate_agent;
	
	@ManyToOne
	User user;

	public RateBankAgent() {
		super();
	}

	public RateBankAgent(int id_rate_agent, int value_rate_agent, User user) {
		super();
		this.id_rate_agent = id_rate_agent;
		this.value_rate_agent = value_rate_agent;
		this.user = user;
	}

	public RateBankAgent(int value_rate_agent, User user) {
		super();
		this.value_rate_agent = value_rate_agent;
		this.user = user;
	}

	public int getId_rate_agent() {
		return id_rate_agent;
	}

	public void setId_rate_agent(int id_rate_agent) {
		this.id_rate_agent = id_rate_agent;
	}

	public int getValue_rate_agent() {
		return value_rate_agent;
	}

	public void setValue_rate_agent(int value_rate_agent) {
		this.value_rate_agent = value_rate_agent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
