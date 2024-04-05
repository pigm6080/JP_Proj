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

        <label for="destination">여행지:</label><br>
        <input type="text" id="destination" name="destination" required><br>
        
        <label for="description">설명:</label><br>
        <textarea id="description" name="description" rows="4" cols="50" required></textarea><br>
        
        <label for="category_id">카테고리:</label><br>
        <select id="category_id" name="category_id" required>
            <option value="">카테고리 선택</option>
            <option value="1">카테고리 1</option>
            <option value="2">카테고리 2</option>
            <option value="3">카테고리 3</option>
            <!-- 필요한 만큼 카테고리 옵션을 추가하세요 -->
        </select><br>
        
        <!-- 파일 업로드 입력 필드 -->
        <label for="file">파일 업로드:</label><br>

    <input type="file" id="file" name="file" multiple><br><br>
     <input type ="hidden" name ="${_csrf.parameterName}" value = "${_csrf.token}"/>
    <button type="submit">Submit</button>
</form>



</body>
</html>