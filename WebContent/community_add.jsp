<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>서브페이지</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/benefits_revise.css">
    <link rel="stylesheet" href="./css/sub-banner.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>


</head>
<script>

$(function(){
     $("#uploadbutton").click(function(){
         var form = $('form')[0];
         var formData = new FormData(form);
             $.ajax({
                url: '/api-backend/api/community/post',
                processData: false,
                    contentType: false,
                data: formData,
                type: 'POST',
                success: function(result){
                    alert("업로드 성공!!");
                }
            });
         });
})

</script>
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
                        <a href="../index.html">
                            <img src="./jpg/home.jpg" alt="">
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
                    <h2>공지사항</h2>
                </div>
                <div class="edit_form">
                  <h1>글쓰기</h1>
                   <form action="/api-backend/api/community/post" method="post" enctype="multipart/form-data" class="edit" onsubmit="return checkForm();">
                       <div class="title">
                           <label for="title">제목</label>
                           <input type="text" name="title" placeholder="제목을 입력하세요">
                       </div>
                       <div class="content">
                           <label for="content">내용</label>
                           <textarea name="content" id="" cols="30" rows="10" placeholder="내용을 입력하세요"></textarea>
                       </div>
                       <div class="file" style="height:40px;">
                           <label for="file" style="padding: 15px 10px;">파일 첨부</label>
                           <div class="file_add">
                                <input class="upload-name upload1" value="파일선택">
                               <input type="file" name="community_img" id="ex_filename1" class="upload-hidden1">
                               <label for="ex_filename1" class="ex_filename">업로드</label>
                           </div>   
                            </div>
                       <div class="btn">
                            <input type="submit" value="작성하기">
                           <input type="button" id="uploadbutton" value="취소하기">
                       </div>

                   </form>
                </div>
                
            </div>
            
        </section>

        


    </div>
    <script src="./js/script.js"></script>
</body></html>