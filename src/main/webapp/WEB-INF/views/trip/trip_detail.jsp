<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>여행정보 - 상세조회</title>
<link rel="icon" href="../resources/img/JP.png" />
<link rel="stylesheet" href="../resources/styles/Header.css" />
<link rel="stylesheet" href="../resources/styles/test.css" />
<link rel="stylesheet" href="../resources/styles/reset.css">
<link rel="stylesheet"
	href="../resources/styles/infoDetailStyles/infoHash.css">
<link rel="stylesheet"
	href="../resources/styles/infoDetailStyles/infoDetail.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
<script defer src="../resources/js/test.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- IONICONS -->
<script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>

<!-- JS -->
<!--      <script defer src="../resources/js/test.js"></script> -->


<!--  댓글 부분 -->
<script type="text/javascript" src="../resources/js/reply.js"></script>
<script type="text/javascript">
	/*
	console.log("=================");
	console.log("JS TEST");
	
	var bnoValue = '${id}';
	
	console.log(bnoValue);
	
	
	
	replyService.add(
		{reply:"JS  TEST" , replyer :"tester" , bno:bnoValue} // reply
		,
		function(result){
			alert("RESULT " + result);
	);
	
	
	replyService.getList({bno:bnoValue,page:1} , function(list){
		
		for(var i=0, len =list.length || 0; i< len; i++){
			console.log(list[i]);
		}
		
	});
	
	
	replyService.remove(2 , function(count){
		
		console.log(count);
		
		if(count ==="success"){
			alert("REMOVED");
		} }
		,function(err){
			alert('ERROR...');
		});
	
	replyService.update({
		rno : 1,
		bno : bnoValue,
		reply : "Modify Reply...."
	}, function(result){
		
		alert("수정완료...");
	});
	
	replyService.get(1, function(data){
		console.log(data);
	});
	
	rest댓글 테스트 완료
	 */
	$(document)
			.ready(
					function() {
						var operForm = $("#operForm");

						$("button[data-oper='modify']").on(
								"click",
								function(e) {
									operForm.attr("action", "/board/modify")
											.submit();
								});

						$("button[data-oper='list']").on("click", function(e) {
							operForm.find("#bno").remove();
							operForm.attr("action", "/board/list");
							operForm.submit();
						});

						console.log('자바 스크립트 시작');

						var bnoValue = '${id}';
						var replyUL = $(".chat");

						console.log(bnoValue + replyUL);

						showList(1);

						function showList(page) {

							replyService
									.getList(
											{
												bno : bnoValue,
												page : page || 1
											},
											function(list) {
												var str = "";
												if (list == null
														|| list.length == 0) {
													replyUL.html("");
													return;
												}

												for (var i = 0, len = list.length || 0; i < len; i++) {
													console
															.log('자바 스크립트 	출력 2시작');
													str += "<li class='list clearfix' data-rno='" + list[i].rno + "'>";
													str += "<div><div class='header'><strong class='primary-font'>"
															+ list[i].replyer
															+ "</strong>";
													str += " <small class='pull-right text-muted'>"
															+ replyService
																	.displayTime(list[i].replyDate)
															+ "</small></div>";
													str += "<p>"
															+ list[i].reply
															+ "</p></div></li>";
													str += "<br>"
												}
												replyUL.html(str);
											}); //end function
						}//end showList

						var modal = $('.modal');
						var modalInputReply = modal.find("input[name='reply']");
						var modalInputReplyer = modal
								.find("input[name='replyer']");
						var modalInputReplyDate = modal
								.find("input[name='replyDate']");

						var modalModBtn = $('#modalModBtn');
						var modalRemoveBtn = $('#modalRemoveBtn');
						var modalRegisterBtn = $('#modalRegisterBtn');

						$("#addReplyBtn").on('click', function(e) {
							console.log('addReplyBtn');
							modal.find("input").val("");
							modalInputReplyDate.closest('div').hide();
							modal.find("button[id != 'modalCloseBtn']").hide();

							modalRegisterBtn.show();

							$(".modal").modal("show");
						}); //on end

						modalRegisterBtn.on("click", function(e) {
							var reply = {
								reply : modalInputReply.val(),
								replyer : modalInputReplyer.val(),
								bno : bnoValue
							};

							replyService.add(reply, function(result) {
								alert(result);
								modal.find("input").val("");

								//새로고침해서 새롭게달린 글을 가져온다.
								showList(1);
							});
						});

					});
