package org.zerock.security.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class secu_config extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/customLogin")  // csrf예외처리
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());// csrf 토큰자동생성
		 http
         .authorizeRequests()
             .antMatchers("/customLogout").authenticated() // /customLogout에 대한 접근 권한을 인증된 사용자에게만 허용
             .anyRequest().permitAll() // 다른 모든 요청은 모든 사용자에게 허용
         .and()
         .formLogin()
             .loginPage("/customLogin")
             .permitAll()
         .and()
         .logout()
             .permitAll();
	}

}
