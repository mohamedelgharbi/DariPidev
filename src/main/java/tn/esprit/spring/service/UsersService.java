package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Users;
import tn.esprit.spring.repository.UsersRepository;

@Service(value = "userService")
public class UsersService implements IUsersService,UserDetailsService  {
	@Autowired
	UsersRepository usersrepository;

	@Override
	public Users authenticate(String login, String password) {

		return usersrepository.getUsersByEmailAndPassword(login, password);
	}

	@Override
	public Users addUser(Users u) {
		return usersrepository.save(u);
		
	}

	@Override
	public List<Users> retrieveAllVente() {
		// TODO Auto-generated method stub
		return (List<Users>) usersrepository.findAll();
	}

	@Override
	public Users addUsers(Users u) {
		// TODO Auto-generated method stub
		return usersrepository.save(u);
	}

	@Override
	public void deleteUser(String id) {
		usersrepository.deleteById((int) Long.parseLong(id));		
	}

	@Override
	public UserDetails loadUserByUsername(String email){
		 Users user = usersrepository.findByEmail(email);
	        if(user == null){
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	        return user;
	}

	@Override
	public Users addOrUpdateUser(Users users) {
		
		return usersrepository.save(users);
	}

	//@Override
	//public Users addOrUpdateUser(Users users) {
		//return usersrepository.save(users);
		
	//}
	
	
}
