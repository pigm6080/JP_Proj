package org.zerock.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class LoginUriInterceptFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    	
    	// 현재 인증된 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // 인증되지 않은 사용자인 경우
        if (authentication == null || !authentication.isAuthenticated()) {
            // 로그인 URI를 인터셉트하고 특정 동작 수행
        	String uri ="/";
    		
    		RequestCache requestCache = new HttpSessionRequestCache();
    		SavedRequest saveRequest = requestCache.getRequest(request, response);
            
    		if (request.getRequestURI().equals("/CustomLogin")) {
                // 특정 URI를 인터셉트할 때 수행할 동작
                // 예를 들어, 로그인 버튼 클릭 시의 처리를 여기에서 수행String prevPage = (String) request.getSession().getAttribute("prevPage");
            	
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
        			response.sendRedirect("/CustomLogin");
        		}
            	
            	
            	
                System.out.println("Login URI intercepted");
                return;
            }
        }
        // 다음 필터로 이동
        filterChain.doFilter(request, response);
    	
    }
      
    
}
