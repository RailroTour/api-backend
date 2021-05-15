package oauth.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import common.KakaoAPI;
import oauth.dao.OauthDAO;
import oauth.dto.KakaoUserBean;
import oauth.dto.TokenBean;
import user.dao.UserDAO;
import user.dto.UserBean;

public class OauthLoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String access_token = null;
		
		for(int i=0; i<cookies.length; i++) { //토큰 찾기
			if(cookies[i].getName().equals("access_token")) {
				access_token = cookies[i].getValue();
				break;
			}
		}
		
		KakaoAPI kakao = new KakaoAPI(access_token);
		TokenBean token = kakao.getTokenTime();
		try {
			if(token==null) {
				response.sendError(400, "access token이 유효하지 않습니다.");
				return;
			}
			else if(Integer.parseInt(token.getExpires_in()) < 50) { //토큰 만료 체크
			
				response.sendError(400, "재로그인 해주세요.");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KakaoUserBean kakaouser = kakao.getUserInfo();
		
		try {
			OauthDAO oauth = new OauthDAO(ConnectionProvider.getConnection());
			
			int cnt = oauth.SignUp_Check(kakaouser);

			HttpSession session = request.getSession();
			Cookie cookie = new Cookie("email", kakaouser.getEmail());
			
			if(cnt == 1) { //회원가입 되어있는 상태면
				System.out.println("가입상태");
				// 로그인 처리
				session.setAttribute("social_user_id", kakaouser.getId());
				session.setAttribute("email", kakaouser.getEmail());
				response.addCookie(cookie);
				response.setStatus(201);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(JsonConverter.objectToJson(kakaouser));
				return;
			}
			else { //회원가입 안되어있을 경우 회원가입
				System.out.println("미가입상태");
				int inserted_id = oauth.SocialUser_SignUp(kakaouser);
				
				UserDAO userdao = new UserDAO(ConnectionProvider.getConnection());
				UserBean user = userdao.get(inserted_id);
				
				session.setAttribute("social_user_id", kakaouser.getId());
				session.setAttribute("email", kakaouser.getEmail());
				response.addCookie(cookie);
				response.setStatus(201);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(JsonConverter.objectToJson(kakaouser));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
