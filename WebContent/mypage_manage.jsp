<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>마이페이지 : 내정보 관리</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/mypage_management.css?ver=2">
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
 
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
                    <h3>My Page</h3>
                    <h2>
                        마이페이지
                    </h2>
                </div>
            </div>
        </section>
        <section id="sub-content">
            
            <div id="sub-con-body" class="section">
                <div class="notify">
                   <img src="./mypage_img/notification.png" alt="" width="30px" class="notify_img">
                    <div class="title">내 정보를 <span class="textcolor">최신 정보로 관리</span>해주세요.</div>
                </div>
                <form action="" id="management" enctype="multipart/form-data">
                   <ul>
                       <li class="profile">
                           <span class="text">프로필 사진</span>
                           <img src="" alt="">
                           <input type="file" id="imgchange" accept="image/*" name="imgfile" hidden>
                           <label for="imgchange" class="imgchange">이미지 변경</label>
                       </li>
                       <li>
                           <span class="text">아이디</span>
                           <div>cartoonpoet</div>
                       </li>
                       <li>
                           <span class="text">이름</span>
                           <div>손준호</div>
                       </li>
                       <li>
                           <span class="text">닉네임</span>
                           <div><input type="text" value="하루"></div>
                       </li>
                       <li>
                           <span class="text">이메일</span>
                           <div><input type="text" value="cartoonpoet@naver.com"></div>
                       </li>
                   </ul>
                   <div class="btn-group">
                       <button class="cancel">취소</button><button class="modify">변경</button>
                   </div>
                </form>
            </div>
        </section>
        
    </div>
    <%@include file="footer.jsp" %>
    <script>

    
     $(document).ready(function(){
      	  $('#imgchange').on('change', function(e){
      		if($(this).val()!=""){
                var ext=$(this).val().split(".").pop().toLowerCase();
                if($.inArray(ext, ["gif", "jpg", "jpeg", "png"])==-1){
                    swal('이미지 파일만 업로드 해주세요.');
                    $(this).val('');
                    return;
                }
                var fileSize=this.files[0].size;
                var maxSize=(1024*1024)*10;
                if(fileSize>maxSize){
                    swal('파일용량 10MB를 초과했습니다.');
                    $(this).val('');
                    return;
                }
                var formData=new FormData($('#management')[0]);
                $.ajax({
            		type:'POST',
            		url:'./MyPageIMGChange.me',
            		data:formData,
            		async: true,
                    processData : false,
                    contentType : false,
            		success:function(data){
            			console.log('파일업로드 성공');
            			console.log(data);
            			$('.profile img').attr('src', data);
            		},
            		error:function(data){
            			alert('파일 업로드 실패');
            			console.log('파일 업로드 실패');
            		}
            	})
                $(this).val('');
            }
      	  })
      })
  </script>
</body>
</html>