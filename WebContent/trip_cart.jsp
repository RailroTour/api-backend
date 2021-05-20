<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>서브페이지</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/sub01.css">
    <link rel="stylesheet" href="./css/styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>

    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/footer.css">
    <script src="./js/header.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>

<body>
<%@include file="header.jsp" %>
    <div id="wrap">
        <!-- 전체를 감싸는 부분 -->
        <section id="sub-imgbanner">
            <div class="section">
                <div class="sub-img-text">
                    <h3>Join tomorrow</h3>
                    <h2>
                        내일을 잇다, <b>내일로</b>
                    </h2>
                </div>
            </div>
        </section>
        <section id="sub-content">
            <div id="sub-con-navi">
                <div class="sub-con-navi-box">
                    <div class="homebtn">
                        <a href="../index.html">
                            <img src="./jpg/home.jpg" alt="">
                        </a>
                    </div>
                    <div class="listmenu">
                        <button>플래너</button>
                        <ul class="listbox">
                            <li><a href="#">내일로 소개</a></li>
                            <li><a href="#">TOP 100</a></li>
                            <li><a href="#">검색</a></li>
                            <li><a href="sub02.html">커뮤니티</a></li>
                        </ul>
                    </div>
                    <div class="listmenu">
                        <button>여행바구니</button>
                        <ul class="listbox">
                            <li><a href="#">새 플래너 작성</a></li>
                            <li><a href="#">내 플래너 목록</a></li>
                        </ul>
                    </div>

                </div>
            </div>
            <div id="sub-con-body">
                <div class="s-c-b-title">
                    <h3>trip_cart</h3>
                    <h2>여행 바구니</h2>
                </div>

            </div>
        </section>

        <div class="cart_tourist_destination">
            <div class="cart_title">내가 담은 목록</div>
            <div class="head">
                <div>ID</div>
                <div>이미지</div>
                <div>제목</div>
                <div>구분</div>
                <div>선택</div>
            </div>
            <div class="row1">
                <div>ID</div>
                <div>
                <!-- 상세보기 페이지 이동-->
                <a href="#"><img class="destination_img" src="jpg/palace.jpeg"></a></div>
                <div><a href="#">제목</a></div>
                <div>구분</div>
                 <div>
                <button><img class="close_mark_img" src="jpg/close_mark.png"></button></div>
            </div>
            <div class="row1">
                <div>ID</div>
                <div>
                <!-- 상세보기 페이지 이동-->
                <a href="#"><img class="destination_img" src="jpg/palace.jpeg"></a></div>
                <div><a href="#">제목</a></div>
                <div>구분</div>
                 <div>
                <button><img class="close_mark_img" src="jpg/close_mark.png"></button></div>
            </div>
            <div class="row1">
                <div>ID</div>
                <div>
                <!-- 상세보기 페이지 이동-->
                <a href="#"><img class="destination_img" src="jpg/palace.jpeg"></a></div>
                <div><a href="#">제목</a></div>
                <div>구분</div>
                <div>
                <button><img class="close_mark_img" src="jpg/close_mark.png"></button></div>
            </div>
        </div>


    </div>
    <%@include file="footer.jsp" %>
    <script src="./js/script.js"></script>
</body></html>