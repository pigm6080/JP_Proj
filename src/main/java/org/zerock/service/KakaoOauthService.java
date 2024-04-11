package org.zerock.service;

<<<<<<< HEAD
=======
import java.util.Map;

import org.springframework.ui.Model;
import org.zerock.domain.AuthVO;
>>>>>>> features
import org.zerock.domain.KakaoTokenVO;
import org.zerock.domain.UserVO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface KakaoOauthService {
	String kakaoUrl(); //login page url injector
	
	KakaoTokenVO getToken(String code); //access-token get
	
	UserVO getKakaoUserInfo(KakaoTokenVO token) throws JsonMappingException, JsonProcessingException; //user-info get by access-token
	
	String tokenValidation(KakaoTokenVO token); //token validation
	
	
	int kakaoLogOut(String access_token); // access_token needs..

<<<<<<< HEAD
	UserVO kakaoRegist(UserVO vo, UserServiceImpl userSrv);
=======

	String kakaoRegist(UserVO uservo, Model model);
>>>>>>> features
}
