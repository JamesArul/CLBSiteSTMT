package com.jpro.studentsmeetcontrollerrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpro.studentsmeetbackend.dao.UserDAO;
import com.jpro.studentsmeetbackend.model.User;

@RestController
public class UserController {
	
private static final Logger log=LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	private User user;
	
	@Autowired
	private UserDAO userDAO;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User newUser)
	{
		boolean valid=userDAO.createUser(newUser);
		if(valid){
			return new ResponseEntity<User>(newUser,HttpStatus.OK);
		}
		else{
			return null;
		}
	}

}
