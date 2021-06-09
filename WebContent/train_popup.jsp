<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image⁄x-icon" href="favicon.ico">
    <title>기차시간 조회</title>
    <link rel="stylesheet" href="./css/commen.css">
    <link rel="stylesheet" href="./css/popup.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="./js/popup.js?ver=169"></script>
</head>
<body>
    <center>기차시간 조회</center>
        <ul id="train">
            <li>    
                <select name="start-train-station" id="start">
                     <option value="">출발역 선택</option>
                     <optgroup label="전라북도" class="bukdo">
<!--                          <option value="NAT041993">여수EXPO</option>
                        <option value="NAT030667">용동</option>  -->
                     </optgroup>
                    <optgroup label="전라남도" class="namdo">
<!--                         <option value="NAT031998">나주</option>
                        <option value="NAT032099">다시</option> -->
                     </optgroup>
                </select>
           </li>
           <li>-</li>
            <li>
                <select name="end-train-station" id="end">
                     <option value="">도착역 선택</option>
                     <optgroup label="전라북도" class="bukdo">
<!--                          <option value="NAT041072">곡성</option>
                        <option value="NAT030667">용동</option>  -->
                     </optgroup>
                    <optgroup label="전라남도" class="namdo">
<!--                         <option value="NAT031998">나주</option>
                        <option value="NAT032099">다시</option> -->
                     </optgroup>
                </select>
            </li>
            <li id="search-btn">
                <button>조회</button>
            </li>
    </ul>
    <!--열차종류, 출발지, 도착지, 출발시간, 도착시간, 가격-->
    <ul class="bar">
        <li class="train_kind">열차 종류</li>
        <li class="start_station">출발지</li>
        <li class="end_station">도착지</li>
        <li class="start_time">출발시간</li>
        <li class="end_time">도착시간</li>
        <li class="price">가격</li>
    </ul>
    <div class="informations">
<!--     <ul class="train_info">
        <li class="train_kind">무궁화</li>
        <li class="start_station">11</li>
        <li class="end_station">232</li>
        <li class="start_time">45:ㄹㅇㄴㅁㄹㄴㅇ</li>
        <li class="end_time">ㄹㄴㅁㅇㄹㄴㅇ:ㄹㄴㅇㅁㄹㄴㅇ</li>
        <li class="price">ㄹㄴㅇㅁㄹㄴㅇㅁ</li>
    </ul> -->
    </div>
    <center class="close"><button class="btn">닫기</button></center>
    <script>
        $(document).ready(function(){
            $('.btn').click(function(e){
                window.close();
            })
        })

    </script>
</body>
</html>