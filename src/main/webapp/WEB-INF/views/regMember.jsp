<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원가입 페이지</title>
    <link rel="icon" href="./img/JP.png" />
    <link rel="stylesheet" href="./styles/reset.css" />
    <link rel="stylesheet" href="./styles/regMemberStyles/regMember.css" />
    <style>
      @font-face {
        font-family: "MaplestoryBold";
        src: url("./font/Maplestory\ Bold.ttf") format("truetype");
      }

      body {
        font-family: "MaplestoryBold", sans-serif;
      }
    </style>
  </head>
  <body>
    <div class="signup-form">
      <h2>회원가입</h2>
      <form>
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
      </form>
    </div>
  </body>
</html>
