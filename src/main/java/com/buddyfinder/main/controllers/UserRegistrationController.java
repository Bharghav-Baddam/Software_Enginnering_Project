package com.buddyfinder.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.buddyfinder.beans.User;

@Controller
public class UserRegistrationController {

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String getRegisterUser(){
		return "userRegistraion";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user){
		
		
		return "";
	}
	
}
