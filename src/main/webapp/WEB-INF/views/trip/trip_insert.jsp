<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행정보 업로드</title>
</head>
<body>


<h1>여행정보 업로드</h1>


<form action="/addUserAndFile" method="post" enctype="multipart/form-data">
	<label for="username">사용자:</label>
	<input type="text" id="username" name="username"><br><br>
    <label for="placeName">여행지명:</label>
    <input type="text" id="placeName" name="placeName"><br><br>
    <label for="hashtag">해시태그:</label>
    <input type="text" id="hashtag" name="hashtag"><br><br>
    <label for="description">한줄소개:</label>
    <input type="text" id="description" name="description"><br><br>
    <label for="address">주소:</label>
    <input type="text" id="address" name="address"><br><br>
    <label for="rating">별점:</label>
    <input type="number" id="rating" name="rating" min="0" max="5" step="1"><br><br>
    <label for="author">작성자:</label>
    <input type="text" id="author" name="author"><br><br>
    <label for="phone_number">매장번호:</label>
    <input type="text" id="phone_number" name="phone_number"><br><br>
    <label for="sns_url">SNS 주소:</label>
    <input type="text" id="sns_url" name="sns_url"><br><br>
    <label for="other_info">기타정보:</label>
    <input type="text" id="other_info" name="other_info"><br><br>
    <label for="file">파일업로드:</label>
    <input type="file" id="file" name="file" multiple><br><br>
    <button type="submit">Submit</button>
      <input type ="hidden" name ="${_csrf.parameterName}" value = "${_csrf.token}"/>
</form>




</body>
</html>