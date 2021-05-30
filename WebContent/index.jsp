<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>내일로투어</title>
    <link rel="stylesheet" href="css/commen.css">
    <link rel="stylesheet" href="css/style.css?ver=21">
    <link rel="stylesheet" href="bxslide/dist/jquery.bxslider.css">
   <meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="bxslide/dist/jquery.bxslider.min.js">
    </script>
    <script src="./js/main.js?ver=7"></script>
    <script> /* 배너 슬라이드 */
            $(document).ready(function(){
                $('.slider').bxSlider({
                    auto:true,
                    adaptiveHeight:true,
                    mode:'fade'
                });
            });
    </script>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/footer.css">
    <script src="./js/header.js?ver=2"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    
    
</head>
<body>
<%@include file="header.jsp" %>
    <div id="wrap"> <!-- 전체를 감싸는 부분 -->

        <main>
            <ul class="slider">
                <li class="slideimg1"></li>
                <li class="slideimg2"></li>
<!--                <li class="slideimg3"></li>-->
            </ul>
        </main>
        <section id="content">
            <section id="banner">
                <div class="section">
                    <section id="ban01"><!--내일로 소개 부분 -->
                        <div class="ban-textbox">
                            <a href="#">
                                <img src="./jpg/introduce_railro.jpg" alt="">
                            </a>
                        </div>
                        <div class="ban-imgbox">
                            <a href="#">
                                <img src="./jpg/bn01.jpg" alt="">
                            </a>
                        </div>
                    </section> 
                    <section id="ban02">
                        <div id="ban02-1">
                            <div class="ban-iconbox">
                                <ul>
                                    <li class="one"><a href="./top100_food_tour_rooms.jsp?contenttypeid=12&pageNo=1">
                                        <img src="./jpg/ban-icon1.jpg" alt="">
                                    </a></li>
                                    <li class="two"><a href="./top100_food_tour_rooms.jsp?contenttypeid=32&pageNo=1">
                                        <img src="./jpg/ban-icon5.jpg" alt="">
                                    </a></li>
                                    <li class="three"><a href="./top100_planner.jsp?pageNo=1">
                                        <img src="./jpg/ban-icon6.jpg" alt="">
                                    </a></li>
                                    <li class="four"><a href="./top100_food_tour_rooms.jsp?contenttypeid=39&pageNo=1">
                                        <img src="./jpg/ban-icon4.jpg" alt="">
                                    </a></li>
                                </ul>
                            </div>
                             <div class="ban-textbox">
                             <span class="bottom">
                                 
                             </span>
                            <a href="#">
                                <img src="./jpg/top100.jpg" alt="">
                            </a>
                        </div>
                        </div>
                        <div id="ban02-2">
                            <div class="rank">
                                <div id="rank-list">
                                    <dl>
                                        <dt>실시간 급상승 검색어</dt>
                                        <dd>
                                            <ol>
                                                <li>
                                                   <a href="#">
                                                        <span class="rank-color">&nbsp;1</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <span class="rank-color">&nbsp;2</span>
                                                    </a>
                                                 </li>
                                                <li>
                                                    <a href="#">
                                                        <span class="rank-color">&nbsp;3</span>
   
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <span class="rank-color">&nbsp;4</span>
      
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <span class="rank-color">&nbsp;5</span>

                                                        
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <span class="rank-color">&nbsp;6</span>

                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <span class="rank-color">&nbsp;7</span>

                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <span class="rank-color">&nbsp;8</span>

                                                     </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <span class="rank-color">&nbsp;9</span>

                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <span class="rank-color">10</span>

                                                    </a>
                                                </li>
                                            </ol>
                                        </dd>
                                    </dl>
                                  </div>
                                      <div class="hoverrank-list">
                                        <ol>
                                            <li class="real_time_rank">실시간 인기 검색어</li>
                                            <li class="top"><a href="#"><b>1</b></a></li>
                                            <li class="top"><a href="#"><b>2</b></a></li>
                                            <li class="top"><a href="#"><b>3</b></a></li>
                                            <li class="top"><a href="#"><b>4</b></a></li>
                                            <li class="top"><a href="#"><b>5</b></a></li>
                                            <li class="top"><a href="#"><b>6</b></a></li>
                                            <li class="top"><a href="#"><b>7</b></a></li>
                                            <li class="top"><a href="#"><b>8</b></a></li>
                                            <li class="top"><a href="#"><b>9</b></a></li>
                                            <li class="top"><a href="#"><b>10</b></a></li>
                                            <li class="last_update">2018.05.02. 19:30:00 마지막 업데이트</li>
                                       </ol>
                                  </div>
                            </div>
                            <div class="CustomSearch">
                                <ul>
                                    <li class="Search-Title">
                                        <img src="jpg/search.png" alt="">
                                        사용자 맞춤 여행코스 검색
                                    </li>
                                    <li class="day">기간</li>
                                    <li class="r-button">
                                            <select name="" id="">
                                                <option value="">5일</option>
                                                <option value="">7일</option>
                                            </select>
                                    </li>
                                    <li class="tema">테마</li>
                                    <li>
                                        <span class="tema_group">
                                            <select name="" id="">
                                                <option value="">관광</option>
                                                <option value="">식도락</option>
                                                <option value="">휴식</option>
                                                <option value="">익스트림</option>
                                            </select>
                                        </span>
                                    </li>

                                    <li class="search">
                                    	검색
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </section>
                    <section id="ban03">
                        <div class="imgbox">
                            <img src="jpg/1.jpg" alt="">
                            <img src="jpg/2.jpg" alt="">
                        </div>
                    </section>
                    <section id="ban04">
                        <section id="timeline-title">
                           <div class="real_time">
                           		<span class="time">실시간</span>
                            	<span>&nbsp;플래너</span>
                            	<a href="#">
