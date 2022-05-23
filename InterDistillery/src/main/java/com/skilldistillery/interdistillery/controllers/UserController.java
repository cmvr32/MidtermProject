package com.skilldistillery.interdistillery.controllers;

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

	@RequestMapping(path = { "/", "homePage.do" })
	public String home(Model model) {
		model.addAttribute("DEBUG", userDao.findById(1)); // DEBUG REMOVE LATER
		return "homePage";
	}

	@RequestMapping(path = { "/", "home.do" })
	public String home1(@RequestParam Integer id, Model model) {
		model.addAttribute("FINDBYID", userDao.findById(id)); // DEBUG REMOVE LATER
		return "homePage";
	}

	@RequestMapping("getUser.do")
	public String findUserAccountByNameAndEmail(@RequestParam String firstName, String lastName, String email,
			Model model) {
		User user = userDao.findUserAccountByNameAndEmail(firstName, lastName, email);
		model.addAttribute("user", user);
		return "login/account";
	}

	@RequestMapping("getUser.do")
	public String findByUserNameAndPassword(@RequestParam String username, String password, Model model) {
		User user = userDao.findByUserNameAndPassword(username, password);
		model.addAttribute("user", user);
		return "login/account";
	}

	@RequestMapping(path = "CreateUser.do", method = RequestMethod.POST)
	public String AddNewUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String userName, @RequestParam String password, RedirectAttributes redir, User user) {
		User newUser = new User(firstName, lastName, email, userName, password);
		user = userDao.createUser(user);
		boolean addUserFlag = true;
		redir.addFlashAttribute("addUserFlag", addUserFlag);
		redir.addFlashAttribute("studyGuides", user);
		return "redirect:.do";
	}

	@RequestMapping(path = "CreateUser.do", method = RequestMethod.GET)
	public String addUserGetProcess(User user) {
		return "account";
	}

	@RequestMapping(path = "CreateUser.do")
	public String addNewUser() {
		return "";
	}

	@RequestMapping("directToLogin.do")
	public String directToLogin() {
		return "Login/login";
	}

	@RequestMapping("directToCreateUser.do")
	public String directToCreateUser() {
		return "Login/CreateUser";
	}

//	@RequestMapping(path = ".do", method = RequestMethod.POST)
//	public String updateUserBiography(RedirectAttributes redir, User user) {
//		boolean updateUserBiographyFlag = true;
//		user = userDao.updateUserfristNameLastName(null, null);
//		redir.addFlashAttribute("updateUserBiographyFlag", updateUserBiographyFlag);
//		redir.addFlashAttribute("user", user);
//		return "redirect:.do";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String updateUserBiographyGetProcess(User user) {
//		return "";
//	}
//
//	@RequestMapping(path = ".do")
//	public String updateUserBiographyPage(Model model, int id) {
//		User user = userDao.findById(id);
//		model.addAttribute("user", user);
//		return "";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.POST)
//	public String updateUserfristNameLastName(RedirectAttributes redir, User user) {
//		boolean updateUserFirstNameLastNameFlag = true;
//		user = userDao.updateUserfristNameLastName(null, null);
//		redir.addFlashAttribute("updateUserFirstNameLastNameFlag", updateUserFirstNameLastNameFlag);
//		redir.addFlashAttribute("user", user);
//		return "redirect:.do";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String updateUserfristNameLastNameGetProcess(User user) {
//		return "";
//	}
//
//	@RequestMapping(path = ".do")
//	public String updateUserfristNameLastNamePage(Model model, int id) {
//		User user = userDao.findById(id);
//		model.addAttribute("user", user);
//		return "";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.POST)
//	public String updateUserEmail(RedirectAttributes redir, User user) {
//		boolean updateUserEmailFlag = true;
//		user = userDao.updateUserEmail(0, null);
//		redir.addFlashAttribute("updateUserEmailFlag", updateUserEmailFlag);
//		redir.addFlashAttribute("user", user);
//		return "redirect:.do";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String updateUserEmailGetProcess(User user) {
//		return "";
//	}
//
//	@RequestMapping(path = ".do")
//	public String updateUserEmailPage(Model model, int id) {
//		User user = userDao.findById(id);
//		model.addAttribute("user", user);
//		return "";
//	}

//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String updateUser(RedirectAttributes redir, @RequestParam String firstName, @RequestParam String lastName,
//			@RequestParam String email, @RequestParam String userName, @RequestParam String password,
//			@RequestParam String profileImageUrl, @RequestParam String profileBannerUrl,
//			@RequestParam String biography) {
//
//		boolean updateUserEmailFlag = true;
//
//		User user = userDao.findUserAccountByNameAndEmail(firstName, lastName, email);
//
//		userDao.updateUser(user);
//		redir.addFlashAttribute("updateUserEmailFlag", updateUserEmailFlag);
//		redir.addFlashAttribute("user", user);
//		return "redirect:.do";
//
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.POST)
//	public String deleteUser(RedirectAttributes redir, @RequestParam String firstName, @RequestParam String lastName,
//			@RequestParam String email) {
//
//		User user = userDao.findUserAccountByNameAndEmail(firstName, lastName, email);
//		Integer userId = user.getId();
//		boolean containsFlag = userDao.deleteUser(userId);
//		boolean deleteUserFlag = true;
//		redir.addFlashAttribute("deleteUserFlag", deleteUserFlag);
//		redir.addFlashAttribute("containsFlag", containsFlag);
//		return "redirect:.do";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String deleteUserGetProcess(User user) {
//		return "";
//	}

}
