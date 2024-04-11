<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="_csrf" content="${_csrf.token}" />
	<meta name="_csrf_header" content="${_csrf.headerName}" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>여행정보 업로드</title>
    
    <!-- IONICONS -->
    <script
      src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"
    ></script>

    <style>
      @font-face {
        font-family: "MaplestoryBold";
        src: url("../resources/font/Maplestory Bold.ttf") format("truetype");
      }
      
      @font-face {
        font-family: "Maplestory Light";
        src: url("../resources/font/Maplestory Light.ttf") format("truetype");
      }
      
      body {
        font-family: "MaplestoryBold", "MaplestoryLight", sans-serif;
      }

    </style>
  </head>
<body>


<h1>여행정보 업로드</h1>


<form action="/trip/addUserAndFile" method="post" enctype="multipart/form-data">
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<%--    <sec:csrfInput/> --%>
   <label for="username">사용자</label>
   <input type="text" id="username" name="username"><br><br>
    <label for="placeName">여행지명</label>
    <input type="text" id="placeName" name="placeName"><br><br>
    <label for="hashtag">해시태그</label>
    <input type="text" id="hashtag" name="hashtag"><br><br>
    <label for="description">한줄소개</label>
    <input type="text" id="description" name="description"><br><br>
    <label for="address">주소</label>
    <input type="text" id="address" name="address"><br><br>
    <label for="rating">별점</label>
    <input type="number" id="rating" name="rating" min="0" max="5" step="1"><br><br>
    <label for="author">작성자</label>
    <input type="text" id="author" name="author"><br><br>
    <label for="phone_number">매장번호</label>
    <input type="text" id="phone_number" name="phone_number"><br><br>
    <label for="sns_url">SNS 주소</label>
    <input type="text" id="sns_url" name="sns_url"><br><br>
    <label for="other_info">기타정보</label>
    <input type="text" id="other_info" name="other_info"><br><br>
    <label for="file">파일업로드</label>
    <input type="file" id="file" name="file" multiple><br><br>
    <button type="submit">Submit</button>
   
</form>

<style>
body {
    font-family: 'Maplestory Light', sans-serif;
    margin: 0;
    padding: 20px;
    background-color: #f4f4f4;
}

form {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
}

label {
    color: rgba(42, 193, 188, 0.8);
    font-weight: bold;
}

input[type="text"],
input[type="number"],
input[type="file"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid rgba(42, 193, 188, 0.5);
    border-radius: 5px;
    box-sizing: border-box; /* So padding does not affect width */
}

input[type="submit"],
button {
    background-color: #2ac1bc;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.1s ease;
}

input[type="submit"]:hover,
button:hover {
    opacity: 0.6;
}

input[type="submit"]:active,
button:active {
    transform: translateY(2px);
}

input:focus,
button:focus {
    outline: none;
    border-color: rgba(42, 193, 188, 0.8);
}

::placeholder { 
    color: rgba(0,0,0,0.4);
    opacity: 1; 
}


</style>
<script>
document.addEventListener('DOMContentLoaded', function() {

    const form = document.querySelector('form');
    const requiredFields = document.querySelectorAll('input[required]');


    form.addEventListener('submit', function(event) {
        let isFormValid = true;


        requiredFields.forEach(field => {
            if (!field.value.trim()) {
                isFormValid = false;
                field.style.borderColor = 'red';
            } else {
                field.style.borderColor = ''; 
            }
        });

        if (!isFormValid) {
            event.preventDefault();
            alert('모든 항목을 입력해주세요.');
            return false;
        }

        const fileInput = document.querySelector('input[type="file"]');
        if (fileInput.files.length > 0) {
            console.log("파일 업로드 시작...");
        }
    });

    const buttons = document.querySelectorAll('button');
    buttons.forEach(button => {
        button.addEventListener('mousedown', function() {
            this.style.transform = 'scale(0.95)';
        });
        button.addEventListener('mouseup', function() {
            this.style.transform = 'scale(1)';
        });
        button.addEventListener('mouseleave', function() {
            this.style.transform = 'scale(1)';
        });
    });
});
</script>


</body>
</html>