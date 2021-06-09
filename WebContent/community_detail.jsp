<%@page import="community_comment.CommentBean"%>
<%@page import="community_comment.CommentDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="common.*"%>
<%@ page import="community.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
<title>게시물 보기</title>
<link rel="stylesheet" href="./css/commen.css">
<link rel="stylesheet" href="./css/benefits_read.css">
<link rel="stylesheet" href="./css/sub-banner.css">
<link rel="stylesheet" href="css/header.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>


</head>

<body>
	<script type="text/javascript">
	function Confirmbefore(count,id){
		console.log(id);
		console.log(count);
		
		if(id==1)
			{
			if(confirm("첫 페이지 입니다 ")== true)
			{
				location.href = "community_detail.jsp?id=" + id;
				}
			}
	
		else if(id <= count && id !=1){
			console.log("check");
			var link = id-1;
			location.href = "community_detail.jsp?id=" + link;
		}
		
		return;
	}
	function Confirmafter(count,id){
		console.log(id);
		console.log(count);
		
		if(id==count)
			if(confirm("마지막 페이지 입니다 ")== true)
				location.href = "./community_detail.jsp?id=" + id;
		if(id < count)
			{
			console.log("check");
			var link = id+1;
			location.href = "./community_detail.jsp?id=" + link;
			}
		return;
	}
	
	
	
</script>
	<jsp:include page="header.jsp" />
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	CommunityDAO dao = new CommunityDAO(ConnectionProvider.getConnection());
	CommunityBean community = dao.get(id);
	int views = dao.getView(id);

	int count = dao.count();

	HttpSession ses = request.getSession();
	String email = (String) ses.getAttribute("email");

	String user = dao.getLoginusername(email);
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
				<div class="view_form">
					<div class="title">
						<h1><%=community.getTitle()%></h1>
						<%
						if (community.getUsername().equals(user)) {//본인만 수정 가능
						%>
						<a href="community_edit.jsp?id=<%=id%>">수정</a>
						<%
						}
						%>
					</div>
					<ul class="post_info">
						<li>작성자 : <%=community.getUsername()%></li>
						<li><%=community.getRegister_date()%></li>
						<li>조회 <%=views%>회
						</li>
					</ul>

					<div class="download" style="display:;">
						<!--파일첨부 부분-->
						<img alt="" src="<%=community.getCommunity_img()%>">
					</div>

					<div class="content">
						<%=community.getContent()%>
					</div>
					<div class="bt_group">
						<button class="Previous">
							<a onclick="Confirmbefore(<%=count%>,<%=id%>)">이전글</a>

						</button>
						<button class="next">
							<a onclick="Confirmafter(<%=count%>,<%=id%>)">다음글</a>
						</button>
						<button class="list">
							<a href="community.jsp">목록</a>
						</button>
						<%
						if (community.getUsername().equals(user)) {
						%>
						<input type="button" onclick="deleteConfirm('<%=id%>')"
							class="delete" id="deletebutton" value="삭제">
						<%
						}
						%>
					</div>
					<div class="comment_title"
						style="font-size: 15px; font-weight: 500;">댓글</div>
					<div class="comment">
						<form id="comment_add">
							<textarea name="contents" id="contents" cols="50" rows="10"
								maxlength="200" placeholder="200자 이하만 입력 가능합니다."></textarea>

							<div class="board_id_value">
								<input value="<%=id%>" name="id" id="board_id" type="number"
									style="display: none;">
							</div>

							<%
							if (email == null) {
							%>
							<script>
							function login_required(email) {
								alert("로그인이 필요합니다");
								//location.reload();
							}
						</script>
							<%
}
%>

							<input type="button" value="등록"
								onclick="login_required('<%=email%>')" id="uploadbutton">

						</form>
					</div>
					<%
					try {
						CommentDAO daocomment = new CommentDAO(ConnectionProvider.getConnection());
						List<CommentBean> list = daocomment.get();
						for (CommentBean p : list) {
							Integer comment_id = p.getId();
							Integer board_id = p.getBoard_id();
							String content = p.getContent();
							String username = p.getUsername();
							String date = p.getRegister_date();
					%>
					<%if (id == board_id) {%>
					<ul class="comments">
						<li class="comment" data-review_id="42">

							<div class="contents"><%=content%></div>
							<div class="profile">
								<%
								if (daocomment.getWriter(comment_id).equals(user)) {
								%><div class="delete">
									<input type="button"
										onclick="commentDeleteConfirm('<%=comment_id%>')"
										class="comment_delete" id="comment_deletebtn" value="삭제">
								</div>
								<%
								}
								%>

								<div class="writer1">작성자</div>
								<div class="writer2"><%=username%></div>
								<div class="date1">작성일</div>
								<div class="date2"><%=date%></div>
							</div>
						</li>
					</ul>
					<%
					}
					%>
					<%
					}

					} catch (SQLException ex) {
					out.println("Fail to connection");

					}
					%>
				</div>

			</div>

		</section>

	</div>
	<script src="./js/script.js"></script>
	<script>
	//댓글 등록 
	$("#comment_add #uploadbutton").on(
			'click',
			function() {

				$.ajax({
					type : 'post',
					url : './api/comment/post',
					dataType : 'json',
					data : {
						board_id:$("#board_id").val(),
						content:$("#contents").val()
					},
					success : function(data) {
						location.reload();
						
					},
					error : function(data, request, status, error) {
						console.log("code: " + request.status + "\n"
								+ "message:" + request.responseText + "\n"
								+ "error:" + error);
					}
				});
			});
</script>
	<script>
	//게시물 삭제
	function deleteConfirm(id) {
		if(confirm("삭제하시겠습니까?")== true){
			var id = String(id);
			$.ajax({
				url : './api/community/delete',
				
				cache : false,
				data : {id:id},
				dataType : 'json',
				type : 'get',
				success : function(data) {
					location.href='community.jsp';
					
				},
				error : function(data, request, status, error) {
					console.log("code: " + request.status + "\n"
							+ "message:" + request.responseText + "\n"
							+ "error:" + error);
				}
			});
		}
			
		else
			return;
	}
	
	function commentDeleteConfirm(comment_id) {
		if(confirm("삭제하시겠습니까?")== true){
			var id = String(comment_id);
			$.ajax({
				url : './api/comment/delete',
				
				cache : false,
				data : {id:id},
				dataType : 'json',
				type : 'get',
				success : function(data) {
					location.reload();
					
				},
				error : function(data, request, status, error) {
					console.log("code: " + request.status + "\n"
							+ "message:" + request.responseText + "\n"
							+ "error:" + error);
				}
			});
		}
			
		else
			return;
	}
	</script>
</body>
</html>