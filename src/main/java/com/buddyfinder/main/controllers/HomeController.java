package com.buddyfinder.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@RequestMapping(method=RequestMethod.GET, value="/home")
	public ModelAndView getHome(ModelAndView model) {
		
		model.setViewName("home");
		return model;
	}
}
