
const encoding_api_key = 'JXL40bCK2WGOu%2FE1WOGjuALpADt64Wb2mQVwNpxiA0bre%2FV8GozZggM2O01%2FPaTTyNm0A2JahebDf%2FPGwW8jbg%3D%3D';
const decoding_api_key = 'JXL40bCK2WGOu/E1WOGjuALpADt64Wb2mQVwNpxiA0bre/V8GozZggM2O01/PaTTyNm0A2JahebDf/PGwW8jbg=='

var files = [];
var tags = [];
var like = 0;

if(getParameterByName('contenttypeid')==12){
    $(".listmenu>button.info_name").text('관광지 정보');
	$(".text_group>.menu").hide(); //대표메뉴
	$(".text_group>.open_time").hide(); //영업시간
	$(".text_group>.rest").hide(); //휴무일
	$(".more_info>.discount").hide(); //할인정보
	$(".more_info>.representative_menu").hide() //대표메뉴
	$(".more_info>.kid").hide(); //어린이 놀이방 여부
	$(".more_info>.opening").hide(); //개업일
	$(".more_info>.packing").hide(); //포장 가능
	$(".more_info>.reserv").hide(); //예약안내
	$(".more_info>.scale").hide(); //규모
	$(".more_info>.seats").hide(); //좌석수
	$(".more_info>.smoking").hide(); //금연/흡연여부
	$(".more_info>.handling_menu").hide(); //취급메뉴
}
else if(getParameterByName('contenttypeid')==32){
    $(".listmenu>button.info_name").text('숙박 정보');
	$(".text_group>.menu").hide();//대표메뉴
	$(".text_group>.open_time").hide(); //영업시간
	$(".text_group>.rest").hide(); //휴무일
	$(".more_info>.stroller").hide(); //유모차 대여 여부
	$(".more_info>.credit_card").hide(); //신용카드 대여 여부
	$(".more_info>.animal").hide(); //애완동물 가능 여부
	$(".more_info>.available_age").hide(); //체험가능 연령
	$(".more_info>.experience").hide(); //체험 안내
	$(".more_info>.open").hide(); //개장일
	$(".more_info>.parking").hide(); //주차시설
	$(".more_info>.rest_day").hide(); //쉬는날
	$(".more_info>.use").hide(); //이용시기
	$(".more_info>.use_time").hide(); //이용시간
	$(".more_info>.discount").hide(); //할인정보
	$(".more_info>.representative_menu").hide() //대표메뉴
	$(".more_info>.kid").hide(); //어린이 놀이방 여부
	$(".more_info>.opening").hide(); //개업일
	$(".more_info>.packing").hide(); //포장 가능
	$(".more_info>.reserv").hide(); //예약안내
	$(".more_info>.scale").hide(); //규모
	$(".more_info>.seats").hide(); //좌석수
	$(".more_info>.smoking").hide(); //금연/흡연여부
	$(".more_info>.handling_menu").hide(); //취급메뉴
}
else if(getParameterByName('contenttypeid')==39){
    $(".listmenu>button.info_name").text('음식점 정보');
	$(".text_group>.rest").hide(); //휴무일
	$(".more_info>.people").hide(); //수용인원
	$(".more_info>.stroller").hide(); //유모차 대여 여부
	$(".more_info>.animal").hide(); //애완동물 가능 여부
	$(".more_info>.available_age").hide(); //체험가능 연령
	$(".more_info>.experience").hide(); //체험 안내
	$(".more_info>.experience").hide(); //문의 및 안내
	$(".more_info>.open").hide(); //개장일
	$(".more_info>.rest_day").hide(); //쉬는날
	$(".more_info>.use").hide(); //이용시기
	$(".more_info>.use_time").hide(); //이용시간
}

