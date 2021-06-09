<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="community.*"%>
<%@ page import="common.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
<title>커뮤니티</title>
<link rel="stylesheet" href="./css/commen.css">
<link rel="stylesheet" href="css/style.css?ver=21">
<link rel="stylesheet" href="bxslide/dist/jquery.bxslider.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="./css/sub-banner.css">
<link rel="stylesheet" href="./css/benefits_list.css">
<link rel="stylesheet" href="./css/header.css">
<script src="./js/header.js?ver=2"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">

<script src="./js/main.js?ver=7"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<script src="bxslide/dist/jquery.bxslider.min.js">
	
</script>
<script src="./js/header.js"></script>
<script src="./js/script.js"></script>
</head>

<body>

	<%
	CommunityDAO daocount = new CommunityDAO(ConnectionProvider.getConnection());
	int count = daocount.count();
	HttpSession ses = request.getSession();
	String email = (String) ses.getAttribute("email");
	System.out.println("email 은 이거입니다: " + email);

	int pageNumber = 1; //기본은 1 페이지를 할당
	// 만약 파라미터로 넘어온 오브젝트 타입 'pageNumber'가 존재한다면
	// 'int'타입으로 캐스팅을 해주고 그 값을 'pageNumber'변수에 저장한다
	if (request.getParameter("pageNumber") != null) {
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
	%>
	<%@include file="header.jsp"%>
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

				<div class="s-c-b-cover">
					<div class="cover-search">
						<p>
							· Total : <b><%=count%></b>건 <b><%=pageNumber%>/<%=count / 10 + 1%></b>
							페이지
						</p>

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
							try {
								CommunityDAO dao = new CommunityDAO(ConnectionProvider.getConnection());
								List<CommunityBean> list = dao.getList(pageNumber);
								for (CommunityBean p : list) {
									Integer id = p.getId();
									String title = p.getTitle();
									String username = p.getUsername();
									String date = p.getRegister_date();
									Integer views = p.getViews();
							%>
							<tbody>

								<tr class="tdbgcolor">
									<td><%=id%></td>
									<td><a href="community_detail.jsp?id=<%=id%>"><%=title%></a></td>
									<td><%=username%></td>
									<td><%=date%></td>
									<td><%=views%></td>
								</tr>
							</tbody>
							<%
							}

							} catch (SQLException ex) {
							out.println("Fail to connection");

							}
							%>
						</table>
					</div>

					<!-- 페이징 처리 영역 -->
					<div class="cover-btn">
						<%
						if (pageNumber != 1) {
						%>
						<div
							style="display: flex; justify-content: flex-start; width: 100%;">
							<div class="btn_community_previous" style="margin-right: 5px">
								<a href="community.jsp?pageNumber=<%=pageNumber - 1%>">이전</a>
							</div>





							<%
							}
							if (daocount.nextPage(pageNumber + 1)) {
							%>
							<div class="btn_community_next">
								<a href="community.jsp?pageNumber=<%=pageNumber + 1%>">다음</a>


							</div>
							<%
							if (pageNumber != 1) {
							%>
						</div>
						<%
						}
						%>
						<%
						}
						%>

						<%
						if (email == null) {
						%>
						<script>
							function login_required(email) {
								alert("로그인이 필요합니다");
								location.href = "login.jsp";
							}
						</script>
						<%
}
%>
						<%
						if (email != null) {
						%>
						<script>
							function login_required(email) {

								location.href = "community_add.jsp";
							}
						</script>
						<%
}
%>
						<input type="button" class="post" value="글쓰기"
							onclick="login_required('<%=email%>')">


					</div>

				</div>
			</div>

		</section>




	</div>
	<%@include file="footer.jsp"%>
	<script src="./js/script.js"></script>

</body>
</html>