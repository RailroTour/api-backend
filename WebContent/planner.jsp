<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
    <title>플래너 보기</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/mynote.css?ver=15">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    </script>
    
      <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css">
    
    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>


    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/footer.css?ver=1">
    <script src="./js/header.js?ver=2"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    
</head>
<body>
<%@include file="header.jsp" %>
    <div id="wrap"> <!-- 전체를 감싸는 부분 -->
        <section id="sub-content">
           <section id="note_img" style="background:url('./mynote_jpg/note_bg.jpg') no-repeat;background-size:cover;background-position:center center;">
                <div class="note_info">
                    <ul class="note_info_center">
                        <div class="top">
                                 <li class="cover_img">
                               <form id="createNewsAndEventsForm" method="post" enctype="multipart/form-data" >
                               <input type="file" id="img" accept="image/*" name="save" accept="image/gif, image/jpeg, image/png" hidden>
                               </form>
                               	<label for="img" class="img_change">커버사진 바꾸기</label>
                           </li>
                             <!-- <li class="add_mynote"><img src="./mynote_jpg/add.png" alt=""></li> -->
                            <!-- <li class="like"><img src="./mynote_jpg/footprint.png" alt=""></li> -->
                        </div>
                        <li class="user">
                            <div class="user_img">
                                <img src="./mynote_jpg/man-user.png" alt="">
                            </div>
                            <div class="user_name">
                                닉네임
                            </div>
                        </li>
                        <li class="title">
                            <div>
                                드디어 끝났구나....
                            </div>
                        </li>
                        <li class="note_date">
                            <div class="date">
                                2018.01.15~2018.01.19 (5일)
                            </div>
                            <div class="tema" style="background-color: #696969">
                                체험여행
                            </div>
                        </li>
                        <li class="add_info">
                            <div class="rectangle">
<!--                                 <img src="./mynote_jpg/foot.png" alt="">
                                <span>좋아요 수</span> -->
                                <img src="./mynote_jpg/view.png" alt="" class="view">
                                <span class="view"> <!-- 조회수 --></span>
                            </div>
                        </li>
                    </ul>
                </div>
            </section>
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
                         <button>여행 플래너</button>
                        <ul class="listbox">
                            <li><a href="./planner1.jsp">새 플래너 작성</a></li>
                            <li><a href="./myplanner.jsp">플래너 목록</a></li>
                        </ul>
                    </div>
                    
                </div>
            </div>

            <div id="sub-con-body" class="section">
                <div class="plan_nav">
                    <div class="top_arrow" onclick="arrow_Move(-1)"></div>
                    <ul class="nav_route">
<!--                         <li style="color: #0093ff" onclick="fnMove(0)">DAY1 전주<hr></li>
                        <li onclick="fnMove(1)">DAY2 전주<hr></li>
                        <li onclick="fnMove(2)">DAY3 전주<hr></li>
                        <li onclick="fnMove(3)">DAY4 전주<hr></li>
                        <li onclick="fnMove(4)">DAY5 전주<hr></li>
                        <li onclick="fnMove(5)">DAY6 전주<hr></li>
                        <li onclick="fnMove(6)">DAY7 전주</li> -->
                    </ul>
                    <div class="bottom_arrow" onclick="arrow_Move(1)"></div>
                </div>
                <div class="plan_route">
                    <ul class="select">
                        <li style="color: #006cff" class="view1">순서대로 보기</li>
<!--                         <span>&nbsp;|&nbsp;</span>
                        <li class="view2">표로 보기</li> -->
                    </ul>
                    
                    <div class="plan_info">
<!--                           <ul class="day_info">
                            <li class="day">DAY1</li>
                            <li class="date_info">
                                <span class="date">2018-07-22</span>
                                <span class="area">전주</span>
                            </li>
                        </ul>
                        
                        <ul class="day_route">
                            <li class="route">
                                <div class="number">
                                    <span>2</span>
                                </div>
                                <div class="info">
                                    <a href="">
                                        <img src="./mynote_jpg/test.jpg" alt="">
                                    </a>
                                    <div class="title">
                                        갈비집
                                    </div>
                                    <div class="kinds">
                                        <img src="./mynote_jpg/spoon.png" alt="" class="food_tour_hash">
                                        <a href=""><img src="./mynote_jpg/info.png" alt="" class="info"></a>
                                    </div>
                                    <div class="arrow"></div>
                                    <div contenteditable="true" class="post">메모가 없습니다.</div>
                                </div>
                            </li>
                             <hr class="line">
                            <li class="route">
                                <div class="number">
                                    <span>2</span>
                                </div>
                                <div class="info">
                                    <a href="">
                                        <img src="./mynote_jpg/test.jpg" alt="">
                                    </a>
                                    <div class="title">
                                        갈비집
                                    </div>
                                    <div class="kinds">
                                        <img src="./mynote_jpg/spoon.png" alt="" class="food_tour_hash">
                                        <a href=""><img src="./mynote_jpg/info.png" alt="" class="info"></a>
                                    </div>
                                    <div class="arrow"></div>
                                    <div contenteditable="true" class="post">메모가 없습니다.</div>
                                </div>
                            </li>
                        </ul> -->
                    </div>
                </div>
                
            </div>
        </section>
        
    </div>
 <%@include file="footer.jsp" %>   
<div id="dialog" title="알림">
    해당 노트를 내 노트에 담으시겠어요?
</div>
    <script src="./js/mynote.js?ver=73"></script>
    <script src="./js/script.js"></script>
    <script>
    $(function () {

      var $gnb = $(".plan_nav").first();
      var gnbTop = $gnb.offset().top;

      function fixGNB() {
        var winTop = $(window).scrollTop();
        $gnb.css({
          'position': (winTop > gnbTop-100) ? 'fixed' : 'absolute',
          'top': (winTop > gnbTop-100) ? '300px' : ''
        });
      }

      fixGNB();

      $(window).scroll(function () {
        fixGNB();
      });  


        $("#dialog").dialog({
            autoOpen:false, //자동으로 열리지않게
            position:['center', 'center'], //x,y  값을 지정
            //"center", "left", "right", "top", "bottom"
            modal:true, //모달대화상자
            resizable:false, //크기 조절 못하게

            buttons:{
                "확인":function(){
                    $(this).dialog("close");
                },"취소":function(){
                    $(this).dialog("close");
                }
            }
        });

    });
  </script>


</body>
</html>