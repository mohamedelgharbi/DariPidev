package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.service.NotificationServiceImpl;
import tn.esprit.spring.service.UsersService;
import tn.esprit.spring.service.VenteService;

@Scope(value = "session")
@Controller(value = "notificationController")
@ELBeanName(value = "notificationController")

public class NotificationController {
	@Autowired
	VenteService VenteService;
	@Autowired
	UsersService UsersService;
	@Autowired
	UsersController UsersController;
	@Autowired
	NotificationServiceImpl notificationservice;

	private Integer notificationId;

	private String message;

	private Date createdAt;
	private boolean isRead;

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
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

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	private List<Notification> notifications;

	public List<Notification> getNotifications() {

		List<Notification> notifications = notificationservice.retrieveAllNotifications();
		return notifications;

	}

	public void setAnnonces(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Date currentDate() {
		Date currdate = new Date();
		return currdate;
	}

	public List<Notification> getNotificationsSameDay() {
		Date currdate = new Date();

		notifications = notificationservice.retrieveAllNotifications();

		for (int i = 0, j = notifications.size() - 1; i < j; i++) {

			notifications.add(i, notifications.remove(j));
		}

		return notifications;
	}

	public Date getDate() {
		Date currdate = new Date();
		return currdate;

	}

}