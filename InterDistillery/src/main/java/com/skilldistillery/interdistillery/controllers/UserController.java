package com.skilldistillery.interdistillery.controllers;

import java.util.List;

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

	// START: Home page
	@RequestMapping(path = { "homePage.do" })
	public String home1(@RequestParam Integer id, Model model) {
		model.addAttribute("FINDBYID", userDao.findById(id)); // DEBUG REMOVE LATER
		return "homePage";
	}

	// LOGIN METHOD
	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public String findByUserNameAndPassword(@RequestParam String username, String password, Model model,
			HttpSession session) {

		System.err.println("---LOGIN USER---");
		User user = userDao.findByUserNameAndPassword(username, password);

		Integer userId = user.getId();
		User userAccountInfo = userDao.findById(userId);

		System.out.println("********************");
		System.err.println("---GET USE ACCOUNT INFO---");
		System.out.println("User Id:  " + userId);
		System.out.println("UserDAO:  " + userDao);
		System.out.println("********************");
		System.out.println(userAccountInfo);

		System.err.println(userAccountInfo);

		if (user != null) {

			model.addAttribute("userAccountInfo", userAccountInfo);
			model.addAttribute("user", user);
			System.err.println("---USER LOGGED IN---");
			System.err.println("USER: " + user);
			if (user.getRole().equalsIgnoreCase("Admin")) {

				User admin = user;

				System.err.println("---USER IS A ADMIN---");
				System.err.println("ADMIN: " + admin);

				model.addAttribute("admin", admin);
				session.setAttribute("admin", admin);
			}
			session.setAttribute("user", user);
			session.setAttribute("userAccountInfo", userAccountInfo);

			return "homePage";

		} else {

			return "Login/login";
		}
	}

