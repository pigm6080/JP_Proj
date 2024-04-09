package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.UserVO;
import org.zerock.mapper.UserMapper;
import org.zerock.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.warn("Load User By UserName 유저의 이름은 !!!!!!!!!!:" + username);
		
		//usernamemeans userid
		
		UserVO vo = userMapper.read(username);
		
		log.warn("queried by member mapper vo에서 가져온 값은 !!!!!!!!!!:" + vo);
		
		return vo == null ? null : new CustomUser(vo);
	}
	
	
	
}
