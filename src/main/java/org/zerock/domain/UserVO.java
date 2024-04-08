package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class UserVO {
	
	private String username;
	private String password;
	private String name;
	private String phone;
	private Date createday;
	private List<AuthVO> authList;
<<<<<<< HEAD


	public UserVO(String username, String password, String name, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
}
=======
	
	
}
>>>>>>> mergeTest
