package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		log.warn("Login Successs");
		
		  // 인증된 사용자의 정보를 세션에 추가
        HttpSession session = request.getSession();
        session.setAttribute("authenticatedUser", auth.getName());
		
        
        // 권한에 따라 리다이렉트할 URL 결정
        List<String> roleNames = getRoleNames(auth);
//        String redirectUrl = determineRedirectUrl(roleNames);
        
        
//		List<String> roleNames = new ArrayList<String>();
//		
//		auth.getAuthorities().forEach(authrity ->{
//			
//			roleNames.add(authrity.getAuthority());
//			
//		});
		
		
		log.warn("ROLE NAMES :" + roleNames);
		/*
		if(roleNames.contains("ROLE_ADMIN")) {
			
			response.sendRedirect("/sample/admin");
			return;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {
			
			response.sendRedirect("/sample/member");
			return;
		}
		*/
		response.sendRedirect("/");
//		response.sendRedirect(redirectUrl);
		
	}
	
	 private List<String> getRoleNames(Authentication authentication) {
	        List<String> roleNames = new ArrayList<>();
	        authentication.getAuthorities().forEach(authority -> roleNames.add(authority.getAuthority()));
	        return roleNames;
	    }

//	    private String determineRedirectUrl(List<String> roleNames) {
//	        if (roleNames.contains("ROLE_ADMIN")) {
//	            return "/admin";
//	        } else if (roleNames.contains("ROLE_MEMBER")) {
//	            return "/member";
//	        } else {
//	            return "/";
//	        }
//	    }
	
	
}
