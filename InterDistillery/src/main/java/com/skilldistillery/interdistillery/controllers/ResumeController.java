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

import com.skilldistillery.interdistillery.data.ResumeDAO;
import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.User;

@Controller
public class ResumeController {

	@Autowired
	private ResumeDAO resumeDao;

//	@RequestMapping(path = { "/", "homePage.do" })
//	public String home(Model model) {
//		model.addAttribute("DEBUG", resumeDao.findResumeById(1)); // DEBUG REMOVE LATER
//		return "homePage";
//	}

	@RequestMapping("directToAddResume.do")
	public String directToAddResume() {
		return "resume/CreateResume";
	}

	@RequestMapping(path = "ViewResume.do", method = RequestMethod.GET)
	public String singleResume(int id, Model model) {
		List<Resume> resumes = new ArrayList<>();
		resumes.add(resumeDao.findResumeById(id));
		model.addAttribute("resumes", resumes);
		return "resume/CreateResume";
	}

//	@RequestMapping(path = ".do")
//	public String Resume(Model model) {
//		List<Resume> resumes = resumeDao.findAllResumes();
//		model.addAttribute("resumes", resumes);
//		return "";
//	}

	@RequestMapping(path = "CreateResume.do", method = RequestMethod.POST)
	public String addResume(Model model,
							@RequestParam String contactInfo,
							@RequestParam String introduction,
							@RequestParam String experience,
							@RequestParam Integer degree,
							HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		Resume newResume = new Resume();
		newResume.setContactInfo(contactInfo);
		newResume.setIntroduction(introduction);
		newResume.setExperience(experience);
		newResume.setDegree(degree);
		newResume = resumeDao.createResume(newResume, user);
		//boolean addResumeFlag = true;
		//redir.addFlashAttribute("addResumeFlag", addResumeFlag);
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
//	@RequestMapping(path = ".do", method = RequestMethod.POST)
//	public String updateResume(RedirectAttributes redir, Resume resumes) {
//		boolean updateResumeFlag = true;
//		resumes = resumeDao.updateResume(resumes);
//		redir.addFlashAttribute("updateResumeFlag", updateResumeFlag);
//		redir.addFlashAttribute("resumes", resumes);
//		return "redirect:.do";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String updateResumeGetProcess(Resume resumes) {
//		return "";
//	}
//
//	@RequestMapping(path = ".do")
//	public String Resume(Model model, int id) {
//		Resume resumes = resumeDao.findResumeById(id);
//		model.addAttribute("resumes", resumes);
//		return "";
//	}
}
