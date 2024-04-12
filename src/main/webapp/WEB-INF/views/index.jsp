<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8" />
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>너 J발 P야?</title>
<link rel="icon" href="resources/img/JP.png" />
<link rel="stylesheet" href="resources/styles/Header.css" />
<link rel="stylesheet" href="resources/styles/Content.css" />
<link rel="stylesheet" href="resources/styles/reset.css" />
<link rel="stylesheet" href="resources/styles/footer.css" />
<link rel="stylesheet" href="resources/styles/community.css" />
<link rel="stylesheet" href="resources/styles/info.css" />
<link rel="stylesheet" href="resources/styles/planer.css" />
<link rel="stylesheet" href="resources/styles/them.css" />
<link rel="stylesheet" href="resources/styles/home.css" />
<link rel="stylesheet" href="resources/styles/test.css" />
<script defer src="resources/js/slide.js"></script>
<script defer src="resources/js/home.js"></script>
<script defer src="resources/js/test.js"></script>
<script defer src="resources/js/theme.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- IONICONS -->
<script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>
<script type="module"
	src="https://unpkg.com/ionicons@5.2.3/dist/ionicons/ionicons.esm.js"></script>

<style>
@font-face {
	font-family: "MaplestoryBold";
	src: url("/resources/font/Maplestory Bold.ttf") format("truetype");
}

@font-face {
	font-family: "Maplestory Light";
	src: url("/resources/font/Maplestory Light.ttf") format("truetype");
}

body {
	font-family: "MaplestoryBold", "MaplestoryLight", sans-serif;
}

