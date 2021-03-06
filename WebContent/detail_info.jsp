<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
<title>세부정보</title>
<link rel="stylesheet" href="./css/commen.css">
<link rel="stylesheet" href="./css/sub-banner.css">
<link rel="stylesheet" href="./css/detail_info.css?ver=5">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<script src="./jqcloud/d3.js"></script>
<script src="./jqcloud/d3.layout.cloud.js"></script>
<script src="./jqcloud/d3.wordcloud.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


<script src="./js/script.js"></script>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css?ver=10">
<script src="./js/header.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">

</head>
<body>
	<%@include file="header.jsp"%>
	<div id="wrap">
		<!-- 전체를 감싸는 부분 -->
		<section id="img_banner">
			<div class="more_info">
				<div class="img">
					<ul class="img_collection" id="slides">
						<!-- <li style="display: block"><img src="./Food_More_Infomation_IMG/1.jpg" alt=""></li>
                        <li><img src="./Food_More_Infomation_IMG/2.jpg" alt=""></li>
                        <li><img src="./Food_More_Infomation_IMG/3.jpg" alt=""></li> -->
					</ul>
					<ul class="btn_group">
						<li class="Previous"><img
							src="./Food_More_Infomation_IMG/left-arrow.png" alt=""></li>
						<!--
                        <li class="Stop"><img src="./Food_More_Infomation_IMG/pause-button.png" alt=""></li>
                        <li class="Play" style="display: none"><img src="./Food_More_Infomation_IMG/play-button.png" alt=""></li>
-->
						<li class="Next"><img
							src="./Food_More_Infomation_IMG/left-arrow.png" alt=""></li>
					</ul>
				</div>
				<div class="text">
					<ul class="text_group">
						<li class="title">
							<span>none</span> 
							<span class="trip_cart">여행바구니</span>
						</li>
						<li class="rotate">
							<div>&#8226; 주소</div>
							<div>미표시</div>
						</li>
						<li class="menu">
							<div>&#8226; 대표 메뉴</div>
							<div>미표시</div>
						</li>
						<li class="open_time">
							<div>&#8226; 영업 시간</div>
							<div>미표시</div>
						</li>
						<li class="rest">
							<div>&#8226; 휴무일</div>
							<div>미표시</div>
						</li>
						<li class="phone">
							<div>&#8226; 전화번호</div>
							<div>미표시</div>
						</li>
						<li class="homepage">
							<div>&#8226; 홈페이지</div>
							<div>미표시</div>
						</li>
					</ul>
				</div>
			</div>
		</section>
		<section id="sub-content">
			<div id="sub-con-navi">
				<div class="section">
					<div class="homebtn">
						<a href="./index.html"> <img src="./jpg/home.jpg" alt="">
						</a>
					</div>
					<div class="listmenu">
						<button>상세정보</button>
					</div>
					<div class="listmenu">
						<button class="info_name">음식점 정보</button>
					</div>

				</div>
			</div>
			<div id="sub-con-body" class="section">
				<ul class="more_info">
					<li class="overview"><span>&#8226; 개 요</span> <span>미표시</span>
					</li>
					<!-- <li class="url">
                        <span>&#8226; 홈페이지 주소</span>
                        <span><a href="#">www.naver.com</a></span>
                    </li> -->
					<li class="post"><span>&#8226; 우편번호</span> <span>미표시</span></li>
					<li class="people"><span>&#8226; 수용인원</span> <span>미표시</span>
					</li>
					<li class="stroller"><span>&#8226; 유모차 대여 여부</span> <span>미표시</span>
					</li>
					<li class="credit_card"><span>&#8226; 신용카드 가능 여부</span> <span>미표시</span>
					</li>
					<li class="animal"><span>&#8226; 애완동물 가능 여부</span> <span>미표시</span>
					</li>
					<li class="available_age"><span>&#8226; 체험가능 연령</span> <span>미표시</span>
					</li>
					<li class="experience"><span>&#8226; 체험 안내</span> <span>미표시</span>
					</li>
					<li class="question"><span>&#8226; 문의 및 안내</span> <span>미표시</span>
					</li>
					<li class="open"><span>&#8226; 개장일</span> <span>미표시</span></li>
					<li class="parking"><span>&#8226; 주차시설</span> <span>미표시</span>
					</li>
					<li class="rest_day"><span>&#8226; 쉬는날</span> <span>미표시</span>
					</li>
					<li class="use"><span>&#8226; 이용시기</span> <span>미표시</span></li>
					<li class="use_time"><span>&#8226; 이용시간</span> <span>미표시</span>
					</li>
					<li class="discount"><span>&#8226; 할인정보</span> <span>미표시</span>
					</li>
					<li class="representative_menu"><span>&#8226; 대표메뉴</span> <span>미표시</span>
					</li>
					<li class="kid"><span>&#8226; 어린이 놀이방 여부</span> <span>미표시</span>
					</li>
					<li class="opening"><span>&#8226; 개업일</span> <span>미표시</span>
					</li>
					<li class="packing"><span>&#8226; 포장 가능</span> <span>미표시</span>
					</li>
					<li class="reserv"><span>&#8226; 예약 안내</span> <span>미표시</span>
					</li>
					<li class="scale"><span>&#8226; 규모</span> <span>미표시</span></li>
					<li class="seats"><span>&#8226; 좌석수</span> <span>미표시</span></li>
					<li class="smoking"><span>&#8226; 금연/흡연 여부</span> <span>미표시</span>
					</li>
					<li class="handling_menu"><span>&#8226; 취급 메뉴</span> <span>미표시</span>
					</li>

					<li class="location">
						<div id="wordcloud">
							<!--워드클라우드-->
						</div>
						<div id="map"></div>
					</li>
				</ul>
				<div class="review1">방문자 후기</div>
				<div class="review2">장소의 리뷰를 적어주세요.</div>
				<div class="comment">
					<form action="post" id="comment_add" onsubmit="return false" enctype="multipart/form-data">
						<div class="imgfile">
							<!--
                            <ul class="preview" style="background-image: url('')">
                                <li>삭제</li>
                            </ul>
