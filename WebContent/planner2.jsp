<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>새 플래너 작성 : 지역 선택</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/sub-banner.css">
    <link rel="stylesheet" href="./css/planner2.css?ver=1">
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
<script src="./js/planner2.js"></script>


 	<script src="./js/script.js"></script>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/footer.css">
    <script src="./js/header.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp" %>
    <div id="wrap"> <!-- 전체를 감싸는 부분 -->
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
                        <button>내일로 소개</button>
                        <ul class="listbox">
                            <li><a href="#">플래너</a></li>
                            <li><a href="#">TOP 100</a></li>
                            <li><a href="#">플래너</a></li>
                            <li><a href="#">내 주변</a></li>
                            <li><a href="sub02.html">고객센터</a></li>
                        </ul>
                    </div>
                    <div class="listmenu">
                         <button>새 플래너 작성</button>
                        <ul class="listbox">
                            <li><a href="#">플래너 목록</a></li>
                        </ul>
                    </div>
                    
                </div>
            </div>
            <div id="sub-con-body" class="section">
                <div class="s-c-b-title">
                    <h3>New Planner Create</h3>
                    <h2>새 플래너 작성</h2>
                </div>
                <ul class="travel-box selected-area">
                    <li class="key"><span>여행 지역</span></li>
                    <li class="vals">
<!--
                        <div class="area-item">
                            <button class="cancel-btn"><img src="./jpg/cancel_btn.png" alt=""></button>
                            <span class="area-name">경주</span>
                            <button class="adjust-btn minus"><img src="./jpg/minus.png" alt=""></button>
                            <span><input type="text" disabled value="7" class="day-num"> 일</span>
                            <button class="adjust-btn plus"><img src="./jpg/plus.png" alt=""></button>
                        </div>
-->
                    </li>
                </ul>
                <ul class="travel-box travel-area">
                    <li class="key"><span>여행지</span></li>
                    <li class="vals">
						<div class="select">
							<input type="radio" id="select" name="claasify" checked><label for="select">전체</label> 
							<input type="radio" id="select2" name="claasify"><label for="select2">전라북도</label>
							<input type="radio" id="select2" name="claasify"><label for="select2">전라남도</label>
						</div>
					</li>
                </ul>
                
                <ul class="areas">
                    <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                                        <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                                        <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                                        <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                                        <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                                        <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                                        <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                                        <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                                        <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                                        <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                                        <li class="area">
                       <img src="./thumb/%EA%B0%80%ED%8F%89_thumb.jpg" alt="" class="area-img">
                       <div class="black-cover"></div>
                        <span class="do">경상북도,</span>
                        <span class="si-gun-gu">경주</span>
                    </li>
                </ul>
                
                <button class="detail-schedule-btn">상세 일정 만들기</button>
                
            </div>
        </section>

    </div>
    <%@include file="footer.jsp" %>

</body>
</html>