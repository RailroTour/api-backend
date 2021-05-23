$(document).ready(function(){
	$.ajax({
		url: './api/myplanner/get', //request 보낼 서버의 경로
		type: 'get', // 메소드(get, post, put 등)
		success: function(data) {
			console.log("나의 플래너 목록:" + JSON.stringify(data));

		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		},
		beforeSend: function() {
			$("#viewLoading").show();
		},
		complete: function() {
			$("#viewLoading").hide();
		}
	});
})