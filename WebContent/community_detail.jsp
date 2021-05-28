<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="common.*"%>
<%@ page import="community.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>서브페이지</title>
<link rel="stylesheet" href="./css/commen.css">
<link rel="stylesheet" href="./css/benefits_read.css">
<link rel="stylesheet" href="./css/sub-banner.css">
<link rel="stylesheet" href="css/header.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>


</head>

<body>
	<jsp:include page="header.jsp" />
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	CommunityDAO dao = new CommunityDAO(ConnectionProvider.getConnection());
	CommunityBean community = dao.get(id);
	%>
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
						<a href="../index.html"> <img src="./jpg/home.jpg" alt="">
						</a>
					</div>
					<div class="listmenu">
						<button>내일로 소개</button>
						<ul class="listbox">
							<li><a href="#">내일로 소개</a></li>
							<li><a href="#">TOP 100</a></li>
							<li><a href="#">플래너</a></li>
							<li><a href="#">내 주변</a></li>
							<li><a href="sub02.html">고객센터</a></li>
						</ul>
					</div>
					<div class="listmenu">
						<button>내일로 란?</button>
						<ul class="listbox">
							<li><a href="#">내일로 소개</a></li>
							<li><a href="#">TOP 100</a></li>
							<li><a href="#">플래너</a></li>
							<li><a href="#">내 주변</a></li>
							<li><a href="#">고객센터</a></li>
						</ul>
					</div>

				</div>
			</div>
			<div id="sub-con-body" class="section">
				<div class="s-c-b-title">
					<h3>Community</h3>
					<h2>정보공유</h2>
				</div>
				<div class="view_form">
					<div class="title">
						<h1><%=community.getTitle() %></h1>
						<a href="#">수정</a>
					</div>
					<ul class="post_info">
						<li>작성자 : <%=community.getUsername() %></li>
						<li><%=community.getRegister_date() %></li>
						<li>조회 100회</li>
					</ul>
					<!--<div class="download">
						<!--파일첨부 부분
					</div>
					-->
					<div class="content">
						<%=community.getContent() %>
					</div>
					<div class="bt_group">
						<button class="Previous">
							<a href="#">이전글</a>
						</button>
						<button class="next">
							<a href="">다음글</a>
						</button>
						<button class="list">
							<a href="">목록</a>
						</button>
						<button class="delete">
							<a href="">삭제</a>
						</button>
					</div>

				</div>

			</div>

		</section>




	</div>
	<script src="./js/script.js"></script>
</body>
</html>