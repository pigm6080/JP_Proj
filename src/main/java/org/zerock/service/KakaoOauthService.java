package org.zerock.service;

import org.springframework.http.ResponseEntity;
import org.zerock.domain.KakaoTokenVO;
import org.zerock.domain.UserVO;

public interface KakaoOauthService {
	String kakaoUrl(); //login page url injector
	
	KakaoTokenVO getToken(String code); //access-token get
	
	ResponseEntity<String> getKakaoUserInfo(KakaoTokenVO token); //user-info get by access-token
	
	String tokenValidation(KakaoTokenVO token); //token validation
	
	
	int kakaoLogOut(String access_token); // access_token needs..

	void kakaoRegist(UserVO vo, UserServiceImpl userSrv);
}
