var days = Number(getParameterByName("days"));
var tema_id = Number(getParameterByName("tema_id"));
$(document).ready(function(){
	switch(days){
		case 3: $(".days label").siblings().removeClass('selected');
				$(".three").addClass('selected');
				break;
		case 7:  $(".days label").siblings().removeClass('selected');
				$(".seven").addClass('selected');
				break;
	}
	
	switch(tema_id){
		case 14: $(".tema-select label").siblings().removeClass('selected');
			$(".tema-select label").eq(0).addClass('selected');
			break;
		case 15: $(".tema-select label").siblings().removeClass('selected');
			$(".tema-select label").eq(1).addClass('selected');
			break;
		case 16: $(".tema-select label").siblings().removeClass('selected');
			$(".tema-select label").eq(2).addClass('selected');
			break;
		case 17: $(".tema-select label").siblings().removeClass('selected');
			$(".tema-select label").eq(3).addClass('selected');
			break;
	}
	$.ajax({
		type: 'get',
		url: './api/custom_search/get',
		data: {
			days: days,
			tema_id: tema_id
		},
		dataType: 'json',
		success: function(data) {
			console.log("커스텀 플래너 검색 : " + JSON.stringify(data));
			$(".planner").remove();
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
	
    $('.bar li label').on('click', function(){
		var for_name = $(this).attr('for');
		
        $(this).addClass('selected');
        $(this).siblings().removeClass('selected');

		if (for_name.indexOf("day") != -1){
			days = $("#"+for_name).val();
		}
		else{
			tema_id = $("#"+for_name).val();
		}
		$.ajax({
			type: 'get',
			url: './api/custom_search/get',
			data: {
				days: days,
				tema_id: tema_id
			},
			dataType: 'json',
			success: function(data) {
				console.log("커스텀 플래너 검색 : " + JSON.stringify(data));
				$(".planner").remove();
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
    })
    $('.s-c-b-content center button').on('click', function(){
        var travel_day=$('input[name="travel_day"]:checked').val()
        var travel_tema=$('input[name="travel_tema"]:checked').val();
        console.log(travel_day);
        console.log(travel_tema);
    })
})

function getParameterByName(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.search);
        return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}


function planner_elements(planner_id, img_path, start_day, days, title, tema_name, view, trip_course, nickname){
	return '<a href=./planner.jsp?planner_id='+planner_id+' data-planner_id='+planner_id+' target="_blank" class="planner"><ul class="list_item"><li><img src='+img_path+' alt="" width="346px" height="200px"><div class="note_info"><h1>'+start_day+' ('+days+'일)</h1><h1>'+title+'</h1></div></li><li><div class="like"><span class="tema">'+tema_name+'여행</span><span>'+view+'</span><img src="./note_plans_list_jpg/eye.png" alt="" width="20px"></div><div class="route">'+trip_course+'</div><div class="person"><img src="./note_plans_list_jpg/user.png" alt="" width="20px"><span>&nbsp;'+nickname+'</span></div></li></ul></a>'
}