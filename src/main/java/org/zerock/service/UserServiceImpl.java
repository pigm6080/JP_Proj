package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.domain.AuthVO;
import org.zerock.domain.UserVO;
import org.zerock.mapper.UserMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private PasswordEncoder pwecoderEncoder;
	
	@Override
	public void register(UserVO vo , AuthVO userAuth) {
		
		vo.setPassword(pwecoderEncoder.encode(vo.getPassword()));
		
		log.info("register 입니다." + vo);
		
		mapper.insert(vo);
		mapper.insertAuth(vo.getUsername());
		String thisauth = this.grantAuth(userAuth);

		log.info( vo.getName() + "님 역할이 " + thisauth + " 설정되었습니다.");
	}

	@Override
	public UserVO get(String id) {
		
		log.info("get..입니당 !!" + id);
		
		return mapper.read(id);
	}

	@Override
	public boolean modify(UserVO vo) {
		
		log.info("update..입니당 !!" + vo);
		
		return mapper.update(vo);
	}

	@Override
	public boolean remove(String id) {
		
		log.info("remove입니당 !!" + id);
		
		return mapper.delete(id);
	}

	@Override
	public List<UserVO> getList() {
		log.info("List--입니다.");
		return mapper.getList();
	}

	@Override
	public String grantAuth(AuthVO authVO) {
		mapper.grantAuth(authVO);
		String addedAuth = authVO. getAuthority();
		return addedAuth;
	}

	@Override
	public AuthVO getUserAuth(String username) {
		AuthVO authGet = mapper.getUserAuth(username);
		return authGet;
	}





}