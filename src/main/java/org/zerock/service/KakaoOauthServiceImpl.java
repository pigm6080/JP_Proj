package org.zerock.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;
import org.zerock.domain.AuthVO;
import org.zerock.domain.KakaoTokenVO;
import org.zerock.domain.UserVO;
import org.zerock.mapper.UserMapper;
import org.zerock.oauthutil.OTPgenerator;
import org.zerock.security.domain.Role;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
@PropertySource("classpath:/oauth/KakaoOauthClient.properties")
public class KakaoOauthServiceImpl implements KakaoOauthService {

	// 서비스에 필요한 상수

	private static final String REDIRECT_URI = "http://localhost:8082/Oauth/kakao/getAuth";
	private static final String VALIDATION_URL = "https://kapi.kakao.com/v1/user/access_token_info"; // https://
	private static final String KAPI_PREFIX = "https://kapi.kakao.com/";
	private static final String LOGOUT_URL = "https://kauth.kakao.com/oauth/logout";
	private static final String AUTHRIZATION_URL = "https://kauth.kakao.com/oauth/authorize";
	private static final String TOKEN_REQUEST_URL = "https://kauth.kakao.com/oauth/token";

	@Value("${client_id}")
	private String REST_API_KEY; // client_id

	@Value("${client_secret}")
	private String CLIENT_SECRET; // client_secret
	
	@Autowired
	private UserMapper mapper;
	
	

