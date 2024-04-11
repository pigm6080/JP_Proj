package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Component;
>>>>>>> features
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
<<<<<<< HEAD
@Service
=======
@Component
>>>>>>> features
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
//		
//		log.warn("Login Successs");
//		
//		// 인증된 사용자의 정보를 세션에 추가
//        HttpSession session = request.getSession();
//        session.setAttribute("authenticatedUser", auth.getName());
//        
//    
//        
//        // 권한에 따라 리다이렉트할 URL 결정
//        List<String> roleNames = getRoleNames(auth);
////        String redirectUrl = determineRedirectUrl(roleNames);
//        
//        
////		List<String> roleNames = new ArrayList<String>();
////		
////		auth.getAuthorities().forEach(authrity ->{
////			
////			roleNames.add(authrity.getAuthority());
////			
////		});
//		
//		
//		log.warn("ROLE NAMES :" + roleNames);
//		/*
//		if(roleNames.contains("ROLE_ADMIN")) {
//			
//			response.sendRedirect("/sample/admin");
//			return;
//		}
//		
//		if(roleNames.contains("ROLE_MEMBER")) {
//			
//			response.sendRedirect("/sample/member");
//			return;
//		}*/
//		
//		
//		
//		response.sendRedirect("/");
		
//		response.sendRedirect(redirectUrl);
		
		
		
		/*
		 * By KGH 04-084 16:13
		 * Success Handler 수정/추가
		 * - 핸들러 인터셉트 후 로그인 버튼을 누른 시점 uri 저장
		 * - 로그인 성공 후 이전 저장해두었던 uri로 리턴 
		 * 
		 * 
		 */

        WebAuthenticationDetails web = (WebAuthenticationDetails) auth.getDetails();
        
        
        
        log.info("IP : " + web.getRemoteAddress());
        log.info("Session ID : " + web.getSessionId());
		
		// 인증 ID
        log.info("name : " + auth.getName());
		
		// 권한 리스트
		List<GrantedAuthority> authList = (List<GrantedAuthority>) auth.getAuthorities();
		log.info("권한 : ");
		for(int i = 0; i< authList.size(); i++) {
			log.info(authList.get(i).getAuthority() + " ");
		}
		
		//Default URI
		String uri ="/";
		
		RequestCache requestCache = new HttpSessionRequestCache();
		SavedRequest saveRequest = requestCache.getRequest(request, response);
//		if(saveRequest != null) {
//			uri = saveRequest.getRedirectUrl();	
//			log.info(uri);
//		}
		
		
		//로그인 버튼 눌러서 로그인 페이지 접속시
		String prevPage = (String) request.getSession().getAttribute("prevPage");
		
		if (prevPage != null) {
			request.getSession().removeAttribute("prevPage");
		}
		
		if (saveRequest != null) {  // 강제 인터셉트 당했다면
			uri = saveRequest.getRedirectUrl();
			requestCache.removeRequest(request, response);
		} else if (prevPage != null && !prevPage.equals("")) { //직접 uri입력해서 접속시
			uri = prevPage;
		}
		
		Enumeration<String> list = request.getSession().getAttributeNames();
		while(list.hasMoreElements()) {
			log.info(list.nextElement());
		}
		
		
		if (uri != null) { // null 체크 추가
		    response.sendRedirect(uri);
		}else if(uri == null) {
			response.sendRedirect("/");
		}
		
<<<<<<< HEAD
		
		
		
	    
		
		
		
=======

>>>>>>> features
		
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
