package com.buddyfinder.main.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buddyfinder.main.services.AdminService;
import com.buddyfinder.main.services.Search;

@Controller
@RequestMapping("/adminpanel")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

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
	

}
