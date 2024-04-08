<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <a href="/trip/detailInsert">여행정보 작성</a>
        </div>
          </section>

        <!--여행정보 하단 게시판부분-->

        


                      <!-- 두번째 게시물-->
            
                    <!-- 세번째 게시물-->
                
                  <!-- 맛집 관련 게시물 -->
                                       <!-- 첫번째 게시물-->
                               
              
                  <!-- 테마 관련 게시물 -->
               




            

                  <!-- 세번째 게시물-->
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/thempark03.jpeg" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>바랭이 공방</h1>
                        <div class="star-rating">
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                      </div>
                          <div class="rating-text">
                            <p class="info_num">5</p>
                            <p class="info_maxnum">/ 5</p>
                          </div>
                      </div>
                      <div class="board_subtitle">
                        <p>자유로운 주제로 만들고싶은 도자기를 만들어 볼 수 있는 곳</p>
                      </div>
                      <div class="board_add">
                        <p>경기도 용인시 기흥구 보정동 878-6번지</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                </div>

                </div>
                    <div class="board_list" id="fest_board" style="display: none;">
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/make01.jpeg" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>뚝플레이스</h1>
                        <div class="star-rating">
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                      </div>
                          <div class="rating-text">
                            <p class="info_num">5</p>
                            <p class="info_maxnum">/ 5</p>
                          </div>
                      </div>
                      <div class="board_subtitle">
                        <p>예쁜 소품도 살 수 있고 공방 체험도 가능한 곳</p>
                      </div>
                      <div class="board_add">
                        <p>경기도 용인시 처인구 원삼면 원양로 422 용담호수 광장</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                 
                </div>


                    <!-- 두번째 게시물-->
                <div class="board_container">
                  <div class="board_item">
                    <img src="../resources/img/make02.jpg" alt="카페이미지">
                    <div class="heart_container">
                      <div class="heart" onclick="toggleHeart()">
                        <i class="fa-regular fa-heart"></i>
                      </div>
                    </div>
                  </div>
                <div class="board_info">
                    <div class="board_title">
                      <h1>소유화실</h1>
                      <div class="star-rating">
                        <span class="star">&#9733;</span>
                        <span class="star">&#9733;</span>
                        <span class="star">&#9733;</span>
                        <span class="star">&#9733;</span>
                        <span class="star">&#9733;</span>
                    </div>
                        <div class="rating-text">
                          <p class="info_num">5</p>
                          <p class="info_maxnum">/ 5</p>
                        </div>
                    </div>
                    <div class="board_subtitle">
                      <p>가족이나 연인 친구끼리 방문해서 원데이 클래스를 즐길수 있는 곳</p>
                    </div>
                    <div class="board_add">
                      <p>경기 용인시 기흥구 죽전로 6 201호</p>
                    </div>
                    <div class="add_review"><a href="#">후기 등록</a></div>
                </div>
              </div>

                  <!-- 세번째 게시물-->
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/thempark03.jpeg" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>바랭이도자기공방</h1>
                        <div class="star-rating">
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                      </div>
                          <div class="rating-text">
                            <p class="info_num">5</p>
                            <p class="info_maxnum">/ 5</p>
                          </div>
                      </div>
                      <div class="board_subtitle">
                        <p>자유로운 주제로 만들고싶은 도자기를 만들어 볼 수 있는 곳</p>
                      </div>
                      <div class="board_add">
                        <p>경기도 용인시 기흥구 보정동 878-6번지</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                </div>
                </div>
                    <div class="board_list" id="show_board" style="display: none;">
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/show01.jpg" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>백남준아트센터</h1>
                        <div class="star-rating">
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                      </div>
                          <div class="rating-text">
                            <p class="info_num">5</p>
                            <p class="info_maxnum">/ 5</p>
                          </div>
                      </div>
                      <div class="board_subtitle">
                        <p>세계적인 비디오 아티스트 고(故) 백남준 선생님의 작품을 소장 및 전시중</p>
                      </div>
                      <div class="board_add">
                        <p>경기도 용인시 기흥구 상갈동 백남준로 10</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                 
                </div>


                    <!-- 두번째 게시물-->
                <div class="board_container">
                  <div class="board_item">
                    <img src="../resources/img/show02.jpeg" alt="카페이미지">
                    <div class="heart_container">
                      <div class="heart" onclick="toggleHeart()">
                        <i class="fa-regular fa-heart"></i>
                      </div>
                    </div>
                  </div>
                <div class="board_info">
                    <div class="board_title">
                      <h1>어린이박물관</h1>
                      <div class="star-rating">
                        <span class="star">&#9733;</span>
                        <span class="star">&#9733;</span>
                        <span class="star">&#9733;</span>
                        <span class="star">&#9733;</span>
                        <span class="star">&#9733;</span>
                    </div>
                        <div class="rating-text">
                          <p class="info_num">5</p>
                          <p class="info_maxnum">/ 5</p>
                        </div>
                    </div>
                    <div class="board_subtitle">
                      <p>다양한 체험형 전시, 교육 활동, 놀이 공간이 있는 어린이 박물관입니다.</p>
                    </div>
                    <div class="board_add">
                      <p>경기도 용인시 기흥구 상갈로 6</p>
                    </div>
                    <div class="add_review"><a href="#">후기 등록</a></div>
                </div>
              </div>

                  <!-- 세번째 게시물-->
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/show03.jpg" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>석주선 박물관</h1>
                        <div class="star-rating">
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                      </div>
                          <div class="rating-text">
                            <p class="info_num">5</p>
                            <p class="info_maxnum">/ 5</p>
                          </div>
                      </div>
                      <div class="board_subtitle">
                        <p>석주선 박사의 평생을 담은 유물들을 볼수 있는 곳</p>
                      </div>
                      <div class="board_add">
                        <p> 경기도 용인시 수지구 죽전로 152 석주선기념박물관</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                </div>
                </div>
                    <div class="board_list" id="night_board" style="display: none;">
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/night01.jpg" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>동백호수공원</h1>
                        <div class="star-rating">
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                      </div>
                          <div class="rating-text">
                            <p class="info_num">5</p>
                            <p class="info_maxnum">/ 5</p>
                          </div>
                      </div>
                      <div class="board_subtitle">
                        <p>250개의 음악분수에서 내뿜는 알록달록 LED 조명이 화려한 용인의 밤을 연출</p>
                      </div>
                      <div class="board_add">
                        <p>기흥구 동백중앙로 239</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                 
                </div>


                    <!-- 두번째 게시물-->
                

                  <!-- 세번째 게시물-->
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/night03.jpg" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>석성산</h1>
                        <div class="star-rating">
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                          <span class="star">&#9733;</span>
                      </div>
                          <div class="rating-text">
                            <p class="info_num">5</p>
                            <p class="info_maxnum">/ 5</p>
                          </div>
                      </div>
                      <div class="board_subtitle">
                        <p>탁 트인 정상에서 바라보는 또다른 빛의 장관을 연출</p>
                      </div>
                      <div class="board_add">
                        <p>용인시 기흥구 동백동과 포곡읍 마성리, 유림동</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                </div>
                </div>
            </div>
          </section>
    </div>
  </body>
</html>