</script>

<style>
@font-face {
	font-family: 'MaplestoryBold';
	src: url('../resources/font/Maplestory\ Bold.ttf') format('truetype');
}

body {
	font-family: 'MaplestoryBold', sans-serif;
}

</style>
</head>
<body>
	<header>
		<div class="nav" style="opacity: 0.8;">
			<div class="logo-group">
				<div class="logo">
					<a href="/"> <img src="../resources/img/로고02.png" alt="로고" />
						<span class="project-name">너 J발 P야?</span></a>
				</div>
			</div>
			<div class="nav-buttons">
				<button class="button" data-section="home">홈</button>
				<button class="button" data-section="them">테마</button>
				<button class="button" data-section="planer">여행플래너</button>
				<button class="button  on" data-section="trip_info">여행정보</button>
				<button class="button" data-section="community">커뮤니티</button>
			</div>
			<!--로그인 정보단-->


			<h1 class="username">${user.name}${UserName}</h1>
			<h1 class="username">${SNSUserName}</h1>
			<div class="auth-buttons">
				<button id="loginButton" class="button"
					onclick="location.href='/customLogin'">로그인</button>
				<button id="registerButton" class="button"
					onclick="location.href='/regMember'">회원가입</button>

				<form action="/customLogout" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<button id="logoutBtnton" class="button nondisplay">로그아웃</button>
				</form>

				<!-- 										<button id="logoutBtnton" class="button nondisplay" -->
				<!-- 											onclick="location.href='/customLogout'">로그아웃</button> -->
			</div>
		</div>

		<!--로그인 javascript-->


		<script>
			//   페이지 로드 후 호출되는 함수
			window.onload = function() {
				checkSession();
			};

			// 세션에 값이 있는지 확인하는 함수
			function checkSession() {
				$.ajax({
					url : '/Oauth/kakao/checkSession', // 세션 확인을 위한 서버 엔드포인트
					type : 'GET',
					success : function(data) {
						if (data.indexOf("ROLE") != -1
								|| data.indexOf("Kakao") != -1) {
							// 											console.log(data);
							// 세션에 값이 있는 경우
							document.getElementById("loginButton").classList
									.add("nondisplay");
							document.getElementById("registerButton").classList
									.add("nondisplay");
							document.getElementById("logoutBtnton").classList
									.remove("nondisplay");
						} else if (!data) {
							document.getElementById("loginButton").classList
									.remove("nondisplay");
							document.getElementById("registerButton").classList
									.remove("nondisplay");
							document.getElementById("logoutBtnton").classList
									.add("nondisplay");
						}
					},
					error : function(xhr, status, error) {
						console.error('Error occurred during session check:',
								error);
					}
				});
			}

			function logout() {
				// CSRF 토큰 가져오기
				var csrfTokenMeta = document
						.querySelector('meta[name="_csrf"]');
				var csrfHeaderMeta = document
						.querySelector('meta[name="_csrf_header"]');

				// CSRF 토큰과 헤더 이름이 유효한지 확인
				if (csrfTokenMeta && csrfHeaderMeta) {
					var csrfToken = csrfTokenMeta.getAttribute('content');
					var csrfHeader = csrfHeaderMeta.getAttribute('content');

					// XMLHttpRequest 객체 생성
					var xhr = new XMLHttpRequest();

					// 요청 설정
					xhr
							.open("GET", "http://localhost:8082/logOutProcess",
									true); // true는 비동기 방식을 의미

					// 요청 헤더에 CSRF 토큰 추가
					xhr.setRequestHeader(csrfHeader, csrfToken);

					// 응답 처리
					xhr.onload = function() {
						if (xhr.status >= 200 && xhr.status < 300) {
							// 요청이 성공한 경우 응답 처리
							console.log(xhr.responseText); // 응답 데이터 출력
						} else {
							// 요청이 실패한 경우 오류 처리
							console.error("Request failed with status",
									xhr.status);
						}
					};

					// 요청 보내기
					xhr.send();
				} else {
					console.error("CSRF 토큰 또는 헤더를 찾을 수 없습니다.");
				}
			}
		</script>
		<!-- 사이드 퀵nav-->
		<div class="l-navbar" id="navbar">
			<nav class="nav_t">
				<div>
					<div class="nav__brand">
						<ion-icon name="menu-outline" class="nav__toggle" id="nav-toggle"></ion-icon>
						<a href="../resources/index.html" class="nav__logo">너 J발 P야?</a>
					</div>
					<div class="nav__list">
						<a href="/" class="nav__link "> <ion-icon name="home-outline"
								class="nav__icon"></ion-icon> <span class="nav_name">홈</span>
						</a> <a href="/tema/home" class="nav__link collapse active"> <ion-icon
								name="chatbubbles-outline" class="nav__icon"></ion-icon> <span
							class="nav_name">테마</span>
						</a> <a href="/planner/home" class="nav__link "> <ion-icon
								name="folder-outline" class="nav__icon"></ion-icon> <span
							class="nav_name">플래너</span>
						</a> <a href="/trip/home" class="nav__link"> <ion-icon
								name="pie-chart-outline" class="nav__icon"></ion-icon> <span
							class="nav_name">여행정보</span>
						</a> <a href="/community/home" class="nav__link collapse"> <ion-icon
								name="people-outline" class="nav__icon"></ion-icon> <span
							class="nav_name">커뮤니티</span>
						</a>
					</div>
			</nav>
		</div>
	</header>
	<!--여행정보 상단 해시태그부분-->
	<section id="info_hash">
		<div class="info_title_box">
			<div class="info_title">
				<h1>
					용인 여행 <span>버킷리스트</span>
				</h1>
			</div>
			<div class="hashtag">
				<div class="hashtag_circle1">
					<img src="../resources/img/infoimg01.png" alt="">
					<p class="hashtag_title_text">#카페</p>
				</div>
				<div class="hashtag_circle1">
					<img src="../resources/img/infoimg02.png" alt="">
					<p class="hashtag_title_text">#맛집</p>
				</div>
				<div class="hashtag_circle1">
					<img src="../resources/img/infoimg03.png" alt="">
					<p class="hashtag_title_text">#체험</p>
				</div>
				<div class="hashtag_circle1">
					<img src="../resources/img/infoimg04.png" alt="">
					<p class="hashtag_title_text">#공원</p>
				</div>
				<div class="hashtag_circle1">
					<img src="../resources/img/infoimg05.png" alt="">
					<p class="hashtag_title_text">#테마</p>
				</div>
				<div class="hashtag_circle1">
					<img src="../resources/img/infoimg06.png" alt="">
					<p class="hashtag_title_text">#공방</p>
				</div>
				<div class="hashtag_circle1">
					<img src="../resources/img/infoimg07.png" alt="">
					<p class="hashtag_title_text">#축제</p>
				</div>
				<div class="hashtag_circle1">
					<img src="../resources/img/infoimg08.png" alt="">
					<p class="hashtag_title_text">#전시</p>
				</div>
				<div class="hashtag_circle1">
					<img src="../resources/img/infoimg09.png" alt="">
					<p class="hashtag_title_text">#야경</p>
				</div>
			</div>
		</div>
	</section>
	<!--상세조회 영역-->
	<section id="detail_main">
		<!-- 파일 목록을 순회하며 이미지 출력 -->
		<div class="detail_title_container">
			<c:forEach var="file" items="${files}">
				<!-- 현재 파일이 선택한 장소와 같은 장소일 때 -->
				<c:if test="${file.placeName eq placeName}">
					<!-- 이미지 출력 -->
					<h1 class="detail_title">${file.placeName }</h1>
					<p class="detail_sub_title" style="padding-bottom: 30px;">${file.description }</p>
					<img src="/trip${file.filepath}"
						style="width: 1250px; height: 800px; opacity: 0.7; padding-bottom: 30px;">
				</c:if>
			</c:forEach>
		</div>
	</section>
	<c:set var="placeInfoDisplayed" value="false" />
	<!-- 파일 목록을 다시 순회하며 장소 정보 출력 -->
	<c:forEach var="file" items="${files}">
		<!-- 현재 파일이 선택한 장소와 같은 장소일 때 -->
		<c:if test="${file.placeName eq placeName}">
			<!-- 장소 정보가 아직 출력되지 않았다면 -->
			<c:if test="${not placeInfoDisplayed}">
				<!-- 장소 정보 출력 -->
				<!-- placeInfoDisplayed 변수를 true로 설정하여 다른 장소 정보를 더이상 출력하지 않도록 함 -->
				<section id="detail_info">
					<div class="detail_info_title">
						<h1>상세정보</h1>
					</div>
					<div class="detail_info_content">
						<div class="info_address info">
							<i class="fa-solid fa-location-dot fa-xl"></i>
							<p class="address">${file.address}</p>
						</div>
						<div class="phone info">
							<i class="fa-solid fa-phone fa-xl"></i>
							<p class="phone_num">${file.phone_number}</p>
						</div>
						<div class="site info">
							<i class="fa-solid fa-globe fa-xl"></i>
							<p class="site_url">${file.sns_url}</p>
						</div>
						<div class="noti info">
							<i class="fa-solid fa-exclamation-circle fa-xl"></i>
							<p class="noti_text">${file.other_info}</p>
						</div>
					</div>
				</section>
				<c:set var="placeInfoDisplayed" value="true" />
			</c:if>
		</c:if>
	</c:forEach>

	<!-- 여기서 부터댓글 시작. -->









	<section id="reply">


		<style>