//	logout.do removes the user from session and redirects to index.do.
	@RequestMapping(path = "logout.do")
	public String logout(HttpSession session) {
		System.err.println("---LOG OUT IN USER---");
		session.removeAttribute("userAccountInfo");
		session.removeAttribute("user");
		return "homePage";
	}

	// admin only
	// display all user accounts
	@RequestMapping(path = "adminAccountInformation.do", method = RequestMethod.GET)
	public String adminViewManageAccounts(RedirectAttributes redir, Model model, HttpSession session) {

		// user in session
		User admin = (User) session.getAttribute("admin");

		System.out.println(admin.getRole());

		Integer userId = admin.getId();
		List<User> listUserAccounts = null;

		listUserAccounts = userDao.findAllUsers();
		model.addAttribute("listUserAccounts", listUserAccounts);
		session.setAttribute("listUserAccounts", listUserAccounts);

		return "Admin";
	}

	// CREATE NEW USER ACCOUNT
	@RequestMapping(path = "CreateUser.do", method = RequestMethod.POST)
	public String addNewUser(Model model, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String username, @RequestParam String password) {
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setActive(1);
		newUser.setRole("User");
		newUser = userDao.createUser(newUser);
		model.addAttribute("user", newUser);
		return "homePage";
	}

	@RequestMapping(path = "CreateUser.do", method = RequestMethod.GET)
	public String addUserGetProcess(User user) {
		return "Login/account";
	}

	// UPDATE USER
	@RequestMapping(path = "UpdateUser.do", method = RequestMethod.GET)
	public String updateUser(RedirectAttributes redir, Model model, User user, HttpSession session) {

		// user in session
		User userInSession = (User) session.getAttribute("user");

		// start update
		User updatedUser = userDao.updateUser(user);

		// add updated user to the session
		session.setAttribute("user", updatedUser);

		// get new user account information
		Integer updatedUserId = updatedUser.getId();
		User userAccountInfo = userDao.findById(updatedUserId);

		// add new user to the model
		model.addAttribute("userAccountInfo", userAccountInfo);

		return "Login/account";

	}

	// UPDATE USER
	@RequestMapping(path = "changeUserRole.do", method = RequestMethod.GET)
	public String changeUserRole(RedirectAttributes redir, Model model, Integer userId, HttpSession session) {

		// user in session
		User userInSession = (User) session.getAttribute("user");
		
		
		System.err.println("USER FROM SESSION");
		System.out.println ("USER: "+userInSession);
		
		System.err.println("USER FROM PARAM");
		System.out.println("USER ID: "+ userId);
		
		User userRoleToChange=userDao.findById(userId);
		
		// start update
		User userRoleChanged = userDao.changeRole(userRoleToChange, userId);

		// add updated user to the session
		session.setAttribute("user", userRoleChanged);

		// get new user account information
		Integer updatedUserId = userRoleChanged.getId();
		User userAccountInfo = userDao.findById(updatedUserId);

		// add new user to the model
		model.addAttribute("userAccountInfo", userAccountInfo);
		session.setAttribute("userAccountInfo", userAccountInfo);
		return "redirect:adminAccountInformation.do";

	}

	// Deactivate User
	@RequestMapping(path = "deactivateUser.do", method = RequestMethod.GET)
	public String deactivateUser(RedirectAttributes redir, Model model, Integer userId, HttpSession session) {

		// user in session
		User userInSession = (User) session.getAttribute("user");
		
		

		System.err.println("USER FROM SESSION");
		System.out.println ("USER: "+userInSession);
		
		System.err.println("USER FROM PARAM");
		System.out.println("USER ID: "+ userId);
		
		User userToDeactivate=userDao.findById(userId);

		// start deactivation
		User deactivatedUser = userDao.activateUserStatus(userToDeactivate, userId);

		System.err.println("---Deactivate User---");
		System.out.println("WAS DEACTIVATED?" + deactivatedUser);

		// add updated user to the session
		model.addAttribute(deactivatedUser);
		session.setAttribute("deactivatedUser", deactivatedUser);

		if (userInSession.getRole().equalsIgnoreCase("Admin")) {

			return "redirect:adminAccountInformation.do";

		} else if (userInSession.getRole().equalsIgnoreCase("User")) {

			return "redirect:logout.do";

		}
		return null;
	}

	// DELETE USER
	@RequestMapping(path = "DeleteUser.do", method = RequestMethod.POST)
	public String deleteUser(RedirectAttributes redir, Model model, User user, Integer userId, HttpSession session) {

		User userInSession = (User) session.getAttribute("user");

		boolean userDeleted = userDao.deleteUser(userId);
		model.addAttribute("deletedUser", userDeleted);
		session.removeAttribute("user");

		System.out.println("user was deleted");
		return "redirect:homepage.do";

	}

	// DEACTIVATE ACCOUNT?
	@RequestMapping(path = "DeleteUser.do", method = RequestMethod.GET)
	public String deleteUserGetProcess(User user) {
		return "Login/DeleteUser";
	}

	// REDIRECT METHODS
	@RequestMapping("directToLogin.do")
	public String directToLogin() {
		return "Login/login";
	}

	@RequestMapping("directToCreateUser.do")
	public String directToCreateUser() {
		return "Login/CreateUser";
	}

	@RequestMapping("directToUpdateUser.do")
	public String directToUpdateUser(Integer userId, Model model) {

		System.out.println("********************");
		System.err.println("---DIRECT TO UPDATE USER.DO---");
		System.out.println("User Id:  " + userId);
		System.out.println("UserDAO:  " + userDao);
		System.out.println("********************");
		User userUpdate = userDao.findById(userId);
		model.addAttribute("userUpdate", userUpdate);

		return "Login/UpdateUser";
	}

	@RequestMapping("directToHomePage.do")
	public String directToHomePage() {
		return "homePage";
	}

	@RequestMapping("directToAccount.do")
	public String directToAccount() {
		return "Login/account";
	}

	@RequestMapping("directToStretchGoalMessage.do")
	public String directToStretchGoalMessage() {
		return "StretchGoal";
	}

}
