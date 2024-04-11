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


@Log4j
@Component
public class SignupUriInterceptFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    	
    	// 현재 인증된 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 로그인된 유저가 아니라면
        if (authentication == null || !authentication.isAuthenticated()) {
            // 회원가입 URI를 인터셉트하고 특정 동작 수행
        	String uri ="/";
    		
    		RequestCache requestCache = new HttpSessionRequestCache();
    		SavedRequest saveRequest = requestCache.getRequest(request, response);
    		// 회원가입 URI를 인터셉트하고 특정 동작 수행
        if (request.getRequestURI().equals("/regMember")) {
            System.out.println("Signup URI intercepted");

            

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
    			 response.sendRedirect("/regMember");
    		}
        	
        	
        	
            System.out.println("Regist URI intercepted");
            return;

        }

        // 다음 필터로 이동
        filterChain.doFilter(request, response);
        	}
        }
}

