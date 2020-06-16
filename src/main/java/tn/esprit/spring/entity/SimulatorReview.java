package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SimulatorReview")
public class SimulatorReview {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id_review;

	private String content_review;

	private Date addedDate;

	@ManyToOne
	User user;

	public SimulatorReview() {
		super();
	}

	public SimulatorReview(int id_review, String content_review, Date addedDate, User user) {
		super();
		this.id_review = id_review;
		this.content_review = content_review;
		this.addedDate = addedDate;
		this.user = user;
	}

	public SimulatorReview(String content_review, Date addedDate, User user) {
		super();
		this.content_review = content_review;
		this.addedDate = addedDate;
		this.user = user;
	}

	public SimulatorReview(String content_review, User user) {
		super();
		this.content_review = content_review;
		this.user = user;
	}

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