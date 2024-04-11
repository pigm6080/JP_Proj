package org.zerock.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

//시큐리티 컨드롤러
@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")
	public String accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);

		model.addAttribute("msg", "Access Denied");

		return "/security/accessError";
	}

	@GetMapping("/customLogin")
	public String loginInput(String error, String logout, Model model) {

		log.info("error :" + error);
		log.info("logout :" + logout);

		if (error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		if (logout != null) {
			model.addAttribute("logout", "logout !!");
		}
		return "/security/customLogin";

	}
	
	

	@RequestMapping("/customLogout")
//	@PostMapping("/customLogout")
	public String logoutGET(@ModelAttribute UserDetails userDetails, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String authUserName = authentication.getName();

		if (model.getAttribute("loggedInUser") != null) {
			log.info(model.getAttribute("loggedInUser"));
			UserDetails nowUser = (UserDetails) model.getAttribute("loggedInUser");
			Collection<? extends GrantedAuthority> authorities = nowUser.getAuthorities();

			if (nowUser.getUsername().equals(authUserName)) {

				for (GrantedAuthority authority : authorities) {
					System.out.println("Authority: " + authority.getAuthority());
					if (authority.equals("ROLE_KakaoUser") || authority.equals("KakaoUser")) { // 권한이 카카오 유저가 맞다면
						return "redireck:/Oauth/kakao/kakaologout";
					}
				}
			}

		}
		log.info("custom logout");

		return "/logout";

	}

}