-->
							<input type="file" id="img" style="display: none"
								accept="image/*"> <label for="img" class="img_add"><img
								src="./Food_More_Infomation_IMG/image-add-button.png" alt=""
								width="17px">사진</label>
						</div>
						<textarea name="contents" id="contents" cols="50" rows="10" maxlength="200"
							placeholder="200자 이하만 입력 가능합니다."></textarea>
						<input type="submit" value="등록" id="submit">
						<div class="tag">
							<input type="checkbox" id="like" style="display: none" value="1">
							<label for="like"><img
								src="./Food_More_Infomation_IMG/like1.png" alt=""
								class="like_btn"></label> <span class="title">태그</span>
							<ul>
								<!--                                <li class="tags">#쩐다.fsdaffsafddfsdfafsdfsadfsadfsadfsafasfsfsfasfsfsfasfas<img src="./Food_More_Infomation_IMG/cancel-button.png" alt=""></li>-->
								<input type="text" class="input_tag" placeholder="#입력 (최대 10개)">
							</ul>
						</div>
					</form>
				</div>
				<div class="review_list">
					<div class="review_info">
						<span>REVIEW</span> <span>|</span> <span>악의적인 비방글은 무통보
							삭제됩니다.</span>
					</div>
					<ul class="analysis">
						<li class="like_total">
							<div class="total">300</div>
							<div class="text">
								182개 리뷰<br>좋아요
							</div>
						</li>
						<div class="zt-span6 last">
							<div class="zt-skill-bar like-bar">
								<div data-width="0" style="" class="like">
									좋아요<span class="like_ratio">0%</span>
								</div>
							</div>
							<div class="zt-skill-bar dislike-bar">
								<div data-width="0" style="" class="dislike">
									싫어요<span class="dislike_ratio">0%</span>
								</div>
							</div>
						</div>
						<h3>
							<strong class="like_comment">?%의 여행자가 이 관광지를 좋아합니다.</strong>
						</h3>
					</ul>
					<div class="latest_review">
						<span>최신순</span> 리뷰
					</div>
					<ul class="reviews">
