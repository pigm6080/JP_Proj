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

<h1>Logout Page</h1>

	<form action="/logOutProcess" method="post" id="logoutForm">>
	    <input type="hidden" name="username" value="${loggedInUser.userName}"/>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
<!-- 		<button>로그아웃</button> -->
	</form>
</body>
<script type="text/javascript">
	document.getElementById("logoutForm").submit();
</script>
</html>