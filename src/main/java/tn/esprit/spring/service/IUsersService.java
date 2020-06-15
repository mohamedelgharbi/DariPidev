package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Users;

public interface IUsersService {

	public Users authenticate(String login, String password);

	public Users addUser(Users u);

	public List<Users> retrieveAllVente();

	public Users addUsers(Users u);

	public void deleteUser(String id);

	public Users addOrUpdateUser(Users users);

}
