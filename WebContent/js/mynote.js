var scroll_position=0;
$(document).ready(function(){
	$.ajax({
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
			$(".note_date>.date").text(data.start_day+'~'+date.getDate()+'('+data.days+'일)');
			$(".tema").text(data.name+'여행');
			$(".rectangle>.view").text(data.view);
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
	
	
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
    $(window).scroll(function(event){
        for(var i=0; i<$('.plan_route .plan_info').length; i++){
            if($('.plan_route .plan_info').eq(i).offset().top-100<=$(this).scrollTop()){
                scroll_position=i;
                $('.nav_route li').eq(i).css('color', '#0093ff');
                $('.nav_route li').eq(i).siblings().css('color', '#898989');
            }
        }
    })
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


function fnMove(seq){ //네비게이션 이동 해당 day로 바로 이동
    scroll_position=seq;
    var offset=$('.plan_route .plan_info').eq(seq).offset();
    $('html, body').animate({scrollTop : offset.top}, 400);
    $('.nav_route li').eq(seq).css('color', '#0093ff');
    $('.nav_route li').eq(seq).siblings().css('color', '#898989');
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
        var offset=$('.plan_route .plan_info').eq(scroll_position).offset();
        $('html, body').animate({scrollTop : offset.top}, 400);
        $('.nav_route li').eq(scroll_position).css('color', '#0093ff');
        $('.nav_route li').eq(scroll_position).siblings().css('color', '#898989');
    }
}


$.urlParam = function(name){
    var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
    return results[1] || 0;
}
 