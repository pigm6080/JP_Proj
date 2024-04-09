package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.zerock.domain.UserVO;

public class UserLoginAuthenticationProvider implements AuthenticationProvider {
	
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	BCryptPasswordEncoder PasswordEncode;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// 사용자 입력정보 받아오기
		String userName = authentication.getName();    //username = id
		String userPassword = (String) authentication.getCredentials();
		
		// DB에 저장된 사용자 정보
		UserVO userInfo = (UserVO) customUserDetailsService.loadUserByUsername(userName);

		if (userInfo == null || !userName.equals(userInfo.getUsername())|| !PasswordEncode.matches(userPassword, userInfo.getPassword())) {
			throw new BadCredentialsException(userName);
		} else if (!userInfo.isAccountNonLocked()) {
			throw new LockedException(userName);

		// 비활성화된 계정일 경우
		} else if (!userInfo.isEnabled()) {
			throw new DisabledException(userName);

		// 만료된 계정일 경우
		} else if (!userInfo.isAccountNonExpired()) {
			throw new AccountExpiredException(userName);

		// 비밀번호가 만료된 경우
		} else if (!userInfo.isCredentialsNonExpired()) {
			throw new CredentialsExpiredException(userName);
		}

		// 다 썼으면 패스워드 정보는 지워줌 (객체를 계속 사용해야 하므로)
		userInfo.setPassword(null);

		/* 최종 리턴 시킬 새로만든 Authentication 객체 */
		Authentication newAuth = new UsernamePasswordAuthenticationToken(
				userInfo, null, userInfo.getAuthorities());

		return newAuth;
	}
	

	@Override
	// 위의 authenticate 메소드에서 반환한 객체가 유효한 타입이 맞는지 검사
	// null 값이거나 잘못된 타입을 반환했을 경우 인증 실패로 간주
	public boolean supports(Class<?> authentication) {

		// 스프링 Security가 요구하는 UsernamePasswordAuthenticationToken 타입이 맞는지 확인
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	
}
