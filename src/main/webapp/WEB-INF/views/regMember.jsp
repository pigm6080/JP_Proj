<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
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
      
      <form action="/reg" method="post"> 
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
