<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<script>
  function validateForm() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var name = document.getElementById("name").value;
    var phone = document.getElementById("phone").value;

    // 아이디 필드 유효성 검사
    if (username == "") {
      alert("아이디를 입력하세요.");
      return false;
    }

    // 비밀번호 필드 유효성 검사
    if (password == "") {
      alert("비밀번호를 입력하세요.");
      return false;
    }

    // 이름 필드 유효성 검사
    if (name == "") {
      alert("이름을 입력하세요.");
      return false;
    }

    // 전화번호 필드 유효성 검사
    if (phone == "") {
      alert("전화번호를 입력하세요.");
      return false;
    }

    // 전화번호는 숫자로만 구성되어야 함
    if (!/^\d+$/.test(phone)) {
      alert("전화번호는 숫자로만 입력하세요.");
      return false;
    }

    // 전화번호는 10자리 또는 11자리여야 함
    if (phone.length != 10 && phone.length != 11) {
      alert("전화번호는 10자리 또는 11자리여야 합니다.");
      return false;
    }

    // 모든 유효성 검사 통과 시 true 반환
    return true;
  }
</script>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원가입 페이지</title>
    <link rel="icon" href="resources/img/JP.png" />
    <link rel="stylesheet" href="resources/styles/reset.css" />
    <link rel="stylesheet" href="resources/styles/regMemberStyles/regMember.css" />
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
    <div class="signup-form">
      <h2>회원가입</h2>
      
      <form action="/reg" method="post" onsubmit="return validateForm()"> 
        <div class="form-group">
          <label for="username">아이디</label>
          <input
            type="text"
            id="username"
            name="username"
            placeholder="아이디를 입력하세요"
          />
        </div>

        <div class="form-group">
          <label for="password">비밀번호</label>
          <input
            type="password"
            id="password"
            name="password"
            placeholder="비밀번호를 입력하세요"
          />
        </div>
        
        <div class="form-group">
          <label for="name">이름</label>
          <input
            type="text"
            id="name"
            name="name"
            placeholder="이름을 입력하세요"
          />
        </div>
 			
        <div class="form-group">
          <label for="phone">전화번호</label>
          <input
            type="tel"
            id="phone"
            name="phone"
            placeholder="전화번호를 입력하세요"
          />
        </div>
               
        <div class="form-group">
          <button type="submit">가입하기</button>
        </div>

        	 <input type ="hidden" name ="${_csrf.parameterName}" value = "${_csrf.token}"/>
     	 </form>
    </div>
  </body>
</html>
