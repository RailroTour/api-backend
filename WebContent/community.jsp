<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="community.*"%>
<%@ page import="common.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>커뮤니티</title>
<link rel="stylesheet" href="./css/commen.css">

<link rel="stylesheet" href="./css/sub-banner.css">
<link rel="stylesheet" href="./css/benefits_list.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>


</head>

<body>
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

				<div class="s-c-b-cover">
					<div class="cover-search">
						<p>
							· Total : <b>11</b>건 <b>[1/2]</b> 페이지
						</p>
						<div class="search-right">
							<select name="" id="">
								<option value="">제목</option>
								<option value="">내용</option>
							</select> <input type="text"> <input type="submit" value="검색"
								class="search_btn">
						</div>
					</div>
					<div class="cover-table">
						<table>
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>날짜</th>
									<th>조회</th>
								</tr>
							</thead>
							<%
							Connection conn = null;
							try{
								CommunityDAO dao = new CommunityDAO(ConnectionProvider.getConnection());
								List<CommunityBean> list = dao.get();
								for(CommunityBean p: list){
									Integer id = p.getId();
									String title = p.getTitle();
									String username = p.getUsername();
									String date = p.getRegister_date();
							%>
							<tbody>

								<tr class="tdbgcolor">
									<td><%= id %></td>
									<td><a href="community_detail.jsp?id=<%= id%>"><%= title %></a></td>
									<td><%= username %></td>
									<td><%= date %></td>
									<td>43</td>
								</tr>
							</tbody>
							<%
								}
								
							} catch(SQLException ex){
								out.println("Fail to connection");
								
							}
%>
						</table>
					</div>
					<div class="cover-btn">
						<div class="bt_group" style="width: 410px;">
							<button>
								<a href="#">&lt;&lt;</a>
							</button>
							<button>
								<a href="#">&lt;</a>
							</button>
							<button>
								<a href="#">1</a>
							</button>
							<button>
								<a href="#">1</a>
							</button>
							<button>
								<a href="#">1</a>
							</button>
							<button>
								<a href="#">1</a>
							</button>
							<button>
								<a href="#">1</a>
							</button>
							<button>
								<a href="#">1</a>
							</button>
							<button>
								<a href="#">1</a>
							</button>
							<button>
								<a href="#">1</a>
							</button>
							<button>
								<a href="#">1</a>
							</button>
							<button>
								<a href="#">10</a>
							</button>
							<button>
								<a href="#">&gt;</a>
							</button>
							<button>
								<a href="#">&gt;&gt;</a>
							</button>
						</div>
						<button class="post">
							<a href="community_add.jsp">글 쓰기</a>
						</button>
					</div>

				</div>
			</div>

		</section>




	</div>
	<script src="./js/script.js"></script>
</body>
</html>