package com.buddyfinder.main.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buddyfinder.main.forms.LoginForm;
import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.repository.AccountRepository;
import com.buddyfinder.main.services.AuthService;
import com.buddyfinder.main.services.Search;
import com.buddyfinder.main.services.UserService;

@Controller
public class HomeController {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AuthService authService;

	@Autowired
	Search search;

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = {"/", "/home"})
	public ModelAndView getHome(ModelAndView modelAndView, HttpSession session) {

		modelAndView.setViewName("home");
		if (authService.isSessionAlive(session.getId())) {
			session.setAttribute("account", authService.getSession(session.getId()));
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminpanel")
	public String getAdmin(Model model, HttpSession session) {
		model.addAttribute("Accounts", accountRepository.findAll());
		return "adminpanel";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/contact")
	public String getContact(Model model, HttpSession session) {
		//model.addAttribute("Accounts", accountRepository.findAll());
		return "contact";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/about")
	public String getAbout(Model model, HttpSession session) {
		//model.addAttribute("Accounts", accountRepository.findAll());
		return "about";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/myactivity")
	public ModelAndView myActivities(ModelAndView modelAndView, HttpSession session) {

		if (authService.isSessionAlive(session.getId())) {
			modelAndView.addObject("myPostedActivities", search.getMyPostedActivities((Account) session.getAttribute("account")));
			modelAndView.setViewName("myactivities");

		} else {

			LoginForm loginForm = new LoginForm();
			modelAndView.addObject("loginForm", loginForm);
			modelAndView.setViewName("redirect:/login");

		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public ModelAndView createActivity(@RequestParam String location, @RequestParam String activity,
			@RequestParam String date, ModelAndView modelAndView, HttpSession session) {

		java.util.Date utilDate;
		java.sql.Date sqlDate = null;

		if (authService.isSessionAlive(session.getId())) {
			Account account = (Account) session.getAttribute("account");

			if (date != null && !date.equals("''")) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

					utilDate = sdf.parse(date);
					sqlDate = new java.sql.Date(utilDate.getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			userService.createEvent(location, activity, sqlDate, account);
			modelAndView.setViewName("redirect:/myactivity");

		} else {

			LoginForm loginForm = new LoginForm();
			modelAndView.addObject("loginForm", loginForm);
			modelAndView.setViewName("redirect:/login");

		}
		return modelAndView;
	}
}
