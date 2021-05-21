<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>마이페이지 : 내정보 관리</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/mypage_management.css?ver=3">
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
 	<script type="text/javascript" src="./js/mypage_manage.js?ver=24"></script>
 	
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
                <div class="notify">
                   <img src="./mypage_img/notification.png" alt="" width="30px" class="notify_img">
                    <div class="title">내 정보를 <span class="textcolor">최신 정보로 관리</span>해주세요.</div>
                </div>
                <form action="" id="management" enctype="multipart/form-data">
                   <ul>
                       <li class="profile">
                           <span class="text">프로필 사진</span>
                           <img src="./jpg/default_profile_img.jpg" alt="">
                           <input type="file" id="imgchange" accept="image/*" name="imgfile" hidden>
                           <label for="imgchange" class="imgchange">이미지 변경</label>
                       </li>
                       <li class="id">
                           <span class="text">아이디</span>
                           <div>cartoonpoet</div>
                       </li>
                       <li class="name">
                           <span class="text">이름</span>
                           <div>손준호</div>
                       </li>
                       <li class="nickname">
                           <span class="text">닉네임</span>
                           <div><input type="text" value="하루"></div>
                       </li>
                       <li class="email">
                           <span class="text">이메일</span>
                           <div><input type="text" value="cartoonpoet@naver.com"></div>
                       </li>
                   </ul>
                   <div class="btn-group">
                       <button class="cancel">취소</button><button class="modify">변경</button>
                   </div>
                </form>
            </div>
        </section>
        
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>