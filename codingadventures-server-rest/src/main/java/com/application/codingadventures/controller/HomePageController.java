package com.application.codingadventures.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomePageController {

	@GetMapping("/HomePage")
	public ModelAndView getHomePage() {
		
		ModelAndView Mv = new ModelAndView("HomePage");
		return Mv;
		
	}
	
}
