<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
<title>게시물 작성</title>
<link rel="stylesheet" href="./css/commen.css">
<link rel="stylesheet" href="./css/benefits_revise.css">
<link rel="stylesheet" href="./css/sub-banner.css">
<link rel="stylesheet" href="css/header.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>

</head>
<body>
<jsp:include page="header.jsp" />
	<div id="wrap">
		<!-- 전체를 감싸는 부분 -->
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
						<a href="./index.jsp"> <img src="./jpg/home.jpg" alt="">
						</a>
					</div>
					<div class="listmenu">
						<button>커뮤니티</button>
						<ul class="listbox">
							<li><a href="./railro_intro.jsp">내일로 소개</a></li>
							<li><a href="./top100_food_tour_rooms.jsp?contenttypeid=12&pageNo=1">TOP 100</a></li>
							<li><a href="./planner1.jsp">플래너</a></li>
							<li><a href="./search_integrated.jsp">검색</a></li>
						</ul>
					</div>
					<div class="listmenu">
						<button>정보공유</button>
						<ul class="listbox">
<!-- 							<li><a href="#">내일로 소개</a></li>
							<li><a href="#">TOP 100</a></li>
							<li><a href="#">플래너</a></li>
							<li><a href="#">내 주변</a></li>
							<li><a href="#">고객센터</a></li> -->
						</ul>
					</div>

				</div>
			</div>
			<div id="sub-con-body" class="section">
				<div class="s-c-b-title">
					<h3>Community</h3>
					<h2>정보공유</h2>
				</div>
				<div class="edit_form">
					<h1>글쓰기</h1>
					<form class="edit" id="community_add" enctype="multipart/form-data">
						<div class="title">
							<label for="title">제목</label> <input type="text" name="title"
								id="title" placeholder="제목을 입력하세요">
						</div>
						<div class="content">
							<label for="content">내용</label>
							<textarea name="content" id="content" cols="30" rows="10"
								placeholder="내용을 입력하세요"></textarea>
						</div>
						<div class="file" style="height: 40px;">
							<label for="file" style="padding: 15px 10px;">파일 첨부</label>
							<div class="file_add">
								<input class="upload-name upload1" value="파일선택" disabled="disabled"> <input
									type="file" name="community_img" id="img_file"
									class="upload-hidden1"> <label for="img_file"
									class="ex_filename">업로드</label>
							</div>
						</div>
						<div class="btn">
							<input type="button" id="uploadbutton" value="작성하기"> <input
								type="button" value="취소하기" onclick="location.href='community.jsp'">
						</div>

					</form>
				</div>

			</div>

		</section>




	</div>
	<script src="./js/script.js"></script>
	<script>
	
	$("#community_add #uploadbutton").on(
			'click',
			function() {

				var formData = new FormData();
				var fileInput = document.querySelector("#img_file");

				formData.append('title', $("#title").val());
				formData.append('content', $("#content").val());
				formData.append('community_img', fileInput.files[0]);
				$.ajax({
					url : './api/community/post',
					enctype : 'multipart/form-data',
					processData : false,
					contentType : false,
					cache : false,
					data : formData,
					dataType : 'json',
					type : 'post',
					success : function(data) {
						location.href='community.jsp';
						
					},
					error : function(data, request, status, error) {
						console.log("code: " + request.status + "\n"
								+ "message:" + request.responseText + "\n"
								+ "error:" + error);
					}
				});
			});

</script>

</body>
</html>