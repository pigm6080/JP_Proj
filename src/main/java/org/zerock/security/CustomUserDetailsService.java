package org.zerock.security;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
>>>>>>> features
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
		
<<<<<<< HEAD
		UserVO vo = userMapper.read(username);

		log.warn("queried by member mapper vo에서 가져온 값은 !!!!!!!!!!:" + vo);
=======
		UserVO user = userMapper.read(username);
		
		AuthVO userAuth = userMapper.getUserAuth(user.getUsername());
>>>>>>> features
		
		if (user.getUsername() == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
		log.warn("현 로그인 유저에게 주어진 권한VO 객체 : " + userAuth);
		log.warn("현 로그인 유저에게 주어진 권한 : " + userAuth.getAuth());
		
		 // UserDetails 객체를 생성하여 사용자 정보 설정
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(userAuth.getAuth()) // 사용자의 역할 설정
                .build();

		log.warn("queried by member mapper vo에서 가져온 값은 !!!!!!!!!!:" + user);
		log.warn("queried by member mapper vo에서 가져온 권한VO는 !!!!!!!!!!:" + userAuth);
		log.warn("queried by member mapper vo에서 가져온 비밀번호는 !!!!!!!!!!:" + user.getPassword());
		
		
		// HttpSession을 사용하여 사용자 정보를 세션에 저장 (선택사항)
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        session.setAttribute("loggedInUser", userDetails);
     
        
        return userDetails;
		
//		return user == null ? null : new CustomUser(user);
		
		
//		return UserAdapter(vo);
	}
	
	public AuthVO getUserAuthority(String username) {
		return userMapper.getUserAuth(username);
	}
	
	
	
}
