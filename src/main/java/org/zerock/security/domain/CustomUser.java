package org.zerock.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.UserVO;

public class CustomUser extends User{
	
	private static final long serialVersionUID = 1L;

	private UserVO user;

	public CustomUser(String id, String password, Collection<? extends GrantedAuthority> authorities) {
			
		// <? extends GrantedAtority의 형태의 값으로 속성 정하겠다.	
		super(id, password, authorities);
		
	}

	public CustomUser(UserVO vo) {

		super(vo.getId(), vo.getPassword(), vo.getAuthList().stream()
		.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		this.user = vo;
	}
}
