package com.buddyfinder.main.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.buddyfinder.main.forms.LoginForm;
import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.services.AuthService;

@Controller
public class LoginController {

	@Autowired
	AuthService authService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String showAddPersonPage(Model model) {

		LoginForm loginForm = new LoginForm();

		model.addAttribute("loginForm", loginForm);
		return "login";
	}

	// TODO: return html
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login( @ModelAttribute("loginForm") LoginForm loginForm, HttpSession session, Model model) {

		Account account = authService.isAuthenticated(loginForm.getEmail(), loginForm.getPassword());
		// ModelAndView modelAndView = new ModelAndView();

		if (account != null) {
			
			session.setAttribute("account", account);
			return "home";

		} else {
			model.addAttribute("loginForm", loginForm);
			return "login";
		}

	}
}
