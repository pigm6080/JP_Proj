package org.zerock.service;

import java.util.Map;

import org.zerock.domain.AuthVO;
import org.zerock.domain.KakaoTokenVO;
import org.zerock.domain.UserVO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface KakaoOauthService {
	String kakaoUrl(); //login page url injector
	
	KakaoTokenVO getToken(String code); //access-token get
	
	Map<UserVO, AuthVO> getKakaoUserInfo(KakaoTokenVO token) throws JsonMappingException, JsonProcessingException; //user-info get by access-token
	
	String tokenValidation(KakaoTokenVO token); //token validation
	
	
	int kakaoLogOut(String access_token); // access_token needs..

	UserVO kakaoRegist(UserVO vo, UserServiceImpl userSrv);
}
