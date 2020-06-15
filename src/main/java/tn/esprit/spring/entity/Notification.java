package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer notificationId;
	@Column
	private String message;
	@Column
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	private int action;
	@ManyToOne
	private Users user;
	@ManyToOne
	private Vente vente;

	public void setUser(Users user) {
		this.user = user;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public Notification() {
	}

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public Users getUser() {
		return user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Notification(Integer notificationId, String message, Date createdAt, Users user) {
		super();
		this.notificationId = notificationId;
		this.message = message;
		this.createdAt = createdAt;
		this.user = user;
	}

	public Notification(String message, Date createdAt) {
		super();
		this.message = message;
		this.createdAt = createdAt;

	}

	public Notification(String message, Date createdAt, Users user) {
		super();
		this.message = message;
		this.createdAt = createdAt;
		this.user = user;
	}

	public Notification(String message, Date createdAt, int action, Users user) {
		super();
		this.message = message;
		this.createdAt = createdAt;
		this.action = action;
		this.user = user;
	}

	public Notification(String message, Date createdAt, Users user, int action) {
		super();
		this.message = message;
		this.createdAt = createdAt;
		this.user = user;
		this.action = action;

	}

	public Notification(Integer notificationId, String message, Date createdAt, int action, Users user, Vente vente) {
		super();
		this.notificationId = notificationId;
		this.message = message;
		this.createdAt = createdAt;
		this.action = action;
		this.user = user;
		this.vente = vente;
	}

	public Notification(String message, Date createdAt, Users user, Vente vente , int action) {
		super();
		this.message = message;
		this.createdAt = createdAt;
		
		this.user = user;
		this.vente = vente;
		this.action = action;
	}

	

	
	
}