const api_key = "JXL40bCK2WGOu/E1WOGjuALpADt64Wb2mQVwNpxiA0bre/V8GozZggM2O01/PaTTyNm0A2JahebDf/PGwW8jbg==";

const url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon";

const none_img = "data:image/png;base64,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";
$(document).ready(function() {
	$.ajax({ // 여행바구니 담은 목록 불러오기
		url: './api/tripcart', //request 보낼 서버의 경로
		type: 'get', // 메소드(get, post, put 등)
		success: function(data) {
			console.log("여행 바구니 목록:" + JSON.stringify(data));
			for(var i=0; i<data.length; i++){
				$.get(url, {
					pageNo: 1,
					numOfRows: 10,
					MobileOS: 'ETC',
					MobileApp: 'railro',
					serviceKey: api_key,
					_type: 'json',
					contentId: data[i].serial_num,
					contentTypeId: data[i].division_id,
					defaultYN: 'Y',
					firstImageYN: 'Y'
				}, function(response_data) {
					//console.log('success : ' + JSON.stringify(response_data));
					if(response_data.response.body.totalCount>0){
						response_data=response_data.response.body.items.item;
						$(".trip_cart").append(
							elements(response_data.contentid, 
							response_data.firstimage2 == null ? none_img:response_data.firstimage2,
							response_data.title,
							response_data.contenttypeid
							)
						);
					}
					else{
						response_data=response_data.response.body.items.item;
					}
				});
			}
			
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
	
	$(document).on('click', ".row1 .delete", function(){ // 여행바구니 요소 삭제
		contentid = $(this).parent().parent().find("div").first().text();

		$.ajax({
			url: './api/tripcart' + '?' + $.param({ "contentid": contentid}),
			type: 'DELETE',
			success:function(data){
				alert('삭제되었습니다.');
				location.reload();
			}
		});
	});
})

function elements(contentid, img, title, contenttypeid){ //추가 요소
	var classify;
	if (contenttypeid == 12) {
		classify = '관광지';
	}
	else if (contenttypeid = 39) {
		classify = '음식점';
	}
	else if (contenttypeid = 32) {
		classify = '숙소';
	}
	var link = "./detail_info.jsp?contenttypeid="+contenttypeid+"&contentid="+contentid;
	return '<div class="row1"><div>'+contentid+'</div><div><a href='+link+' target="_blank"><img class="destination_img" src='+img+'></a></div><div><a href="#">'+title+'</a></div><div>'+classify+'</div><div><button class="delete"><img class="close_mark_img" src="jpg/close_mark.png"></button></div></div>';
}