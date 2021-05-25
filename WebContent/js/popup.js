const train_key = "DrVFgkqXkuQbgQfBPCyTkqsUDXXukiY3pGLkMGgXwCA+MZ2XCGAmvQdQtDm8QlqKejostGbcJSHKR0Ru8n8Weg==";

$(document).ready(function(){
	$.ajax({ //상단 정보 셋팅
		url: './api/station/get', //request 보낼 서버의 경로
		type: 'get', // 메소드(get, post, put 등)
		success: function(data) {
			console.log("역 정보:" + JSON.stringify(data));
			for(var i=0; i<data.length; i++){
				if(data[i].cityname == "전라북도"){
					$(".bukdo").append('<option value='+data[i].nodeid+'>'+data[i].nodename+'</option>');
				}
				else if(data[i].cityname == "전라남도"){
					$(".namdo").append('<option value='+data[i].nodeid+'>'+data[i].nodename+'</option>');
				}
			}
		},
		error: function(request, status, error) {
			//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});

	
	
    $("#search-btn>button").on('click', function(){
        var start_station = $("#start option:selected").val();
        var end_station = $("#end option:selected").val();
        var date = new Date();
        
		$.ajax({ //상단 정보 셋팅
			url: './api/train/get', //request 보낼 서버의 경로
			type: 'get', // 메소드(get, post, put 등)
			data: {
				depPlaceId: start_station,
				arrPlaceId: end_station,
			},
			success: function(data) {
				console.log("기차 정보:" + JSON.stringify(data));
				$(".train_info").remove();
				data = data.response.body.items.item;
				if(data != undefined){
					for (var i = 0; i < data.length; i++) {
						var depplandtime = String(data[i].depplandtime);
						var arrplandtime = String(data[i].arrplandtime);
						depplandtime = depplandtime.substring(8, 10) + ':' + depplandtime.substring(10, 12);
						arrplandtime = arrplandtime.substring(8, 10) + ':' + arrplandtime.substring(10, 12);
						$(".informations").append(
							'<ul class="train_info"><li class="train_kind">' + data[i].traingradename + '</li><li class="start_station">' + data[i].depplacename + '</li><li class="end_station">' + data[i].arrplacename + '</li><li class="start_time">' + depplandtime + '</li><li class="end_time">' + arrplandtime + '</li><li class="price">' + data[i].adultcharge + '</li></ul>'
						);
					}
				}
			

			},
			error: function(request, status, error) {
				//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
    })
})

function jsonCallback(data)
{
    console.log(data); // This is called properly
}