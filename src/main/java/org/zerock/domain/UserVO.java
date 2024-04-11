package org.zerock.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString

public class UserVO implements UserDetails{ //extends User{
	
//	public UserVO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//	}


	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name;
	private String phone;
	private Date createday;
	private AuthVO authList;

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> authList.getAuth());
    }


//	@Override
	// 계정이 만료 되지 않았는가?
	public boolean isAccountNonExpired() {

		return true;
	}

//	@Override
	// 계정이 잠기지 않았는가?
	public boolean isAccountNonLocked() {

		return true;
	}

//	@Override
	// 패스워드가 만료되지 않았는가?
	public boolean isCredentialsNonExpired() {

		return true;
	}

//	@Override
	// 계정이 활성화 되었는가?
	public boolean isEnabled() {

		return true;
	}

}

	
	

