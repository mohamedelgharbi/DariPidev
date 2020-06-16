package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.service.IUserService;

@Scope(value = "session")
@Controller(value = "userController")
@ELBeanName(value = "userController")

public class UserController {
	@Autowired
	IUserService iUserService;
}
