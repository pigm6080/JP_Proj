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
	public @ResponseBody String kakaoGetCode(@RequestParam String code) throws IOException {

		KakaoTokenVO token_ = kakaoSrv.getToken(code);
		ResponseEntity<String> UserInfoRes = kakaoSrv.getKakaoUserInfo(token_);

		ObjectMapper kuifmapper = new ObjectMapper();
		KakaoUserInfoVO kuif = null;

		if (kakaoSrv.tokenValidation(token_).equals("200 OK")) {
		}
		System.out.println("응답 자체 "+UserInfoRes);
		System.out.println("응답 투스트링 "+UserInfoRes.toString());
		System.out.println("응답 헤더 "+UserInfoRes.getHeaders());
		System.out.println("응답 바디 "+UserInfoRes.getBody());
		
		/*
		try {
			kuif = kuifmapper.readValue(UserInfoRes.getBody(), KakaoUserInfoVO.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		
		if (userSrv.get(kuif.getNickname()) == null) { // 기존 회원 확인
			UserVO kakaoUser = new UserVO();
			kakaoUser.setUsername(Long.toString(kuif.getId())); // Long형 Kakao User Info를 String으로 형 변환
			kakaoUser.setPassword(OTPgenerator.generateTemporaryPassword());
			kakaoUser.setName(kuif.getNickname());
			kakaoUser.setPhone("null");

			userSrv.register(kakaoUser);
		} */

//		return "카카오인증완료 : "+ response;
//		return kakaoUserInfoVO.getBody();

		return "redirect:/";
	}

	@RequestMapping(value = "/logout") // kakao login 회원인 경우 로그아웃 수행
	public String logOut(String accessToken, Model model) throws IOException {

		String token = (String) model.getAttribute("access_token");
		kakaoSrv.kakaoLogOut(token);
		return "redirect:/";

	}

}
