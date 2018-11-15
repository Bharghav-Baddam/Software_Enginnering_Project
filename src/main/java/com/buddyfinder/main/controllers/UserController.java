package com.buddyfinder.main.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.buddyfinder.main.forms.LoginForm;
import com.buddyfinder.main.forms.WallForm;
import com.buddyfinder.main.forms.WallPost;
import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.services.AuthService;
import com.buddyfinder.main.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	AuthService authService;

	@RequestMapping(value = { "/users/{id}/wallPosts" }, method = RequestMethod.GET)
	public ModelAndView getWallPost(ModelAndView modelAndView, HttpSession session, @PathVariable Integer id) {

		if (authService.isSessionAlive(session.getId())) {
			WallForm wallForm = new WallForm();
			List<WallPost> wallPosts = userService.getWallPostsForUser(id);
			if(wallPosts != null) {
				Collections.reverse(wallPosts);
			}
			Account wallUserAccount = userService.getUser(id);
			modelAndView.addObject("wallPosts", wallPosts);
			modelAndView.addObject("wallForm", wallForm);
			modelAndView.addObject("wallUserAccount", wallUserAccount);
			modelAndView.setViewName("myWall");
		} else {

			LoginForm loginForm = new LoginForm();
			modelAndView.addObject("loginForm", loginForm);
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@RequestMapping(value = { "/users/{id}/wallPosts" }, method = RequestMethod.POST)
	public String postOnWall(ModelAndView modelAndView, HttpSession session, @PathVariable Integer id,
			@ModelAttribute("commentForm") WallForm wallForm) {

		if (authService.isSessionAlive(session.getId())) {

			if(wallForm.getImage()!=null) {
				userService.saveWallPost(wallForm, id, authService.getSession(session.getId()));
			}
			modelAndView.setViewName("redirect:/users/" + id + "/wallPosts");
			return "redirect:/users/" + id + "/wallPosts";
		} else {

			LoginForm loginForm = new LoginForm();
			modelAndView.addObject("loginForm", loginForm);
			return "login";
		}
	}

}
