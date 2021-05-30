<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>내일로 소개</title>
    <link rel="stylesheet" href="./css/commen.css">
    
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/sub01.css">
   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
 
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/footer.css">
    <script src="./js/header.js?ver=2"></script>
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
                            <li><a href="#">TOP 100</a></li>
                            <li><a href="#">플래너</a></li>
                            <li><a href="#">검색</a></li>
                            <li><a href="sub02.html">커뮤니티</a></li>
                        </ul>
                    </div>
                    <div class="listmenu">
                         <button>내일로 바우처</button>
                        <ul class="listbox">
                            <li><a href="./railro_intro.jsp">내일로 소개</a></li>
                        </ul>
                    </div>
                    
                </div>
            </div>
            <div id="sub-con-body">
                <div class="s-c-b-title">
                    <h3>Railro Voucher</h3>
                    <h2>내일로 바우처</h2>
                </div>

            </div>
        </section>
        <section class="railro_intro_img">
           <img src="https://www.letskorail.com/images/prd/railro_ticket_02.jpg"> 
        </section>
        
    </div>
    <%@include file="footer.jsp" %>
    <script src="./js/script.js"></script>
</body>
</html>