<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
    <title>통합검색</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/search_integrated.css">
    <link rel="stylesheet" href="./css/search_bar.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="./js/search_integrated.js?ver=12"></script>


    <script src="./js/script.js"></script>
        <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/footer.css">
    <script src="./js/header.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    
</head>

<body>
<%@include file="header.jsp" %>
    <div id="wrap">
        <!-- 전체를 감싸는 부분 -->
        <section id="content">
            <div class="search_bar">
                <input type="text" placeholder="검색어 입력" class="search_input">
                <button class="search_btn">검색</button>
            </div>
            <div class="result_bar">
                <div>
                    d의 검색 결과입니다.
                </div>
            </div>
            <ul class="itemlist">
                <li class="itembox selected"><a href="#">전체</a></li>
                <li class="itembox"><a href="./search_tour.jsp">관광지</a></li>
                <li class="itembox"><a href="./search_foods.jsp">음식점</a></li>
                <li class="itembox"><a href="#">플래너</a></li>
                <li class="itembox"><a href="./search_rooms.jsp">숙소</a></li>
            </ul>
            <div class="Contents">
                <div class="Tourist Tour">
                    <div class="Tourist_Title">
                        <h1>관광지</h1>
                        <!-- <h2>더보기<a href=""><img src="./jpg/plus.png" alt=""></a></h2> -->
                    </div>
<!--

                    <ul class="Tour_group">
                       <a href="#">
                        <li class="TourImage"><img src="./map_image/광주.jpg" alt="" width="148px"></li>
                        <div class="TourInfo">
                            <li class="TourTitle">하회마을</li>
                            <li class="shopping_add"><img src="./jpg/plus.png" alt=""></li>
                            <li class="TourContent">하회별신굿탈놀이는 하회마을 <br>dddddddddddddddddfffffffffff</li>
                        </div>
                        <div class="like_review">
                            <span>321321</span>
                            <img src="./mynote_jpg/review.png" alt="">
                        </div>
                        </a>
                    </ul>
-->
                    
                </div>
                <div class="Tourist Restaurant">
                    <div class="Tourist_Title">
                        <h1>음식점</h1>
                        <!-- <h2>더보기<a href=""><img src="./jpg/plus.png" alt=""></a></h2> -->
                    </div>

                
                </div>
                <div class="Travel_Course Tourist">
                    <div class="Tourist_Title">
                        <h1>플래너</h1>
                        <!-- <h2>더보기<img src="./jpg/plus.png" alt=""></h2> -->
                    </div>

                    <div class="plans_list_rows">
<!--                         <a href="">
                            <ul class="list_item">
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
                                        <span>
                                            11
                                        </span>
                                        <img src="./mynote_jpg/footprint.png" alt="" width="20px">
                                    </div>
                                    <div class="route">
                                        여수-전주-담양-고창-순창-보성
                                    </div>
                                    <div class="person">
                                        <img src="./note_plans_list_jpg/user.png" alt="" width="20px">
                                        <span>사공수기</span>
                                    </div>
                                </li>
                            </ul>
                        </a> -->


                    </div>
                </div>
                  <div class="Tourist Rooms">
                    <div class="Tourist_Title">
                        <h1>숙소</h1>
                        <!-- <h2>더보기<a href=""><img src="./jpg/plus.png" alt=""></a></h2> -->
                    </div>

                    
                </div>

<!--
                <div class="page_num_group">
                    <a href="#">이전</a>
                    <a href="#" class="selected">1</a>
                    <a href="#">2</a>
                    <a href="#">다음</a>
                </div>
-->

            </div>
        </section>

    </div>
<%@include file="footer.jsp" %>
</body></html>