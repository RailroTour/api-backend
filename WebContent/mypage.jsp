<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
    <title>마이페이지</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/mypage_home.css?ver=2">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
 
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
                    <h3>My Page</h3>
                    <h2>
                        마이페이지
                    </h2>
                </div>
            </div>
        </section>
        <section id="sub-content">
            
            <div id="sub-con-body" class="section">
<!--
                <div class="s-c-b-title">
                    <h3>My Page</h3>
                    <h2>마이페이지</h2>
                </div>
-->
                <div class="mypage">
                   <a href="#">
                    <ul class="box1">
                        <div><img src="./mypage_img/notification.png" alt="" width="15px">&nbsp;&nbsp;추천하는 보호설정</div>
                        <li class="text1">내 개인정보를 항상</li>
                        <li class="text2">최신 정보로</li>
                        <li class="text3"><span>관리</span>해주세요!</li>
                        <li class="text4">ID/PW 분실방지를 위해 최신정보로 유지하세요</li>
                    </ul>
                    </a>
                    <a href="./mypage_manage.jsp">
                    <ul class="box1">
                        <div><img src="./mypage_img/notification.png" alt="" width="15px">&nbsp;&nbsp;안전하게 보호</div>
                        <li class="text1">내정보를</li>
                        <li class="text2">최신정보로 관리</li>
                        <li class="btn">변경</li>
                        <li class="text5">주기적으로 변경해주세요.</li>
                    </ul>
                    </a>
                    <a href="./mypage_remove.jsp">
                    <ul class="box1">
                        <div><img src="./mypage_img/notification.png" alt="" width="15px">&nbsp;&nbsp;개인정보 파기</div>
                        <li class="text1">안전하게</li>
                        <li class="text2">회원탈퇴</li>
                        <li class="btn">탈퇴</li>
                        <li class="text6">회원탈퇴시 개인정보는 즉시 파기됩니다.</li>
                    </ul>
                    </a>
                </div>
            </div>
        </section>
        
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>