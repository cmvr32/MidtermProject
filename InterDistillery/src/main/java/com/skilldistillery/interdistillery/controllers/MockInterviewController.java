package com.skilldistillery.interdistillery.controllers;

import java.sql.Time;
import java.util.Date;

import javax.servlet.http.HttpSession;

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

//	@RequestMapping(path = {"ViewMockInterview.do" })
//	public String home(Model model) {
//		model.addAttribute("DEBUG", mockInterviewDao.findByMockIntervieweeId(1)); // DEBUG REMOVE LATER
//		return "homePage";
//	}

	@RequestMapping(path = { "ViewMockInterview.do" })
	public String home(Model model) {
		model.addAttribute("VIEWINTERVIEWS", mockInterviewDao.findByMockIntervieweeId(1)); // DEBUG REMOVE LATER
		return "homePage";
	}

	// create interview
	@RequestMapping(path = "CreateInterview.do", method = RequestMethod.POST)
	public String addInterview(Model model, 
			@RequestParam MockInterview interview,
			@RequestParam MockInterview interviewDate, 
			@RequestParam MockInterview interviewTime, 
			@RequestParam String topic,
			HttpSession session) {
		
		User newUser = new User();
		newUser.addMockInterviewAppointments(interview);
		newUser.addMockInterview(interviewDate);
		newUser.addMockInterviewAppointments(interviewTime);
//		newUser.addJobListing(topic);
		model.addAttribute("user", newUser);
		return "mockinterview/MockInterviewResources";
	}

	@RequestMapping(path = "CreateInterview.do", method = RequestMethod.GET)
	public String addInterviewGetProcess(User user) {
		return "mockinterview/MockInterviewResources";
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
//	public String deleteInterviewGetProcess(MockInterview interviews) {
//		return "";
//	}

	// TODO FINSH UPDATE
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

	// Redirect Methods:

	@RequestMapping("directToRequestMockInterview.do")
	public String directToRequestMockInterview() {
		return "mockinterview/RequestMockInterview";
	}

	@RequestMapping("directToViewMockInterviewRequest.do")
	public String directToViewMockInterviewRequest() {
		return "mockinterview/ViewMockInterviewRequest";
	}

	@RequestMapping("directToDeleteMockInterview.do")
	public String directToDeleteMockInterview() {
		return "mockinterview/DeleteMockInterview";
	}

	@RequestMapping("directToUpdateMockInterview.do")
	public String directToUpdateMockInterview() {
		return "mockinterview/UpdateMockInterview";
	}

	@RequestMapping("directToMockInterviewResources.do")
	public String directToMockInterviewResources() {
		return "mockinterview/MockInterviewResources";
	}
}
