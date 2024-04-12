<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8" />
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>로그인 페이지</title>
<link rel="icon" href="resources/img/JP.png" />
<link rel="stylesheet"
	href="resources/styles/regMemberStyles/loginMember.css" />
<link rel="stylesheet" href="resources/styles/reset.css" />
<style>
@font-face {
	font-family: "MaplestoryBold";
	src: url("resources/font/Maplestory\ Bold.ttf") format("truetype");
}

      body {
        font-family: "MaplestoryBold", sans-serif;
      }
    </style>
  </head>
  <body>
  	<h2><c:out value="${error }"/></h2>
	<h2><c:out value="${logout }"/></h2>
	    <div id="wrap">
	      <div class="title">
	        <div class="title_header">
	          <img src="resources/img/로고02.png" alt="로고" />
	          <h1>너 J발 P야?</h1>
	        </div>
	        <p>J발 P야? 회원가입으로 모든 서비스를 이용할 수 있어요</p>
	      </div>
	      <div class="login_form">
		<form action="${request.pageContext.contextPath}/login" method="post">
	        <div class="inputBox">
	          <label for="username">아이디</label>
	          <input type="text" id="username" name="username" />
	        </div>
	        <div class="inputBox">
	          <label for="password">비밀번호</label>
	          <input type="password" id="password" name="password" />
	        </div>
	        
	        <button type="submit" class="login_button">로그인</button>
	        <input type ="hidden" name ="${_csrf.parameterName}" value = "${_csrf.token}"/>
	</form>
	        <p class="joinus">
	          아직 회원이 아니신가요? ->
	          <a href="/regMember" class="reg">회원가입</a>
	          
	        </p>
	      </div>
	
      <div class="sns_login">
        <div class="login_dec"></div>
        <p>SNS 계정으로 로그인</p>
        <div class="login_dec"></div>
      </div>
      <div class="sns_icon">
        <a href="/Oauth/kakao/kakaologin"><img
			
				src="resources/img/kakao.png" alt="카카오" /></a> <a
				href="/Oauth/kakao/checkSession"><img
				src="resources/img/kakao.png" alt="카카오" />세션체크용</a> <a href="#"><img
				src="resources/img/naver.png" alt="네이버" /></a> <a href="#"><img
				src="resources/img/facebook.png" alt="구글" /></a>
		</div>

		<div class="login_footer">
			<p>Copyright © 2024 J발 P야? | Designed with ❤️ by J.P</p>
		</div>
	</div>


</body>
<script type="text/javascript">
	var prevPageCheck = '<c:out value="${prevPage}"/>';
	var isLoginTry = '<c:out value="${loginTry}"/>';

	

	if (prevPageCheck == "kakaoOauth" && isLoginTry == "Oauth_authenticated") {
		document.getElementById("loginForm").addEventListener(
				"submit",
				function(event) {
					event.preventDefault(); // 기본 폼 제출 방지

					var csrfHeader = '<c:out value="${_csrf.parameterName}"/>';
					var csrfToken = '<c:out value="${_csrf.token}"/>';
					console.log("이전 페이지 체크 : ", prevPageCheck);
					console.log("로그인 시도 체크 : ", isLoginTry);

					var snsUserName = '<c:out value="${username}"/>';
					var snsUserPswd = '<c:out value="${password}"/>';

					var xhr = new XMLHttpRequest();
					xhr.open("POST", "/login", true);
					xhr.setRequestHeader("Content-Type",
							"application/x-www-form-urlencoded");
					xhr.setRequestHeader(csrfHeader, csrfToken); // CSRF 토큰 설정

					xhr.onreadystatechange = function() {
						if (xhr.readyState == 4 && xhr.status == 200) {
							// 요청 성공 시 처리
							console.log(xhr.responseText);
						}
					};

					var data = "username=" + encodeURIComponent(snsUserName)
							+ "&password=" + encodeURIComponent(snsUserPswd);
					xhr.send(data); // 데이터 전송
				});
		
		document.getElementById("loginForm").submit();

	}else {
		document.getElementById("loginForm").addEventListener("submit",	function(event) {
			document.getElementById("loginForm").submit();
		}
	}
</script>
</html>

