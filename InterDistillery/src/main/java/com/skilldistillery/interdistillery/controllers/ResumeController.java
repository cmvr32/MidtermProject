package com.skilldistillery.interdistillery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.interdistillery.data.ResumeDAO;

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

//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String singleResume(int id, Model model) {
//		List<Resume> resumes = new ArrayList<>();
//		resumes.add(resumeDao.findResumeById(id));
//		model.addAttribute("resumes", resumes);
//		return "";
//	}
//
//	@RequestMapping(path = ".do")
//	public String Resume(Model model) {
//		List<Resume> resumes = resumeDao.findAllResumes();
//		model.addAttribute("resumes", resumes);
//		return "";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.POST)
//	public String addInterview(RedirectAttributes redir, Resume resumes) {
//		resumes = resumeDao.addNewResume(resumes);
//		boolean addResumeFlag = true;
//		redir.addFlashAttribute("addResumeFlag", addResumeFlag);
//		redir.addFlashAttribute("resumes", resumes);
//		return "redirect:.do";
//	}
//
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
//		Resume resumes = resumeDao.findById(id);
//		model.addAttribute("resumes", resumes);
//		return "";
//	}
}