$(document).ready(function(){
    //detailIntro(api_key, getParameterByName('contenttypeid'), getParameterByName('contentid'));
    
    
    //기본정보 조회
    detailCommon(decoding_api_key, getParameterByName('contenttypeid'), getParameterByName('contentid'));
    //소개정보 조회
    detailIntro(decoding_api_key, getParameterByName('contenttypeid'), getParameterByName('contentid'));
	//이미지 조회
	detailImage(decoding_api_key, getParameterByName('contentid'));


    (function( $ ) {
    "use strict";
    $(function() {
        function animated_contents() {
            $(".zt-skill-bar > div ").each(function (i) {
                var $this  = $(this),
                    skills = $this.data('width');

                $this.css({'width' : skills + '%'});

            });
        }
        
        if(jQuery().appear) {
            $('.zt-skill-bar').appear().on('appear', function() {
                animated_contents();
            });
        } else {
            animated_contents();
        }
    });
}(jQuery));

	$("#comment_add #submit").on('click', function(){ //리뷰 등록
		var formData = new FormData();

		
		for(var i=0; i<files.length; i++){
			formData.append('file'+i, files[i]);
		}
		formData.append('tags', tags);
		formData.append('like', like);
		formData.append('contents', $("#contents").val());
		formData.append('contenttypeid', getParameterByName('contenttypeid'));
		formData.append('contentid', getParameterByName('contentid'));
		
		$.ajax({
			type: 'post',
			enctype: 'multipart/form-data',
			cache: false,
			url: './api/review/post',
			data: formData,
			async: false,
			contentType: false,
			processData: false,
			dataType: 'json',
			success: function(msg){
				console.log(msg);
				if(msg.id != null){
					location.reload();
				}
			},
			error: function(request, status, error) {
				//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
			
		})
	})

    $('#like').on('change', function(){ //좋아요
        if($('#like').is(':checked')){
            $('.like_btn').attr('src', './Food_More_Infomation_IMG/like2.png');
			like = 1;
        }
        else{
            $('.like_btn').attr('src', './Food_More_Infomation_IMG/like1.png');
			like = 0;
        }
    })
    $('#comment_add textarea').on('focus', function(){ //리뷰 클릭 감지
		if (getCookie("access_token") == null) {
			alert('로그인 후 이용하실 수 있습니다.');
			$(this).blur();
			return;
		}
    })

	
	$(".trip_cart").on('click', function(){ //여행바구니 담기
		$.ajax({
			url: './api/tripcart', //request 보낼 서버의 경로
			type: 'post', // 메소드(get, post, put 등)
			data:{
				division_id:getParameterByName('contenttypeid'),
				serial_num:getParameterByName('contentid')
			},
			success: function(data) {
				console.log("data:" + JSON.stringify(data));
				alert('담기 성공!');
			},
			error: function(request, status, error) {
				//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				alert('로그인 후 이용가능합니다.');
			}
		});
	})

    $(document).on('click', '.imgfile .preview',function(){ //사진 삭제
		files.splice($(this).index(), 1);
        $(this).remove();
    })

    $('#img').on('change', function(){ //사진 추가
        if($(this).val()!=""){
            var ext=$(this).val().split(".").pop().toLowerCase();
            
            if($.inArray(ext, ["gif", "jpg", "jpeg", "png"])==-1){
                swal('이미지 파일만 업로드 해주세요.');
                $(this).val('');
                return;
            }
            var fileSize=this.files[0].size;
            var maxSize=(1024*1024)*10;
            if(fileSize>maxSize){
                swal('파일용량 10MB를 초과했습니다.');
                $(this).val('');
                return;
            }
            
            if($('.imgfile .preview').length>4){
                swal('이미지는 5개까지만 첨부할 수 있습니다.');
                $(this).val('');
                return;
            }
            readURL(this);
			files.push($(this)[0].files[0]);
			
            $(this).val('');
        }
    })
    $(document).on('keydown', '.input_tag',function(key){ //태그 추가
        if(key.keyCode==13){//엔터키가 들어오면
            if($('.tags').length<10){
                var tag=$(this).val();
				tags.push(tag);
                if(tag!=''){
                    $('.tag ul .input_tag').before('<li class="tags">#'+tag+'<img src="./Food_More_Infomation_IMG/cancel-button.png" alt=""></li>');
                }
            }
            else{
                swal('태그는 최대 10개까지 등록할 수 있습니다.');
            }
            $(this).val('');
			return false;
        }

    })
    $(document).on('click', '.tags img', function(){ //태그 삭제
		tags.splice($(this).parent().index(), 1);
        $(this).parent().remove();
    })
   $('.btn_group .Previous').on("click", function(){
       for(var i=0; i<$('.img_collection li').length; i++){
           if($('.img_collection li').eq(i).css('display')=='block'){
               $('.img_collection li').eq(i).fadeOut();
               $('.img_collection li').eq(i).css('display', 'none');
               if(i<1){
                   var num=$('.img_collection li').length;
                   $('.img_collection li').eq(num-1).fadeIn(500);
                   $('.img_collection li').eq(num-1).css('display', 'block');
               }
               else{
                   $('.img_collection li').eq(i-1).fadeIn(500);
                   $('.img_collection li').eq(i-1).css('display', 'block');
               }
               break;
           }
       }
   })
    $('.btn_group .Next').on("click", function(){
        for(var i=0; i<$('.img_collection li').length; i++){
           if($('.img_collection li').eq(i).css('display')=='block'){
               $('.img_collection li').eq(i).fadeOut();
               $('.img_collection li').eq(i).css('display', 'none');
               if(i==$('.img_collection li').length-1){
                   $('.img_collection li').eq(0).fadeIn(500);
                   $('.img_collection li').eq(0).css('display', 'block');
               }
               else{
                   $('.img_collection li').eq(i+1).fadeIn(500);
                   $('.img_collection li').eq(i+1).css('display', 'block');
               }
               break;
           }
       }
    })

})

function readURL(input){
    if(input.files&&input.files[0]){
        var reader=new FileReader();
        reader.onload=function(e){
            var vimg='<ul class="preview" style="background-image: url('+e.target.result+')"><li>삭제</li></ul>';
            $('#img').before(vimg);
        }
        reader.readAsDataURL(input.files[0]);
    }
}
function detailCommon(api_key, contentTypeId, contentId){
	$.get('http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon', {
		pageNo: 1,
		numOfRows: 10,
		MobileOS: 'ETC',
		MobileApp: 'railro',
		serviceKey: api_key,
		contentTypeId: contentTypeId,
		_type: 'json',
		contentId: contentId,
		defaultYN: 'Y',
		firstImageYN: 'Y',
		addrinfoYN: 'Y',
		overviewYN: 'Y'
	}, function(data) {
		console.log('공통정보 조회 : '+JSON.stringify(data));
		//console.log('success : '+JSON.stringify(data.response.body));
		//console.log(data.response.body.items.item);
		data = data.response.body.items.item;
		$(document).attr('title', '상세정보 : ' + data.title);
		$(".text>.text_group>.title>span:first-child").text(data.title); //제목
		$(".text>.text_group>.rotate>div:last-child").text(data.addr1); //주소
		
		var none_img = data.firstimage==undefined ? "https://lh3.googleusercontent.com/proxy/g-K2vc17c_0QH-IwpjFdLFbxZrzEJIJ8Zy-qzSx58Xvow2OnCZ-VIkqAkxi4e1vmneRL59IhpJ524lIKa3Hyprb687aEOgs":data.firstimage;
		$(".img_collection").append( //이미지
			'<li style="display: block"><img src=' + none_img + ' alt=""></li>'
		);
		$(".text>.text_group>.homepage>div:last-child").html(data.homepage); //홈페이지
		$(".more_info>.overview>span:last-child").html(data.overview); //개요
		$(".more_info>.post>span:last-child").text(data.zipcode); //우편번호
		$(".text>.text_group>.phone>div:last-child").text(data.tel); //전화번호
	}
	);
}
function detailIntro(api_key, contentTypeId, contentId){

    $.get('http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro', {
            pageNo: 1,
            numOfRows: 10,
            MobileOS: 'ETC',
            MobileApp: 'railro',
            serviceKey: api_key,
            contentTypeId: contentTypeId,
            _type: 'json',
            contentId: contentId
        }, function(data){
            //console.log('success : '+JSON.stringify(data));
            console.log('success : '+JSON.stringify(data.response.body.items.item));
            data = data.response.body.items.item;
            if(contentTypeId==12){
                $(".more_info>.people>span:last-child").text(data.accomcount);
                $(".more_info>.stroller>span:last-child").text(data.chkbabycarriage);
                $(".more_info>.credit_card>span:last-child").text(data.chkcreditcard);
                $(".more_info>.animal>span:last-child").text(data.chkpet);
                $(".more_info>.available_age>span:last-child").text(data.expagerange);
                $(".more_info>.experience>span:last-child").text(data.expguide == "" ? '미표시':data.expguide);
                $(".more_info>.question>span:last-child").text(data.infocenter);
                $(".more_info>.open>span:last-child").text(data.opendate);
                $(".more_info>.parking>span:last-child").text(data.parking == "" ? '미표시':data.parking);
                $(".more_info>.rest_day>span:last-child").text(data.restdate);
                $(".more_info>.use>span:last-child").text(data.useseason);
                $(".more_info>.use_time>span:last-child").html(data.usetime == "" ? '미표시':data.usetime);
            }
            else if(contentTypeId==39){
                $(".more_info>.discount>span:last-child").text(data.discountinfofood == "" ? '미표시':data.discountinfofood);
                $(".more_info>.representative_menu>span:last-child").text(data.firstmenu);
                $(".more_info>.kid>span:last-child").text(data.kidsfacility);
                $(".more_info>.opening>span:last-child").text(data.opendatefood);
                $(".more_info>.packing>span:last-child").text(data.packing);
                $(".more_info>.reserv>span:last-child").text(data.reservationfood);
                $(".more_info>.scale>span:last-child").text(data.scalefood);
                $(".more_info>.seats>span:last-child").text(data.seat);
                $(".more_info>.smoking>span:last-child").text(data.smoking);
                $(".more_info>.handling_menu>span:last-child").text(data.treatmenu == "" ? '미표시':data.treatmenu);
            }
/*			else if(contentTypeId==32){
				for(key in data){
					if(data[key] != ""){
						$(".more_info").append(
							'<li class="post"><span>&#8226; '+key+'</span> <span>'+data[key]+'</span></li>'
						);
					}
				}
			}*/
        }
    );
}
function getParameterByName(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.search);
        return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}


function detailImage(api_key, contentId){
	$.get('http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailImage', {
		pageNo: 1,
		numOfRows: 100,
		MobileOS: 'ETC',
		MobileApp: 'railro',
		serviceKey: api_key,
		_type: 'json',
		contentId: contentId,
		imageYN: 'Y',
		subImageYN: 'Y'
	}, function(data) {
		console.log('이미지 조회 : '+JSON.stringify(data));
		//console.log('success : '+JSON.stringify(data.response.body));
		//console.log(data.response.body.items.item);
		var cnt = data.response.body.totalCount;
		if(cnt != 0){
			data = data.response.body.items.item;
			for (var i = 0; i < data.length; i++) {
				$(".img_collection").append(
					'<li><img src=' + data[i].originimgurl + ' alt=""></li>'
				);
			}
		}
	}
	);
}