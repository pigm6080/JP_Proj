<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
		#loginForm {
			display:none;
		}
</style>
<body>
	폼 자동제출 . . .
	<p>${username}</p>
	<p>${password}</p>
<!-- 	<form id="loginForm" action="/login" method="post"> -->
<%-- 		<input type="hidden" id="username" name="username" value="${snsUserInfo.username}" /> --%>
<%-- 		<input type="hidden" id="password" name="password" value="${snsUserInfo.password}" /> --%>
<%-- 		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" /> --%>
<!-- 	</form> -->
	
	
	<form id="loginForm" action="/kakaoLoginProcess" method="post">
	          <input type="text" id="username"   name="username"  value="${username}"/>
	          <input type="password" id="password"  name="password"   value="${password}"/>
	        <input type ="hidden" name ="${_csrf.parameterName}" value = "${_csrf.token}"/>
	</form>
	<script type="text/javascript">
		//         window.location.replace("/kakaoLogin");
		
		var snsUserName = '<c:out value="${username}"/>';
		var snsUserPswd = '<c:out value="${password}"/>';
		console.log("jstl",snsUserName);
		console.log("jstl",snsUserPswd);
		
		var username = document.querySelector('#username');
		var password = document.querySelector('#password');
		console.log("querySelector",username);
		console.log("querySelector",password);
		
		if (username != "" || username != null || username != undefined) {

			document.getElementById("loginForm").submit();
		}
		
	
		
		
	
// 		function login() {
// 		    var username = "${snsUserInfo.username}"; // 로그인 폼에서 입력한 사용자명
// 		    var password = "${snsUserInfo.password}"; // 로그인 폼에서 입력한 비밀번호
// 			var csrftoken = "${_csrf.token}";
			
// 		    // XMLHttpRequest 객체를 생성하여 POST 요청 보내기
// 		    var xhr = new XMLHttpRequest();
// 		    xhr.open("POST", "/login", true);
// 		    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

// 		    // CSRF 토큰을 헤더에 추가
// 		    xhr.setRequestHeader("X-CSRF-TOKEN", csrftoken);
		    
// 		    xhr.onreadystatechange = function() {
// 		        if (xhr.readyState === 4 && xhr.status === 200) {
// 		            // 로그인 성공 후 처리할 작업
// 		            window.location.href = "/"; // 로그인 성공 후 이동할 URI
// 		        }
// 		    };
// 		    // POST 요청에 사용될 데이터 설정
// 		    var params = "username=" + encodeURIComponent(username) + "&password=" + encodeURIComponent(password);
// 		    xhr.send(params);
// 		}
	</script>
</body>
</html>