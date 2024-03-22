package org.zerock.security.domain;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.MemberVO;

import lombok.extern.log4j.Log4j;

public class CustomUser extends User{
	
	private static final long serialVersionUID = 1L;

	private MemberVO member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
																// <? extends GrantedAtority의 형태의 값으로 속성 정하겠다.	
		super(username, password, authorities);
		
	}

	public CustomUser(MemberVO vo) {

		super(vo.getUserid(), vo.getUserpw(), vo.getAuthList().stream()
		.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		this.member = vo;
	}
}
