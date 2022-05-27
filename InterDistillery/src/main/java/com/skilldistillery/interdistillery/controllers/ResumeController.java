package com.skilldistillery.interdistillery.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.interdistillery.data.ResumeDAO;
import com.skilldistillery.interdistillery.data.UserDAO;
import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.User;

@Controller
public class ResumeController {

	@Autowired
	private ResumeDAO resumeDao;

	@Autowired
	private UserDAO userResumeDao;

	// START: Home Page
	@RequestMapping(path = { "/", "homePage.do" })
	public String home(Model model) {
		model.addAttribute("DEBUG", resumeDao.findResumeById(1)); // DEBUG REMOVE LATER
		return "homePage";
	}

	// VIEW RESUME
	@RequestMapping(path = "ViewResume.do", method = RequestMethod.GET)
	public String viewUserResumes(Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");
		List<Resume> userResumes = new ArrayList<>();

		userResumes.addAll(userResumeDao.findAllCurrentUserResumes(user));

		model.addAttribute("userResumes", userResumes);

		return "resume/ViewResume";
	}

	// CRUD OPERATIONS

	// CREATE RESUME
	@RequestMapping(path = "CreateResume.do", method = RequestMethod.POST)
	public String addResume(RedirectAttributes redir, Model model, @RequestParam String contactInfo, @RequestParam String introduction,
			@RequestParam String experience, String education, String skills, String certs, String other, HttpSession session) {
		
		Integer degree =1;
		
		User user = (User) session.getAttribute("user");
		Resume newResume = new Resume();
		newResume.setContactInfo(contactInfo);
		newResume.setIntroduction(introduction);
		newResume.setExperience(experience);
		newResume.setDegree(degree);
		newResume = resumeDao.createResume(newResume, user);
		// boolean addResumeFlag = true;
		// redir.addFlashAttribute("addResumeFlag", addResumeFlag);
		model.addAttribute("resume", newResume);
		return "resume/ResumeResources";
	}

	// UPDATE RESUME
	@RequestMapping(path = "updateResume.do", method = RequestMethod.GET)
	public String updateResume(RedirectAttributes redir, Model model, Resume resume, HttpSession session) {

		System.out.println("********************");
		System.err.println("---DELETERESUME.DO---");
		System.out.println("Resume Id:  " + resume);
		System.out.println("ResumeDAO:  " + resumeDao);
		System.out.println("********************");

		// user in session
		User user = (User) session.getAttribute("user");
		int userId = user.getId();
		Resume updatedResume = resumeDao.updateResume(resume);
		model.addAttribute("editResume", updatedResume);

		return "redirect:ViewResume.do";

	}

	// DELETE RESUME
	@RequestMapping(path = "deleteResume.do", method = RequestMethod.POST)
	public String deleteResume(RedirectAttributes redir, Model model, Resume resume, Integer resumeId,
			HttpSession session) {

		// user in session
		User user = (User) session.getAttribute("user");
		int userId = user.getId();

		boolean resumeDeleted = resumeDao.deleteResume(resumeId);
		model.addAttribute("deletedResume", resumeDeleted);

		return "redirect:ViewResume.do";
	}

	// Redirect Methods:
	@RequestMapping("directToAddResume.do")
	public String directToAddResume() {
		return "resume/CreateResume";
	}

	@RequestMapping("directToResumeResources.do")
	public String directToResumeResources() {
		return "resume/ResumeResources";
	}

	@RequestMapping("directToDeleteResume.do")
	public String directToDeleteResume() {
		return "resume/DeleteResume";
	}

	@RequestMapping("directToUpdateResume.do")
	public String directToUpdateResume(Integer resumeId, Model model) {
		System.out.println("********************");
		System.err.println("---DIRECT TO UPDATE RESUME.DO---");
		System.out.println("Resume Id:  " + resumeId);
		System.out.println("ResumeDAO:  " + resumeDao);
		System.out.println("********************");
		Resume userResume = resumeDao.findResumeById(resumeId);
		model.addAttribute("editResume", userResume);
		return "resume/UpdateResume";
	}

	@RequestMapping("directToViewResume.do")
	public String directToViewResume(Integer resumeId, Model model) {

		return "resume/DeleteResume";
	}

}