<!--  						<li class="review">
							<div class="btn">
								<button class="modify">수정</button>
								<button class="remove">삭제</button>
							</div>
							<div class="imgs">
								<img src="./jpg/2.jpg" alt="" width="100px"> 
								<img src="./jpg/2.jpg" alt="" width="100px">
							</div>
							<div class="contents">
								dddddd dddddd dddddd dddddd dddddd
								dddddd dddddd dddddd dddddd dddddd dddddd dddddd dddddd dddddd
								dddddd dddddd
							</div>
							<div class="profile">
								<div class="writer1">작성자</div>
								<div class="writer2">손준호</div>
								<div class="like1">좋아요</div>
								<div class="like2">
									<img src="./Food_More_Infomation_IMG/like2.png" alt="">
								</div>
								<div class="date1">작성일</div>
								<div class="date2">2018-09-22 03:33:33</div>
							</div>
							<div class="hashtags">
								<span>#맛있어요</span> <span>#맛있어요</span> <span>#맛있어요</span> <span>#맛있어요</span>
								<span>#맛있어요</span> <span>#맛있어요</span> <span>#맛있어요</span>
							</div>
						</li> -->


					</ul>
<!-- 					<div class="page_num_group">
						<a href="#">이전</a> <a href="#" class="selected">1</a> <a href="#">2</a>
						<a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">6</a>
						<a href="#">7</a> <a href="#">8</a> <a href="#">다음</a>
					</div> -->
				</div>
			</div>
		</section>

	</div>
	<%@include file="footer.jsp"%>
	<script type="text/javascript"
		src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script src="./js/detail_info.js?ver=80"></script>


	<script>
		//워드클라우드 스크립트 
	var words = [];
	$.ajax({
		type: 'get',
		url: './api/wordcloud/get',
		data: {
			contentid: getParameterByName('contentid'),
			contenttypeid:getParameterByName('contenttypeid')
		},
		success: function(data) {
			console.log("워드클라우드 사용할 해시태그 개수 : "+JSON.stringify(data));
			for(var i=0; i<data.length; i++){
				words.push(
					{text: data[i].hashtag, size: data[i].frequency}
				);
			}
			d3.wordcloud().size([ 500, 300 ]).fill(
					d3.scale.ordinal().range(
							[ "#884400", "#448800", "#888800", "#444400" ])).words(
					words).start();
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}

	})
		// word frequencies of first two chapters of Oliver Twist
/* 		var words = [
				{
					text : '장어탕',
					size : 50
				},
				{
					text : '맛집',
					size : 47
				},
				{
					text : '식당',
					size : 46
				},
				{
					text : '한식',
					size : 36
				},
				{
					text : '일식',
					size : 29,
					href : 'https://en.wikipedia.org/wiki/Beadle'
				},
				{
					text : '중식',
					size : 29
				},
				{
					text : '여기가 맛집',
					size : 56,
					href : 'https://en.wikipedia.org/wiki/Mrs.'
				},
				{
					text : '맛있어요',
					size : 27,
					href : 'http://educationcing.blogspot.nl/2012/06/oliver-twist-mrs-manns-character.html'
				}, {
					text : '친절해요',
					size : 27
				}, {
					text : '서비스가 좋아요',
					size : 26
				}, ]; */

/* 		d3.wordcloud().size([ 500, 300 ]).fill(
				d3.scale.ordinal().range(
						[ "#884400", "#448800", "#888800", "#444400" ])).words(
				words).start(); */
	</script>
</body>
</html>