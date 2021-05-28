var files = '';

$(document).ready(function(){
	$.ajax({ //기본 정보 불러오기
		type: 'get',
		url: './api/user/get',
		success: function(data) {
			console.log(data);
			id = data.id;
			$(".profile>img").attr('src', data.profile_img);
			$(".id>div").text(data.username);
			$(".name>div>input").val(data.name);
			$(".nickname>div>input").val(data.nickname);
			$(".email>div").text(data.email);
		},
		error: function(data) {
			console.log('실패');
		}
	});
	
	
	$(".btn-group>.modify").on('click', function(){ //데이터 수정하기
		formData = new FormData();
		formData.append('id', id);
		formData.append('name', $(".name>div>input").val());
		formData.append('nickname', $(".nickname>div>input").val());
		formData.append('profile_img', files);
		$.ajax({
			type: 'post',
			enctype: 'multipart/form-data',
			cache: false,
			url: './api/user/put',
			data: formData,
			async: false,
			contentType: false,
			processData: false,
			dataType: 'json',
			success: function(msg){
				console.log(msg);
				location.reload();
			},
			error: function(request, status, error) {
				//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
			
		})

	});
	$('#imgchange').on('change', function(e) {
		if ($(this).val() != "") {
			files = ($(this)[0].files[0]);
			readInputFile(this);
			$(this).val('');
		}
	})
})

// 등록 이미지 등록 미리보기
function readInputFile(input) {
    if(input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$(".profile>img").attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

