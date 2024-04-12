package org.zerock.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.KakaoTokenVO;
import org.zerock.domain.UserVO;
import org.zerock.oauthutil.SessionChecker;
import org.zerock.service.KakaoOauthServiceImpl;
import org.zerock.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/Oauth/kakao")
public class OauthController {

	private final UserServiceImpl userSrv;
	private final KakaoOauthServiceImpl kakaoSrv;
	private static final Logger logger = LoggerFactory.getLogger(OauthController.class);

//	@Autowired
//	UserServiceImpl userSrv;
//
//	@Autowired
//	KakaoOauthServiceImpl kakaoSrv;

	public OauthController(UserServiceImpl srv, KakaoOauthServiceImpl kakaoSrv) {
		this.userSrv = srv;
		this.kakaoSrv = kakaoSrv;
		
	};

	@RequestMapping(value = "/kakaologin", method = RequestMethod.GET)
	public String kakaoOauthStart() {
		System.out.println(kakaoSrv.kakaoUrl());
		return "redirect:" + kakaoSrv.kakaoUrl();
	}

	@RequestMapping(value = "/getAuth", method = RequestMethod.GET)
	public String kakaoGetCodeAndRegist(@RequestParam String code, Model model) throws IOException { //
		System.out.println(code);
		KakaoTokenVO token_ = kakaoSrv.getToken(code);

		// Map<String , Object> 반환에서 Object 뽑아내어 casting
		UserVO KakaoUserInfo = kakaoSrv.getKakaoUserInfo(token_);
		System.out.println(KakaoUserInfo);

//		AuthVO KakaoUserAuthInfo = (AuthVO) kakaoSrv.getKakaoUserInfo(token_).get("AuthVO");
//		System.out.println(KakaoUserAuthInfo);

		
		String isRegisted = kakaoSrv.kakaoRegist(KakaoUserInfo, model); // UserVO vo Return
		System.out.println(isRegisted);

//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("username", kakaoUser.getUsername());
//		modelAndView.addObject("password", kakaoUser.getPassword());
//		modelAndView.addObject("loginTry", "Oauth_authenticated");
//		modelAndView.addObject("prevPage", "kakaoOauth");
//		modelAndView.setViewName("security/customLogin");
		
		model.addAttribute("username", KakaoUserInfo.getUsername());
		model.addAttribute("password", KakaoUserInfo.getPassword());
		model.addAttribute("loginTry", "Oauth_authenticated");
		model.addAttribute("prevPage", "kakaoOauth");
		
		
//		 redirectAttributes.addAttribute("username",  kakaoUser.getUsername());
//		 redirectAttributes.addAttribute("password",  kakaoUser.getPassword());
//		 redirectAttributes.addAttribute("loginTry",  "Oauth_authenticated");
//		 redirectAttributes.addAttribute("prevPage", "kakaoOauth");
		return "security/kakaoLogin";
//		return modelAndView;
	}


	@RequestMapping(value = "/kakaologout") // kakao login 회원인 경우 로그아웃 수행
	public String kakaoLogOut(String accessToken, Model model, HttpServletRequest request) throws IOException {

		String token = (String) model.getAttribute("access_token");
		kakaoSrv.kakaoLogOut(token,request);

//		return "redirect:/";
		return "/security/customLogout";

	}
	
	
	
	

	@GetMapping("/checkSession")
	public String checkSession(HttpServletRequest request, Model model, Principal princ) {
//	    HttpSession session = request.getSession(false);
		HttpSession session = request.getSession(false);
		String result = null;
		if (session != null) {
			Object userData = session.getAttribute("Check");
			if (userData != null) {
				System.out.println("User data found in session: " + userData.toString());
				model.addAttribute("Check", userData.toString());
			} else if (session.getAttribute("loggedInUser") != null) {
				Object userInfo = session.getAttribute("loggedInUser");
				model.addAttribute("check", userInfo);

			} else {
				System.out.println("User data not found in session");
				result = "User data not found in session";
				model.addAttribute("Check", result);
			}
		} else {
			result = "Session not found";
			model.addAttribute("Check", result);
		}

		SessionChecker sChecker = new SessionChecker();
		model.addAttribute("sChecker", sChecker.principanView().toString());

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			String username = userDetails.getUsername();
			model.addAttribute("userNm", username);
			model.addAttribute("principal", principal);
		} else {
			// 주의: principal이 UserDetails의 인스턴스가 아닐 경우 처리 로직
			model.addAttribute("userNm", principal.toString());
			model.addAttribute("principal", "Anonymous");
		}

		model.addAttribute("princ", princ);

		if (isAuthenticated()) {
			model.addAttribute("auth", "auth success");
		}

		return "/security/sessionCheck";
	}

	private boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return false;
		}
		return authentication.isAuthenticated();
	}

}