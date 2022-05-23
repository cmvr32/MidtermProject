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

	@RequestMapping(path = { "/", "home.do" })
	public String home(Model model) {
		model.addAttribute("DEBUG", userDao.findById(1)); // DEBUG REMOVE LATER
		return "homePage";
	}

	@RequestMapping("getUser.do")
	public String findUserAccountByNameAndEmail(@RequestParam Integer fid, Model model) {
		User user = userDao.findByUserNameAndPassword(null, null);
		model.addAttribute("user", user);
		return "";
	}

	@RequestMapping("getUser.do")
	public String findByUserNameAndPassword(@RequestParam Integer fid, Model model) {
		User user = userDao.findUserAccountByNameAndEmail(null, null, null);
		model.addAttribute("user", user);
		return "";
	}

	@RequestMapping(path = ".do", method = RequestMethod.POST)
	public String AddNewUser(RedirectAttributes redir, User user) {
		user = userDao.createUser(user);
		boolean addUserFlag = true;
		redir.addFlashAttribute("addUserFlag", addUserFlag);
		redir.addFlashAttribute("studyGuides", user);
		return "redirect:.do";
	}

	@RequestMapping(path = ".do", method = RequestMethod.GET)
	public String addUserGetProcess(User user) {
		return "";
	}

	@RequestMapping(path = ".do")
	public String addNewUser() {
		return "";
	}

	@RequestMapping(path = ".do", method = RequestMethod.POST)
	public String updateUserBiography(RedirectAttributes redir, User user) {
		boolean updateUserBiographyFlag = true;
		user = userDao.updateUserfristNameLastName(null, null);
		redir.addFlashAttribute("updateUserBiographyFlag", updateUserBiographyFlag);
		redir.addFlashAttribute("user", user);
		return "redirect:.do";
	}

	@RequestMapping(path = ".do", method = RequestMethod.GET)
	public String updateUserBiographyGetProcess(User user) {
		return "";
	}

	@RequestMapping(path = ".do")
	public String updateUserBiographyPage(Model model, int id) {
		User user = userDao.findById(id);
		model.addAttribute("user", user);
		return "";
	}

	@RequestMapping(path = ".do", method = RequestMethod.POST)
	public String updateUserfristNameLastName(RedirectAttributes redir, User user) {
		boolean updateUserFirstNameLastNameFlag = true;
		user = userDao.updateUserfristNameLastName(null, null);
		redir.addFlashAttribute("updateUserFirstNameLastNameFlag", updateUserFirstNameLastNameFlag);
		redir.addFlashAttribute("user", user);
		return "redirect:.do";
	}

	@RequestMapping(path = ".do", method = RequestMethod.GET)
	public String updateUserfristNameLastNameGetProcess(User user) {
		return "";
	}

	@RequestMapping(path = ".do")
	public String updateUserfristNameLastNamePage(Model model, int id) {
		User user = userDao.findById(id);
		model.addAttribute("user", user);
		return "";
	}

	@RequestMapping(path = ".do", method = RequestMethod.POST)
	public String updateUserEmail(RedirectAttributes redir, User user) {
		boolean updateUserEmailFlag = true;
		user = userDao.updateUserEmail(0, null);
		redir.addFlashAttribute("updateUserEmailFlag", updateUserEmailFlag);
		redir.addFlashAttribute("user", user);
		return "redirect:.do";
	}

	@RequestMapping(path = ".do", method = RequestMethod.GET)
	public String updateUserEmailGetProcess(User user) {
		return "";
	}

	@RequestMapping(path = ".do")
	public String updateUserEmailPage(Model model, int id) {
		User user = userDao.findById(id);
		model.addAttribute("user", user);
		return "";
	}

	@RequestMapping(path = ".do", method = RequestMethod.POST)
	public String deleteUser(RedirectAttributes redir, int id) {
		boolean containsFlag = userDao.deleteUser(id, null, null, null, null);
		boolean deleteUserFlag = true;
		redir.addFlashAttribute("deleteUserFlag", deleteUserFlag);
		redir.addFlashAttribute("containsFlag", containsFlag);
		return "redirect:.do";
	}

	@RequestMapping(path = ".do", method = RequestMethod.GET)
	public String deleteUserGetProcess(User user) {
		return "";
	}

}
