package org.zerock.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.zerock.domain.AuthVO;
import org.zerock.domain.KakaoTokenVO;
import org.zerock.domain.UserVO;
import org.zerock.mapper.UserMapper;
import org.zerock.oauthutil.OTPgenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
@PropertySource("classpath:/oauth/KakaoOauthClient.properties")
public class KakaoOauthServiceImpl implements KakaoOauthService {

	private static final Logger logger = LoggerFactory.getLogger(KakaoOauthServiceImpl.class);
	
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
	@Autowired
	private UserServiceImpl userSrv;
	
	

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
	public KakaoTokenVO getToken(String code) throws IOException {
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

		return token;
	}

	@Override
	public UserVO getKakaoUserInfo(@ModelAttribute KakaoTokenVO token)
			throws IOException, RestClientException {
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
		ObjectMapper omp = new ObjectMapper();
		JsonNode bodyJson = null;

		String bodyString = response2.getBody();
		log.info("response2 : " + response2);
		log.info("response2 : " + response2.getBody());
		log.info("bodyString : " + bodyString);

		bodyJson = omp.readTree(bodyString);
		log.info("bodyJson : " + bodyJson);

		JsonNode propertiesJson = bodyJson.get("properties");
		JsonNode kakaoAccount = bodyJson.get("kakao_account");
		
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

		
		log.info(bodyJson.get("id").asText());
		
		String username = bodyJson.get("id").asText(); // Numberic ID
//		String password = OTPgenerator.generateTemporaryPassword();  //Temporary password (20) add
		String name = propertiesJson.get("nickname").asText();
		String phone = "null";
	
		log.info(" username : " + username + "\n password : " + "\n name : "+ name + "\n phone : "+ phone); //+ password 


//		Map<String, Object> voList = new HashMap<>();
	        
		UserVO vo = new UserVO();
		vo.setUsername(username.toString());
//		vo.setPassword(password);
		vo.setName(name);		// name
		vo.setPhone(phone);		// phone
//		vo.setAuthList(thisAuth);
		
		
//		voList.put("UserVO", vo);
//		voList.put("AuthVO", vo.getAuthList());
		
		return vo;
	}

	@Override
	public String kakaoUrl() {
		String kakaoURL = "https://kauth.kakao.com/oauth/authorize?" + "client_id=" + REST_API_KEY + "&redirect_uri="
				+ REDIRECT_URI + "&response_type=code";
		return kakaoURL;
	}

	@Override
	public int kakaoLogOut(String access_token ,HttpServletRequest request) {
		int result = 0;

		RestTemplate rt = new RestTemplate();
		HttpHeaders logOutHeader = new HttpHeaders();
		logOutHeader.add("Authorization", "bearer " + access_token);
	
		// CsrfToken 객체 가져오기
		CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

		// CsrfToken이 존재하는지 확인하고 헤더에 추가
		if (csrfToken != null) {
		    logOutHeader.add(csrfToken.getHeaderName(), csrfToken.getToken());
		}
		
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



//	@Override
//	public UserVO kakaoRegist(UserVO vo, UserServiceImpl userSrv) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	// 유저 정보를 토대로 자동 회원가입을 진행시킴
	@Override
	public String kakaoRegist(@RequestParam(value = "KakaoUserInfo") @ModelAttribute UserVO uservo , Model model) {
		String resultMsg = "Yes start : ";
		
		//새로운 권한 객채 생성
		AuthVO thisAuth = (AuthVO) kakaoRoleAdd(uservo.getUsername()).get("authVO");
		String msg = (String) kakaoRoleAdd(uservo.getUsername()).get("ResultMsg");
		
		UserVO dbread = mapper.read(uservo.getUsername());
		//등록을 진핸한다
		
		if((dbread) != null) {
	    //만약 유저VO getUsername()이 null이면 또 비밀번호가 설정되어있찌않다면 
			//권한 가져오고 비밀번호 설정
			thisAuth = uservo.getAuthList();
			if (dbread.getPassword().isEmpty() || dbread.getPassword()==null) {
			String password = OTPgenerator.generateTemporaryPassword();  //Temporary password (20) add
			uservo.setPassword(password);
			mapper.update(uservo);
			}
			
		}else if (mapper.read(uservo.getUsername()) == null) { //조회할 수 없는 유저면
			thisAuth = uservo.getAuthList();
			String password = OTPgenerator.generateTemporaryPassword();  //Temporary password (20) add
			uservo.setPassword(password);
			userSrv.register(uservo, thisAuth);
			resultMsg = resultMsg + "regist done, "; //등록 후 결과 메시지 추가
		}
		
		/* 여기부터 등록 후 확인작업 */
		
		
		logger.info("thisAuth : ", thisAuth != null? "권한이 없어서 추가됨": "권한이 이미 부여되어있음");
		
		logger.info("Kakao User정보를 토대로 회원가입을 진행시킵니다.");
		//전달받은 정보
		String receivedUserNm = uservo.getUsername();
		AuthVO FoundUserAuth = uservo.getAuthList();
		resultMsg = resultMsg + "received data confirmed, ";
		
		if (receivedUserNm == null || FoundUserAuth == null) {
			String errorPoint = receivedUserNm == null ? "receivedUserNm" :  (FoundUserAuth == null? "receivedUserAuth" : "Unknown Error");
			HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
			
			switch (errorPoint) {
			case "receivedUserNm" :
				
		        session.setAttribute("ErrorMsg", "Received UserName is null Check UserVO inserting process");
		        resultMsg = resultMsg + "error UserName null, ";
				return "redirect:/customLogin";
			case "receivedUserAuth":
				
		        session.setAttribute("ErrorMsg", "Received UserAuth is null Check AuthVO inserting process");
		        kakaoRoleAdd(receivedUserNm);
		        resultMsg = resultMsg + "error UserAuth null, Role add again ";
			}

		}
		//DB에서 불러온 정보
		String thisUserName = userSrv.get(uservo.getUsername()).getUsername();
		AuthVO thisUserAuth = userSrv.getUserAuth(thisUserName);
		
		if(thisUserName != null) {
			if(thisUserName.equals(thisUserAuth.getUsername())) {
				userSrv.grantAuth(thisAuth);
				resultMsg = resultMsg + "Role granted again for role add ,";
			}
		}
		else if (userSrv.get(uservo.getUsername()) == null) {
			userSrv.register(uservo, thisAuth);
			resultMsg = resultMsg + "getUsername NOT FOUND regist again ,";
		}else if (userSrv.getUserAuth(thisUserName) == null) {
			resultMsg = resultMsg + "Role granted again for role add ,";
			mapper.insertAuth(thisAuth);
		}
		model.addAttribute("UserVO", thisUserAuth);
		model.addAttribute("AuthVO", thisUserAuth);
		
		return resultMsg;

	}
	
	private Map<String, Object> kakaoRoleAdd(String username) {
		AuthVO injectAuth = new AuthVO(username, "KakaoUser");
		int result = 0;
		if (userSrv.getUserAuth(username)==null) {
			System.out.println("권한을 제대로 읽어올 수 없음. 새로운 추가 진핸");
			mapper.insertAuth(injectAuth);
			result = 1;
		}else { //권한이 있다는게 확인된다면
			System.out.println(mapper.getUserAuth(username).getAuthorities());
			mapper.grantAuth(injectAuth);
			result = 2;
		}
		Map<String, Object> answer = new HashMap<>();
		answer.put("ResultMsg", Integer.toString(result));
		answer.put("authVO", injectAuth);
		
		return answer;
		
	}

}
