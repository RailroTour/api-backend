$(document).ready(function(){
	$.ajax({
		url: './api/myplanner/get', //request 보낼 서버의 경로
		type: 'get', // 메소드(get, post, put 등)
		success: function(data) {
			console.log("나의 플래너 목록:" + JSON.stringify(data));
			for(var i=0; i<data.length; i++){
				$(".plans_list_rows").append(planner_elements(
					data[i].planner_id,
					data[i].img_path,
					data[i].start_day,
					data[i].days,
					data[i].title,
					data[i].tema_name,
					data[i].view,
					data[i].trip_course,
					data[i].nickname
				));
			}
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
	
	$(document).on('click', ".btn>.revise", function(e){
		e.preventDefault();
		alert(11);
	})
	
	$(document).on('click', ".btn>.remove", function(e){
		e.preventDefault();
		var check = confirm('삭제하시겠습니까?');
		
	})
})

function planner_elements(planner_id, img_path, start_day, days, title, tema_name, view, trip_course, nickname){
	return '<a href=./planner.jsp?planner_id='+planner_id+' data-planner_id='+planner_id+'><ul class="list_item"><li><img src='+img_path+' alt="" width="346px" height="200px"><div class="note_info"><h1>'+start_day+' ('+days+'일)</h1><h1>'+title+'</h1></div></li><li><div class="like"><span class="tema">'+tema_name+'여행</span><span>500</span><img src="./note_plans_list_jpg/eye.png" alt="" width="20px"><span>'+view+'</span><img src="./note_plans_list_jpg/foot.png" alt="" width="20px"></div><div class="route">'+trip_course+'</div><div class="person"><img src="./note_plans_list_jpg/user.png" alt="" width="20px"><span>&nbsp;'+nickname+'</span><div class="btn"><span class="revise">수정</span><span style="color: black"> | </span><span class="remove">삭제</span></div></div></li></ul></a>'
}