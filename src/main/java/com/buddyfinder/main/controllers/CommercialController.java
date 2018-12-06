package com.buddyfinder.main.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.services.CommercialService;
import com.buddyfinder.main.services.Search;
@Controller
@RequestMapping("/commercialpanel")
public class CommercialController {
	@Autowired
	private Search search;
	
	@Autowired
	private CommercialService commercialService;
	
	@RequestMapping(method=RequestMethod.POST,value="/action")
	public String getUsers(Model model,@RequestParam String activity) {
		System.out.println(activity);
		model.addAttribute("users", search.getActivities(activity,"", null));
		return "users";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/commercialpanel")
	public String getCommercialPanel(Model model, HttpSession session) {
		
		return "commercialpanel";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/uploadAds")
	public String uploadAds(Model model, HttpSession session,@RequestParam("imagefile") MultipartFile file) {
		Account account =(Account) session.getAttribute("account");
		
			commercialService.saveImageFile(account, file);
			return "redirect:commercialpanel";
	}
}
