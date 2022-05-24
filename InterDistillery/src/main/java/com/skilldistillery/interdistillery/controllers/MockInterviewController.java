package com.skilldistillery.interdistillery.controllers;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.interdistillery.data.MockInterviewDAO;
import com.skilldistillery.interdistillery.entities.MockInterview;
import com.skilldistillery.interdistillery.entities.User;

@Controller
public class MockInterviewController {

	@Autowired
	private MockInterviewDAO mockInterviewDao;

	@RequestMapping(path = {"ViewMockInterview.do" })
	public String home(Model model) {
		model.addAttribute("DEBUG", mockInterviewDao.findByMockIntervieweeId(1)); // DEBUG REMOVE LATER
		return "homePage";
	}
	
	//create interview
	@RequestMapping(path = "CreateInterview.do", method = RequestMethod.POST)
	public String addInterview(RedirectAttributes redir,
							  @RequestParam MockInterview interview, 
							  @RequestParam Date interviewDate, 
							  @RequestParam Time interviewTime,
							  @RequestParam String topic) {
		MockInterview newMockInterview = new MockInterview(interviewDate, interviewTime, topic);
		interview = mockInterviewDao.createInterview(interview);
		boolean addInterviewFlag = true;
		redir.addFlashAttribute("addInterviewsFlag", addInterviewFlag);
		redir.addFlashAttribute("careers", interview);
		return "resume/ViewResume";
	}



	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public String deleteInterview(RedirectAttributes redir, int id) {
		boolean containsFlag = mockInterviewDao.deleteInterview(id);
		boolean deleteInterviewFlag = true;
		redir.addFlashAttribute("deleteInterviewFlag", deleteInterviewFlag);
		redir.addFlashAttribute("containsFlag", containsFlag);
		return "homepage.do";
	}
	
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String addInterviewsGetProcess(MockInterview interviews) {
//		return "";
//	}

//	@RequestMapping(path = ".do")
//	public String addNewInterview() {
//		return "";
//	}

//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String deleteInterviewGetProcess(MockInterview interviews) {
//		return "";
//	}

	
	//TODO FINSH UPDATE
//	@RequestMapping(path = "update.do", method = RequestMethod.POST)
//	public String updateInterview(RedirectAttributes redir, MockInterview interviews) {
//		boolean updateInterviewFlag = true;
//		interviews = mockInterviewDao.updateInterview(interviews);
//		redir.addFlashAttribute("updateInterviewFlag", updateInterviewFlag);
//		redir.addFlashAttribute("career", interviews);
//		return "homepage.do";
//	}

//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String updateInterviewGetProcess(MockInterview interviews) {
//		return "";
//	}
//
//	@RequestMapping(path = ".do")
//	public String Interview(Model model, int id) {
//		MockInterview interviews = mockInterviewDao.findById(id);
//		model.addAttribute("interviews", interviews);
//		return "";
//	}
	
//	@RequestMapping(path = "ViewSingleMockInterview.do", method = RequestMethod.GET)
//	public String singleInterview(User user, Model model) {
//		List<MockInterview> interviews = new ArrayList<>();
//		interviews.add(mockInterviewDao.findByInterviewId(user));
//		model.addAttribute("interviews", interviews);
//		return "mockinterview/ViewMockInterview";
//	}
//
//	//find all interviews for a user
//	@RequestMapping(path = "ViewAllInterviews.do", method =RequestMethod.GET)
//	public String getAllInterview( Model model,
//								@RequestParam int userId) {
//		
//		
//		List<MockInterview> interviews = mockInterviewDao.findAllMockInterviewsForUser();
//		model.addAttribute("interviews", interviews);
//		return "mockinterview/ViewMockInterview";
//	}

	
	//Redirect Methods:
	
	@RequestMapping("directToRequestMockInterview.do")
	public String directToRequestMockInterview() {
		return "mockinterview/RequestMockInterview";
	}
}
