$(document).ready(function(){
	$(".btn-group>.create").on('click', function(){
		const title = $(".planner-title>.input-name>.name").val();
		const start_day = $(".start-day>.input-name>.date").val();
		const days = $("input[name='days']:checked").val();
		const tema = $("input[name='tema']:checked").val();
		
		console.log(title);
		console.log(start_day);
		console.log(days);
		console.log(tema);
		
		$.ajax({
			url: './api/planner/post', //request 보낼 서버의 경로
			type: 'post', // 메소드(get, post, put 등)
			data:{
				title: title,
				start_day: start_day,
				days: days,
				tema_id: tema
			},
			success: function(data) {
				console.log("data:" + JSON.stringify(data));
				location.href="./planner2.jsp?id="+data.id;
			},
			error: function(request, status, error) {
				//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
				//rtnmsg = JSON.parse(request.responseText);
				//alert(rtnmsg.message);
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	})
})