package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private AuthenticationManager authenticationManager;

//	Home page
	@GetMapping("/")
	public String home() {
		return "home";
	}

//	About Page
	@GetMapping("/about")
	public String about() {
		return "about";
	}

//	 Page
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/student-login")
	public String studentLogin() {
		return "student_login";
	}

	@PostMapping("/doLogin")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap model) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			return "redirect:/teacher/add-student"; // Redirect to success page
		} catch (BadCredentialsException e) {
			model.addAttribute("error", "Invalid username or password");
			return "login"; // Redirect back to login page with error message
		}
	}


}
