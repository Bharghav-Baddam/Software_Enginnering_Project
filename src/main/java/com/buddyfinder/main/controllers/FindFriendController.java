package com.buddyfinder.main.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buddyfinder.main.forms.LoginForm;
import com.buddyfinder.main.services.AuthService;
import com.buddyfinder.main.services.Search;

@Controller
@RequestMapping("/search")
public class FindFriendController {
	
	@Autowired
	private Search search;
	
	@Autowired
	AuthService authService;

	@RequestMapping(method=RequestMethod.GET, value="")
	public String findFriend(Model model) {

		return "search";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/findfriends")
	public String findFriend(@RequestParam String location, @RequestParam String activity,
			@RequestParam String date, Model model) {
		System.out.println(date);
		if(!date.equals("''")) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate;
				java.sql.Date sqlDate;
				utilDate = sdf.parse(date);
				sqlDate = new java.sql.Date(utilDate.getTime());
				System.out.println(sqlDate);
				model.addAttribute("Friends", search.getActivities(activity, location, sqlDate));
				return "buddies";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("Friends", search.getActivities(activity, location, null));
		return "buddies";
	}
//	
//	@RequestMapping(method=RequestMethod.GET, value="/findfriends")
//	public String findFriend(@RequestParam String location,@RequestParam String activity,
//			@RequestParam String date, Model model) {
//		System.out.println(location);
//		//search.getFriends will have params passed by @RequestParam annotation
//		//model.addAttribute("Friends", search.getFriends(location, activity, date));
//		model.addAttribute("Friends", search.getFriends(location, activity, date));
//		return "buddies";
//	}	


}



