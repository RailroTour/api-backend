<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script>
function fn_submit(){
    
    var form = new FormData();
    form.append( "file1", $("#file1")[0].files[0] );



		$.ajax({
			type : 'post',
			async : false, //false가 기본값임 - 비동기
			url : '/api-backend/api/user',
			processData : false,
		
	        ontentType : false,
			data : form,
			success : function(data, textStatus) {
				alert("업로드 성공");
			},
			error : function(data, textStatus) {
				console.log(form.data);
				console.log('error');
			}
		//ajax
	});
}

</script>
</head>
<body>

	   <div>
    <label for="file1">파일</label> 
    <input type="file" id="file1" name="file1"> 
    <button id="btn_submit" onclick="javascript:fn_submit()">전송</button>    
</div>




</body>
</html>