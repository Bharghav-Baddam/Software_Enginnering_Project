package com.buddyfinder.main.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.buddyfinder.main.repository.AccountRepository;

@Controller
public class HomeController {

	@Autowired
	AccountRepository accountRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="")
	public String getHome(Model model) {
		
		//pass data 
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/admin")
	public String getAdmin(Model model, HttpSession session) {
		model.addAttribute("Accounts", accountRepository.findAll());
		return "adminpanel";
	}
}
