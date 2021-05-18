package oauth.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;

public class OauthLogoutAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		response.setStatus(404);
		return;
	}

}
