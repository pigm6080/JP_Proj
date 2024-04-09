package org.zerock.security;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.zerock.domain.AuthVO;
import org.zerock.domain.UserVO;
import org.zerock.mapper.UserMapper;
import org.zerock.security.domain.CustomUser;
//import org.zerock.oauthutil.UserAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.warn("Load User By UserName 유저의 이름은 !!!!!!!!!!:" + username);
		
		//usernamemeans userid
		
		UserVO user = userMapper.read(username);
		AuthVO userAuth = userMapper.getUserAuth(username);
		if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
		
		 // UserDetails 객체를 생성하여 사용자 정보 설정
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles() // 사용자의 역할 설정
                .build();

		log.warn("queried by member mapper vo에서 가져온 값은 !!!!!!!!!!:" + user);
		
		// HttpSession을 사용하여 사용자 정보를 세션에 저장 (선택사항)
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        session.setAttribute("loggedInUser", userDetails);
        
        return userDetails;
		
//		return user == null ? null : new CustomUser(user);
		
		
//		return UserAdapter(vo);
	}
	
	
	
}
