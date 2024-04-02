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
        </div>
          </section>

        <!--여행정보 하단 게시판부분-->

          <section id="info_board">
            <div id="board_container">
                <div class="board_header">
                    <div class="board_category">#카페</div>
                    <div class="dropdown">
                        <button onclick="toggleDropdown()" class="dropbtn">별점순 <i class="fas fa-caret-down dropdown_icon"></i></button>
                        <div id="myDropdown" class="dropdown-content">
                          <a href="#" onclick="sortBy('별점순')">별점순 <i class="fas fa-caret-down dropdown_icon"></i></a>
                          <a href="#" onclick="sortBy('공감순')">공감순 <i class="fas fa-caret-down dropdown_icon"></i></a>
                          <a href="#" onclick="sortBy('조회순')">조회순 <i class="fas fa-caret-down dropdown_icon"></i></a>
                        </div>
                      </div>
                
                </div>
                    <div class="board_list" id="cafe_board">
                      <!-- 첫번째 게시물-->
                      <div class="board_container">
                      <div class="board_item">
                        <img src="../resources/img/board_img01.png" alt="카페이미지">
                        <div class="heart_container">
                          <div class="heart" onclick="toggleHeart()">
                            <i class="fa-regular fa-heart"></i>
                          </div>
                        </div>
                      </div>
                    <div class="board_info">
                        <div class="board_title">
                          <h1>노브 133</h1>
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
                          <p>통유리 대형카페, 루프탑, 야외테라스, 브런치, 카페, 맥주, 대관가능!</p>
                        </div>
                        <div class="board_add">
                          <p>경기도 용인시 처인구 포곡읍 유운리 320-9</p>
                        </div>
                        <div class="add_review"><a href="#">후기 등록</a></div>
                    </div>
                   
                  </div>


                      <!-- 두번째 게시물-->
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/board_img02.png" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>묵리459</h1>
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
                        <p>용인 처인구 카페 갤러리 같았던 자연속의 카페</p>
                      </div>
                      <div class="board_add">
                        <p>경기도 용인시 처인구 이동읍 이원로 484</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                </div>

                    <!-- 세번째 게시물-->
                    <div class="board_container">
                      <div class="board_item">
                        <img src="../resources/img/board_img03.png" alt="카페이미지">
                        <div class="heart_container">
                          <div class="heart" onclick="toggleHeart()">
                            <i class="fa-regular fa-heart"></i>
                          </div>
                        </div>
                      </div>
                    <div class="board_info">
                        <div class="board_title">
                          <h1>리프플레이스</h1>
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
                          <p>용인 근처 농촌테마파크 동물 먹이주기체험, 아이들과 가기 좋은 카페</p>
                        </div>
                        <div class="board_add">
                          <p>경기도 용인시 처인구 원삼면 농촌파크로97번길 2</p>
                        </div>
                        <div class="add_review"><a href="#">후기 등록</a></div>
                    </div>
                  </div>
      
                
                </div>
                    <div class="board_list" id="restaurant_board" style="display: none;">
                  <!-- 맛집 관련 게시물 -->
                                       <!-- 첫번째 게시물-->
                                       <div class="board_container">
                                        <div class="board_item">
                                          <img src="../resources/img/restaurant02.jpg" alt="카페이미지">
                                          <div class="heart_container">
                                            <div class="heart" onclick="toggleHeart()">
                                              <i class="fa-regular fa-heart"></i>
                                            </div>
                                          </div>
                                        </div>
                                      <div class="board_info">
                                          <div class="board_title">
                                            <h1>산사랑</h1>
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
                                            <p>매장내에 예쁜 정원과 함께 눈과 입이 모두 즐거운 한정식집</p>
                                          </div>
                                          <div class="board_add">
                                            <p>경기도 용인시 수지구 샘말로89번길 9</p>
                                          </div>
                                          <div class="add_review"><a href="#">후기 등록</a></div>
                                      </div>
                                     
                                    </div>
                  
                  
                                        <!-- 두번째 게시물-->
                                    <div class="board_container">
                                      <div class="board_item">
                                        <img src="../resources/img/restaurant01.jpg" alt="카페이미지">
                                        <div class="heart_container">
                                          <div class="heart" onclick="toggleHeart()">
                                            <i class="fa-regular fa-heart"></i>
                                          </div>
                                        </div>
                                      </div>
                                    <div class="board_info">
                                        <div class="board_title">
                                          <h1>총각손칼국수</h1>
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
                                          <p>저렴한 가격과 함께 가정식같은 정갈한 음식을 자랑하는 칼국수집</p>
                                        </div>
                                        <div class="board_add">
                                          <p>경기도 용인시 기흥구 신갈동 64-6</p>
                                        </div>
                                        <div class="add_review"><a href="#">후기 등록</a></div>
                                    </div>
                                  </div>
                  
                                      <!-- 세번째 게시물-->
                                      <div class="board_container">
                                        <div class="board_item">
                                          <img src="../resources/img/restaurant03.png" alt="카페이미지">
                                          <div class="heart_container">
                                            <div class="heart" onclick="toggleHeart()">
                                              <i class="fa-regular fa-heart"></i>
                                            </div>
                                          </div>
                                        </div>
                                      <div class="board_info">
                                          <div class="board_title">
                                            <h1>미가훠궈양고기</h1>
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
                                            <p>수요미식회 등 많은 방송에 출연한 용인의 훠궈 양꼬치 맛집</p>
                                          </div>
                                          <div class="board_add">
                                            <p>경기도 용인시 수지구 풍덕천1동 풍덕천로140번길 15</p>
                                          </div>
                                          <div class="add_review"><a href="#">후기 등록</a></div>
                                      </div>
                                    </div>
                </div>
                    <div class="board_list" id="exp_board" style="display: none;">
                  <!-- 체험 관련 게시물 -->
                    <!-- 첫번째 게시물-->
                    <div class="board_container">
                      <div class="board_item">
                        <img src="../resources/img/exp01.jpg" alt="카페이미지">
                        <div class="heart_container">
                          <div class="heart" onclick="toggleHeart()">
                            <i class="fa-regular fa-heart"></i>
                          </div>
                        </div>
                      </div>
                    <div class="board_info">
                        <div class="board_title">
                          <h1>한국민속촌</h1>
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
                          <p>한국의 민속적인 삶을 종합적으로 재현하고 있는 한국의 전통문화를 체험할 수 있는곳</p>
                        </div>
                        <div class="board_add">
                          <p>경기도 용인시 기흥구 민속촌로 90</p>
                        </div>
                        <div class="add_review"><a href="#">후기 등록</a></div>
                    </div>
                   
                  </div>


                      <!-- 두번째 게시물-->
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/exp02.jpg" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>용인대장금파크</h1>
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
                        <p>드라마의 배경에 따라 각 시대에 맞는 건축양식과 생활공간을 체험할 수 있는곳</p>
                      </div>
                      <div class="board_add">
                        <p>경기도 용인시 처인구 백암면 용천리 778-1</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                </div>

                    <!-- 세번째 게시물-->
                    <div class="board_container">
                      <div class="board_item">
                        <img src="../resources/img/exp03.JPG" alt="카페이미지">
                        <div class="heart_container">
                          <div class="heart" onclick="toggleHeart()">
                            <i class="fa-regular fa-heart"></i>
                          </div>
                        </div>
                      </div>
                    <div class="board_info">
                        <div class="board_title">
                          <h1>한택식물원</h1>
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
                          <p>가족들과 함께 자연을 산책하며 힐링할 수 있는 식물원</p>
                        </div>
                        <div class="board_add">
                          <p>경기도 용인시 처인구 백암면 옥산리 365</p>
                        </div>
                        <div class="add_review"><a href="#">후기 등록</a></div>
                    </div>
                  </div>
                </div>
                    <div class="board_list" id="park_board" style="display: none;">
                  <!-- 공원 관련 게시물 -->
                                      <div class="board_container">
                      <div class="board_item">
                        <img src="../resources/img/park01.jpg" alt="카페이미지">
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
                          <p>음악분수와 야외무대가 있는 환경생태 개념의 호수 공원 </p>
                        </div>
                        <div class="board_add">
                          <p>경기도 용인시 기흥구 중동 동백5로 12</p>
                        </div>
                        <div class="add_review"><a href="#">후기 등록</a></div>
                    </div>
                   
                  </div>


                      <!-- 두번째 게시물-->
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/park02.jpg" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>기흥호수공원</h1>
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
                        <p>경기도에서 3번째로 큰 저수지를 포함하고 있는 호수 공원</p>
                      </div>
                      <div class="board_add">
                        <p>경기도 용인시 기흥구 동탄기흥로 923</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                </div>

                    <!-- 세번째 게시물-->
                    <div class="board_container">
                      <div class="board_item">
                       <!-- <img src="../resources/img/park03.JPG" alt="카페이미지">-->
                        <div class="heart_container">
                          <div class="heart" onclick="toggleHeart()">
                            <i class="fa-regular fa-heart"></i>
                          </div>
                        </div>
                      </div>
                    <div class="board_info">
                        <div class="board_title">
                          <h1>아르피아공원</h1>
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
                          <p>체육공원에서 마음껏 뛰어놀고 전망대도 구경할수 있는곳</p>
                        </div>
                        <div class="board_add">
                          <p>경기도 용인시 수지구 포은대로 499</p>
                        </div>
                        <div class="add_review"><a href="#">후기 등록</a></div>
                    </div>
                  </div>
                </div>
                    <div class="board_list" id="them_board" style="display: none;">
                  <!-- 테마 관련 게시물 -->
                  <div class="board_container">
                    <div class="board_item">
                      <img src="../resources/img/thempark01.jpg" alt="카페이미지">
                      <div class="heart_container">
                        <div class="heart" onclick="toggleHeart()">
                          <i class="fa-regular fa-heart"></i>
                        </div>
                      </div>
                    </div>
                  <div class="board_info">
                      <div class="board_title">
                        <h1>에버랜드</h1>
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
                        <p>다양한 연령대별 놀이기구와 화려한 불꽃놀이가 자랑인 테마파크</p>
                      </div>
                      <div class="board_add">
                        <p>경기도 용인시 에버랜드로 199</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                 
                </div>


                    <!-- 두번째 게시물-->
                <div class="board_container">
                  <div class="board_item">
                    <img src="../resources/img/thempark02.jpg" alt="카페이미지">
                    <div class="heart_container">
                      <div class="heart" onclick="toggleHeart()">
                        <i class="fa-regular fa-heart"></i>
                      </div>
                    </div>
                  </div>
                <div class="board_info">
                    <div class="board_title">
                      <h1>농촌테마파크</h1>
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
                      <p>도심에서 벗어나 농촌생활을 체험해보고 휴식을 취할수 있는 테마파크</p>
                    </div>
                    <div class="board_add">
                      <p>경기도 용인시 원삼면 농촌파크로 80-1</p>
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
                        <h1>곤충테마파크</h1>
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
                        <p>가족들과 여러가지 체험을 하기 좋은 곤충테마파크</p>
                      </div>
                      <div class="board_add">
                        <p>경기도 용인시 처인구 백암면 삼백로 835번길 38</p>
                      </div>
                      <div class="add_review"><a href="#">후기 등록</a></div>
                  </div>
                </div>

                </div>
                    <div class="board_list" id="make_board" style="display: none;">
                  <!-- 공방 관련 게시물 -->
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
                <div class="board_container">
                  <div class="board_item">
                    <img src="../resources/img/night02.png" alt="카페이미지">
                    <div class="heart_container">
                      <div class="heart" onclick="toggleHeart()">
                        <i class="fa-regular fa-heart"></i>
                      </div>
                    </div>
                  </div>
                <div class="board_info">
                    <div class="board_title">
                      <h1>보정동카페거리</h1>
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
                      <p>용인시의 대표적인 문화의 거리로 이국적인 카페와 상점이 몰려있어 영화·드라마 촬영지로도 '핫'한 명소! </p>
                    </div>
                    <div class="board_add">
                      <p>경기도 용인시 기흥구 보정동 1344</p>
                    </div>
                    <div class="add_review"><a href="#">후기 등록</a></div>
                </div>
              </div>

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
