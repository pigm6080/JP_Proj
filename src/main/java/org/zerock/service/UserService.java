package org.zerock.service;

import java.util.List;

import org.zerock.domain.AuthVO;
import org.zerock.domain.UserVO;

public interface UserService {
	
	//삽입
//	public void register(UserVO vo);
	void register(UserVO vo, AuthVO userAuth);
	
	//한개 출력
	public UserVO get(String username);
	
	//수정
	public boolean modify(UserVO vo);
	
	//지우기
	public boolean remove(String username);
	
	//회원 전체 리스트 출력
	public List<UserVO> getList();
	public String emailcheck(String username);
	
	//권한 부여 추가 k - private 처리
	boolean grantAuth(AuthVO authVO);
	AuthVO getUserAuth(String username);
}