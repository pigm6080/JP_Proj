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

		if (vo.getUsername().equals(userAuth.getUsername())) {
			vo.setPassword(pwecoderEncoder.encode(vo.getPassword()));
			vo.setAuthList(userAuth);
			log.info("주어진 UserVO의 유저이름과 AuthVO의 유저이름이 일치합니다. 등록을 진행합니다.");
			log.info("register 입니다." + vo);
			
			mapper.insert(vo);
			mapper.insertAuth(userAuth);


			log.info( vo.getName() + "님 역할이 " + userAuth.getAuth() + " 설정되었습니다.");

		}else if (!(vo.getUsername().equals(userAuth.getUsername()))) {
			log.info("주어진 UserVO의 유저이름과 AuthVO의 유저이름이 일치하지않습니다.");
			log.info("파라미터를 확인해주세요");
		}else {
			log.info("일치 / 불일치 여부 이외 문제가 발생한 것 같습니다.");
		}
		
		
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
	public boolean grantAuth(AuthVO authVO) {
		AuthVO received = authVO;
		return mapper.grantAuth(received);
	}

	@Override
	public AuthVO getUserAuth(String username) {
		AuthVO authGet = mapper.getUserAuth(username);
		return authGet;
	}

	@Override
	public String emailcheck(String username) {
		
		UserVO vo = mapper.read(username);
		
		System.out.println("id check :" + username + " : " + vo);
		
		if(vo == null) {
			return "ok";
		}else {
			return "no";
		}
	}

}