package org.zerock.oauthutil;

import org.zerock.domain.UserVO;

import lombok.Getter;

@Getter
public class UserAdapter extends UserVO{

	/**
	 * 
	 */
	
	private UserVO user;
	private static final long serialVersionUID = 1L;

	public UserAdapter(UserVO user) {
		super( user.getUsername() , user.getPassword() , user.getAuthList());

		 this.user = user;
	}

	

}
