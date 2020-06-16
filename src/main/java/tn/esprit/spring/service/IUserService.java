package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.User;

public interface IUserService {
	public User authenticate(String login, String password);

	public int addOrUpdateUser(User user);

	public List<User> getAllUsers();

	public void deleteUserByID(int userID);

	public int getAgentsNumberJPQL();

	public List<User> getUserByRole();

	public int logOut(int userID);

	public User getUserById(int userID);

	public void scorePlus(int userID);

	public void scoreMoins(int userID);

	List<User> topscore();
}
