package com.skilldistillery.interdistillery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.interdistillery.data.UserDAO;
import com.skilldistillery.interdistillery.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home(Model model) {
		
		model.addAttribute("DEBUG", userDao.findById(1)); // DEBUG REMOVE LATER
		return "homePage";
	}

	@RequestMapping("getUser.do")
	public String showUser(@RequestParam Integer fid, Model model) {
		User user = userDao.findById(fid);
		model.addAttribute("user", user);
		return "";
	}

}
