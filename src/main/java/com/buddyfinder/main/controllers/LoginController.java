package com.buddyfinder.main.controllers;

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
	public ModelAndView showAddPersonPage(ModelAndView modelAndView) {

		LoginForm loginForm = new LoginForm();
		modelAndView.addObject("blogForm", loginForm);
		modelAndView.setViewName("login.html");
		;
		return modelAndView;
	}

	// TODO: return html
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public RedirectView login(RedirectAttributes redirectAttribute, @ModelAttribute("blogForm") LoginForm loginForm) {

		Account account = authService.isAuthenticated(loginForm.getEmail(), loginForm.getPassword());
		// ModelAndView modelAndView = new ModelAndView();

		if (account != null) {
			
			redirectAttribute.addFlashAttribute("first_name", account.getFirstName());
			redirectAttribute.addFlashAttribute("last_name", account.getLastName());
			redirectAttribute.addFlashAttribute("account_id", account.getAccountId());
			redirectAttribute.addFlashAttribute("email", account.getEmail());

			// TODO: We need to change this mapping in the database
			// modelAndView.addObject("friends", account.getFriends());

		} else {
			return new RedirectView("/login");
		}
		return new RedirectView("/home");
	}
}
