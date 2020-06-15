package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Users;
import tn.esprit.spring.service.UsersService;

@RestController
public class UsersRestController {
@Autowired
UsersService usersservice;


//@PreAuthorize("hasRole('ADMINISTRATEUR') or hasRole('USER')")
@GetMapping("/users")
@ResponseBody
public List<Users> retrieveAllusers() {
	List<Users> list = usersservice.retrieveAllVente();
	return list;
}

@PostMapping("/add-users")
@ResponseBody
public Users AddVente(@RequestBody Users u) {
	Users users =usersservice.addUser(u);
	return users;
}


}
