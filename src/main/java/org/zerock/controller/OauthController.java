package org.zerock.controller;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.security.Principal;
>>>>>>> features

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
>>>>>>> features
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.KakaoTokenVO;
import org.zerock.domain.KakaoUserInfoVO;
import org.zerock.domain.UserVO;
import org.zerock.oauthutil.OTPgenerator;
=======
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.AuthVO;
import org.zerock.domain.KakaoTokenVO;
import org.zerock.domain.UserVO;
>>>>>>> features
import org.zerock.oauthutil.SessionChecker;
import org.zerock.service.KakaoOauthServiceImpl;
import org.zerock.service.UserServiceImpl;

<<<<<<< HEAD
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

=======
import lombok.extern.slf4j.Slf4j;

@Slf4j
>>>>>>> features
@Controller
@RequestMapping("/Oauth/kakao")
public class OauthController {

	private final UserServiceImpl userSrv;
	private final KakaoOauthServiceImpl kakaoSrv;
<<<<<<< HEAD
=======
	private static final Logger logger = LoggerFactory.getLogger(OauthController.class);
>>>>>>> features

//	@Autowired
//	UserServiceImpl userSrv;
//
//	@Autowired
//	KakaoOauthServiceImpl kakaoSrv;

	public OauthController(UserServiceImpl srv, KakaoOauthServiceImpl kakaoSrv) {
		this.userSrv = srv;
		this.kakaoSrv = kakaoSrv;
<<<<<<< HEAD
	};

	@RequestMapping(value = "/login", method = RequestMethod.GET)
=======
		
	};

	@RequestMapping(value = "/kakaologin", method = RequestMethod.GET)
>>>>>>> features
	public String kakaoOauthStart() {
		System.out.println(kakaoSrv.kakaoUrl());
		return "redirect:" + kakaoSrv.kakaoUrl();
	}

	@RequestMapping(value = "/getAuth", method = RequestMethod.GET)
<<<<<<< HEAD
	public String kakaoGetCodeAndRegist(@RequestParam String code , @ModelAttribute("KakaoUser") UserVO vo, HttpSession session) throws IOException { // 

		KakaoTokenVO token_ = kakaoSrv.getToken(code);
//		ResponseEntity<String> UserInfoRes = kakaoSrv.getKakaoUserInfo(token_);
		UserVO KakaoUserInfo = kakaoSrv.getKakaoUserInfo(token_);
		
		
		
		UserVO kakaoUser = kakaoSrv.kakaoRegist(KakaoUserInfo, userSrv); //UserVO vo Return
		
//		session.setAttribute("KakaoUser",kakaoUser);
//		session.setMaxInactiveInterval(3600);
		
		return "redirect:/"; //home으로 리다이렉트
	}
	
	
	
	
	

	@RequestMapping(value = "/logout") // kakao login 회원인 경우 로그아웃 수행
	public String logOut(String accessToken, Model model) throws IOException {

		String token = (String) model.getAttribute("access_token");
		kakaoSrv.kakaoLogOut(token);
		return "redirect:/logout";

	}
	
	@GetMapping("/checkSession")
    public String checkSession(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession(false); // 세션이 없으면 null 반환
        String result = null;
        if (session != null) {
            // 세션에 저장된 데이터 조회
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
        	result =  "Session not found";
        	model.addAttribute("Check", result);
        }
        
        SessionChecker sChecker = new SessionChecker();
        model.addAttribute("principalCheck",sChecker.principanView().toString());
        
        
		return "security/sessionCheck";
    }
=======
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
	public String kakaoLogOut(String accessToken, Model model) throws IOException {

		String token = (String) model.getAttribute("access_token");
		kakaoSrv.kakaoLogOut(token);

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
>>>>>>> features

}
