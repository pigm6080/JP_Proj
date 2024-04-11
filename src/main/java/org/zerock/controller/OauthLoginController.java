package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.security.UserLoginAuthenticationProvider;

@Controller
public class OauthLoginController {

	@Autowired
	private UserLoginAuthenticationProvider authProvider;

	@PostMapping("/kakaoLoginProcess")
	public String customLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

//		String uname = (String) model.getAttribute("username");
//		String pword = (String) model.getAttribute("password");
		String loginTry = (String) model.getAttribute("loginTry");
		String prevPage = (String) model.getAttribute("prevPage");

		model.addAttribute("loginTry", loginTry);
		model.addAttribute("prevPage", prevPage);

		try {
			Authentication authentication = authProvider
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			// 인증 성공 후 처리, 예: 홈페이지로 리다이렉트
			return "redirect:/";
		} catch (AuthenticationException e) {
			// 인증 실패 처리, 예: 로그인 페이지로 리다이렉트
			e.printStackTrace();
			return "redirect:/customLogin";
		}
	}
}
