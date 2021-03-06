<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
    <title>Top 100</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/sub-banner.css">
    <link rel="stylesheet" href="./css/top100.css?ver=1">
   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
     <script src="./js/top100.js?ver=14">
    </script>
 
 
     <script src="./js/script.js"></script>
    <link rel="stylesheet" href="css/header.css?ver=1">
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
                <div class="section">
                    <div class="homebtn">
                        <a href="./Main.me">
                            <img src="./jpg/home.jpg" alt="">
                        </a>
                    </div>
                    <div class="listmenu">
                        <button>TOP 100</button>
                        <ul class="listbox">
                            <li><a href="./railro_intro.jsp">내일로 소개</a></li>
                            <li><a href="./planner1.jsp">플래너</a></li>
                            <li><a href="./search_integrated.jsp">검색</a></li>
                            <li><a href="./community.jsp">커뮤니티</a></li>
                        </ul>
                    </div>
                    <div class="listmenu">
                         <button class="sub-menu"></button>
                        <ul class="listbox sub-box">
<!-- 
                        	<li><a href="./Top100_Search.se?contenttypeid=12&page_num=1">관광지</a></li>

                            <li><a href="./Top100_Search.se?contenttypeid=39&page_num=1">음식점</a></li>
                            <li><a href="./Top100_Note.se?page_num=1">내일로 노트</a></li>
                            <li><a href="./Top100_Member.se?page_num=1">내일러</a></li> -->
                        </ul>
                    </div>
                    
                </div>
            </div>
            <div id="sub-con-body" class="section">
                <div class="s-c-b-title">
                    <h3>Top 100</h3>
                    <h2><!-- 음식점 --></h2>
                </div>
                <ul class="top">
                    <div id="viewLoading" style="text-align: center">
                        <img src="./note_plans_list_jpg/ajax-loader.gif" alt="" width="80px">
                    </div>
<!--                      <li>
                        <span class="rank">1</span>
                        <a href="./Detail_Info.se?contentid=&contenttypeid=" target="_blank"><img src="./top100/906977d7b5b011571499b4081e136dbe.jpg" alt=""></a>
                        <div class="title">음식점명</div>
                        <div class="like_group">
                            <img src="./top100/heart.png" alt="" class="like"><span class="like_cnt">500</span>
                        </div>
                        <span class="review_cnt">리뷰 :1</span>
                        <div class="tags">
                            <span>#덥다</span> <span>#덥다</span> <span>#덥다</span> <span>#덥다</span> 
                        </div>
                    </li> -->
                </ul>
                <div class="page_num_group">
<!--                     	<a href="./Top100_Search.se?contenttypeid=" class="selected">1~50위</a>
                		<a href="./Top100_Search.se?contenttypeid=">50~100위</a> -->
                </div>
            </div>
        </section>
        
        
       
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>