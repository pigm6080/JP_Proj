package org.zerock.domain;


import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class AuthVO implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String auth;

	
    public AuthVO(String username, String auth) {
        this.auth = auth;
    }

    @Override
    public String getAuthority() {
        return auth;
    }
}