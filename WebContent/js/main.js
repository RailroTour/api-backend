$(document).ready(function(){
	$.ajax({
		type: 'get',
		url: './api/realtimeplanner/get',
		success: function(data) {
			console.log(JSON.stringify(data));
			for(var i=0; i<data.length; i++){
				$(".timeline1").eq(i).find("a").attr('href', './planner.jsp?planner_id='+data[i].id);
				$(".timeline1").eq(i).find("img").attr('src', data[i].img_path);
				$(".timeline1").eq(i).find("div.text").text(data[i].title);
				$(".timeline1").eq(i).find("span.traveler").html('&nbsp; '+data[i].nickname);
			}
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}

	})
})

