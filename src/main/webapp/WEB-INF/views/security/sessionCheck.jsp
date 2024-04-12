<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>Insert title here</title>
</head>
<body>


<h1>유저 로그인 세션 확인</h1>



<h2>session 기본추가확인</h2>
<p>check : ${Check}</p>

<hr>
<h2>session checker 커스텀메소드를 통한 확인</h2>
<p>${sChecker}</p>

<hr>
<h2>@AuthenticationPrincipal을 통한 확인</h2>

<p>유저이름 : ${userNm}</p>
<p>유저비밀번호 : ${principal}</p>


<p>princ : ${princ}</p>

<h2>auth을 통한 확인</h2>
<p>auth : ${auth}</p>
</body>
</html>