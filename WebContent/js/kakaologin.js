Kakao.init('6f0f8167f64486dc0809c9626d6436d5');
console.log(Kakao.isInitialized());
//Kakao.API.request({
//  url: '/v1/user/unlink',
//  success: function(res) {
////    alert('success: ' + JSON.stringify(res))
//  },
//  fail: function(err) {
////    alert('fail: ' + JSON.stringify(err))
//  },
//})
$(document).ready(function(){

});
function loginWithKakao() {
    Kakao.Auth.login({
      success: function(authObj) {
        console.log(authObj);
        console.log(authObj["access_token"]);
        $.cookie('access_token', authObj["access_token"], {expires: 7199, path:'/'});
        $.cookie('refresh_token', authObj["refresh_token"], {expires: 5183999});
        location.href = './oauth/login';
/*
                $.ajax({
                  url:'./oauth/login', //request 보낼 서버의 경로
                  type:'post', // 메소드(get, post, put 등)
                  contentType:'application/json; charset=utf-8',
                  success: function(data) {
                    console.log("data:"+JSON.stringify(data));
					location.href = './index.jsp';
                  },
                  error: function(request, status, error) {
                    //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
                    //rtnmsg = JSON.parse(request.responseText);
                    //alert(rtnmsg.message);
                    console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                  }
                });
                */
      },
      fail: function(err) {
        alert(JSON.stringify(err))
      },
    })
}