<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
    <title>상세일정 만들기</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/planner3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <header>
            <img src="./jpg/RailroTour%20LOGO.png" alt="">
                <div class="Note_title"> </div>
                <div class="Note_edit_title">
                    <input type="text" value="" class="Note_title_input" maxlength="20">
                    <input type="submit" value="확인" name="Note_title_submit" class="Note_title_submit">
                </div>
            <a href="./index.jsp"><input type="button" value="저장 후 닫기"></a>
    </header>
    <section>
        <div class="side_left">
            <div class="edit_day">
<!--전체일정란-->
                <button class="date_change" id="datepicker">
                   <div class="date_info">
                        <h1>
                            2018-06-30 ~ 07-04
                        </h1>
<!--
                        <div>
                            <img src="./planner_Step2_JPG/settings.png" alt="" width="15px">
                            <span>EDIT</span>
                        </div>
-->
                   </div>
                </button>
                <div class="day_arrange">
                    <!-- <button data-area=1 class="selected">
                        <ul>
                            <li class="day">
                                <div class="day_num">DAY1</div>
                                <div class="day_str">목요일</div>
                            </li>
                            <li class="date">
                                <div class="date_num">06.07</div>
                                <div class="date_area">서울</div>
                            </li>
                        </ul>
                    </button>
                    <button data-area=35 data-sigungu=1>
                        <ul>
                            <li class="day">
                                <div class="day_num">DAY2</div>
                                <div class="day_str">금요일</div>
                            </li>
                            <li class="date">
                                <div class="date_num">06.08</div>
                                <div class="date_area">대구</div>
                            </li>
                        </ul>
                    </button>
                    <button data-area=3>
                        <ul>
                            <li class="day">
                                <div class="day_num">DAY3</div>
                                <div class="day_str">토요일</div>
                            </li>
                            <li class="date">
                                <div class="date_num">06.09</div>
                                <div class="date_area">여수</div>
                            </li>
                        </ul>
                    </button>
                    <button data-area=4>
                        <ul>
                            <li class="day">
                                <div class="day_num">DAY4</div>
                                <div class="day_str">일요일</div>
                            </li>
                            <li class="date">
                                <div class="date_num">06.10</div>
                                <div class="date_area">전주</div>
                            </li>
                        </ul>
                    </button>
                    <button data-area=5>
                        <ul>
                            <li class="day">
                                <div class="day_num">DAY5</div>
                                <div class="day_str">월요일</div>
                            </li>
                            <li class="date">
                                <div class="date_num">06.11</div>
                                <div class="date_area">포항</div>
                            </li>
                        </ul>
                    </button>
                     -->
                </div>
            </div>
            <div class="edit_route">
                 <div class="top">
                   <div class="day_group">
<!--
                        <span class="day">DAY1</span>
                        <span class="wall">|</span>
                        <span class="date">06.04</span>
                        <span class="week">(목요일)</span>
-->
                       <span class="course">여행코스</span>
                        <!-- <img src="./planner3-img/refresh.png" alt="" width="20px" class="refresh"> -->
                   </div>
                 </div>
                 <div class="bottom" id="route_add">
<!--                      <div class="route">
                        <div class="curcle">1</div>
                         <img src="./jpg/bn01.jpg" alt="" width="80px" height="75px">
                         <ul class="route_info">
                             <li class="title">북촌 한옥 마을fsdfasdfsdafs</li>
                             <li class="kind">관광지</li>
                         </ul>
                        <div class="btn_group">
                             <img src="./jpg/cancel_btn.png" alt="" class="delete_btn">
                         </div>
                     </div> -->
                 </div>
            </div>
        </div>
        
        <div id="map"></div>
        <div class="route_search">
            <div class="search_area">
                <span class="area_name">
                    <ul>
                        <li class="area">여행 일정 추가하기</li>
<!--
                        <li class="area_change">
                            도시변경
                        </li>
-->
                    </ul>
                </span>
                <span class="search_form">
                    <input type="text" maxlength="30" placeholder="장소 검색" class="area_search">
                </span>
                <span class="kind_select">
                    <div class="fas fa-camera" id="tour"></div>
                    <div class="fas fa-utensils" id="food"></div>
                    <div class="fas fa-hotel" id="rooms"></div>
                    <div class="fas fa-train" id="train"></div>
                    <div class="fas fa-suitcase" id="cart"></div>
                </span>
            </div>
            <div class="search_result">
               <div class="all">
<!--
                   <div class="search_data">
                       <a href="" class="img">
                        <img src="./jpg/bn01.jpg" alt="" width="100px" height="100px">
                    </a>
                    <ul class="info_group">
                       <input type="hidden" class="content_id" value="0">
                        <li class="title">북촌 한옥 마을111111111111111111111111111</li>
                        <li class="sub_title">관광지</li>
                    </ul>
                    <div class="add_btn">
                        <img src="./map_image/add.png" alt="" class="route_add_btn">
                    </div>
                </div>
-->
                    
                                   
<!--
                    <div class="search_data">
                    <div class="img">
                        <img src="./jpg/bn01.jpg" alt="" width="100px" height="100px">
                    </div>
                    <ul class="info_group">
                       <input type="hidden" class="content_id" value="0">
                        <li class="title">묵집</li>
                        <li class="sub_title">밥</li>
                        <li class="comment_like_group">
                            <div>
                                <img src="./planner3-img/comment.png" alt="" width="15px">
                                523
                            </div>
                            <div>|</div>
                            <div>
                            <img src="./planner3-img/stamp.png" alt="" width="15px">
                                24
                            </div>
                        </li>
                        <div class="day_marker">
                            DAY1
                        </div>
                    </ul>
                    <div class="add_btn">
                        <img src="./map_image/add.png" alt="" class="route_add_btn">
                    </div>
                </div>
-->
               </div>
        
               <div class="hash_add">
                   <input type="text" value="기차" class="hash" maxlength="6" disabled>
                   
                   <div class="radio_group">
                       <label for="fas fa-train"></label><input type="radio" name="kind" id="move" value="이동">  
                   </div>
                    <!-- <textarea name="" id="" cols="35" rows="3" placeholder="메모" style="resize:none" maxlength="20"></textarea> -->
                    
                    <button class="hash_add_btn">추가하기</button>
               </div>
            </div>
        </div>
    </section>
    
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6f0f8167f64486dc0809c9626d6436d5"></script>
    <script src="./js/planner3-kakaomap.js?ver=2"></script>
    <script src="./js/planner3.js?ver=73"></script>
</body>
</html>