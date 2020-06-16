package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RateBankOffer")
public class RateBankOffer {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_rate_offer;
	
	private int value;
	
	@ManyToOne
	User user;

	public RateBankOffer() {
		super();
	}

	public RateBankOffer(int id_rate_offer, int value, User user) {
		super();
		this.id_rate_offer = id_rate_offer;
		this.value = value;
		this.user = user;
	}

	public RateBankOffer(int value, User user) {
		super();
		this.value = value;
		this.user = user;
	}

	public int getId_rate_offer() {
		return id_rate_offer;
	}

	public void setId_rate_offer(int id_rate_offer) {
		this.id_rate_offer = id_rate_offer;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
