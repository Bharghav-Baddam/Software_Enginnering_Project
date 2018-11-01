package com.buddyfinder.main.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.buddyfinder.main.repository.AccountRepository;
import com.buddyfinder.main.services.AuthService;

@Controller
public class HomeController {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AuthService authService;
	
	@RequestMapping(method=RequestMethod.GET, value="/home")
	public ModelAndView getHome(ModelAndView modelAndView, HttpSession session) {
		
		modelAndView.setViewName("home");
		if (authService.isSessionAlive(session.getId())) {
			session.setAttribute("account", authService.getSession(session.getId()));
		}
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/adminpanel")
	public String getAdmin(Model model, HttpSession session) {
		model.addAttribute("Accounts", accountRepository.findAll());
		return "adminpanel";
	}
}
