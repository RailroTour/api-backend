$(document).ready(function(){
	$.ajax({
		type: 'GET',
		url: './api/user',
		success: function(data) {
			console.log(data);
			id = data.id;
			$(".profile>img").attr('src', data.profile_img);
			$(".id>div").text(data.username);
			$(".name>div").text(data.name);
			$(".nickname>div>input").val(data.nickname);
			$(".email>div>input").val(data.email);
		},
		error: function(data) {
			console.log('실패');
		}
	});
	$(".btn-group>.modify").on('click', function(){
		formData = new FormData();
		formData.append('id', id);
		formData.append('username', $(".id>div").text());
		formData.append('name', $(".name>div").text());
		formData.append('nickname', $(".nickname>div>input").val());
		formData.append('email', $(".email>div>input").val());
		for (var i = 0; i < $('#imgchange')[0].files.length; i++) {
			formData.append('profile_img', $('#imgchange')[0].files[i]);
		}

		$.ajax({
			url: './api/user', //request 보낼 서버의 경로
			type: 'put', // 메소드(get, post, put 등)
			data: formData,
			success: function(data) {
				console.log("data:" + JSON.stringify(data));
			},
			error: function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});

	});
	$('#imgchange').on('change', function(e) {
		readInputFile(this);
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

