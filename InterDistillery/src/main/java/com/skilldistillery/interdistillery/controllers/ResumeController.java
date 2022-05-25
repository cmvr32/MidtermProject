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

	@RequestMapping(path = { "/", "homePage.do" })
	public String home(Model model) {
		model.addAttribute("DEBUG", resumeDao.findResumeById(1)); // DEBUG REMOVE LATER
		return "homePage";
	}

	
//
//	@RequestMapping("getResumes.do")
//	public String directToUpdateResume2(Model model, HttpSession session) {
//
//		User user = (User) session.getAttribute("user");
//		List<Resume> userResumes = new ArrayList<>();
//
//		userResumes.addAll(userResumeDao.findAllCurrentUserResumes(user));
//
//		model.addAttribute("userResumes", userResumes);
//
//		return "resume/UpdateResume";
//	}

	@RequestMapping(path = "ViewResume.do", method = RequestMethod.GET)
	public String viewUserResumes(Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");
		List<Resume> userResumes = new ArrayList<>();

		userResumes.addAll(userResumeDao.findAllCurrentUserResumes(user));

		model.addAttribute("userResumes", userResumes);

//		List<Resume> resumes = new ArrayList<>();
//		resumes.add(resumeDao.findResumeById(user));
//		model.addAttribute("resumes", resumes);

		return "resume/ViewResume";
	}

//	@RequestMapping(path = ".do")
//	public String Resume(Model model) {
//		List<Resume> resumes = resumeDao.findAllResumes();
//		model.addAttribute("resumes", resumes);
//		return "";
//	}

	@RequestMapping(path = "CreateResume.do", method = RequestMethod.POST)
	public String addResume(Model model, @RequestParam String contactInfo, @RequestParam String introduction,
			@RequestParam String experience, @RequestParam Integer degree, HttpSession session) {

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
		return "Login/account";
	}
	

//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String addResumeGetProcess(Resume resumes) {
//		return "";
//	}
//
//	@RequestMapping(path = ".do")
//	public String addNewResume() {
//		return "";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.POST)
//	public String deleteResume(RedirectAttributes redir, int id) {
//		boolean containsFlag = resumeDao.deleteResume(id);
//		boolean deleteResumeFlag = true;
//		redir.addFlashAttribute("deleteResumeFlag", deleteResumeFlag);
//		redir.addFlashAttribute("containsFlag", containsFlag);
//		return "redirect:.do";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String deleteResumeGetProcess(Resume resumes) {
//		return "";
//	}
//

	@RequestMapping(path = "updateResume.do", method = RequestMethod.GET)
	public String updateResume(RedirectAttributes redir, 
							   Model model, 
							   Resume resume, 
							   HttpSession session) {
	
		//user in session
		User user = (User) session.getAttribute("user");
		int userId = user.getId();
		Resume updatedResume = resumeDao.updateResume(resume);
		model.addAttribute("editResume", updatedResume);
		
		return "redirect:ViewResume.do";

	}
	
	
	//Redirect Methods:
	
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
		System.out.println("Resume Id:  " + resumeId);
		System.out.println("ResumeDAO:  " + resumeDao);
		System.out.println("********************");
		Resume userResume = resumeDao.findResumeById(resumeId);
		model.addAttribute("editResume", userResume);
		return "resume/UpdateResume";
	}
	@RequestMapping("directToViewResume.do")
	public String directToViewResume() {
		return "resume/ViewResume";
	}

}
