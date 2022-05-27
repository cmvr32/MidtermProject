package com.skilldistillery.interdistillery.controllers;

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
import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.User;

@Controller
public class MockInterviewController {

	@Autowired
	private MockInterviewDAO mockInterviewDao;

	@Autowired
	private UserDAO userDao;

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
	@RequestMapping(path = "RequestMockInterview.do", method = RequestMethod.GET)
	public String addInterview(RedirectAttributes redir, Model model,
			@RequestParam MockInterview interviewDate, @RequestParam MockInterview interviewTime,
			@RequestParam String topic, HttpSession session) {

		User user = (User) session.getAttribute("user");
		
		MockInterview newInterview = new MockInterview();
		
		
		newInterview = mockInterviewDao.createInterview(newInterview, user);

		model.addAttribute("mockInterview", newInterview);
		session.setAttribute("mockInterview", newInterview);
		
		return "mockinterview/MockInterviewResources";
	}

	@RequestMapping(path = "CreateInterview.do", method = RequestMethod.GET)
	public String addInterviewGetProcess(User user) {
		return "mockinterview/MockInterviewResources";
	}

	@RequestMapping(path = "DeleteMockInterview.do", method = RequestMethod.POST)
	public String deleteInterview(RedirectAttributes redir, MockInterview mockInterview, int id, Model model,
			HttpSession session) {
		User userInSession = (User) session.getAttribute("user");

		boolean interDeleted = mockInterviewDao.deleteInterview(id);
		model.addAttribute("deletedUser", interDeleted);
		userInSession.removeMockInterview(mockInterview);

		System.out.println("Interview was deleted!");
		return "redirect:homepage.do";
	}

	@RequestMapping(path = "DeleteMockInterview.do", method = RequestMethod.GET)
	public String deleteInterviewGetProcess(MockInterview interviews) {
		return "Login/";
	}

	// UPDATE INTERVIEW
//	@RequestMapping(path = "EditMockInterview.do", method = RequestMethod.GET)
//	public String editMockInterview(RedirectAttributes redir, MockInterview interviews, HttpSession session) {
//
//		System.out.println("********************");
//		System.err.println("---DELETERESUME.DO---");
//		System.out.println("Resume Id:  " + interviews);
//		System.out.println("ResumeDAO:  " + mockInterviewDao);
//		System.out.println("********************");
//
//		// user in session
//		User user = (User) session.getAttribute("user");
//		int userId = user.getId();
//		MockInterview updatedInterview = mockInterviewDao.
//		model.addAttribute("editInterview", interviews);
//
//		return "mockinterview/ViewMockInterviewRequest";
//
//	}

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
