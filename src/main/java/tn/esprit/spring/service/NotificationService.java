package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.Vente;

public interface NotificationService {

	public Notification addNotification(Notification u);

	public List<Notification> retrieveAllNotifications();

	void deleteNotification(String id);

	int nbrNotif();
	
	

}
