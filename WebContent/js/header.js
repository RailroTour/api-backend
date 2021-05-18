$(document).ready(function(){
    $(window).resize(function() { 
        if($(window).width() >768) {
            $(".m-menu").css("display", "block");
        }
        else{
            $(".m-menu").css("display", "none");
        }
    });
    $(".navbar__toggleBtn").on('click', function(){
        $('.m-menu').slideToggle(500);
    });
    
    $(".logout-btn").on('click', function(){
    	deleteCookie('access_token');
    	deleteCookie('refresh_token');
    });
});

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
