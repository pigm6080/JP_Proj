<!DOCTYPE html>
<html lang="kr">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>여행정보 - 상세조회</title>
        <link rel="icon" href="./img/JP.png" />
        <link rel="stylesheet" href="./styles/Header.css" />
        <link rel="stylesheet" href="./styles/test.css" />
        <link rel="stylesheet" href="./styles/reset.css">
        <link rel="stylesheet" href="./styles/infoDetailStyles/infoHash.css">
        <link rel="stylesheet" href="./styles/infoDetailStyles/infoDetail.css">
        <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
      /> 
        <script defer src="./js/test.js"></script>

        <!-- IONICONS -->
        <script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>
        <!-- JS -->
        <script defer src="./js/test.js"></script>

        <style>
            @font-face {
                font-family: 'MaplestoryBold';
                src: url('./font/Maplestory\ Bold.ttf') format('truetype');
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
                  <a href="./index.html">
                    <img src="./img/로고02.png" alt="로고" />
                    <span class="project-name">너 J발 P야?</span></a
                  >
                </div>
              </div>
              <div class="nav-buttons">
                <button class="button" data-section="home">홈</button>
                <button class="button" data-section="them">테마</button>
                <button class="button" data-section="planer">여행플래너</button>
                <button class="button  on" data-section="trip_info">여행정보</button>
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
                        <a href="./index.html" class="nav__logo">너 J발 P야?</a>
                      </div>
                      <div class="nav__list">
                        <a href="./index.html" class="nav__link ">
                          <ion-icon name="home-outline" class="nav__icon"></ion-icon>
                          <span class="nav_name">홈</span>
                        </a>
                        <a href="./them.html" class="nav__link collapse ">
                          <ion-icon name="chatbubbles-outline" class="nav__icon"></ion-icon>
                          <span class="nav_name">테마</span>
                        </a>
            
                        <a href="./planer.html" class="nav__link " >
                          <ion-icon name="folder-outline" class="nav__icon"></ion-icon>
                          <span class="nav_name">플래너</span>
                        </a>
            
                        <a href="./tripInfo.html" class="nav__link active">
                          <ion-icon name="pie-chart-outline" class="nav__icon"></ion-icon>
                          <span class="nav_name">여행정보</span>
                        </a>
            
                        <a href="./community.html" class="nav__link collapse">
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
                    <img src="./img/infoimg01.png" alt="">
                    <p class="hashtag_title_text">#카페</p>
                </div>
                <div class="hashtag_circle1">
                    <img src="./img/infoimg02.png" alt="">
                    <p class="hashtag_title_text">#맛집</p>
                </div>
                <div class="hashtag_circle1">
                    <img src="./img/infoimg03.png" alt="">
                    <p class="hashtag_title_text">#체험</p></div>
                <div class="hashtag_circle1">
                    <img src="./img/infoimg04.png" alt="">
                    <p class="hashtag_title_text">#공원</p></div>
                <div class="hashtag_circle1">
                    <img src="./img/infoimg05.png" alt="">
                    <p class="hashtag_title_text">#테마</p></div>
                <div class="hashtag_circle1">
                    <img src="./img/infoimg06.png" alt="">
                    <p class="hashtag_title_text">#공방</p></div>
                <div class="hashtag_circle1">
                    <img src="./img/infoimg07.png" alt="">
                    <p class="hashtag_title_text">#축제</p></div>
                <div class="hashtag_circle1">
                    <img src="./img/infoimg08.png" alt="">
                    <p class="hashtag_title_text">#전시</p></div> 
                <div class="hashtag_circle1">
                    <img src="./img/infoimg09.png" alt="">
                    <p class="hashtag_title_text">#야경</p></div>
            </div>
        </div>
          </section>
          <!--상세조회 영역-->
          <section id="detail_main">
                <div class="detail_title_container">
                    <h1 class="detail_title">목리459</h1>
                    <p class="detail_sub_title">용인 처인구 카페 갤러리 같았던 자연속의 카페</p>
                </div>
           
                <div class="detail_img_container">
                    <img src="./img/night02.png" alt="" style="opacity: 0.5;">
                </div>
          </section>

          <section id="detail_info">
                <div class="detail_info_title">
                    <h1>상세정보</h1>
                </div>
                <div class="detail_info_content">
                    <div class="info_address info">
                        <i class="fa-solid fa-location-dot fa-xl"></i>
                        <p class="address">경기 용인시 처인구 포곡읍 곡현로133번길 21 노브133</p>
                    </div>
                    <div class="phone info">
                        <i class="fa-solid fa-phone fa-xl"></i>
                        <p class="phone_num">031-333-3333</p>
                    </div>
                    <div class="site info">
                        <i class="fa-solid fa-globe fa-xl"></i>
                        <p class="site_url">https://www.naver.com</p>
                    </div>
                    <div class="noti info">
                        <i class="fa-solid fa-exclamation-circle fa-xl"></i>
                        <p class="noti_text">단체 이용 가능, 주차, 무선 인터넷, 남녀화장실 구분</p>
                    </div>
                 </div>
          </section>

          <section id="reply">
                <div class="reply_title">
                    <h1>여행지가 마음에 드시나요?</h1>
                    <h2>자세한 여행후기는 내 후기등록에서!</h2>
                    <img src="./img/info_detail_icon01.png" alt="">
                    <div class="reviewBtn"><p>내 후기등록</p></div>
                </div>
                    <!-- 덧글 입력창 -->
                        <div class="comment_input">
                            <form id="commentForm">
                                <textarea id="commentText" placeholder="덧글을 입력하세요..." rows="4" cols="50"></textarea>
                                <button type="submit">덧글 등록</button>
                            </form>
                        </div>
                     <!-- 덧글 목록 -->
                        <div class="comment_list">
                            <div class="comment_item">
                                <p><strong>사용자1:</strong> 여행지가 정말 멋있었어요! 다음에 또 방문하고 싶네요.</p>
                                <p><strong>등록일:</strong> 2024-03-28</p>
                                <div class="like_dislike_btns">
                                    <button class="like_btn">
                                        <i class="fa-solid fa-thumbs-up fa-lg"></i>
                                     </button>
                                     <button class="dislike_btn">
                                         <i class="fa-solid fa-thumbs-down fa-lg"></i>
                                     </button>
                                </div>
                            </div>
                            <div class="comment_item">
                                <p><strong>사용자2:</strong> 이곳은 너무 아름다웠어요. 풍경이 정말 멋졌습니다.</p>
                                <p><strong>등록일:</strong> 2024-03-27</p>
                                <div class="like_dislike_btns">
                                    <button class="like_btn">
                                        <i class="fa-solid fa-thumbs-up fa-lg"></i>
                                     </button>
                                     <button class="dislike_btn">
                                         <i class="fa-solid fa-thumbs-down fa-lg"></i>
                                     </button>
                                </div>
                            </div>
                            <div class="comment_item">
                                <p><strong>사용자3:</strong> 여행지의 분위기가 정말 좋았어요. 하루가 너무 빨리 지나갔네요.</p>
                                <p><strong>등록일:</strong> 2024-03-26</p>
                                <div class="like_dislike_btns">
                                    <button class="like_btn">
                                       <i class="fa-solid fa-thumbs-up fa-lg"></i>
                                    </button>
                                    <button class="dislike_btn">
                                        <i class="fa-solid fa-thumbs-down fa-lg"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
          </section>
    </body>
</html>