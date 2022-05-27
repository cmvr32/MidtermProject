package com.skilldistillery.interdistillery.controllers;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.interdistillery.data.MockInterviewDAO;
import com.skilldistillery.interdistillery.data.UserDAO;
import com.skilldistillery.interdistillery.entities.MockInterview;
import com.skilldistillery.interdistillery.entities.User;

@Controller
public class MockInterviewController {

	@Autowired
	private MockInterviewDAO mockInterviewDao;

	@Autowired
	private UserDAO userDao;

	@RequestMapping(path = { "ViewMockInterview.do" })
	public String home(Model model) {
		model.addAttribute("VIEWINTERVIEWS", mockInterviewDao.findByMockIntervieweeId(1)); // DEBUG REMOVE LATER
		return "homePage";
	}

	//CREATE
	@RequestMapping(path = "RequestMockInterview.do", method = RequestMethod.GET)
	public String addInterview(RedirectAttributes redir, Model model, Date interviewDate, 
			String name, String topic, String interviewType, String level, String other, HttpSession session) {

		
		User user = (User) session.getAttribute("user");

		MockInterview newInterview = new MockInterview();

		newInterview.setInterviewDate(interviewDate);
		newInterview.setTopic(topic);

		newInterview = mockInterviewDao.createInterview(newInterview, user);

		System.out.println(newInterview);
		System.out.println("********************");
		model.addAttribute("mockInterview", newInterview);
		session.setAttribute("mockInterview", newInterview);

		return "mockinterview/MockInterviewResources";
	}

	//DELETE
	@RequestMapping(path = "DeleteMockInterview.do", method = RequestMethod.POST)
	public String deleteInterview(RedirectAttributes redir, Model model, Integer interviewId, 
			HttpSession session) {
		
		System.err.println("DELETE INTERVIEW");
	
	
		User userInSession = (User) session.getAttribute("user");
	
		int userId = userInSession.getId();
		
		System.out.println("userId: " + userId);
		System.out.println("interview id: " + interviewId);
		
		
		boolean interviewDeleted = mockInterviewDao.deleteInterview(interviewId);
		model.addAttribute("interviewDeleted", interviewDeleted);

		System.out.println("Interview was deleted!");
		return "redirect:ViewMockInterviewRequest.do";
	}


	// find all interviews for a user
	@RequestMapping(path = "ViewMockInterviewRequest.do", method = RequestMethod.GET)
	public String getAllInterview(RedirectAttributes redir, Model model, User user, HttpSession session) {

		User userInSession = (User) session.getAttribute("user");
		Integer userInSessionId = userInSession.getId();

		System.err.println("Interview Controller, Interview Request Method " + userInSessionId);
		System.err.println("USER ID: " + userInSessionId);
		System.err.println("USER DAO: " + userDao);

		List<MockInterview> interviews = userDao.userFindMockInterview(userInSession, userInSessionId);
		System.out.println("MockInterviews: " + interviews);

		model.addAttribute("interviews", interviews);
		session.setAttribute("interviews", interviews);
		return "mockinterview/ViewMockInterviewRequest";
	}

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