<!--                                 	<img src="jpg/reset.png" alt="" class="reset">
                                	<span class="resettext">&nbsp;새로고침</span> -->
                            	</a>
                            	<span class="line"></span>
                           </div>
                            
                            <div class="timeline1">
                               <a href="#" target="_blank">
                                   <img src="jpg/timeline1.jpg" alt="" style="width:81px; height:81px" >
                               </a>
                                <div class="bubble">
                                   <a href="#" target="_blank">
                                        <div class="text"><!-- 바다로 가즈아~~! --></div>
                                   </a>
                                   <span class="travel-bar">
                                       <i>Traveler</i>
                                       <span class="traveler">
                                           <!-- &nbsp;권재인 -->
                                       </span>
<!--                                        <div class="stamp_comment_cnt">
                                       	<input type="text" value="50" readonly>
                                       	<a href="">
                                       	<img src="jpg/stamp.png" alt="">
                                       	</a>
                                       </div> -->
                                   </span>
                                </div>
                            </div>
    						<div class="timeline1">
                               <a href="#" target="_blank">
                                   <img src="jpg/timeline1.jpg" alt="" style="width:81px; height:81px">
                               </a>
                                <div class="bubble">
                                   <a href="#" target="_blank">
                                        <div class="text"></div>
                                   </a>
                                   <span class="travel-bar">
                                       <i>Traveler</i>
                                       <span class="traveler">
                                           <!-- &nbsp;권재인 -->
                                       </span>
<!--                                        <div class="stamp_comment_cnt">
                                       	<input type="text" value="50" readonly>
                                       	<a href="">
                                       	<img src="jpg/stamp.png" alt="">
                                       	</a> -->
                                       </div>
                                   </span>
                                </div>
                            </div>
                        </section>
                        
                    </section>
                    <div class="clear"></div>
                </div>
            </section>
            
            <section id="intro">
                <div id="intro-title">
                    <div id="bg_fixed">
                        <h2>추천 여행 코스</h2>
                        <p>
                             많은 여행자들의 플래너를 볼 수 있습니다.<br>
                             생생한 여행 이야기를 만나보세요.
                        </p>
                    </div>
                </div>
                <div id="intro-banner" class="section planners">
<!--                        <a href="#" target="_blank"><ul class="planner">
                           <li class="cover-img"><img src="https://planner.jeju.com/images/mypage/keep_img_PT02.jpg" alt=""></li>
                           <li class="basic-data">
                               <span class="view"><i class="fas fa-eye"></i> 111</span>
                               <span class="writer">by.박현미</span>
                            </li>
                           <li class="contents">
                               <span class="days">3일</span>
                               <span class="title">너와함께 2박3일 커플 여행dddddddddddddddddddddddd</span>
                           </li>
                           <li class="decoration"><span class="circle">커플</span></li>
                       </ul></a> -->
                       
<!--                     <div class="view">
                       <a href="#">
                        View More
                        </a>
                    </div> -->
                </div>

            </section>
            
        </section>
        
    </div>
    <%@include file="footer.jsp" %>
    <script src="js/script.js?ver=18"></script>
    <script>
    
     $(function() {
      var count = $('#rank-list li').length;
      var height = $('#rank-list li').height();

      function step(index) {
          $('#rank-list ol').delay(2000).animate({
              top: -height * index,
          }, 500, function() {
              step((index + 1) % count);
          });
      }

      step(1);
  });

     var getCookie = function(name) {
    	 var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    	 return value? value[2] : null;
    	 };

    		$.ajax({ //인기검색어
    			type: 'GET',
    			url: './trending/keyword',
    			success: function(data) {
    				console.log(data);
    				for(let i=0; i<data.length; i++){
    					$("#rank-list>dl>dd>ol>li").eq(i).find('a').append('&nbsp;'+data[i].keyword);
    					$(".hoverrank-list>ol>li.top").eq(i).find('a').append('&nbsp;'+data[i].keyword);
    					$(".hoverrank-list>ol>li.top").eq(i).find('a').attr('href', './search_integrated.jsp?keyword='+data[i].keyword);
    					
    					let today = new Date();
    					$(".hoverrank-list>ol>li.last_update").text(dateFormat(today)+' 마지막 업데이트');
    				}
    			},
    			error: function() {
    				console.log('ajax failed');
    			}
    		});
   		
  </script>
</body>
</html>