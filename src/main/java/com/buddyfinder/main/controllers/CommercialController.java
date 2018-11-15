package com.buddyfinder.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.buddyfinder.main.services.Search;

@RequestMapping("/commercialpanel")
@Controller
public class CommercialController {
	@Autowired
	private Search search;
	@RequestMapping(method=RequestMethod.POST,value="/action")
	public String getUsers(Model model,@RequestParam String activity) {
		System.out.println(activity);
		model.addAttribute("users", search.getActivities(activity,"", null));
		return "users";
	}
}
