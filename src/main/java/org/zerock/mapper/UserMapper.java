package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.UserVO;

public interface UserMapper {

	public UserVO read(String id);
	
	public void insert(UserVO vo);
	
	public boolean delete(String id);
	
	public boolean update(UserVO vo);
	
	public List<UserVO> getList();

}
