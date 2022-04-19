package com.hospital.hospitalroomsservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitalroomsservice.entities.User;
import com.hospital.hospitalroomsservice.modal.AuthReqBody;
import com.hospital.hospitalroomsservice.modal.AuthResBody;
import com.hospital.hospitalroomsservice.repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	UserRepository userRepo;

	@PostMapping("/login")
	public AuthResBody authenticate(@RequestBody AuthReqBody authReqBody) {
		AuthResBody auth = new AuthResBody();
		auth.setAuthenticated(false);
		List<User> users = userRepo.getUserByNameAndPwd(authReqBody.getUsername(), authReqBody.getPassword());
		if (users != null && !users.isEmpty()) {
			auth.setUser(users.get(0));
			auth.setAuthenticated(true);
		}

		return auth;
	}
}
