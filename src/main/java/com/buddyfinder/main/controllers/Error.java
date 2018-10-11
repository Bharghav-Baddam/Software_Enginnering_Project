package com.buddyfinder.main.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Error implements ErrorController{

	
	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "error";
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}

	
}
