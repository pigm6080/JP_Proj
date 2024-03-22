package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;
import org.zerock.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.warn("Load User By UserName 유저의 이름은 !!!!!!!!!!:" + username);
		
		//usernamemeans userid
		
		MemberVO vo = memberMapper.read(username);
		
		log.warn("queried by member mapper vo에서 가져온 값은 !!!!!!!!!!:" + vo);
		
		return vo == null ? null : new CustomUser(vo);
	}
	
	
	
}
