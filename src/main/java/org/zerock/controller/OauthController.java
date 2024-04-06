package org.zerock.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public @ResponseBody String kakaoGetCodeAndRegist(@RequestParam String code) throws IOException {

		KakaoTokenVO token_ = kakaoSrv.getToken(code);
//		ResponseEntity<String> UserInfoRes = kakaoSrv.getKakaoUserInfo(token_);
		UserVO KakaoUserInfo = kakaoSrv.getKakaoUserInfo(token_);
		
		kakaoSrv.kakaoRegist(KakaoUserInfo, userSrv);
		
		return "redirect:/";
	}

	@RequestMapping(value = "/logout") // kakao login 회원인 경우 로그아웃 수행
	public String logOut(String accessToken, Model model) throws IOException {

		String token = (String) model.getAttribute("access_token");
		kakaoSrv.kakaoLogOut(token);
		return "redirect:/";

	}

}
