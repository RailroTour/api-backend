<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Header</title>
    <!--     <link rel="stylesheet" href="css/commen.css">
    <link rel="stylesheet" href="css/header.css">
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    
    </script>
    <script src="./js/header.js"></script> -->
    <meta name="viewport" content="width=device-width, initial-scale=0.75">
  </head>
  <body>
    <div id="wrap">
      <!-- 전체를 감싸는 부분 -->
      <header>
        <!--상단 메뉴 -->
        <section id="head-top">
          <!-- 상단메뉴의 검은색 메뉴 -->
          <div class="section">
            <div class="topnavi">
              <!-- 메뉴명 -->
              <ul>
                <li>
                  <a href="./index.jsp">홈으로</a>
                  <span></span>
                </li>
                <li>
                  <a href="#">즐겨찾기</a>
                  <span></span>
                </li>
                <%if(session.getAttribute("email")==null){ %>
                <li>
                  <a href="./login.jsp">로그인</a>
                  <span></span>
                </li>
                <%}else{ %>
                <li class="logout-btn">
                  <a href="./oauth/logout">로그아웃</a>
                  <span></span>
                </li>
                <li>
                  <a href="./mypage.jsp">마이페이지</a>
                  <span></span>
                </li>
                <li>
                  <a href="./trip_cart.jsp">여행바구니</a>
                  <span></span>
                </li>
                <%} %>
              </ul>
            </div>

            <div class="snsicon">
              <!-- 상단아이콘 -->
              <a href="https://www.letskorail.com/" class="sns2" target="_black"
                >카페</a
              >
              <a href="https://cafe.naver.com/hkct" class="sns3" target="_black"
                >코레일</a
              >
            </div>
          </div>
        </section>
        <section id="head-bot">
          <div class="section">
            <div id="logo">
              <!-- 로고 -->
              <a href="./index.jsp">
                <img src="jpg/RailroTour%20LOGO.png" alt="" class="main_logo" />
              </a>
            </div>
            <nav>
              <ul class="m-menu">
                <!--메인메뉴-->
                <li
                  class="list01 list"
                  onmouseover="bgcolor(1)"
                  onmouseout="removecolor(1)"
                >
                  <a href="./railro_intro.jsp" class="list_a1">내일로 소개</a>
                </li>
                <li
                  class="list02 list"
                  onmouseover="bgcolor(2)"
                  onmouseout="removecolor(2)"
                >
                  <a
                    href="./top100_food_tour_rooms.jsp?contenttypeid=12&pageNo=1"
                    class="list_a2"
                    >TOP 100</a
                  >
                </li>
                <li
                  class="list03 list"
                  onmouseover="bgcolor(3)"
                  onmouseout="removecolor(3)"
                >
                  <a href="./planner1.jsp" class="list_a3">플래너</a>
                </li>
                <li
                  class="list04 list"
                  onmouseover="bgcolor(4)"
                  onmouseout="removecolor(4)"
                >
                  <a href="./search_integrated.jsp" class="list_a4">검색</a>
                </li>
                <li
                  class="list05 list"
                  onmouseover="bgcolor(5)"
                  onmouseout="removecolor(5)"
                >
                  <a href="./community.jsp" class="list_a5">커뮤니티</a>
                </li>
              </ul>
            </nav>
            <div class="s-menu">
              <div class="section">
                <div class="float">
                  <dl
                    class="hoverbg1 hoverbg"
                    onmouseover="bgcolor(1)"
                    onmouseout="removecolor(1)"
                  >
                    <!--                                            <dt>지우지 말것</dt>-->
                    <dd><a href="./railro_intro.jsp">내일로 란?</a></dd>
                    <dd><a href="./railro_voucher.jsp">내일로 바우처</a></dd>
                  </dl>
                  <dl
                    class="hoverbg2 hoverbg"
                    onmouseover="bgcolor(2)"
                    onmouseout="removecolor(2)"
                  >
                    <dd>
                      <a
                        href="./top100_food_tour_rooms.jsp?contenttypeid=12&pageNo=1"
                        >관광지</a
                      >
                    </dd>
                    <dd>
                      <a
                        href="./top100_food_tour_rooms.jsp?contenttypeid=39&pageNo=1"
                        >맛집</a
                      >
                    </dd>
                    <dd><a href="./top100_planner.jsp?pageNo=1">코스</a></dd>
                    <dd>
                      <a
                        href="./top100_food_tour_rooms.jsp?contenttypeid=32&pageNo=1"
                        >숙소</a
                      >
                    </dd>
                  </dl>
                  <dl
                    class="hoverbg3 hoverbg"
                    onmouseover="bgcolor(3)"
                    onmouseout="removecolor(3)"
                  >
                    <dd><a href="./planner1.jsp">새 플래너 작성</a></dd>
                    <dd><a href="./myplanner.jsp">내 플래너 목록</a></dd>
                  </dl>
                  <dl
                    class="hoverbg4 hoverbg"
                    onmouseover="bgcolor(4)"
                    onmouseout="removecolor(4)"
                  >
                    <dd><a href="./search_integrated.jsp">통합검색</a></dd>
                    <dd><a href="./search_tour.jsp">관광지 검색</a></dd>
                    <dd><a href="./search_foods.jsp">음식점 검색</a></dd>
                    <dd><a href="./search_rooms.jsp">숙소 검색</a></dd>
                    <dd><a href="./search_planner.jsp">플래너 검색</a></dd>
                  </dl>
                  <dl
                    class="hoverbg5 hoverbg"
                    onmouseover="bgcolor(5)"
                    onmouseout="removecolor(5)"
                  >
                    <dd><a href="./community.jsp">정보공유</a></dd>
                  </dl>
                </div>
              </div>
            </div>
            <a href="#" class="navbar__toggleBtn">
              <i class="fas fa-bars"></i>
            </a>
          </div>
        </section>
      </header>
    </div>

    <!-- <script src="js/script.js"></script> -->
  </body>
</html>
