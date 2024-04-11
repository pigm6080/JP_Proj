<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>파일 정보 수정 폼</title>
</head>
<body>
    <h1>파일 정보 수정</h1>
   <form action="updateFile" method="post">
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="hidden" name="id" value="${file.id}"> <!-- hidden 타입으로 id 값을 전달 -->
    
    <!-- 수정 가능한 필드들 -->
    <label for="placeName">Place Name:</label><br>
    <input type="text" id="placeName" name="placeName" value="${file.placeName}"><br>

    <label for="description">Description:</label><br>
    <textarea id="description" name="description">${file.description}</textarea><br>

    <label for="address">Address:</label><br>
    <input type="text" id="address" name="address" value="${file.address}"><br>

    <label for="rating">Rating:</label><br>
    <input type="number" id="rating" name="rating" value="${file.rating}"><br>

    <label for="author">Author:</label><br>
    <input type="text" id="author" name="author" value="${file.author}"><br>

    <label for="phone_number">Phone Number:</label><br>
    <input type="text" id="phone_number" name="phone_number" value="${file.phone_number}"><br>

    <label for="sns_url">SNS URL:</label><br>
    <input type="text" id="sns_url" name="sns_url" value="${file.sns_url}"><br>

    <label for="other_info">Other Info:</label><br>
    <input type="text" id="other_info" name="other_info" value="${file.other_info}"><br>
    
    <!-- 수정 버튼 -->
    <input type="submit" value="Update">
</form>
</body>
</html>