.nondisplay {
	display: none;
}
</style>
</head>
<body id="body-pd">
	<div class="wrap">
		<header>
			<div class="nav">
				<div class="logo-group">
					<div class="logo">
						<a href="/"> <img src="resources/img/로고02.png" alt="로고" /> <span
							class="project-name">너 J발 P야?</span>
						</a>
					</div>
				</div>
				<div class="nav-buttons">
					<button class="button" data-section="home">홈</button>
					<button class="button" data-section="them">테마</button>
					<button class="button" data-section="planer">여행플래너</button>
					<button class="button" data-section="trip_info">여행정보</button>
					<button class="button" data-section="community">커뮤니티</button>
				</div>


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
						<button id="logoutBtnton" class="button nondisplay" >로그아웃</button>
					</form>

					<!-- 					<button id="logoutBtnton" class="button nondisplay" -->
					<!-- 						onclick="location.href='/logOutProcess'">로그아웃</button> -->
				</div>
				<div class="hamburger">
					<div class="line line-1"></div>
					<div class="line line-2"></div>
					<div class="line line-3"></div>
				</div>
				<div class="menu">
					<ul>
						<li><a href="/customLogin">로그인</a></li>
						<li><a href="/regMember">회원가입</a></li>

					</ul>
				</div>





				<script>
					//   페이지 로드 후 호출되는 함수
					window.onload = function() {
						checkSession();
					};

					// 세션에 값이 있는지 확인하는 함수
					function checkSession() {
						$
								.ajax({
									url : '/Oauth/kakao/checkSession', // 세션 확인을 위한 서버 엔드포인트
									type : 'GET',
									success : function(data) {
										if (data.indexOf("ROLE") != -1
												|| data.indexOf("Kakao") != -1) {
											// 											console.log(data);
											// 세션에 값이 있는 경우
											document
													.getElementById("loginButton").classList
													.add("nondisplay");
											document
													.getElementById("registerButton").classList
													.add("nondisplay");
											document
													.getElementById("logoutBtnton").classList
													.remove("nondisplay");
										} else if (!data) {
											document
													.getElementById("loginButton").classList
													.remove("nondisplay");
											document
													.getElementById("registerButton").classList
													.remove("nondisplay");
											document
													.getElementById("logoutBtnton").classList
													.add("nondisplay");
										}
									},
									error : function(xhr, status, error) {
										console
												.error(
														'Error occurred during session check:',
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
							var csrfToken = csrfTokenMeta
									.getAttribute('content');
							var csrfHeader = csrfHeaderMeta
									.getAttribute('content');

							// XMLHttpRequest 객체 생성
							var xhr = new XMLHttpRequest();

							// 요청 설정
							xhr.open("GET",
									"http://localhost:8082/logOutProcess", true); // true는 비동기 방식을 의미

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
			</div>
			<!-- 사이드 퀵nav-->
			<div class="l-navbar" id="navbar">
				<nav class="nav_t">
					<div>
						<div class="nav__brand">
							<ion-icon name="menu-outline" class="nav__toggle" id="nav-toggle"></ion-icon>
							<a href="/" class="nav__logo">너 J발 P야?</a>
						</div>
						<div class="nav__list">
							<a href="/" class="nav__link active"> <ion-icon
									name="home-outline" class="nav__icon"></ion-icon> <span
								class="nav_name">홈</span>
							</a> <a href="/tema/home" class="nav__link"> <ion-icon
									name="chatbubbles-outline" class="nav__icon"></ion-icon> <span
								class="nav_name">테마</span>
							</a> <a href="/planner/home" class="nav__link collapse"> <ion-icon
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

		<!-- 홈 영역 -->

		<section id="홈" class="home">
			<div class="home_container home_slide_container">
				<!-- 슬라이드 1번-->
				<div class="home_slide1">
					<div class="home_slide1_text">
						<div class="home_slide1_textBox">
							<h1>두근두근 설레는</h1>
						</div>
						<p>
							감성과 특색이 넘치는 <br />신상 여행지
						</p>
						<div class="home_slide1_button">
							<p class="home_slide1_button_text">
								<a href="#">자세히 보기</a>
							</p>
						</div>
					</div>
					<div class="home_slide1_imgbox"></div>
				</div>
				<!-- 슬라이드 2번-->
				<div class="home_slide2">
					<div class="home_slide2_text">
						<div class="home_slide2_textBox">
							<h1>인기폭발 핫한</h1>
						</div>
						<p>
							요즘 떠오르는 <span class="hothot">HOT 10</span> <br /> <span
								class="hothot">인기</span> 여행지
						</p>
						<div class="home_slide2_button">
							<p class="home_slide2_button_text">
								<a href="#">자세히 보기</a>
							</p>
						</div>
					</div>
					<div class="home_slide2_imgbox"></div>
				</div>
				<!-- 슬라이드 3번-->
				<div class="home_slide3">
					<div class="home_slide3_text">
						<div class="home_slide3_textBox">
							<h1>너만 모르는</h1>
						</div>
						<p>
							요즘 떠오르는 HOT 10 <br />인기 여행지
						</p>
						<div class="home_slide3_button">
							<p class="home_slide3_button_text">
								<a href="#">자세히 보기</a>
							</p>
						</div>
					</div>
					<div class="home_slide3_imgbox"></div>
				</div>
			</div>
			<div class="slide_bar_container">
				<div class="slide_bar_info">
					<progress id="progress" value="20" max="100"></progress>
					<div class="slide_bar_info_num">
						<p class="info_num">01</p>
						<p class="info_maxnum">/ 05</p>
					</div>
					<div class="slide_bar_button">
						<a href="#" id="leftArrow"> <img
							src="resources/img/arrow-left.png" alt="" /></a> <a href="#"
							id="playButton"><img src="resources/img/play.png" alt="" /></a>
						<a href="#" id="rightArrow"><img
							src="resources/img/arrow-right.png" alt="" /></a>
					</div>
				</div>
			</div>
		</section>

		<!-- 테마 영역 -->
		<section id="테마" class="content">
			<div class="home_container testcont" style="overflow: hidden">
				<div class="them__container">
					<div class="inner">
						<div class="inner_text">
							<h1>다채로운 즐거움이 가득한</h1>

							<h1>추천 테마 여행 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp; &nbsp; &nbsp;</h1>
							<p class="them_subtitle">다양한 테마여행으로 떠나보아요</p>
							<div class="them_button">
								<p class="them_button_text">
									<a href="/tema/home">다양한 테마 보기</a>
								</p>
							</div>
						</div>
						<div class="them_img_container">
							<div class="them_img_box1"></div>
							<div class="them_img_box2"></div>
							<div class="them_img_box3"></div>
							<div class="them_img_box4"></div>
							<div class="them_img_box5"></div>
						</div>
					</div>
					<div class="inner"></div>
					<div class="inner"></div>
				</div>
			</div>
			<button class="them_prevBtn"></button>
			<button class="them_nextBtn"></button>
		</section>

		<!-- 여행 플래너 영역-->

		<section id="여행플래너" class="content_planner">
			<div class="trip_container">
				<div class="tripplanner_text_box">
					<p class="title tripplanner_title">여행 플래너</p>
					<p class="subtitle">Planner</p>
					<p class="description">
						<span class="highlight">P</span> 가 원하는 여행의 시작!<br /> <span
							class="highlight">J발</span> 30초만 투자해
					</p>
					<div class="tripplanner_button">
						<p class="title">
							<a href="/planner/home">코스만들기</a>
						</p>
					</div>
				</div>
				<div class="tripplanner_img"></div>
			</div>
		</section>

		<!-- 여행정보 영역 -->

		<section id="여행정보" class="content_info">
			<div class="home_container info_container">
				<div class="info_textbox">
					<h1>여행 정보</h1>
					<p>용인, 어디까지 가봤니?</p>
					<div class="infobox">
						<div class="info_pic pic1">
							<img src="resources/img/infopic1.png" alt="" />
						</div>
						<div class="info_pic pic2">
							<img src="resources/img/infopic2.png" alt="" />
						</div>
					</div>
				</div>

				<div class="info_board">
					<div class="info_board_article">
						<div class="circle">#카페</div>
						<div class="circle">#맛집</div>
						<div class="circle">#체험</div>
						<div class="circle">#공원</div>
						<div class="circle">#테마</div>
						<div class="circle">#공방</div>
						<div class="circle">#축제</div>
						<div class="circle">#전시</div>
						<div class="circle">#야경</div>
					</div>
				</div>
			</div>
		</section>

		<!-- 커뮤니티 영역 -->

		<section id="커뮤니티" class="content_footer">
			<div class="com_container">
				<div class="community-container">
					<div class="text-content">
						<h1>커뮤니티</h1>
						<p>
							다녀왔던 여행지, 맛집, 카페<br />계획 등을 <span class="highlight">공유</span>해보아요
						</p>
					</div>
					<a href="#" class="shortcut-button">바로가기</a>
				</div>
				<div class="instagram-layout">
					<img class="instagram-image" src="/resources/img/커뮤니티이미지레이아웃.png"
						alt="" /> <img class="community-image"
						src="/resources/img/커뮤니티이미지.jpg" alt="" />
				</div>
			</div>
		</section>

		<!-- footer 영역 -->

		<footer>
			<div class="connect">
				<p>[Connect with us: GitHub | Facebook | Instagram]</p>
			</div>
			<div class="footer_logo">
				<div class="thth"></div>
				<div class="footer_logo_container">
					<img src="resources/img/로고02.png" alt="로고이미지" />
					<h2>너 J발 P야?</h2>
				</div>
				<div class="icon">
					<img src="/resources/img/gihub.png"
						style="width: 65px; height: 65px; object-fit: cover" /><img
						src="/resources/img/facebook.png"
						style="width: 64px; height: 64px; object-fit: cover" /><img
						src="/resources/img/instagram.png"
						style="width: 62px; height: 62px; object-fit: cover" />
				</div>
			</div>
			<p class="copy">Copyright Corp. 2024 너 J발 P야? | Designed with ❤️
				by JP</p>
		</footer>
	</div>
</body>
</html>