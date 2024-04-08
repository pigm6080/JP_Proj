package org.zerock.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.KakaoTokenVO;
import org.zerock.domain.KakaoUserInfoVO;
import org.zerock.domain.UserVO;
import org.zerock.oauthutil.OTPgenerator;
import org.zerock.service.KakaoOauthServiceImpl;
import org.zerock.service.UserServiceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String kakaoOauthStart() {
		System.out.println(kakaoSrv.kakaoUrl());
		return "redirect:" + kakaoSrv.kakaoUrl();
	}

	@RequestMapping(value = "/getAuth", method = RequestMethod.GET)
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
            Object userData = session.getAttribute("KakaoUser");
            if (userData != null) {
                System.out.println("User data found in session: " + userData.toString());
                model.addAttribute("session", userData.toString());
            } else {
            	System.out.println("User data not found in session"); 
            	result = "User data not found in session";
            	model.addAttribute("session", result);
            }
        } else {
        	result =  "Session not found";
        	model.addAttribute("session", result);
        }
		return "security/sessionCheck";
    }

}
