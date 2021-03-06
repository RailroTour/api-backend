<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
    <title>음식점 검색</title>
    <link rel="stylesheet" href="./css/commen.css">
   <link rel="stylesheet" href="./css/search_integrated.css">
    <link rel="stylesheet" href="./css/search_destination.css">
    <link rel="stylesheet" href="./css/search_bar.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="./js/search_foods.js"></script>
    
    
    <script src="./js/script.js"></script>
       <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/footer.css">
    <script src="./js/header.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    
</head>
<body>
<%@include file="header.jsp" %>
    <div id="wrap"> <!-- 전체를 감싸는 부분 -->
        

        <section id="content">
                        <div class="search_bar">
                <input type="text" placeholder="검색어 입력" class="search_input">
                <button class="search_btn">검색</button>
            </div>
             <div class="result_bar">
                <div>
                    ????의 검색 결과입니다.
                </div>
            </div>
            <ul class="itemlist">
                <li class="itembox"><a href="#">전체</a></li>
                <li class="itembox"><a href="#">관광지</a></li>
                <li class="itembox selected"><a href="#">음식점</a></li>
                <li class="itembox"><a href="#">플래너</a></li>
                <li class="itembox"><a href="#">숙소</a></li>
            </ul>
            <div class="Contents">
                
                <div class="Tourist Restaurant">
                    <div class="Tourist_Title">
                        <h1>음식점</h1>
                   </div>
                    
<!--
                    <ul class="Tour_group">
                        <li class="TourImage"><img src="./map_image/광주.jpg" alt="" width="148px"></li>
                        <div class="TourInfo">
                            <li class="TourTitle">하회마을</li>
                            <li class="shopping_add"><img src="./jpg/plus.png" alt=""></li>
                            <li class="TourContent">하회별신굿탈놀이는 하회마을   <br>dddddddddddddddddfffffffffff</li>
                        </div>
                        <div class="like_review">
                           <span>321321</span>
                            <img src="./mynote_jpg/review.png" alt="">
                            <span>321321</span>
                            <img src="./mynote_jpg/footprint.png" alt="">
                        </div>
                    </ul>
-->
                    
                </div>
                <div class="page_num_group">
<!--
                    <a href="#">이전</a>
                    <a href="#" class="selected">1</a>
                    <a href="#">2</a>
                    <a href="#">다음</a>
-->
                </div>
            </div>
        </section>
        
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>