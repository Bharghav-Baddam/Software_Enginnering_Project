package com.buddyfinder.main.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.models.Activity;
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
			@RequestParam String date, Model model, HttpSession session) {
		System.out.println(date);
		if(!date.equals("''")) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate = null;
				java.sql.Date sqlDate = null;
				if(date != null && !date.isEmpty()) {
					utilDate = sdf.parse(date);
					sqlDate = new java.sql.Date(utilDate.getTime());
				}
				
				// if user is logged in then he must not be able to see his results in search because
				// the buddies page will have a send request button.
				if (authService.isSessionAlive(session.getId())) {
					ArrayList<Activity> activities = search.getActivities(activity, location, sqlDate);
					ArrayList<Activity> otherActivities = new ArrayList<>();
					if(activities!=null) {
						for(Activity a: activities) {
							if(!(a.getPostedBy().getAccountId().equals(((Account)session.getAttribute("account")).getAccountId()))){
								otherActivities.add(a);
							}
						}
					}
					model.addAttribute("Friends", otherActivities);
				}else {
					model.addAttribute("Friends", search.getActivities(activity, location, sqlDate));
				}
				
				return "buddies";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//model.addAttribute("Friends", search.getActivities(activity, location, null));
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



