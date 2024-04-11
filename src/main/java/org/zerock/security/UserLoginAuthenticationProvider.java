package org.zerock.security;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;


@Log4j
@Component
public class UserLoginAuthenticationProvider implements AuthenticationProvider {
	
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	BCryptPasswordEncoder PasswordEncode;
	 private String token = "fetch";
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// 사용자 입력정보 받아오기
		String userName = authentication.getName();    //username = id
		String userPassword = authentication.getCredentials().toString();
		
		// DB에 저장된 사용자 정보
		UserDetails userInfo = customUserDetailsService.loadUserByUsername(userName);
		boolean foundOauthUser = false;
		String OauthUserPass = null;
		for (GrantedAuthority authorities : userInfo.getAuthorities()) { // "ROLE_KakaoUser"
			System.out.println("DB에 저장된 유저 역할 : " + authorities);
			System.out.println("KakaoUser인가 ? 1차:" + authorities.getAuthority()+ " : " +  authorities.getAuthority());
			System.out.println("KakaoUser인가 ? 2차 : " + authorities.getAuthority().indexOf("KakoUser"));
			
			
				if (authorities.getAuthority().indexOf("KakoUser") != -1)  {
					foundOauthUser = true;
				}
		}
		
		if (foundOauthUser) {
			OauthUserPass = userInfo.getPassword();
			System.out.println("1차확인 SNS유저 패스 비밀번호 : "+ OauthUserPass);
			System.out.println("1차확인 DB에 저장된 유저비밀번호 : " + userInfo.getPassword());
		}
		
		// UserVO 객체를 UserAdapter를 사용하여 UserDetails로 변환
	    //UserDetails userDetails = new UserAdapter(userInfo);
		
		boolean matchPw = PasswordEncode.matches(userPassword , userInfo.getPassword());
		
		System.out.println("유저이름 : " + userName);
		System.out.println("유저비밀번호 : "+ userPassword);
		System.out.println("유저비밀번호 인코딩: "+ PasswordEncode.encode(userPassword));
		System.out.println("유저비밀번호 일치? : "+ matchPw);
		System.out.println("DB에 저장된 유저이름 : " + userInfo.getUsername());
		System.out.println("DB에 저장된 유저비밀번호 : " + userInfo.getPassword());
		
		if (OauthUserPass != null) { //sns 가입 유저였다
			this.oauthUserCheck(userInfo , userName, OauthUserPass);
		}else if ( OauthUserPass == null) { //일반 유저였으니..
			this.generalUserCheck(userInfo, userName, OauthUserPass ,userPassword);
		}
		
		// 다 썼으면 패스워드 정보는 지워줌 (객체를 계속 사용해야 하므로)
		//userInfo.setPassword(null);
		
		List<String> stringAuthorities = List.of(customUserDetailsService.getUserAuthority(userName).getAuth());//"ROLE_USER", "ROLE_ADMIN");
		Collection<GrantedAuthority> grantedAuthorities = stringAuthorities.stream()
			    .map(SimpleGrantedAuthority::new)
			    .collect(Collectors.toList());
		
		/* 최종 리턴 시킬 새로만든 Authentication 객체 */
		Authentication newAuth = new UsernamePasswordAuthenticationToken(
				userInfo, null,grantedAuthorities);//, );  //userInfo.getAuthorities());
		
		return newAuth;
	}
	

	@Override
	// 위의 authenticate 메소드에서 반환한 객체가 유효한 타입이 맞는지 검사
	// null 값이거나 잘못된 타입을 반환했을 경우 인증 실패로 간주
	public boolean supports(Class<?> authentication) {

		// 스프링 Security가 요구하는 UsernamePasswordAuthenticationToken 타입이 맞는지 확인
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	private void oauthUserCheck(UserDetails userInfo , String userName , String OauthUserPass) {
		if (userInfo == null || !userName.equals(userInfo.getUsername())|| OauthUserPass == null) {
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
	}

	
	private void generalUserCheck(UserDetails userInfo , String userName , String OauthUserPass ,String userPassword) {
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
	}
	
}
