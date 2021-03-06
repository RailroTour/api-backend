<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
    <title>사용자 맞춤 내일로노트 검색</title>
    <link rel="stylesheet" href="./css/commen.css">
     <link rel="stylesheet" href="./css/sub-banner.css?ver=2">
    <link rel="stylesheet" href="./css/note_plans.css">
   <link rel="stylesheet" href="./css/customize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>

<script src="./js/script.js"></script>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css?ver=2">
<script src="./js/header.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp"%>
    <div id="wrap"> <!-- 전체를 감싸는 부분 -->
        <section id="sub-imgbanner">
            <div class="section">
                <div class="sub-img-text">
                    <h3>Let's Go!</h3>
                    <h2>
                        떠나라! <b>청춘들이여</b>
                    </h2>
                </div>
            </div>
        </section>
        <section id="sub-content">

            <div id="sub-con-body" class="section">
                <div class="s-c-b-title">
                    <h3>Custom Search</h3>
                    <h2>사용자 맞춤 플래너 검색</h2>
                </div>
                <div class="s-c-b-content">
                   <ul class="bar days">
                       <li>여행 기간</li>
                       <li>
                           <input type="radio" value="3" name="travel_day" id="travel_day3" hidden checked>
                           <label for="travel_day3" class="selected three">3일</label>
                           <input type="radio" value="7" name="travel_day" id="travel_day7" hidden>
                           <label for="travel_day7" class="seven">7일</label>
                       </li>
                   </ul>
                   <ul class="bar tema-select">
                       <li>여행 테마</li>
                       <li>
                           <input type="radio" value="14" name="travel_tema" id="tema1" hidden checked>
                           <input type="radio" value="15" name="travel_tema" id="tema2" hidden>
                           <input type="radio" value="16" name="travel_tema" id="tema3" hidden>
                           <input type="radio" value="17" name="travel_tema" id="tema4" hidden>
                           <label for="tema1" class="selected">관광</label>
                           <label for="tema2">휴식</label>
                           <label for="tema3">체험</label>
                           <label for="tema4">힐링</label>
                       </li>
                   </ul>
<!--                    <ul class="bar">
                       <li>지역 개수</li>
                       <li>

                           <input type="radio" value="1" name="area_cnt" id="area1" hidden checked>
                           <label for="area1" class="selected">1개</label>
                           <input type="radio" value="2" name="area_cnt" id="area2" hidden>
                           <label for="area2">2개</label>
                          <input type="radio" value="3" name="area_cnt" id="area3" hidden>
                           <label for="area3">3개</label>
                          <input type="radio" value="4" name="area_cnt" id="area4" hidden>
                           <label for="area4">4개</label>
                          <input type="radio" value="5" name="area_cnt" id="area5" hidden>
                           <label for="area5">5개</label>
                          <input type="radio" value="6" name="area_cnt" id="area6" hidden>
                           <label for="area6">6개</label>
                          <input type="radio" value="7" name="area_cnt" id="area7" hidden>
                           <label for="area7">7개</label>

                       </li>
                   </ul> -->
                   <!-- <center><button>검색</button></center> -->
                    <div class="plans_list_rows" style="margin-top: 80px;">
						<div id="viewLoading" style="text-align: center">
							<img src="./note_plans_list_jpg/ajax-loader.gif" alt=""
								width="80px">
						</div>
<!-- 						<a href="" class="planner" target="_blank"><ul class="list_item">
                            <li>
                                <img src="./note_plans_list/seoul.jpg" alt="" width="346px" height="200px">
                                <div class="note_info">
                                    <h1>2018-07-23 (7일)</h1>
                                    <h1>수기수기한 여행</h1>
                                </div>
                            </li>
                            <li>
                                <div class="like">
                                 <span class="tema">
                                     체험여행
                                 </span>
                                  <span>
                                      500
                                  </span>
                                   <img src="./note_plans_list_jpg/eye.png" alt="" width="20px">
                                </div>
                                <div class="route">
                                    여수-전주-담양-고창-순창-보성-전주-담양-고창-순창-보성
                                </div>
                                <div class="person">
                                    <img src="./note_plans_list_jpg/user.png" alt="" width="20px">
                                    <span>사공수기</span>
                                </div>
                            </li>                    
                        </ul></a> -->

                    </div>
                    
                    <div id="viewLoading">
                        <img src="./note_plans_list_jpg/ajax-loader.gif" alt="" width="80px">
                    </div>
                </div>
            </div>
        </section>
        
    
    </div>
    <%@include file="footer.jsp"%>
    <script src="./js/custmize.js?ver=25"></script>

</body>
</html>