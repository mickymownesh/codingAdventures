package com.application.codingadventures;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/testpage")
	public String testPage() {
	  return "Welcome to test page";
	} 
}
