package interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zerock.service.KakaoOauthServiceImpl;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private KakaoOauthServiceImpl kakaoSrv;
	
	public LoginInterceptor() {
		
	}

}
