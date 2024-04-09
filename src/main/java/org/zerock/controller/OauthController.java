package org.zerock.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.KakaoTokenVO;
import org.zerock.domain.UserVO;
import org.zerock.oauthutil.SessionChecker;
import org.zerock.service.KakaoOauthServiceImpl;
import org.zerock.service.UserServiceImpl;

@Controller
@RequestMapping("/Oauth/kakao")
public class OauthController {

	private final UserServiceImpl userSrv;
	private final KakaoOauthServiceImpl kakaoSrv;

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
	public String kakaoGetCodeAndRegist(@RequestParam String code ,  @ModelAttribute UserVO vo, Model model) throws IOException { // 

		KakaoTokenVO token_ = kakaoSrv.getToken(code);
//		ResponseEntity<String> UserInfoRes = kakaoSrv.getKakaoUserInfo(token_);
		UserVO KakaoUserInfo = kakaoSrv.getKakaoUserInfo(token_);
		
		
		
		UserVO kakaoUser = kakaoSrv.kakaoRegist(KakaoUserInfo, userSrv); //UserVO vo Return
		
		model.addAttribute("username", kakaoUser.getName());
		model.addAttribute("password", kakaoUser.getPassword());
		
//		session.setAttribute("KakaoUser",kakaoUser);
//		session.setMaxInactiveInterval(3600);
		
		return "/customLogin/login"; //home으로 리다이렉트
	}
	
	
	
	
	

	@RequestMapping(value = "/logout") // kakao login 회원인 경우 로그아웃 수행
	public String logOut(String accessToken, Model model) throws IOException {

		String token = (String) model.getAttribute("access_token");
		kakaoSrv.kakaoLogOut(token);
		return "redirect:/logout";

	}
	
	
	
	
	@GetMapping("/checkSession")
	public String checkSession(HttpServletRequest request, Model model,Principal princ ) {
	    HttpSession session = request.getSession(false);
	    String result = null;
	    if (session != null) {
	        Object userData = session.getAttribute("Check");
	        if (userData != null) {
	            System.out.println("User data found in session: " + userData.toString());
	            model.addAttribute("Check", userData.toString());
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
