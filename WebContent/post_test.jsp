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
<fieldset>
     <legend>파일 업로드</legend>
     <table>
     <form action="/api-backend/api/user" method="post" enctype="multipart/form-data">
          <tr>
              <td>username : </td>
              <td><input type="text" name="username"/></td>
          </tr>
          <tr>
              <td>password : </td>
              <td><input type="text" name="password"/></td>
          </tr>
           <tr>
              <td>name : </td>
              <td><input type="text" name="name"/></td>
          </tr>
           <tr>
              <td>nickname : </td>
              <td><input type="text" name="nickname"/></td>
          </tr>
          <tr>
              <td>email: </td>
              <td><input type="text" name="email"/></td>
          </tr>
          <tr>
              <td>파일이미 : </td>
              <td><input type="file" value="파일 선택" name="profile_img"/></td>
          </tr>
          <tr>
              <td colspan="2"><input type="submit" value="업로드"/></td>
          </tr>
          </form>
     </table>
</fieldset>




</body>
</html>