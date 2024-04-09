<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>커뮤니티</title>
    
<!--헤더 css-->
<link rel="stylesheet" href="/resources/styles/Header.css">
<!--리셋 css-->
  <link rel="stylesheet" href="/resources/styles/reset.css">
  <!--사이드 nav css-->
  <link rel="stylesheet" href="/resources/styles/test.css">

    <!-- CSS -->
    <link rel="stylesheet" href="/resources/styles/community/community.css">

    <!-- IONICONS -->
    <script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>
    <!-- JS -->
    <script defer src="/resources/js/test.js"></script>
    <!--드롭다운메뉴 js-->
    <script defer src="/resources/js/info.js"></script>


    <style>
      @font-face {
        font-family: "MaplestoryBold";
        src: url("/resources/font/Maplestory\ Bold.ttf") format("truetype");
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
                          <a href="/resources/index.html">
                            <img src="/resources/img/로고02.png" alt="로고" />
                            <span class="project-name">너 J발 P야?</span>
                          </a>
                        </div>
                      </div>
                      <div class="nav-buttons">
                        <button class="button" data-section="home">홈</button>
                        <button class="button" data-section="them">테마</button>
                        <button class="button" data-section="planer">여행플래너</button>
                        <button class="button" data-section="trip_info">여행정보</button>
                        <button class="button on" data-section="community">커뮤니티</button>
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
                            <a href="/resources/index.html" class="nav__logo">너 J발 P야?</a>
                          </div>
                          <div class="nav__list">
                            <a href="/resources/index.html" class="nav__link">
                              <ion-icon name="home-outline" class="nav__icon"></ion-icon>
                              <span class="nav_name">홈</span>
                            </a>
                            <a href="/resources/them.html" class="nav__link">
                              <ion-icon name="chatbubbles-outline" class="nav__icon"></ion-icon>
                              <span class="nav_name">테마</span>
                            </a>
                
                            <a href="/resources/planer.html" class="nav__link collapse">
                              <ion-icon name="folder-outline" class="nav__icon"></ion-icon>
                              <span class="nav_name">플래너</span>
                            </a>
                
                            <a href="/resources/tripInfo.html" class="nav__link ">
                              <ion-icon name="pie-chart-outline" class="nav__icon"></ion-icon>
                              <span class="nav_name">여행정보</span>
                            </a>
                
                            <a href="/resources/community.html" class="nav__link collapse active">
                              <ion-icon name="people-outline" class="nav__icon"></ion-icon>
                              <span class="nav_name">커뮤니티</span>
                            </a>
                        </div>
                      </nav>
                    </div>
                  </header>

         <section id="community_main_container">
               <div class="community_main">
                  <ul class="community_main_nav">
                      <li>여행 후기</li>
                      <li>내 여행 후기 등록</li>
                      <li>내 즐겨찾기</li>
                  </ul>
               </div>

         </section>
    </div>
  </body>
</html>