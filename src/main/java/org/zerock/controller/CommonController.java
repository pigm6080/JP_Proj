package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;


//시큐리티 컨드롤러
@Controller
@Log4j
public class CommonController {
	
	
	@GetMapping("/accessError")
	public String accessDenied(Authentication auth , Model model) {
		log.info("access Denied : " + auth);
		
		
		model.addAttribute("msg" , "Access Denied");
		
		return "/security/accessError";
	}
	
	@GetMapping("/customLogin")
	public String loginInput(String error ,String logout ,Model model) {

		log.info("error :" + error);
		log.info("logout :" + logout);
		
		if(error != null) {
			model.addAttribute("error" , "Login Error Check Your Account");
		}
		if(logout != null) {
			model.addAttribute("logout" , "logout !!");
		}
		return "/security/customLogin";
		
		
	}
	@GetMapping("/customLogout")
	public String logoutGET() {
		
		log.info("custom logout");
		
		return "/security/customLogout";
		
		
	}

}
