package org.zerock.oauthutil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SessionChecker {
	
	public Map<Object, Object> principanView() {
	// 현재 인증된 사용자 정보 가져오기
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	Object principal = null;
	Collection<? extends GrantedAuthority> authorities = null;
	
	if (authentication != null) {
	    // 현재 사용자의 Principal 가져오기
		principal = authentication.getPrincipal();
	    
	    // 현재 사용자의 권한 가져오기
		authorities = authentication.getAuthorities();
	    
	    // Principal과 권한 정보 출력
	    System.out.println("Principal: " + principal);
	    System.out.println("Authorities: " + principal);
	} else {
	    System.out.println("사용자가 인증되지 않았습니다.");
	}
		Map<Object , Object> prc = new HashMap<>();
		prc.put(principal, principal);
	
		return prc;
	}
}
