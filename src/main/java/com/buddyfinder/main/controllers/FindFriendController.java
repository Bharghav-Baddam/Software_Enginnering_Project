package com.buddyfinder.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FindFriendController {

	@RequestMapping(method=RequestMethod.GET, value="/findfriend")
	public String findFriend(Model model) {
		return "findfriend";
	}

}
