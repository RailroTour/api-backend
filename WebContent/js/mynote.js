var scroll_position=0;
$(document).ready(function(){
	$.ajax({ //플래너 인증 (내꺼인지 아닌지)
		url: './api/planneroauth/get', //request 보낼 서버의 경로
		type: 'get', // 메소드(get, post, put 등)
		data: {
			planner_id: $.urlParam('planner_id')
		},
		success: function(data) {
			console.log("플래너 인증 정보:" + JSON.stringify(data));
			if(data == 0){ //내께 아니면
				$(".cover_img").remove();
			}
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
	$.ajax({ //상단 정보 셋팅
		url: './api/plannerinfo/get', //request 보낼 서버의 경로
		type: 'get', // 메소드(get, post, put 등)
		data: {
			planner_id: $.urlParam('planner_id')
		},
		success: function(data) {
			console.log("플래너1 정보:" + JSON.stringify(data));
			
			$(".user>.user_name").text(data.nickname);
			$(".title>div").text(data.title);
			var date = new Date(data.start_day);
			date.setDate(date.getDate()+data.days-1);
			var today = date.getFullYear()+"-"+("0"+(date.getMonth()+1)).slice(-2)+"-"+("0"+date.getDate()).slice(-2);
			$(".note_date>.date").text(data.start_day+'~'+today+'('+data.days+'일)');
			$(".tema").text(data.name+'여행');
			$(".rectangle>.view").text(data.view);
			$("#note_img").css({
				'background':'url('+data.img_path+')',
				'background-repeat':'no-repeat',
				'background-size':'cover',
				'background-position':'center center'
			});
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
	
	$.ajax({ //바디 내용 셋팅
		url: './api/tripcourse/get', //request 보낼 서버의 경로
		type: 'get', // 메소드(get, post, put 등)
		data: {
			planner_id: $.urlParam('planner_id')
		},
		success: function(data) {
			console.log("플래너2~3 정보:" + JSON.stringify(data));
			var day = 0;
			
			for(var i=0; i<data.length; i++){
				if(data[i].visit_day == day){
					//관광지, 음식점, 숙소이면
					if (data[i].contenttypeid == 12 || data[i].contenttypeid == 32 || data[i].contenttypeid == 39) {
						var search_data = get_api(data[i].contentid, data[i].contenttypeid);
						console.log("검색 데이터 : " + JSON.stringify(search_data));
						var type_img;
						if (data[i].contenttypeid == 12) {
							type_img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlZcXrIbUyq05noEo3hlz_3NOj2DOm0A3dO0aFqt9tTYOX2JqETrkKc8guTk2OcRg2AVw&usqp=CAU";
						}
						else if (data[i].contenttypeid == 32) {
							type_img = "https://image.flaticon.com/icons/png/512/235/235889.png";
						}
						else if (data[i].contenttypeid == 39) {
							type_img = "http://untickle.com/image/icon_lv2_cate_17.png";
						}


						$(".plan_info .day_route").eq(day-1).append(
							'<hr class="line"><li class="route"><div class="number"><span>'+data[i].order_num+'</span></div><div class="info"><a href=./detail_info.jsp?contenttypeid='+search_data.contenttypeid+'&contentid='+search_data.contentid+' target="_blank"><img src='+search_data.firstimage2+' alt=""></a><div class="title">'+search_data.title+'</div><div class="kinds"><img src='+type_img+' alt="" class="food_tour_hash"><a href=./detail_info.jsp?contenttypeid='+search_data.contenttypeid+'&contentid='+search_data.contentid+' target="_blank"><img src="./mynote_jpg/info.png" alt="" class="info"></a></div><div class="arrow"></div></div></li>'
						);
					}
					//기차이면
					else if (data[i].contenttypeid == 40) {
						var type_img = "https://cdn2.iconfinder.com/data/icons/pittogrammi/142/14-512.png";
						$(".plan_info .day_route").eq(day-1).append(
							'<hr class="line"><li class="route"><div class="number"><span>'+data[i].order_num+'</span></div><div class="info"><a href="#" target="_blank"><img src='+type_img+' alt=""></a><div class="title">기차</div><div class="kinds"><img src='+type_img+' alt="" class="food_tour_hash"><a href="#"><img src="./mynote_jpg/info.png" alt="" class="info"></a></div><div class="arrow"></div></div></li>'
						);
					}
				}
				else{
					day = data[i].visit_day;
					
					//네비게이션 셋팅
					if(day == 1){
						$(".plan_nav>.nav_route").append(
							'<li onclick="fnMove(' + (data[i].visit_day - 1) + ')">DAY' + data[i].visit_day + ' ' + data[i].sigungu_name + '</li>'
						);
					}
					else{
						$(".plan_nav>.nav_route").append(
							'<li onclick="fnMove(' + (data[i].visit_day - 1) + ')"><hr>DAY' + data[i].visit_day + ' ' + data[i].sigungu_name + '</li>'
						);
					}
					
					//내용 셋팅
					$(".plan_info").append(day_info(data[i].visit_day, data[i].sigungu_name));
					//관광지, 음식점, 숙소이면
					if(data[i].contenttypeid == 12 || data[i].contenttypeid == 32 || data[i].contenttypeid == 39){
						var search_data = get_api(data[i].contentid, data[i].contenttypeid);
						console.log("검색 데이터 : "+JSON.stringify(search_data));
						var type_img;
						if(data[i].contenttypeid == 12){
							type_img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlZcXrIbUyq05noEo3hlz_3NOj2DOm0A3dO0aFqt9tTYOX2JqETrkKc8guTk2OcRg2AVw&usqp=CAU";
						}
						else if(data[i].contenttypeid == 32){
							type_img = "https://image.flaticon.com/icons/png/512/235/235889.png";
						}
						else if(data[i].contenttypeid == 39){
							type_img = "http://untickle.com/image/icon_lv2_cate_17.png";
						}
						
						
						$(".plan_info").append(
							'<ul class="day_route"><li class="route"><div class="number"><span>'+data[i].order_num+'</span></div><div class="info"><a href=./detail_info.jsp?contenttypeid='+search_data.contenttypeid+'&contentid='+search_data.contentid+' target="_blank"><img src='+search_data.firstimage2+' alt=""></a><div class="title">'+search_data.title+'</div><div class="kinds"><img src='+type_img+' alt="" class="food_tour_hash"><a href=./detail_info.jsp?contenttypeid='+search_data.contenttypeid+'&contentid='+search_data.contentid+' target="_blank"><img src="./mynote_jpg/info.png" alt="" class="info"></a></div><div class="arrow"></div></div></li></ul>'
						);
					}
					//기차이면
					else if(data[i].contenttypeid == 40){ 
						var type_img = "https://cdn2.iconfinder.com/data/icons/pittogrammi/142/14-512.png";
						$(".plan_info").append(
							'<ul class="day_route"><li class="route"><div class="number"><span>'+data[i].order_num+'</span></div><div class="info"><a href="#"><img src='+type_img+' alt=""></a><div class="title">기차</div><div class="kinds"><img src='+type_img+' alt="" class="food_tour_hash"><a href="#"><img src="./mynote_jpg/info.png" alt="" class="info"></a></div><div class="arrow"></div></div></li></ul>'
						);
					}
				}
			}
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
	
	
	
	$(".cover_img>#createNewsAndEventsForm>#img").change(function(){ //플래너 커버이미지 업로드
		var frm = document.getElementById('createNewsAndEventsForm'); 
		frm.method = 'POST'; 
		frm.enctype = 'multipart/form-data'; 
		var fileData = new FormData(frm);
		fileData.append('planner_id', $.urlParam('planner_id'));
		
		$.ajax({
			type: 'post',
			enctype: 'multipart/form-data',
			cache: false,
			url: './api/planner_coverimg/post',
			data: fileData,
			async: false,
			contentType: false,
			processData: false,
			dataType: 'json',
			success: function(msg){
				location.reload();
			},
			error: function(request, status, error) {
				//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
			
		})

	})
	
    $('.select .view1').on('click', function(){
        $('.plan_route table').hide();
        $('.plan_route .plan_info').show();
        $('.plan_nav').show();
        $(this).css('color', '#006cff');
        $('.view2').css('color', 'black');
        
        //PC이면
        if($(window).width()>768){
            $(".plan_nav").show();
        }
        //모바일이면
        else{
            $(".plan_nav").hide();
        }
    })
    $('.select .view2').on('click', function(){
        $('.plan_route table').show();
        $('.plan_route .plan_info').hide();
        $('.plan_nav').hide();
        $('.view1').css('color', 'black');
        $(this).css('color', '#006cff');
        
        //PC이면
        if($(window).width()>768){
            $(".plan_nav").show();
        }
        //모바일이면
        else{
            $(".plan_nav").hide();
        }
    })
/*    $(window).scroll(function(event){
        for(var i=0; i<$('.plan_route .plan_info').length; i++){
            if($('.plan_route .plan_info').eq(i).offset().top-100<=$(this).scrollTop()){
                scroll_position=i;
                $('.nav_route li').eq(i).css('color', '#0093ff');
                $('.nav_route li').eq(i).siblings().css('color', '#898989');
            }
        }
    })*/
    var placeholder='메모가 없습니다.';
    $(".post").focus(function() {
        if ($(this).text() == placeholder) {
            $(this).text("");
        }
    }).focusout(function() {
        if (!$(this).text().length) {
            $(this).text(placeholder);
        }
    });
    $('.like').on('click', function(){
        var src=$('.like>img').attr('src');
        
        if(src=='./mynote_jpg/footprint.png'){
            $('.like>img').attr('src', './mynote_jpg/footprint2.png');
        }
        else{
            $('.like>img').attr('src', './mynote_jpg/footprint.png');
        }
    }) 

    $('.add_mynote').on('click', function(event){
         $("#dialog").dialog("open");
    })
    
});




function get_api(content_id, content_type_id){
	var search_data;
	
	$.ajax({
		url: 'http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon',
		type: 'get',
		async: false,
		data: {
			pageNo: 1,
			numOfRows: 10,
			MobileOS: 'ETC',
			MobileApp: 'railro',
			serviceKey: "JXL40bCK2WGOu/E1WOGjuALpADt64Wb2mQVwNpxiA0bre/V8GozZggM2O01/PaTTyNm0A2JahebDf/PGwW8jbg==",
			_type: 'json',
			contentId: content_id,
			contentTypeId: content_type_id,
			defaultYN: 'Y',
			firstImageYN: 'Y',
			mapinfoYN: 'Y',
		},
		success: function(response_data) {
			//console.log('관광공사 정보 조회 : ' + JSON.stringify(response_data));
			search_data = response_data.response.body.items.item;
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
	
	return search_data;
}

function day_info(day_num, area_name){
	return '<ul class="day_info"><li class="day">DAY'+day_num+'</li><li class="date_info"><span class="date"> </span><span class="area">'+area_name+'</span></li></ul>'
}

function fnMove(seq){ //네비게이션 이동 해당 day로 바로 이동
    scroll_position=seq;
    var offset=$('.plan_route .plan_info>.day_info').eq(seq).offset();
    $('html, body').animate({scrollTop : offset.top}, 400);
/*    $('.nav_route li').eq(seq).css('color', '#0093ff');
    $('.nav_route li').eq(seq).siblings().css('color', '#898989');*/
}

function arrow_Move(seq){ //네비바 이동 위아래 이동
   scroll_position+=seq;
    if(scroll_position<0){
        alert('처음위치 입니다.');
        scroll_position=0;
        return;
    }
    else if(scroll_position>($('.nav_route li').length-1)){
        alert('마지막위치 입니다.');
        scroll_position=$('.nav_route li').length-1;
        return;
    }
    else{
        var offset=$('.plan_route .plan_info>.day_info').eq(scroll_position).offset();
        $('html, body').animate({scrollTop : offset.top}, 400);
/*        $('.nav_route li').eq(scroll_position).css('color', '#0093ff');
        $('.nav_route li').eq(scroll_position).siblings().css('color', '#898989');*/
    }
}


$.urlParam = function(name){
    var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
    return results[1] || 0;
}
 