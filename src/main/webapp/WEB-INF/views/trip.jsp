<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="kr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>여행 정보</title>
    <link rel="icon" href="../resources/img/JP.png" />
    <link rel="stylesheet" href="../resources/styles/Header.css" />
    <link rel="stylesheet" href="../resources/styles/reset.css" />
    <link rel="stylesheet" href="../resources/styles/test.css" />
    <link rel="stylesheet" href="../resources/styles/infoStyles/infoBoard.css">
    <link rel="stylesheet" href="../resources/styles/infoStyles/infoHash.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
  /> 
  <script defer src="../resources/js/infoBoard.js"></script>

    <!-- IONICONS -->
    <script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>
    <!-- JS -->
    <script defer src="../resources/js/test.js"></script>
    <!--드롭다운메뉴 js-->
    <script defer src="../resources/js/info.js"></script>


    <style>
      @font-face {
        font-family: "MaplestoryBold";
        src: url("../resources/font/Maplestory\ Bold.ttf") format("truetype");
      }
      body {
        font-family: "MaplestoryBold", sans-serif;
      }
    </style>
  </head>
  <body>
    <div id="wrap">
        <!--여행정보 상단 해시태그부분-->
        <header>
            <div class="nav">
              <div class="logo-group">
                <div class="logo">
                  <a href="../resources/index.html">
                    <img src="../resources/img/로고02.png" alt="로고" />
                    <span class="project-name">너 J발 P야?</span>
                  </a>
                </div>
              </div>
              <div class="nav-buttons">
                <button class="button" data-section="home">홈</button>
                <button class="button" data-section="them">테마</button>
                <button class="button" data-section="planer">여행플래너</button>
                <button class="button on" data-section="trip_info">여행정보</button>
                <button class="button" data-section="community">커뮤니티</button>
              </div>
              <div class="auth-buttons">
                <button class="button" onclick="location.href='/customLogin'">
                  로그인
                </button>
                <button class="button" onclick="location.href='/regMember'">
                  회원가입
                </button>
              </div>
            </div>
            <!--사이드 퀵 nav-->
            <div class="l-navbar" id="navbar">
              <nav class="nav_t">
                <div>
                  <div class="nav__brand">
                    <ion-icon
                      name="menu-outline"
                      class="nav__toggle"
                      id="nav-toggle"
                    ></ion-icon>
                    <a href="/" class="nav__logo">너 J발 P야?</a>
                  </div>
                  <div class="nav__list">
                    <a href="/" class="nav__link">
                      <ion-icon name="home-outline" class="nav__icon"></ion-icon>
                      <span class="nav_name">홈</span>
                    </a>
                    <a href="/tema/home" class="nav__link">
                      <ion-icon name="chatbubbles-outline" class="nav__icon"></ion-icon>
                      <span class="nav_name">테마</span>
                    </a>
        
                    <a href="/planner/home" class="nav__link collapse">
                      <ion-icon name="folder-outline" class="nav__icon"></ion-icon>
                      <span class="nav_name">플래너</span>
                    </a>
        
                    <a href="/trip/home" class="nav__link active">
                      <ion-icon name="pie-chart-outline" class="nav__icon"></ion-icon>
                      <span class="nav_name">여행정보</span>
                    </a>
        
                    <a href="/community/home" class="nav__link collapse">
                      <ion-icon name="people-outline" class="nav__icon"></ion-icon>
                      <span class="nav_name">커뮤니티</span>
                    </a>
                </div>
              </nav>
            </div>
        
          </header>
           <!--여행정보 상단 해시태그부분-->
          <section id="info_hash">
            <div class="info_title_box">
            <div class="info_title">
                <h1>용인 여행 <span>버킷리스트</span></h1>
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
                    <p class="hashtag_title_text">#체험</p></div>
                <div class="hashtag_circle1">
                    <img src="../resources/img/infoimg04.png" alt="">
                    <p class="hashtag_title_text">#공원</p></div>
                <div class="hashtag_circle1">
                    <img src="../resources/img/infoimg05.png" alt="">
                    <p class="hashtag_title_text">#테마</p></div>
                <div class="hashtag_circle1">
                    <img src="../resources/img/infoimg06.png" alt="">
                    <p class="hashtag_title_text">#공방</p></div>
                <div class="hashtag_circle1">
                    <img src="../resources/img/infoimg07.png" alt="">
                    <p class="hashtag_title_text">#축제</p></div>
                <div class="hashtag_circle1">
                    <img src="../resources/img/infoimg08.png" alt="">
                    <p class="hashtag_title_text">#전시</p></div> 
                <div class="hashtag_circle1">
                    <img src="../resources/img/infoimg09.png" alt="">
                    <p class="hashtag_title_text">#야경</p></div>
            </div>
            <script type="text/javascript">
			    var hashtagCircles = document.querySelectorAll(".hashtag_circle1");
			
			    for (var i = 0; i < hashtagCircles.length; i++) {
			        hashtagCircles[i].addEventListener("click", function(event) {
			            event.preventDefault(); // 기본 해시 변경 방지
			            var clickedElement = this;
			            var hashtagText = clickedElement.querySelector(".hashtag_title_text").textContent.slice(1);
			            var url = window.location.origin + "/trip/home"; // trip/home으로 이동할 URL
			            var newUrl = url + "?hashtag=" + hashtagText;
			            window.location.href = newUrl;
			        });
			    }
			</script>

            <a href="/trip/detailInsert" style=color:black;>여행정보 작성</a>
        </div>
          </section>
 

            
	<c:forEach var="file" items="${files}" varStatus="loop">
                   <c:if test="${loop.first or file.placeName ne files[loop.index - 1].placeName}">
                  <div class="board_container">
                    <div class="board_item">
                   
                        <img src="/trip${file.filepath}" style="width:350px;">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        
                         <h1>여행지명:${file.placeName}</h1>
                       <p> 
                       <a href="/trip/showdetail?placeName=${file.placeName}&hashtag=${file.hashtag}" style=color:black;>${file.placeName }상세보기</a>
                       </p>
                        <div class="star-rating">
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                      </div>
                          <div class="rating-text">
                            <p class="info_num">${file.rating}</p>
                            <p class="info_maxnum">/ 5</p>
                          </div>
                      </div>
                      <div class="board_subtitle">
                        <p>한줄소개: ${file.description}</p>
                      </div>
                      <div class="board_add">
                       <p>주소: ${file.address}</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                </div>
                   
                <a href="/trip/delete?filename=${file.filename}" style=color:black;>삭제하기</a>
                <a href="/trip/update?id=${file.id} " style=color:black;>수정하기</a>


            </c:if>
 </c:forEach>
           
  </body>
</html>