package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String loginInput(String error ,String logout ,Model model,HttpServletRequest request) {

		log.info("error :" + error);
		log.info("logout :" + logout);
		
		//by KGH 로그인 버튼 누른 시점 uri 저장
		String uri = request.getHeader("Referer");
		
		if(!uri.contains("/customLogin")) {  //로그인 실패로인한 리턴시 요청시점uri가 로그인 페이지가 되지않게 설정
			request.getSession().setAttribute("prevPage",
					request.getHeader("Referer"));
		}
		
		
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
