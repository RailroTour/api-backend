$(document).ready(function(){
	if ($.urlParam('pageNo') == 1) {
		$(".page_num_group").append(
			'<a href=./top100_planner.jsp?pageNo=1 class="selected">1~50위</a>'
		);
		$(".page_num_group").append(
			'<a href=./top100_planner.jsp?pageNo=2 >51~100위</a>'
		);
	}
	else {
		$(".page_num_group").append(
			'<a href=./top100_planner.jsp?pageNo=1 >1~50위</a>'
		);
		$(".page_num_group").append(
			'<a href=./top100_planner.jsp?pageNo=2 class="selected">51~100위</a>'
		);
	}
	
	$.ajax({
		type: 'get',
		url: './api/top100Planner/get',
		data: {
			pageNo: $.urlParam('pageNo')
		},
		dataType: 'json',
		success: function(data) {
			console.log("top100 플래너 데이터 : " + JSON.stringify(data));
			for (var i = 0; i < data.length; i++) {
				$(".plans_list_rows").append(planner_elements(
					data[i].planner_id,
					data[i].img_path,
					data[i].start_day,
					data[i].days,
					data[i].title,
					data[i].tema_name,
					data[i].view,
					data[i].trip_course,
					data[i].nickname,
					$.urlParam('pageNo') == 1 ? i+1 : (i+1+50)
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
})

$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
       return null;
    }
    else{
       return results[1] || 0;
    }
}


function planner_elements(planner_id, img_path, start_day, days, title, tema_name, view, trip_course, nickname, rank){
	return '<a href=./planner.jsp?planner_id='+planner_id+' data-planner_id='+planner_id+' target="_blank"><ul class="list_item"><li><span class="rank_num">'+rank+'</span><img src='+img_path+' alt="" width="346px" height="200px"><div class="note_info"><h1>'+start_day+' ('+days+'일)</h1><h1>'+title+'</h1></div></li><li><div class="like"><span class="tema">'+tema_name+'여행</span><span>'+view+'</span><img src="./note_plans_list_jpg/eye.png" alt="" width="20px"></div><div class="route">'+trip_course+'</div><div class="person"><img src="./note_plans_list_jpg/user.png" alt="" width="20px"><span>&nbsp;'+nickname+'</span></div></li></ul></a>'
}