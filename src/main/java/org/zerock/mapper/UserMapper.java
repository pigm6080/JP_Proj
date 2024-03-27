package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.UserVO;

public interface UserMapper {
	
	//한개 출력
	public UserVO read(String id);
	//삽입
	public void insert(UserVO vo);
	//지우기
	public boolean delete(String id);
	//업데이트
	public boolean update(UserVO vo);
	//회원 전체 리스트 출력
	public List<UserVO> getList();

}
