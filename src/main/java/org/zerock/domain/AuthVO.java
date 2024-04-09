package org.zerock.domain;

import java.util.EnumSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.zerock.security.domain.Role;

import lombok.Data;

@Data
public class AuthVO implements GrantedAuthority {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String auth;

	public AuthVO(String username, String auth) {
	        this.username = username;
	        this.auth = auth;
	    }
	

	@Override
	public String getAuthority() {
		return auth.toString();
	}
}