<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
<script>
$.ajax({
    type:'post',
    async:false, //false가 기본값임 - 비동기
    url:'http://localhost:8080/api-backend/api/user',
    dataType:'json',
    data:{
    	username:"cartoonpoet1",
    	password:"rmsep12",
    	name:"손준호",
    	nickname:"하루네집",
    	email:"cartoonpoet@naver.com"
    },
    success: function(data, textStatus) {
    	console.log(data);
    },
    error:function (data, textStatus) {
        console.log('error');
    }
})    //ajax

</script>
</head>
<body>

</body>
</html>