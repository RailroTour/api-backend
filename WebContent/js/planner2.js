
$(document).ready(function(){
	getAreaList();
	
    $(document).on("click", ".area-item>.cancel-btn", function(){ //여행 지역 삭제
        $(this).parent().remove();
    })

    $(document).on("click", ".area-item>.minus", function(){ //여행 지역 일수 감소
        const val = Number($(this).next().find(".day-num").val());
        if(val>1){
            $(this).next().find(".day-num").val(val-1);
        }
    })
    $(document).on("click", ".area-item>.plus", function(){ //여행 지역 일수 증가
        const val = Number($(this).prev().find(".day-num").val());
        if(val<7){
            $(this).prev().find(".day-num").val(val+1);
        }
    })
    $(document).on("click", ".areas>.area", function(){ //여행 지역 추가
        const area_name = $(this).find(".si-gun-gu").text();
        const area_code = $(this).data('area');
		const sigungu_code = $(this).data('sigungu');
		const sigungu_id = $(this).data('sigungu_id');
		
        $(".selected-area>.vals").append('<div class="area-item" data-area='+area_code+' data-sigungu='+sigungu_code+' data-sigungu_id='+sigungu_id+'><button class="cancel-btn"><img src="./jpg/cancel_btn.png" alt=""></button><span class="area-name">'+area_name+'</span><button class="adjust-btn minus"><img src="./jpg/minus.png" alt=""></button><span><input type="text" disabled value="1" class="day-num"> 일</span><button class="adjust-btn plus"><img src="./jpg/plus.png" alt=""></button></div>');
    })
	$(document).on("click", ".select>input", function(){// 여행 지역 보기 버튼
		$(".areas>.area").remove();
		getAreaList();
	});
	
	$(".detail-schedule-btn").on('click', function(){//planner2 정보 추가
		for(var i=0; i<$(".selected-area>.vals>.area-item").length; i++){
			$.ajax({
				url: './api/planner2/post', //request 보낼 서버의 경로
				type: 'post', // 메소드(get, post, put 등)
				data: {
					planner_id: $.urlParam('id'),
					visit_day: $(".selected-area>.vals>.area-item").eq(i).find(".day-num").val(),
					sigungu_id: $(".selected-area>.vals>.area-item").eq(i).data('sigungu_id')
				},
				success: function(data) {
					console.log("여행 지역 추가 결과 :" + JSON.stringify(data));

				},
				error: function(request, status, error) {
					//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
					console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				}
			});
		}
		location.href="./planner3.jsp?id="+$.urlParam('id');
	});
})

function getAreaList(){ //여행지 목록 불러오기
	$.ajax({
		url: './api/sigungu/get', //request 보낼 서버의 경로
		type: 'get', // 메소드(get, post, put 등)
		data: {
			area_code: $("input[name='classify']:checked").val()
		},
		success: function(data) {
			console.log("여행 지역 목록:" + JSON.stringify(data));
			for(var i=0; i<data.length; i++){
				$(".areas").append('<li class="area" data-area='+data[i].area_code+' data-sigungu='+data[i].sigungu_code+' data-sigungu_id='+data[i].id+'><img src='+data[i].thumb+' alt="" class="area-img"><div class="black-cover"></div><span class="do">'+data[i].area_name+',</span><span class="si-gun-gu">'+data[i].sigungu_name+'</span></li>');
			}
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		},
		beforeSend:function(){
			$("#loading").show();
		},
		complete:function(){
			$("#loading").hide();
		}
	});
}

$.urlParam = function(name){
    var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
    return results[1] || 0;
}
 
