package com.skilldistillery.interdistillery.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.interdistillery.data.UserDAO;
import com.skilldistillery.interdistillery.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;

//	@RequestMapping(path = { "/", "homePage.do" })
//	public String home(Model model) {
//		model.addAttribute("DEBUG", userDao.findById(1));
//		return "homePage";
//	}

	@RequestMapping(path = { "homePage.do" })
	public String home1(@RequestParam Integer id, Model model) {
		model.addAttribute("FINDBYID", userDao.findById(id)); // DEBUG REMOVE LATER
		return "homePage";
	}
	
	
	// LOGIN METHODS

	// THIS IS THE START OF THE LOGIN
	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public String findByUserNameAndPassword(@RequestParam String username, String password, Model model,
			HttpSession session) {
		User user = userDao.findByUserNameAndPassword(username, password);

		System.err.println("---LOGGIN IN USER---");
		
		
		if (user != null) {
			session.setAttribute("user", user);
			return "Login/account";

		} else {

			return "Login/login";
		}
	}

//	logout.do removes the user from session and redirects to index.do.
	@RequestMapping(path = "logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "homePage";
	}
	
	
	@RequestMapping(path="showUser.do", method = RequestMethod.GET)
	public String showUser( Model model, HttpSession session) {
		
		
		User loggedInUser = (User) session.getAttribute("user");
		
		Integer id=loggedInUser.getId();
		
		System.out.println("********************");
		System.out.println("User Id:  " + id);
		System.out.println("UserDAO:  " + userDao);
		System.out.println("********************");
		
		User accountInfo=userDao.findById(id);
		
		model.addAttribute("accountInfo", accountInfo);
		
		return "Login/login";
	}

	@RequestMapping("getUserAccount.do")
	public String findUserAccountByNameAndEmail(@RequestParam String firstName, String lastName, String email,
			Model model) {
		User user = userDao.findUserAccountByNameAndEmail(firstName, lastName, email);
		model.addAttribute("user", user);
		return "login/account";
	}

	@RequestMapping(path = "CreateUser.do", method = RequestMethod.POST)
	public String addNewUser(Model model,
							@RequestParam String firstName, 
							@RequestParam String lastName,
							@RequestParam String email, 
							@RequestParam String username, 
							@RequestParam String password) {
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setUserName(username);
		newUser.setPassword(password);
		newUser.setActive(1);
		newUser.setRole("User");
		newUser = userDao.createUser(newUser);
		//boolean addUserFlag = true;
		//model.addFlashAttribute("addUserFlag", addUserFlag);
		model.addAttribute("user", newUser);
		//System.out.println("User added maybe" + newUser);
		return "homePage";
	}

	@RequestMapping(path = "CreateUser.do", method = RequestMethod.GET)
	public String addUserGetProcess(User user) {
		return "Login/account";
	}

//	@RequestMapping(path = "CreateUser.do")
//	public String addNewUser() {
//		return "Login/login";
//	}

	@RequestMapping(path = "UpdateUser.do", method = RequestMethod.GET)
	public String updateUser(RedirectAttributes redir, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String username, @RequestParam String password,
			@RequestParam String profileImageUrl, @RequestParam String profileBannerUrl,
			@RequestParam String biography) {

		boolean updateUserEmailFlag = true;

		User user = userDao.findUserAccountByNameAndEmail(firstName, lastName, email);

		userDao.updateUser(user);
		redir.addFlashAttribute("updateUserEmailFlag", updateUserEmailFlag);
		redir.addFlashAttribute("user", user);
		return "Login/UpdateUser";

	}

	@RequestMapping(path = "DeleteUser.do", method = RequestMethod.POST)
	public String deleteUser(RedirectAttributes redir, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email) {

		User user = userDao.findUserAccountByNameAndEmail(firstName, lastName, email);
		Integer userId = user.getId();
		boolean containsFlag = userDao.deleteUser(userId);
		boolean deleteUserFlag = true;
		redir.addFlashAttribute("deleteUserFlag", deleteUserFlag);
		redir.addFlashAttribute("containsFlag", containsFlag);
		return "Login/DeleteUser";
	}

	@RequestMapping(path = "DeleteUser.do", method = RequestMethod.GET)
	public String deleteUserGetProcess(User user) {
		return "Login/DeleteUser";
	}


	@RequestMapping("directToLogin.do")
	public String directToLogin() {
		return "Login/login";
	}

	@RequestMapping("directToCreateUser.do")
	public String directToCreateUser() {
		return "Login/CreateUser";
	}

	@RequestMapping("directToHomePage.do")
	public String directToHomePage() {
		return "homePage";
	}
	@RequestMapping("directToAccount.do")
	public String directToAccount() {
		return "Login/account";
	}


}
