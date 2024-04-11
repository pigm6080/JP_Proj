<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">

  <head>
    <meta charset="UTF-8" />
	
		<meta name="_csrf" content="${_csrf.token}" />
		<meta name="_csrf_header" content="${_csrf.headerName}" />
	
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
        /* 비활성화된 상태의 버튼 스타일 */
        #submitBtn:disabled {
            background-color: #ccc;
            color: #666;
            cursor: not-allowed;
        }
    </style>
  </head>
  <body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
	<script>
	// 이메일 입력값을 가져오고,
	// 입력값을 서버로 전송하고 똑같은 이메일이 있는지 체크한 후
	// 사용 가능 여부를 이메일 입력창 아래에 표시
	const emailCheck = () => {
		 
		$(function() {
		    $(document).ajaxSend(function(e, xhr, options) {
		        xhr.setRequestHeader(header, token);
		    });
		});
		

	    const email = document.getElementById("username").value;
	    const checkResult = document.getElementById("check-result");
	    console.log("입력한 이메일", email);
	    // 아작스로 같이 보내줘야 먹는다. 스프링 시큐리티떄문에. crsf  변조 위조 방지
	    var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    
	    $.ajax({
	        // 요청방식: post, url: "email-check", 데이터: 이메일
	    	
	        type: "post",
	        url: "/email-check",
	        data: {
	            "username": email
	        },
	    	
	        beforeSend: function(xhr) {
	        	xhr.setRequestHeader(header, token);
	        },
	    	
	        success: function(res) {
	            console.log("요청성공", res);
	            console.log(res);
	            if (res == "ok") {
	                console.log("사용가능한 이메일");
	                checkResult.style.color = "green";
	                checkResult.innerHTML = "사용가능한 이메일";
	                document.getElementById("submitBtn").disabled = false;
	            } else {
	                console.log("이미 사용중인 이메일");
	                checkResult.style.color = "red";
	                checkResult.innerHTML = "이미 사용중인 이메일";
	                document.getElementById("submitBtn").disabled = true;
	            }
	        },
	        error: function(err) {
	            console.log("에러발생", err);
	        }
	    });
	}
	</script>
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
            onblur="emailCheck()"
          />
          <p id="check-result"></p>
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
        	 <button id="submitBtn" type="submit" disabled>가입하기</button>
        </div>

        	 <input type ="hidden" name ="${_csrf.parameterName}" value = "${_csrf.token}"/>
     	 </form>
    </div>
  </body>
</html>