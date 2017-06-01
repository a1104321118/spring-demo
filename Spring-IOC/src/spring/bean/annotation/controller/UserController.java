package spring.bean.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.bean.annotation.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	public void excute() {
		System.out.println("UserController 的  excute");
		userService.add();
	}
}
