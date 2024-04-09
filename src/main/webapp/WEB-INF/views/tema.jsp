<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>테마</title>
    <link rel="icon" href="../resources/img/JP.png" />
    <link rel="stylesheet" href="../resources/styles/Header.css" />
    <link rel="stylesheet" href="../resources/styles/reset.css" />
    <link rel="stylesheet" href="../resources/styles/themStyles/them.css" />
    <link rel="stylesheet" href="../resources/styles/test.css" />
    <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
  /> 
    <style>
      @font-face {
        font-family: "MaplestoryBold";
        src: url("../resources/font/Maplestory\ Bold.ttf") format("truetype");
      }

      body {
        font-family: "MaplestoryBold", sans-serif;
      }
    </style>
        <!-- IONICONS -->
        <script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>
        <!-- JS -->
        <script defer src="../resources/js/test.js"></script>
  </head>
  <body>
    <header>
      <div class="nav">
        <div class="logo-group">
          <div class="logo">
            <a href="../resources/index.html">
              <img src="../resources/img/로고02.png" alt="로고" />
              <span class="project-name">너 J발 P야?</span></a
            >
          </div>
        </div>
        <div class="nav-buttons">
          <button class="button" data-section="home">홈</button>
          <button class="button on" data-section="them">테마</button>
          <button class="button" data-section="planer">여행플래너</button>
          <button class="button" data-section="trip_info">여행정보</button>
          <button class="button" data-section="community">커뮤니티</button>
        </div>
        <div class="auth-buttons">
          <button class="button" onclick="location.href='loginMember.html'">
            로그인
          </button>
          <button class="button" onclick="location.href='regMember.html'">
            회원가입
          </button>
        </div>
      </div>
          <!-- 사이드 퀵nav-->
          <div class="l-navbar" id="navbar">
            <nav class="nav_t">
              <div>
                <div class="nav__brand">
                  <ion-icon
                    name="menu-outline"
                    class="nav__toggle"
                    id="nav-toggle"
                  ></ion-icon>
                  <a href="../resources/index.html" class="nav__logo">너 J발 P야?</a>
                </div>
                <div class="nav__list">
                  <a href="/" class="nav__link ">
                    <ion-icon name="home-outline" class="nav__icon"></ion-icon>
                    <span class="nav_name">홈</span>
                  </a>
                  <a href="/tema/home" class="nav__link collapse active">
                    <ion-icon name="chatbubbles-outline" class="nav__icon"></ion-icon>
                    <span class="nav_name">테마</span>
                  </a>
      
                  <a href="/planner/home" class="nav__link " >
                    <ion-icon name="folder-outline" class="nav__icon"></ion-icon>
                    <span class="nav_name">플래너</span>
                  </a>
      
                  <a href="/trip/home" class="nav__link">
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

    <section>
        <!--테마 슬라이드-->
      <div class="them_main">

        <div class="slide_container">
            <div class="slide_title">
                <h1>THEME</h1>
                <P>원하는 테마를 선택하세요</P>
            </div>
            <div class="slide_item_container">
                    <div class="slide_them_item">
                        <img src="../resources/img/themPageItem01.png" alt="">
                    </div>
                    <div class="slide_them_item">
                        <img src="../resources/img/themPageItem01.png" alt="">
                    </div>
                    <div class="slide_them_item">
                        <img src="../resources/img/themPageItem01.png" alt="">
                    </div>
                    <div class="slide_them_item">
                        <img src="../resources/img/themPageItem01.png" alt="">
                    </div>
                    <div class="slide_them_item">
                        <img src="../resources/img/themPageItem01.png" alt="">
                    </div>
                    <div class="slide_them_item">
                        <img src="../resources/img/themPageItem01.png" alt="">
                    </div>
            </div>
        </div>


        <!--테마 하단 버튼영역-->
        <div class="them_button_container">
            <div class="btn_container">
            <div class="leftBtn btncircle">
                <i class="fa-solid fa-arrow-left"></i>
            </div>
            <div class="rightBtn btncircle">
                <i class="fa-solid fa-arrow-right"></i>
            </div>      
        </div>
        <div class="them_button_container_dec"></div>   
        </div>
      </div>
    </section>
  </body>
</html>