	@Override
	public String tokenValidation(KakaoTokenVO token) {
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
		log.info("토큰 유효성검사 resp 응답코드 :" + rsVal.getStatusCodeValue() + "그리고" + rsVal.getStatusCode().toString());

		if (rsVal.getStatusCode().value() != 200) {
			log.info("응답 상태 코드 200이 아니래!!!!" + rsVal.getStatusCode().toString());
			return rsVal.getStatusCode().toString();
		}

		log.info("응답 상태 코드 200!!!!");
		return rsVal.getStatusCode().toString();
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
		params.add("redirect_uri", REDIRECT_URI); // FIXME Port번호 맞게 수정
		params.add("code", code); // Code는 항상 달라짐
		params.add("client_secret", CLIENT_SECRET);

		HttpEntity<MultiValueMap<String, String>> kakaoTokenReq = new HttpEntity<>(params, headers);

		log.info(kakaoTokenReq);
		ResponseEntity<String> response = rt.exchange(TOKEN_REQUEST_URL, // https://{요청할 서버 주소}
				HttpMethod.POST, // 요청할 방식
				kakaoTokenReq, // 요청할 때 보낼 데이터
				String.class // 요청 시 반환되는 데이터 타입
		);

		// TODO 응답코드별 에러처리 필요!!
//		log.info(response);
//		log.info("응답코드 헤더: "+response.getHeaders()); //String[] format
//		log.info(response.getStatusCode());
//		log.info("응답코드 밸류: "+response.getStatusCode().value()); //200
//		log.info("응답코드 밸류 타입: "+response.getStatusCode().getClass().getName()); //org.springframework.http.HttpStatus

		if (response.getStatusCode().value() == 200) {
			log.info("응답 상태 코드 200이래!!!!");
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
		log.info("카카오 인증코드 : " + token.getAccess_token());

//		if(valToken(token.getAccess_token(),token.getToken_type())==0) {
//			log.info("good token");
//		}
		return token;
	}

	@Override
	public UserVO getKakaoUserInfo(@ModelAttribute KakaoTokenVO token)
			throws JsonMappingException, JsonProcessingException {
		// For Info Get
		RestTemplate rt2 = new RestTemplate();

		// Header ADD
		HttpHeaders headers2 = new HttpHeaders(); // org.springframework.http.HttpHeaders IMPORT ! ! !
		headers2.add("Authorization", "Bearer " + token.getAccess_token()); // token.getToken_type() =
																			// "Bearer"
		headers2.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		HttpEntity<MultiValueMap<String, String>> kakaoTokenReq2 = new HttpEntity<>(headers2);

		ResponseEntity<String> response2 = rt2.exchange(KAPI_PREFIX + "v2/user/me", // https://{요청할 서버 주소}
				HttpMethod.POST, // 요청할 방식
				kakaoTokenReq2, // 요청할 때 보낼 데이터
				String.class // 요청 시 반환되는 데이터 타입
		);

		log.info("resp2 응답코드 :" + response2.getStatusCodeValue());

		// 문제 발생
		ObjectMapper omp = new ObjectMapper();
		JSONParser jParser = new JSONParser();
		JsonNode bodyJson = null;

		String bodyString = response2.getBody();
		log.info("response2 : " + response2);

		log.info("response2 : " + response2.getBody());

		log.info("bodyString : " + bodyString);

		bodyJson = omp.readTree(bodyString);
		log.info("bodyJson : " + bodyJson);

		JsonNode propertiesJson = bodyJson.get("properties");
		JsonNode kakaoAccount = bodyJson.get("kakao_account");
		JsonNode kakaoProfile = kakaoAccount.get("profile");
		/*
		 * Iterator<String> fieldNames = bodyJson.fieldNames();
		 * 
		 * 
		 * while (fieldNames.hasNext()) { String fieldName = fieldNames.next(); JsonNode
		 * fieldValue = bodyJson.get(fieldName);
		 * 
		 * // 필드 이름과 값을 출력 또는 원하는 작업 수행 log.info("Field: " + fieldName);
		 * log.info("Value: " + fieldValue); }
		 */
		
		
//		log.info("properties 순회");
//		Iterator<String> fieldNames = propertiesJson.fieldNames();
//
//		while (fieldNames.hasNext()) {
//			String fieldName = fieldNames.next();
//			JsonNode fieldValue = propertiesJson.get(fieldName);
//
//			// 필드 이름과 값을 출력 또는 원하는 작업 수행
//			log.info("Field: " + fieldName);
//			log.info("Value: " + fieldValue);
//		}
		
//		log.info("kakao_account 순회");
//		Iterator<String> fieldNames2 = kakaoAccount.fieldNames();
//
//		while (fieldNames2.hasNext()) {
//			String fieldName2 = fieldNames2.next();
//			JsonNode fieldValue2 = kakaoAccount.get(fieldName2);
//
//			// 필드 이름과 값을 출력 또는 원하는 작업 수행
//			log.info("Field: " + fieldName2);
//			log.info("Value: " + fieldValue2);
//		}
		
		
//		log.info("kakao_account의 프로필 순회");
//		Iterator<String> fieldNames3 = kakaoProfile.fieldNames();
//
//		while (fieldNames3.hasNext()) {
//			String fieldName3 = fieldNames3.next();
//			JsonNode fieldValue3 = kakaoProfile.get(fieldName3);
//
//			// 필드 이름과 값을 출력 또는 원하는 작업 수행
//			log.info("Field: " + fieldName3);
//			log.info("Value: " + fieldValue3);
//		}
//		TODO id to STring working.... 04 05 17: 36 ######$$$$$$$$$$$$$$$$$$$$$$$4
		
		log.info(bodyJson.get("id").asText());
		
		String username = bodyJson.get("id").asText(); // Numberic ID
		String password = OTPgenerator.generateTemporaryPassword();  //Temporary password (20) add
		String name = propertiesJson.get("nickname").asText();
		String phone = "null";
//		
		log.info(" username : " + username + "\n password : " + password + "\n name : "+ name + "\n phone : "+ phone);

		// bodyJson <- 결과 JSON
		
		AuthVO authvo = new AuthVO(username, "KakaoUser");
		
	        
	    // 여기서 사용자의 권한을 설정합니다.
	    
	        
		UserVO vo = new UserVO( username, password , authvo.getAuthorities());
		vo.setName(name);		// name
		vo.setPhone(phone);		// phone

		return vo;
	}

	@Override
	public String kakaoUrl() {
		String kakaoURL = "https://kauth.kakao.com/oauth/authorize?" + "client_id=" + REST_API_KEY + "&redirect_uri="
				+ REDIRECT_URI + "&response_type=code";
		return kakaoURL;
	}

	@Override
	public int kakaoLogOut(String access_token) {
		int result = 0;

		RestTemplate rt = new RestTemplate();
		HttpHeaders logOutHeader = new HttpHeaders();
		logOutHeader.add("Authorization", "bearer " + access_token);

		HttpEntity<MultiValueMap<String, String>> logOutReq = new HttpEntity<>(logOutHeader);

		ResponseEntity<String> logOutResponse = rt.exchange(KAPI_PREFIX + "v1/user/logout", // https://{요청할 서버 주소}
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

	// 유저 정보를 토대로 자동 회원가입을 진행시킴
	@Override
	public UserVO kakaoRegist(UserVO vo, UserServiceImpl userSrv) {
		// TODO Auto-generated method stub
		log.info("Kakao User정보를 토대로 회원가입을 진행시킵니다.");
		UserVO returnVO = null;
		
		if(userSrv.get(vo.getUsername()) != null) {
			
			UserVO returnUserName = userSrv.get(vo.getUsername());
			String thisUserName = returnUserName.getUsername();
			AuthVO newAuthVO = new AuthVO(thisUserName, Role.SNSMEMBER.name());
			
			userSrv.grantAuth(newAuthVO);
			//있다면 권한만 설정해준다
		}
		else if (userSrv.get(vo.getUsername()) == null) {
			AuthVO authVO = new AuthVO(vo.getUsername(), Role.SNSMEMBER.name());
			returnVO = vo;

			
			userSrv.register(returnVO, authVO);
			//없다면 등록하여야하고
		}
		
		return returnVO;

	}
}
