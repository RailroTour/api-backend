<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
    <link rel="stylesheet" href="css/styles.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
    <script src="./js/jquery.cookie.js"></script>
    <script src="./js/kakaologin.js?ver=6"></script>
    <title>로그인</title>

    
</head>
<body>

<div class="login_box">
  <a href="#"><img src="jpg/back.png" class="login_box_back_button"></a>
   <a href="#"><img src="jpg/home.png" class="login_box_home_button"></a>
   
    <div class="login_box_title">간편하게 로그인하기</div>
    <div class="login_box_text">귀찮은 입력없이 <br>카카오로 쉽고 빠르게 회원가입하세요.🚀</div>
    <a href="javascript:loginWithKakao()" class="kakaologin"><img class="login_box_button" src="jpg/login_button.png"></a>
    <div class="login_box_describe">
        <div class="login_box_describe_convenience">
            <img src="jpg/convenience.png">
            <span>편의성</span>
        </div>
        <div class="login_box_describe_time">
            <img src="jpg/clock.png">
            <span>시간 단축</span>
        </div>
        <div class="login_box_describe_infomation">
            <img src="jpg/info.png">
            <span>풍부한 정보제공</span>
        </div>
    </div>
</div>
</body>

</html>