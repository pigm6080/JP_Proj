package org.zerock.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name;
	private String phone;
	private Date createday;
	private List<AuthVO> authList;



	public UserVO(String username, String password, String name, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}

	

	@Override
	// 계정이 만료 되지 않았는가?
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	// 계정이 잠기지 않았는가?
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	// 패스워드가 만료되지 않았는가?
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	// 계정이 활성화 되었는가?
	public boolean isEnabled() {

		return true;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    List<GrantedAuthority> authorities = new ArrayList<>();
	    for (AuthVO auth : authList) {
	        authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
	    }
	    return authorities;
	}
	

}

	
	

