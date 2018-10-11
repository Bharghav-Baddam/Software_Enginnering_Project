package com.buddyfinder.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buddyfinder.main.models.Friend;
import com.buddyfinder.main.services.Search;

@Controller
@RequestMapping("/search")
public class FindFriendController {
	
	@Autowired
	private Search search;

	@RequestMapping(method=RequestMethod.GET, value="")
	public String findFriend(Model model) {

		return "search";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/findfriends")
	public String findFriend(@RequestParam String location, @RequestParam String activity,
			@RequestParam String date, Model model) {
		System.out.println(location);
		//search.getFriends will have params passed by @RequestParam annotation
		//model.addAttribute("Friends", search.getFriends(location, activity, date));
		model.addAttribute("Friends", search.getFriends(location, activity, date));
		return "friends";
	}
	

}



