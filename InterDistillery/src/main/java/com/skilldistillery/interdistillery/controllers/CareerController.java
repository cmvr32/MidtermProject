package com.skilldistillery.interdistillery.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.interdistillery.data.CareerDAO;
import com.skilldistillery.interdistillery.entities.Career;

public class CareerController {

//	@Autowired
//	private CareerDAO careerdao;
//
//	@RequestMapping(path = { "/", "home.do" })
//	public String home(Model model) {
//		model.addAttribute("DEBUG", careerdao.findById(1)); // DEBUG REMOVE LATER
//		return "homePage";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String singleCareer(int id, Model model) {
//		List<Career> careers = new ArrayList<>();
//		careers.add(careerdao.findById(id));
//		model.addAttribute("careers", careers);
//		return "";
//	}
//
//	@RequestMapping(path = ".do")
//	public String getAllCareers(Model model) {
//		List<Career> careers = careerdao.findAllCareers();
//		model.addAttribute("careers", careers);
//		return "";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.POST)
//	public String addCareer(RedirectAttributes redir, Career careers) {
//		careers = careerdao.addNewCareer(careers);
//		boolean addSpendingFlag = true;
//		redir.addFlashAttribute("addCareerFlag", addCareerFlag);
//		redir.addFlashAttribute("careers", careers);
//		return "redirect:.do";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String addCareerGetProcess(Career career) {
//		return "";
//	}
//
//	@RequestMapping(path = ".do")
//	public String addNewCareer() {
//		return "";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.POST)
//	public String deleteCareer(RedirectAttributes redir, int id) {
//		boolean containsFlag = careerdao.deleteCareer(id);
//		boolean deleteCareerFlag = true;
//		redir.addFlashAttribute("deleteCareerFlag", deleteCareerFlag);
//		redir.addFlashAttribute("containsFlag", containsFlag);
//		return "redirect:deleteSpending.do";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String deleteCareerGetProcess(Career career) {
//		return "";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.POST)
//	public String updateCareer(RedirectAttributes redir, Career career) {
//		boolean updateCareerFlag = true;
//		career = careerdao.updateCareer(career);
//		redir.addFlashAttribute("updateCareerFlag", updateCareerFlag);
//		redir.addFlashAttribute("career", career);
//		return "redirect:.do";
//	}
//
//	@RequestMapping(path = ".do", method = RequestMethod.GET)
//	public String updateCareerGetProcess(Career career) {
//		return "";
//	}
//
//	@RequestMapping(path = ".do")
//	public String updateCareerPage(Model model, int id) {
//		Career career = careerdao.findById(id);
//		model.addAttribute("career", career);
//		return "";
//	}

}
