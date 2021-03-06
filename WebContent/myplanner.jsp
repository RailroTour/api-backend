<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
    <title>내 플래너 목록</title>
        
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/note_plans.css?ver=8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="./js/myplanner.js?ver=14"></script>
    
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
                        <a href="./index.jsp">
                            <img src="./jpg/home.jpg" alt="">
                        </a>
                    </div>
                    <div class="listmenu">
                        <button>플래너</button>
                        <ul class="listbox">
                            <li><a href="./railro_intro.jsp">내일로 소개</a></li>
                            <li><a href="./top100_food_tour_rooms.jsp?contenttypeid=12&pageNo=1">TOP 100</a></li>
                            <li><a href="./search_integrated.jsp">검색</a></li>
                            <li><a href="./community.jsp">커뮤니티</a></li>
                        </ul>
                    </div>
                    <div class="listmenu">
                         <button>내 플래너 목록</button>
                        <ul class="listbox">
                            <li><a href="./planner1.jsp">새 플래너 작성</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="sub-con-body" class="section">
                <div class="s-c-b-title">
                    <h3>Planner List</h3>
                    <h2>플래너 목록</h2>
                </div>
                <div class="s-c-b-content">
                   
                    <div class="plans_list_rows">
                       
<!--                         <a href=""><ul class="list_item">
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
                                    <img src="./note_plans_list_jpg/foot.png" alt="" width="20px">
                                </div>
                                <div class="route">
                                    여수-전주-담양-고창-순창-보성-전주-담양-고창-순창-보성
                                </div>
                                <div class="person">
                                    <img src="./note_plans_list_jpg/user.png" alt="" width="20px">
                                    <span>사공수기</span>
                                    <div class="btn">
                                        <span class="revise">수정</span>
                                        <span style="color: black">|</span>
                                        <span class="remove">삭제</span>
                                    </div>
                                </div>
                            </li>                    
                        </ul></a> -->
                        
                    </div>
                    
                    <div id="viewLoading">
                        <img src="./note_plans_list_jpg/ajax-loader.gif" alt="" width="80px">
                    </div>
                </div>
            </div>
        </section>
        
    </div>
    <%@include file="footer.jsp" %>

    <script>
//        $(document).ready(function () {
//            // $.ajax() 메서드를 이용한다.
//            $(document).ajaxStart(function(){
//              $('#viewLoading').show();
//            }).ajaxStop(function() {
//              $('#viewLoading').hide();
//            })
//            
//            $(window).scroll(function() {
//
//                if ($(window).scrollTop() == $(document).height() - $(window).height()) {
//                    alert('d');
//                }
//            });
//            
//            $('.person .btn .revise').on('click', function(){
//                alert('수정');
//            })
//            $('.person .btn .remove').on('click', function(e){
//                e.preventDefault(); 
//                $(this).closest('a').remove();
//            })
//        });
  </script>
</body>
</html>