<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>   
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta charset="UTF-8">
<title>J발 너 P야 ? 에러페이지</title>
</head>
<body>
	<h1>J발 너 P야 ? 에러페이지</h1>
	
	<h2><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}" /></h2>
	
	<h2><c:out value="${msg }"/></h2>
</body>
</html>