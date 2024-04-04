package org.zerock.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/Oauth")
public class OauthController {
	
	private final UserServiceImpl userSrv;
	private final KakaoOauthServiceImpl kakaoSrv;
	
//	@Autowired
//	UserServiceImpl userSrv;
//
//	@Autowired
//	KakaoOauthServiceImpl kakaoSrv;
	
	
	public OauthController(UserServiceImpl srv ,KakaoOauthServiceImpl kakaoSrv) {
		this.userSrv = srv;
		this.kakaoSrv = kakaoSrv;
		};
	
	@RequestMapping(value = "/kakao/login")
	public String kakaoOauthStart() {
		System.out.println(kakaoSrv.kakaoUrl());
		return "redirect:" + kakaoSrv.kakaoUrl();
	}

	@GetMapping(value = "/kakao/getAuth")
	public @ResponseBody String kakaoGetCode(String code, Model model) throws IOException {

		KakaoTokenVO token = kakaoSrv.getToken(code);
		ResponseEntity<String> UserInfoRes = kakaoSrv.getKakaoUserInfo(token);
		
		ObjectMapper kuifmapper = new ObjectMapper();
		KakaoUserInfoVO kuif = null;
		
		if(kakaoSrv.tokenValidation(token)==1) {
			try {
				kuif = kuifmapper.readValue(UserInfoRes.getBody(), KakaoUserInfoVO.class);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
		if (userSrv.get(kuif.getNickname()) != null) {
			
			
			
			
		} else if (userSrv.get(kuif.getNickname()) == null) {
			UserVO kakaoUser = new UserVO();
			kakaoUser.setUsername(Long.toString(kuif.getId()));  // Long형 Kakao User Info를 String으로 형 변환
			kakaoUser.setPassword(OTPgenerator.generateTemporaryPassword());
			kakaoUser.setName(kuif.getNickname());
			kakaoUser.setPhone("null");
			
			userSrv.register(kakaoUser);		
		}
		
	
		
		return "community";

//		return "카카오인증완료 : "+ response;
//		return kakaoUserInfoVO.getBody();

	}
	
	@RequestMapping(value="/kakao/logout") //kakao login 회원인 경우 로그아웃 수행
	public String logOut(String accessToken, Model model) throws IOException {
		
		String token = (String) model.getAttribute("access_token");
		kakaoSrv.kakaoLogOut(token);
		return "redirect:/";
		
	}

	
}
