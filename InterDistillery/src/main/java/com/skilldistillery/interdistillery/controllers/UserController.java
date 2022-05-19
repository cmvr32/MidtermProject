package com.skilldistillery.interdistillery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.interdistillery.data.UserDAO;

@Controller
public class UserController {

		@Autowired
	private UserDAO userDao;
	
}
