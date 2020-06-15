package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.repository.UsersRepository;
import tn.esprit.spring.service.IUsersService;

//@Scope(value = "session")
@Controller(value = "sendMailController")
@ELBeanName(value = "sendMailController")
// @Join(path = "/", to = "/")
public class SendMail {
	@Autowired
	UsersRepository userRepository;
	@Autowired
	IUsersService iUserService;

	

}
