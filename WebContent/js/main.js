$(document).ready(function(){
	$.ajax({ //실시간 플래너
		type: 'get',
		url: './api/realtimeplanner/get',
		success: function(data) {
			console.log("실시간 플래너 : "+JSON.stringify(data));
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
	
	$.ajax({ //추천 플래너
		type: 'get',
		url: './api/recommendplanner/get',
		success: function(data) {
			console.log("추천 플래너 : "+JSON.stringify(data));
			for(var i=0; i<data.length; i++){
				if (data[i].tema_id == 14) {
					$(".planners").append(
						'<a href=./planner.jsp?planner_id=' + data[i].id + ' target="_blank"><ul class="planner"><li class="cover-img"><img src=' + data[i].cover_img + ' alt=""></li><li class="basic-data"><span class="view"><i class="fas fa-eye"></i> ' + data[i].view + '</span><span class="writer">by.' + data[i].nickname + '</span></li><li class="contents"><span class="days">' + data[i].days + '일</span><span class="title">' + data[i].title + '</span></li><li class="decoration"><span class="circle tema-tour">' + data[i].tema_name + '</span></li></ul></a>'
					);
				}
				else if (data[i].tema_id == 15) {
					$(".planners").append(
						'<a href=./planner.jsp?planner_id=' + data[i].id + ' target="_blank"><ul class="planner"><li class="cover-img"><img src=' + data[i].cover_img + ' alt=""></li><li class="basic-data"><span class="view"><i class="fas fa-eye"></i> ' + data[i].view + '</span><span class="writer">by.' + data[i].nickname + '</span></li><li class="contents"><span class="days">' + data[i].days + '일</span><span class="title">' + data[i].title + '</span></li><li class="decoration"><span class="circle tema-rest">' + data[i].tema_name + '</span></li></ul></a>'
					);
				}
				else if (data[i].tema_id == 16) {
					$(".planners").append(
						'<a href=./planner.jsp?planner_id=' + data[i].id + ' target="_blank"><ul class="planner"><li class="cover-img"><img src=' + data[i].cover_img + ' alt=""></li><li class="basic-data"><span class="view"><i class="fas fa-eye"></i> ' + data[i].view + '</span><span class="writer">by.' + data[i].nickname + '</span></li><li class="contents"><span class="days">' + data[i].days + '일</span><span class="title">' + data[i].title + '</span></li><li class="decoration"><span class="circle tema-experience">' + data[i].tema_name + '</span></li></ul></a>'
					);
				}
				else if (data[i].tema_id == 17) {
					$(".planners").append(
						'<a href=./planner.jsp?planner_id=' + data[i].id + ' target="_blank"><ul class="planner"><li class="cover-img"><img src=' + data[i].cover_img + ' alt=""></li><li class="basic-data"><span class="view"><i class="fas fa-eye"></i> ' + data[i].view + '</span><span class="writer">by.' + data[i].nickname + '</span></li><li class="contents"><span class="days">' + data[i].days + '일</span><span class="title">' + data[i].title + '</span></li><li class="decoration"><span class="circle tema-health">' + data[i].tema_name + '</span></li></ul></a>'
					);
				}

			}
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}

	})
})