.modal-body {
	padding: 20px;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

.form-control {
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.list clearfix {
	font-size: 10px;
}

/* 선택적으로 폼 컨트롤에 추가 스타일을 지정할 수 있습니다. */
</style>
		<!-- 모달창  -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title" id="myModalLabel">후기 달기</h4>
					</div>
					<div class="modal-body">
						<label>후기 내용</label>
						<div class="form-grouop">

							<input class="form-control" name="reply" placeholder="내용을 입력하시오."
								style="width: 1000px; height: 100px;">
						</div>
						<div class="form-group">
							<label>작성자</label> <input class="form-control" name="replyer"
								placeholder="작성자" style="width: 1000px;">
						</div>
					</div>
					<div class="modal-footer">
						<button id="modalRegisterBtn" type="button"
							class="btn btn-primary">글등록</button>

					</div>
				</div>
			</div>
		</div>
		<!-- 덧글 목록 -->
		<div class="panel-body">
			<ul class="chat">

				<li class="left clearfix" data-rno="12">
					<div>
						<div class="header">
							<strong class="primary-font">user00</strong> <small
								class="pull-right text-muted">2023-01-01 13:13</small>
						</div>
						<p>Good job!</p>
					</div>
				</li>
			</ul>
		</div>

		<div class="reply_title">
			<h1>여행지가 마음에 드시나요?</h1>
			<h2>자세한 여행후기는 내 후기등록에서!</h2>
			<img src="../resources/img/info_detail_icon01.png" alt="">
			<div class="reviewBtn">
				<p>내 후기등록</p>
			</div>
		</div>
	</section>
</body>
</html>