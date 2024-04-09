package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthVO implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String username;
    private String auth;
    private List<GrantedAuthority> authorities;

    public AuthVO(String username, String auth) {
        this.username = username;
        this.auth = auth;
        this.authorities = new ArrayList<>();
        this.authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getAuthority() {
        return auth;
    }
}