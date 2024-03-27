package org.zerock.service;

import java.util.List;

import org.zerock.domain.UserVO;

public interface UserService {
	
	//삽입
	public void register(UserVO vo);
	
	//한개 출력
	public UserVO get(String id);
	
	//수정
	public boolean modify(UserVO vo);
	
	//지우기
	public boolean remove(String id);
	
	//회원 전체 리스트 출력
	public List<UserVO> getList();


}
