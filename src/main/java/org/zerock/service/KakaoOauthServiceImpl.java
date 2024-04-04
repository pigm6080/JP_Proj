package org.zerock.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.zerock.domain.KakaoTokenVO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class KakaoOauthServiceImpl implements KakaoOauthService {

	// 서비스에 필요한 상수
	private static final String REST_API_KEY = "994f98607830bcba0c9fe0ab6e02f5f5"; // client-id
	private static final String REDIRECT_URL = "http://localhost:8082/Oauth/kakao/getAuth"; 
	private static final String VALIDATION_URL = "https://kapi.kakao.com/v1/user/access_token_info"; // https://
	private static final String KAPI_PREFIX = "https://kapi.kakao.com/";
	private static final String LOGOUT_URL = "https://kauth.kakao.com/oauth/logout";
	private static final String AUTHRIZATION_URL = "https://kauth.kakao.com/oauth/authorize";

	@Override
	public int tokenValidation(KakaoTokenVO token) {
		// For Info Get
		RestTemplate rtVal = new RestTemplate();

		// Header ADD
		HttpHeaders hdVal = new HttpHeaders(); // org.springframework.http.HttpHeaders IMPORT ! ! !
		hdVal.add("Authorization", "Bearer " + token.getAccess_token()); // token.getToken_type() = "Bearer"

		HttpEntity<MultiValueMap<String, String>> kakaoTokenReq = new HttpEntity<>(hdVal);

		ResponseEntity<String> rsVal = rtVal.exchange(KAPI_PREFIX + "v1/user/access_token_info", // https://{요청할 서버 주소}
				HttpMethod.GET, // 요청할 방식
				kakaoTokenReq, // 요청할 때 보낼 데이터
				String.class // 요청 시 반환되는 데이터 타입
		);
		System.out.println("토큰 유효성검사 resp 응답코드 :" + rsVal.getStatusCodeValue());

		if (rsVal.getStatusCode().value() != 200) {
			System.out.println("응답 상태 코드 200이 아니래!!!!");
			return -1;
		}

		System.out.println("응답 상태 코드 200!!!!");
		return 1;
	}

	
	@Override
	public KakaoTokenVO getToken(String code) {
		RestTemplate rt = new RestTemplate();

		// Header ADD
		HttpHeaders headers = new HttpHeaders(); // org.springframework.http.HttpHeaders IMPORT ! ! !
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// Body ADD
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", REST_API_KEY); // FIXME API KEY 맞게 수정
		params.add("REDIRECT_URL", REDIRECT_URL); // FIXME Port번호 맞게 수정
		params.add("code", code); // Code는 항상 달라짐

		HttpEntity<MultiValueMap<String, String>> kakaoTokenReq = new HttpEntity<>(params, headers);
		System.out.println(kakaoTokenReq);
		ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", // https://{요청할 서버 주소}
				HttpMethod.POST, // 요청할 방식
				kakaoTokenReq, // 요청할 때 보낼 데이터
				String.class // 요청 시 반환되는 데이터 타입
		);

		// TODO 응답코드별 에러처리 필요!!
//		System.out.println(response);
//		System.out.println("응답코드 헤더: "+response.getHeaders()); //String[] format
//		System.out.println(response.getStatusCode());
//		System.out.println("응답코드 밸류: "+response.getStatusCode().value()); //200
//		System.out.println("응답코드 밸류 타입: "+response.getStatusCode().getClass().getName()); //org.springframework.http.HttpStatus

		if (response.getStatusCode().value() == 200) {
			System.out.println("응답 상태 코드 200이래!!!!");
		}

		// Response Json to Token parsing
		ObjectMapper obmp = new ObjectMapper();
		KakaoTokenVO token = null;

		try {
			token = obmp.readValue(response.getBody(), KakaoTokenVO.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("카카오 인증코드 : " + token.getAccess_token());

//		if(valToken(token.getAccess_token(),token.getToken_type())==0) {
//			System.out.println("good token");
//		}
		return token;
	}

	
	@Override
	public ResponseEntity<String> getKakaoUserInfo(KakaoTokenVO token) {
		// For Info Get
		RestTemplate rt2 = new RestTemplate();

		// Header ADD
		HttpHeaders headers2 = new HttpHeaders(); // org.springframework.http.HttpHeaders IMPORT ! ! !
		headers2.add("Authorization", token.getToken_type() + " " + token.getAccess_token()); // token.getToken_type() =
																								// "Bearer"
		headers2.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		HttpEntity<MultiValueMap<String, String>> kakaoTokenReq2 = new HttpEntity<>(headers2);

		ResponseEntity<String> response2 = rt2.exchange(KAPI_PREFIX + "v2/user/me", // https://{요청할 서버 주소}
				HttpMethod.POST, // 요청할 방식
				kakaoTokenReq2, // 요청할 때 보낼 데이터
				String.class // 요청 시 반환되는 데이터 타입
		);
		System.out.println("resp2 응답코드 :" + response2.getStatusCodeValue());
		return response2;
	}
	
	
	@Override
	public String kakaoUrl() {
		String kakaoURL = "https://kauth.kakao.com/oauth/authorize?" + "client_id=" + REST_API_KEY + "&redirect_uri="
				+ REDIRECT_URL + "&response_type=code";
		return kakaoURL;
	}

	
	@Override
	public int kakaoLogOut(String access_token) {
		int result = 0;
		
		RestTemplate rt = new RestTemplate();
		HttpHeaders logOutHeader = new HttpHeaders();
		logOutHeader.add("Authorization","bearer "+ access_token);

		HttpEntity<MultiValueMap<String, String>> logOutReq = new HttpEntity<>(logOutHeader);
		
		ResponseEntity<String> logOutResponse = rt.exchange(KAPI_PREFIX + "v1/user/logout", // https://{요청할 서버 주소}
					HttpMethod.POST, // 요청할 방식
					logOutReq, // 요청할 때 보낼 데이터
					String.class // 요청 시 반환되는 데이터 타입
			);
		System.out.println("resp 응답코드 :" + logOutResponse.getStatusCodeValue());
		
		if(logOutResponse.getStatusCode().value() != 200) {
			result = 1;
			return result;
		}else {
			result = -1;
			return result;
		}
	}

}
