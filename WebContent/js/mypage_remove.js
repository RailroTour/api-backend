$(document).ready(function(){
	$(".btngroup>.submit").on('click', function(){
		if($(".agree1").is(":checked")==false){
			alert('모두 동의해주세요.');
			return;
		}
		else if($(".agree2").is(":checked")==false){
			alert('모두 동의해주세요.');
			return;
		}
		else if($(".agree3").is(":checked")==false){
			alert('모두 동의해주세요.');
			return;
		}
		
		$.ajax({
			url: './api/user/delete', //request 보낼 서버의 경로
			type: 'post', // 메소드(get, post, put 등)
			contentType: 'application/json; charset=utf-8',
			success: function(data) {
				console.log("data:" + JSON.stringify(data));
				deleteCookie('access_token');
    			deleteCookie('refresh_token');
				location.href="./oauth/logout";
			},
			error: function(request, status, error) {
				//서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	});
})

// 쿠키 생성
function setCookie(name, value, expiredays) {
    var cookie = name + "=" + escape(value) + "; path=/;"
    if (typeof expiredays != 'undefined') {
        var todayDate = new Date();
        todayDate.setDate(todayDate.getDate() + expiredays);
        cookie += "expires=" + todayDate.toGMTString() + ";"
    }
    document.cookie = cookie;
}
 
// 쿠키 획득
function getCookie(name) {
    name += "=";
    var cookie = document.cookie;
    var startIdx = cookie.indexOf(name);
    if (startIdx != -1) {
        startIdx += name.length;
        var endIdx = cookie.indexOf(";", startIdx);
        if (endIdx == -1) {
            endIdx = cookie.length;
            return unescape(cookie.substring(startIdx, endIdx));
        }
    }
    return null;
}
 
// 쿠키 삭제
function deleteCookie(name) {
    setCookie(name, "", -1);
}