const api_key = "JXL40bCK2WGOu/E1WOGjuALpADt64Wb2mQVwNpxiA0bre/V8GozZggM2O01/PaTTyNm0A2JahebDf/PGwW8jbg==";

$(document).ready(function(){
	if ($.urlParam('contenttypeid') == 12) {
		$(".listmenu>.sub-menu").text("관광지");
		$(".listmenu>.sub-box").append(
			'<li><a href="./top100_food_tour_rooms.jsp?contenttypeid=32&pageNo=1">숙소</a></li>'
		);
		$(".listmenu>.sub-box").append(
			'<li><a href="./top100_food_tour_rooms.jsp?contenttypeid=39&pageNo=1">음식점</a></li>'
		);
		$(".s-c-b-title>h2").text("관광지");
	}
	else if ($.urlParam('contenttypeid') == 32) {
		$(".listmenu>.sub-menu").text("숙소");
		$(".listmenu>.sub-box").append(
			'<li><a href="./top100_food_tour_rooms.jsp?contenttypeid=12&pageNo=1">관광지</a></li>'
		);
		$(".listmenu>.sub-box").append(
			'<li><a href="./top100_food_tour_rooms.jsp?contenttypeid=39&pageNo=1">음식점</a></li>'
		);
		$(".s-c-b-title>h2").text("숙소");
	}
	else if ($.urlParam('contenttypeid') == 39) {
		$(".listmenu>.sub-menu").text("음식점");
		$(".listmenu>.sub-box").append(
			'<li><a href="./top100_food_tour_rooms.jsp?contenttypeid=12&pageNo=1">관광지</a></li>'
		);
		$(".listmenu>.sub-box").append(
			'<li><a href="./top100_food_tour_rooms.jsp?contenttypeid=32&pageNo=1">숙소</a></li>'
		);
		$(".s-c-b-title>h2").text("음식점");
	}
	
	if ($.urlParam('pageNo') == 1) {
		$(".page_num_group").append(
			'<a href=./top100_food_tour_rooms.jsp?contenttypeid=' + $.urlParam('contenttypeid') + '&pageNo=1 class="selected">1~50위</a>'
		);
		$(".page_num_group").append(
			'<a href=./top100_food_tour_rooms.jsp?contenttypeid=' + $.urlParam('contenttypeid') + '&pageNo=2 >51~100위</a>'
		);
	}
	else {
		$(".page_num_group").append(
			'<a href=./top100_food_tour_rooms.jsp?contenttypeid=' + $.urlParam('contenttypeid') + '&pageNo=1 >1~50위</a>'
		);
		$(".page_num_group").append(
			'<a href=./top100_food_tour_rooms.jsp?contenttypeid=' + $.urlParam('contenttypeid') + '&pageNo=2 class="selected">51~100위</a>'
		);
	}
	
	
	$.ajax({
		type: 'get',
		url: './api/top100/get',
		data: {
			contenttypeid: $.urlParam('contenttypeid'),
			pageNo: $.urlParam('pageNo')
		},
		dataType: 'json',
		success: function(data) {
			console.log("top100 리뷰 데이터 : "+JSON.stringify(data));
			for(var i=0; i<data.length; i++){
				$.ajax({
					type: 'get',
					url: 'http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon',
					data: {
						ServiceKey: api_key,
						numOfRows: 10,
						pageNo: 1,
						MobileOS: 'ETC',
						MobileApp: 'railro',
						contentId: data[i].contentid,
						contentTypeId: data[i].contenttypeid,
						defaultYN: 'Y',
						firstImageYN: 'Y',
						_type: 'json'
					},
					async:false,
					dataType: 'json',
					success: function(data2) {
						console.log("리뷰 정보 조회 : " + JSON.stringify(data2));
						data2 = data2.response.body.items.item;
						var img_check = data2.firstimage2 == undefined ? 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTE4-IM70qjVRp3sLCP5IAjVpciNZa58m7bz9rEUMQBZTO_LzI8nKZxV__pGJIgkgPzqHg&usqp=CAU' : data2.firstimage2
						var add_tag = '';
						
						if($.urlParam('pageNo') == 1){
							add_tag = '<li><span class="rank">'+(i+1)+'</span><a href="./detail_info.jsp?contentid='+data[i].contentid+'&contenttypeid='+data[i].contenttypeid+'" target="_blank"><img src='+img_check+' alt=""></a><div class="title">'+data2.title+'</div><div class="like_group"><img src="./top100/heart.png" alt="" class="like"><span class="like_cnt">'+data[i].likes_cnt+'</span></div><span class="review_cnt">리뷰 : '+data[i].review_cnt+'</span><div class="tags">';
						}
						else{
							add_tag = '<li><span class="rank">'+(i+1+50)+'</span><a href="./detail_info.jsp?contentid='+data[i].contentid+'&contenttypeid='+data[i].contenttypeid+'" target="_blank"><img src='+img_check+' alt=""></a><div class="title">'+data2.title+'</div><div class="like_group"><img src="./top100/heart.png" alt="" class="like"><span class="like_cnt">'+data[i].likes_cnt+'</span></div><span class="review_cnt">리뷰 : '+data[i].review_cnt+'</span><div class="tags">';
						}
						
						for(var o=0; o<data[i].tags.length; o++){
							add_tag += '<span>#'+data[i].tags[o]+'</span> ';
						}
						add_tag += '</div></li>';
						
						$(".top").append(add_tag);
						
					},
					error: function(request, status, error) {
						//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
						console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
					}
				});
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