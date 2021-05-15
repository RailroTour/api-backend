package oauth.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.KakaoAPI;

public class OauthLoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		String access_token = null;
		
		for(int i=0; i<cookies.length; i++) { //토큰 찾기
			if(cookies[i].getName().equals("access_token")) {
				access_token = cookies[i].getValue();
				break;
			}
		}
		
		KakaoAPI kakao = new KakaoAPI(access_token);
		kakao.getTokenTime();
	}

}
