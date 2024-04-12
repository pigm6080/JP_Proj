package org.zerock.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.zerock.domain.KakaoTokenVO;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class OauthLogoutHandler implements LogoutHandler {

//    private final UserCache userCache;
//
//    public CustomLogoutHandler(UserCache userCache) {
//        this.userCache = userCache;
//    }


    
    private int kakaoLogOut(String access_token) {
		int result = 0;

		RestTemplate rt = new RestTemplate();
		HttpHeaders logOutHeader = new HttpHeaders();
		logOutHeader.add("Authorization", "bearer " + access_token);

		HttpEntity<MultiValueMap<String, String>> logOutReq = new HttpEntity<>(logOutHeader);

		ResponseEntity<String> logOutResponse = rt.exchange("https://kapi.kakao.com/" + "v1/user/logout", // https://{요청할 서버 주소}
				HttpMethod.POST, // 요청할 방식
				logOutReq, // 요청할 때 보낼 데이터
				String.class // 요청 시 반환되는 데이터 타입
		);
		log.info("resp 응답코드 :" + logOutResponse.getStatusCodeValue());

		if (logOutResponse.getStatusCode().value() != 200) {
			result = 1;
			return result;
		} else {
			result = -1;
			return result;
		}
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		String userName = authentication.getName();
        KakaoTokenVO nowToken = null;
        String access_token = null;
        
        if (request.getSession().getAttribute("token") != null) {
        	nowToken = (KakaoTokenVO) request.getSession().getAttribute("token");
        	access_token = nowToken.getAccess_token();
        	log.info("토큰 획득!");
        }else {
        	log.info("request.getSession().getAttribute(\"token\") 에서 토큰을 찾을 수 없음.");
        }
        
        int result = this.kakaoLogOut(access_token);
        
        if (result == 1) {
        	log.info("카카오 로그아웃 과정에서 오류가 발생");
        }        
	}
}