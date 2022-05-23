package com.skilldistillery.interdistillery.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.interdistillery.data.ResumeDAO;
import com.skilldistillery.interdistillery.data.StudyGuideDAO;
import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.StudyGuide;

public class StudyGuideController {
	@Autowired
	private StudyGuideDAO studyGuideDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home(Model model) {
		model.addAttribute("DEBUG", studyGuideDao.); // DEBUG REMOVE LATER
		return "homePage";
	}

	@RequestMapping(path = ".do", method = RequestMethod.GET)
	public String studyGuide(int id, Model model) {
		List<StudyGuide> studyGuides = new ArrayList<>();
		studyGuides.add(studyGuideDao.));
		model.addAttribute("StudyGuides", studyGuides);
		return "";
	}

	@RequestMapping(path = ".do", method = RequestMethod.GET)
	public String singleStudyGuide(int id, Model model) {
		List<StudyGuide> studyGuides = new ArrayList<>();
		studyGuides.add(studyGuideDao.findResumeById(id));
		model.addAttribute("studyGuides", studyGuides);
		return "";
	}

	@RequestMapping(path = ".do")
	public String StudyGuide(Model model) {
		List<StudyGuide> studyGuides = studyGuideDao.findAllResumes();
		model.addAttribute("studyGuides", studyGuides);
		return "";
	}

	@RequestMapping(path = ".do", method = RequestMethod.POST)
	public String addStudyGuide(RedirectAttributes redir, StudyGuide studyGuides) {
		studyGuides = studyGuideDao.addNewResume(studyGuides);
		boolean addStudyGuideFlag = true;
		redir.addFlashAttribute("addStudyGuideFlag", addStudyGuideFlag);
		redir.addFlashAttribute("studyGuides", studyGuides);
		return "redirect:.do";
	}

	@RequestMapping(path = ".do", method = RequestMethod.GET)
	public String addStudyGuideGetProcess(StudyGuide studyGuides) {
		return "";
	}

	@RequestMapping(path = ".do")
	public String addNewStudyGuide() {
		return "";
	}

	@RequestMapping(path = ".do", method = RequestMethod.POST)
	public String deleteStudyGuide(RedirectAttributes redir, int id) {
		boolean containsFlag = studyGuideDao.deleteStudyGuide(id);
		boolean deleteStudyGuideFlag = true;
		redir.addFlashAttribute("deleteResumeFlag", deleteStudyGuideFlag);
		redir.addFlashAttribute("containsFlag", containsFlag);
		return "redirect:.do";
	}

	@RequestMapping(path = ".do", method = RequestMethod.GET)
	public String deleteStudyGuideGetProcess(StudyGuide studyGuides) {
		return "";
	}

	@RequestMapping(path = ".do", method = RequestMethod.POST)
	public String updateStudyGuide(RedirectAttributes redir, StudyGuide studyGuides) {
		boolean updateStudyGuideFlag = true;
		studyGuides = studyGuideDao.updateStudyGuide(studyGuides);
		redir.addFlashAttribute("updateStudyGuideFlag", updateStudyGuideFlag);
		redir.addFlashAttribute("resumes", studyGuides);
		return "redirect:.do";
	}

	@RequestMapping(path = ".do", method = RequestMethod.GET)
	public String updateStudyGuideGetProcess(StudyGuide studyGuides) {
		return "";
	}

	@RequestMapping(path = ".do")
	public String Resume(Model model, int id) {
		StudyGuide studyGuides = studyGuideDao.findById(id);
		model.addAttribute("studyGuides", studyGuides);
		return "";
	}

}
