package com.neu.patientRecordKeeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerL {
	
	@GetMapping("/login")
	public String showMyLoginPage() {

		return "login";
		
	}
	
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "denyAccess";
		
	}
	

}
