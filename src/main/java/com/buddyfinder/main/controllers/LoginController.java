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
	
	@RequestMapping(method=RequestMethod.GET, value="/register")
	public String getLoginPage(
			) {
		
		return "registration";
	}
		
	
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public String registerUser(Model model, @RequestParam String role,@RequestParam String email, 
			@RequestParam String password1, @RequestParam String firstName, @RequestParam String lastName
			) {
		
		if(authService.isUniqueEmail(email)) {
			authService.createAccount(role,email, password1, firstName, lastName);
		}

		return "redirect:/login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login(ModelAndView modelAndView, HttpSession session) {

		if (authService.isSessionAlive(session.getId())) {

			session.setAttribute("account", authService.getSession(session.getId()));
			modelAndView.setViewName("redirect:/home");

		} else {

			LoginForm loginForm = new LoginForm();
			modelAndView.addObject("loginForm", loginForm);
			modelAndView.setViewName("login");

		}
		return modelAndView;
	}

	// TODO: return html
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public RedirectView login(RedirectAttributes redirectAttribute, @ModelAttribute("loginForm") LoginForm loginForm,
			HttpSession session) {
		
		Account account = authService.isAuthenticated(loginForm.getEmail(), loginForm.getPassword(), session.getId());

		if (account != null && account.isBlocked() == false) {
			redirectAttribute.addFlashAttribute("first_name", account.getFirstName());
			redirectAttribute.addFlashAttribute("last_name", account.getLastName());
			redirectAttribute.addFlashAttribute("account_id", account.getAccountId());
			redirectAttribute.addFlashAttribute("email", account.getEmail());
			// TODO: We need to change this mapping in the database
			// modelAndView.addObject("friends", account.getFriends());
			session.setAttribute("account", account);

		} 
		else if(account != null && account.isBlocked() == true) {
			return new RedirectView("/blocked");
		}
		else {
			
			return new RedirectView("/login");
		}
		return new RedirectView("/home");
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public ModelAndView logout(ModelAndView modelAndView, HttpSession session) {

		if (authService.isSessionAlive(session.getId())) {
			authService.removeSession(session.getId());
			session.invalidate();
		}
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/blocked" }, method = RequestMethod.GET)
	public ModelAndView blocked(ModelAndView modelAndView) {

		modelAndView.setViewName("blocked");
		return modelAndView;
	}
}
