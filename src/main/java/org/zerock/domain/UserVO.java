package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class UserVO {
	
	private String id;
	private String password;
	private String username;
	private String phone;
	private Date createday;
	private List<AuthVO> authList;
	
	
}
