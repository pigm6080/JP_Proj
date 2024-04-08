package org.zerock.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class UserToken extends UsernamePasswordAuthenticationToken {
	
	Object principal;
	Object credentials;

	public UserToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
		
		super(principal, credentials, authorities);
		
		 this.principal = principal;
	     this.credentials = credentials;
	     super.setAuthenticated(true); // must use super, as we override
	}

}
