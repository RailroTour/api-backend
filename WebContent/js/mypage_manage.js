$(document).ready(function(){
	$.ajax({
		type: 'GET',
		url: './api/user',
		success: function(data) {
			console.log(data);
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
		alert();
	});
})