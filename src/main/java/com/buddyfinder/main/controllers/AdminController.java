package com.buddyfinder.main.controllers;

import com.buddyfinder.main.forms.LoginForm;
import com.buddyfinder.main.forms.WallForm;
import com.buddyfinder.main.forms.WallPost;
import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.models.Wall;
import com.buddyfinder.main.repository.WallRepository;
import com.buddyfinder.main.services.NotificationService;
import com.buddyfinder.main.services.UserService;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buddyfinder.main.services.AdminService;
import com.buddyfinder.main.services.AuthService;

@Controller
@RequestMapping("/adminpanel")
public class AdminController {
	@Autowired
	AuthService authService;

	@Autowired
	private AdminService adminService;
	@Autowired
	UserService userService;
	@Autowired
	private NotificationService notificationService;

	@RequestMapping(method=RequestMethod.GET, value="/users/{id}/block")
	public String handleUser(Model model, @PathVariable Integer id) {
		Boolean x = adminService.blockUser(id);
		return "redirect:/adminpanel";
	}
	@RequestMapping(method=RequestMethod.GET, value="/users/{id}/checkPostings")
	public ModelAndView check(ModelAndView modelAndView, HttpSession session, @PathVariable Integer id) {
	
			List<WallPost> wallPosts = userService.getWallPostsForUser(id);
			Collections.reverse(wallPosts);
			Account wallUserAccount = userService.getUser(id);
			modelAndView.addObject("wallPosts", wallPosts);
			modelAndView.addObject("wallUserAccount", wallUserAccount);
			modelAndView.setViewName("postings");
		
		return modelAndView;
		
	}
	@RequestMapping(method=RequestMethod.GET, value =  "/posts/{uid}/{pid}/delete")
	public String delete(ModelAndView modelAndView,@PathVariable Integer uid,@PathVariable Integer pid,HttpSession session) {
		if (authService.isSessionAlive(session.getId())) {
		userService.deleteWallPost(pid);
		List<WallPost> wallPosts = userService.getWallPostsForUser(uid);
		Collections.reverse(wallPosts);
		Account wallUserAccount = userService.getUser(uid);
		modelAndView.addObject("wallPosts", wallPosts);
		modelAndView.addObject("wallUserAccount", wallUserAccount);
		modelAndView.setViewName("redirect:/adminpanel/users/" + uid + "/checkPostings");
		return "redirect:/adminpanel/users/" + uid + "/checkPostings";
		}else {
			LoginForm loginForm = new LoginForm();
			modelAndView.addObject("loginForm", loginForm);
			return "login";
		}
		
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


