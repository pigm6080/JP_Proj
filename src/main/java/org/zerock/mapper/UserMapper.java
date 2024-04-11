package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.AuthVO;
import org.zerock.domain.UserVO;

public interface UserMapper {
	
	//한개 출력
	public UserVO read(String username);
	//삽입
	public void insert(UserVO vo);
	//지우기
	public boolean delete(String username);
	//업데이트
	public boolean update(UserVO vo);
	//회원 전체 리스트 출력
	public List<UserVO> getList();
	//로그인
//	public void insertAuth(String username);
	public void insertAuth(AuthVO autoVO);
	
	//권한 부여 추가 k
	boolean grantAuth(AuthVO authVO);
	
	AuthVO getUserAuth(String username);

}



