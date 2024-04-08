package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.zerock.domain.UserVO;

public class userLoginAuthenticationProvider implements AuthenticationProvider {
	
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncode;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// 사용자 입력정보 받아오기
		String userName = authentication.getName();    //username = id
		String userPassword = (String) authentication.getCredentials();
		
		// DB에 저장된 사용자 정보
		UserVO userInfo = (userVO) customUserDetailsService.loadUserByUsername(userName);

		if (userInfo == null || !userName.equals(userInfo.getUsername()))
		
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
