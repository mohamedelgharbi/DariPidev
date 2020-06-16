package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User authenticate(String login, String password) {

		User user = userRepository.getUserByEmailAndPassword(login, password);

		user.setState("Connected");
		userRepository.save(user);

		return user;
	}
	
	@Override
	public int addOrUpdateUser(User user) {
		user.setActif(false);
		user.setState("Disconnected");
		user.setBanned(0); // Score initial
		userRepository.save(user);
		return user.getId_user();
	}

	@Override
	public List<User> getAllUsers() {

		return (List<User>) userRepository.findAll();
	}

	@Override
	public void deleteUserByID(int userID) {
		User user = userRepository.findById(userID).get();
		userRepository.delete(user);

	}

	@Override
	public int getAgentsNumberJPQL() {

		return userRepository.countagent(Role.Agent);
	}

	public List<User> getUserByRole() {

		System.out.println("Agents Selected");
		return userRepository.getUserByRole(Role.Agent);

	}

	@Override
	public int logOut(int userID) {
		User user = userRepository.findById(userID).get();
		user.setState("Disconnected");
		userRepository.save(user);
		return 0;
	}

	@Override
	public User getUserById(int userID) {
		System.out.println("ID Agent To Send Mail" + userID);
		return userRepository.findById(userID).get();
	}

	@Override
	public void scorePlus(int userID) {
		User user = userRepository.findById(userID).get();
		int k = user.getBanned();
		user.setBanned(k + 1);
		userRepository.save(user);
		System.out.println("Score Added !!");
	}

	@Override
	public void scoreMoins(int userID) {

		User user = userRepository.findById(userID).get();
		int k = user.getBanned();
		user.setBanned(k - 1);
		userRepository.save(user);
		System.out.println("Score Down !!");

	}

	@Override
	public List<User> topscore() {
		System.out.println("Top Agent Selected");
		return userRepository.topscore();

	}

}
