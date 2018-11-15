package com.buddyfinder.main.controllers;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buddyfinder.main.services.AdminService;

@Controller
@RequestMapping("/adminpanel")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@Autowired
	private NotificationService notificationService;

	@RequestMapping(method=RequestMethod.POST, value="/action")
	public String handleUser(Model model, @RequestParam String user, @RequestParam String action) {
		System.out.println(user);
		System.out.println(action);
		if(action.equals("block")) {
			Boolean x = adminService.blockUser(user);
		}else {
			Boolean x = adminService.unblockUser(user);
		}

		return "redirect:/adminpanel";
	}

	@RequestMapping(method=RequestMethod.POST, value =  "/notification")
	public String enotify(Model model, @RequestParam String to, @RequestParam String message,@RequestParam String subject) {
		try {
			notificationService.sendEmail(to,message,subject);
			return "redirect:/notification";

		}catch(Exception ex) {
			return "Error in sending email: "+ex;
		}
	}
	

}


