package org.zerock.service;

import org.springframework.http.ResponseEntity;
import org.zerock.domain.KakaoTokenVO;

public interface KakaoOauthService {
	String kakaoUrl(); //login page url injector
	
	KakaoTokenVO getToken(String code); //access-token get
	
	ResponseEntity<String> getKakaoUserInfo(KakaoTokenVO token); //user-info get by access-token
	
	int tokenValidation(KakaoTokenVO token); //token validation
	
	int kakaoLogOut(String access_token); // access_token needs..
}
