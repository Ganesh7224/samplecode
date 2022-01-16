package com.bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.bean.User;
import com.bs.service.LoginImpl;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginImpl myService;

	@GetMapping("/userr")
	public User get() {
		return new User(12, "user1001", "password101");
	}

//	@RequestMapping(value = "/saveUser",method = RequestMethod.POST)
	@PostMapping("/isLogined")
	public String isLogined(@RequestBody User user) {
		String message;

		boolean flag = myService.isLogined(user);
		if (flag == true)
			message = "Present";
		else
			message = "not found";

		return message;
	}
	
	@PostMapping("/saveCred")
	public User saveCred(@RequestBody User user) {
		return myService.saveCred(user);
	}

}