package org.zerock.domain;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.zerock.security.domain.Role;
=======
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
>>>>>>> features

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

<<<<<<< HEAD
@Data
public class UserVO implements UserDetails{
	
=======
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString

public class UserVO implements UserDetails{ //extends User{
	
//	public UserVO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//	}


>>>>>>> features
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name;
	private String phone;
	private Date createday;
<<<<<<< HEAD
	private AuthVO auth;



	public UserVO(String username, String password, String name, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}

	

	@Override
=======
	private AuthVO authList;

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> authList.getAuth());
    }


//	@Override
>>>>>>> features
	// 계정이 만료 되지 않았는가?
	public boolean isAccountNonExpired() {

		return true;
	}

<<<<<<< HEAD
	@Override
=======
//	@Override
>>>>>>> features
	// 계정이 잠기지 않았는가?
	public boolean isAccountNonLocked() {

		return true;
	}

<<<<<<< HEAD
	@Override
=======
//	@Override
>>>>>>> features
	// 패스워드가 만료되지 않았는가?
	public boolean isCredentialsNonExpired() {

		return true;
	}

<<<<<<< HEAD
	@Override
=======
//	@Override
>>>>>>> features
	// 계정이 활성화 되었는가?
	public boolean isEnabled() {

		return true;
	}

<<<<<<< HEAD


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

=======
>>>>>>> features
}

	
	

