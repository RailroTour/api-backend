<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>마이페이지 : 회원탈퇴</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/mypage_remove.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>

    <script src="./js/mypage_remove.js?ver=3"></script>
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
                    <span class="removeimg"></span>
                    <div class="title">회원탈퇴에 앞서 <span class="textcolor">유의사항 및 안내</span>를 반드시 읽고 진행해 주세요.</div>
                </div>
                <form action="" id="passwordchange">
                    <div class="explanation">
                        <ul>
                            <li>아이디 복구 불가 안내</li>
                            <li>회원탈퇴 진행 시 해당 아이디는 복구가 불가능합니다.</li>
                            <li>신중히 선택하신 후 결정해주세요.</li>
                        </ul>
                        <ul>
                            <li>
                                <input type="checkbox" name="agree" class="agree agree1">
                            </li>
                        </ul>
                    </div>
                    <div class="explanation">
                        <ul>
                            <li>내정보 기록 삭제 안내</li>
                            <li>내 개인정보는 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.</li>
                            <li>필요한 데이터는 미리 백업을 해주세요.</li>
                        </ul>
                        <ul>
                            <li>
                                <input type="checkbox" name="agree" class="agree agree2">
                            </li>
                        </ul>
                    </div>
                    <div class="explanation">
                        <ul>
                            <li>플래너 삭제 안내</li>
                            <li>플래너는 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.</li>
                            <li>신중히 선택하신 후 결정해주세요.</li>
                        </ul>
                        <ul>
                            <li>
                                <input type="checkbox" name="agree" class="agree agree3">
                            </li>
                        </ul>
                    </div>
<!--
                    <div class="pwcheck">
                        <span>비밀번호 확인</span>
                        <input type="password" name="pw" class="pw">
                    </div>
-->
                    <div class="btngroup">
                        <a href="./mypage.jsp" class="previous">이전으로</a>
                        <input type="button" value="탈퇴" class="submit" maxlength="32">
                    </div>
                </form>
            </div>
        </section>
        
    </div>
 <%@include file="footer.jsp" %>   
</body>
</html>