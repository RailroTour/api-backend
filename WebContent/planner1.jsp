<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>플래너 정보 입력</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/sub-banner.css?ver=1">
    <link rel="stylesheet" href="./css/planner1.css?ver=1">
    <link rel="stylesheet" href="./css/toggle-switchy.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>

<link rel="stylesheet" href="./jquery-ui-1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="./jquery-ui-1.12.1/jquery-ui.min.js"></script>

<script src="./jquery-ui-1.12.1/datepicker-ko.js"></script>
<script type="text/javascript">
//<![CDATA[
$(function(){
	$("#datepicker").datepicker();
});
//]]>
</script>
	<script src="./js/planner1.js?ver=4"></script>

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
                        <button>플래너</button>
                        <ul class="listbox">
                            <li><a href="#">내일로 소개</a></li>
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
                <form action="" class="planner-form">
                    <ul class="basic-info-group">
                        <li class="basic">기본</li>
                        <li class="info">&nbsp;정보</li>
                    </ul>
                    <ul class="input-form">
                        <li class="planner-name planner-title">
                            <span class="title">플래너 명</span>
                            <span class="input-name"><input type="text" class="name"></span>
                        </li>
                        <li class="planner-name start-day">
                            <span class="title">출발일</span>
                            <span class="input-name"><input type="text" id="datepicker" class="date name" readonly></span>
                        </li>
                        <li class="planner-name days">
                            <span class="title">기간</span>
                            <span class="radio-group">
                                <input type="radio" id="3day" name="days" value="3" checked/>
                                <label for="3day"><span></span>3일</label>
                                <input type="radio" id="7day" name="days" value="7"/>
                                <label for="7day"><span></span>7일</label>
                            </span>
                        </li>
                        <li class="planner-name tema">
                            <span class="title">테마</span>
                            <span class="radio-group">
                                <input type="radio" id="health" name="tema" value="17" checked/>
                                <label for="health"><span></span>힐링</label>
                                <input type="radio" id="tour" name="tema" value="14" />
                                <label for="tour"><span></span>관광</label>
                                <input type="radio" id="experience" name="tema" value="16" />
                                <label for="experience"><span></span>체험</label>
                                <input type="radio" id="rest" name="tema" value="15" />
                                <label for="rest"><span></span>휴식</label>
                            </span>
                        </li>
<!--                         <li class="planner-name disclosure">
                            <span class="title ">공개여부</span>
                            <span class="radio-group">
                                <label class="toggle-switchy" for="example_rounded_4" data-size="sm" data-style="rounded">
								<input checked="true" type="checkbox" id="example_rounded_4">
								<span class="toggle">
									<span class="switch"></span>
								</span>
							</label>
                            </span>
                        </li> -->
                    </ul>
                    <div class="btn-group">
                            <input type="button" value="만들기" class="create">
                            <input type="button" value="취소" class="cancel">
                    </div>
                </form>
            </div>
        </section>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>