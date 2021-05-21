package user.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import user.dao.UserDAO;
import user.dto.UserBean;

public class UserPutAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String profile_img = (String)request.getAttribute("profile_img");
		try {
			if(id == null) {
				response.sendError(400, "id required");
				return;
			}
			else if(username == null) {
				response.sendError(400, "username required");
				return;
			}
			else if(password == null) {
				response.sendError(400, "password required");
				return;
			}
			else if(name == null) {
				response.sendError(400, "name required");
				return;
			}
			else if(nickname == null) {
				response.sendError(400, "nickname required");
				return;
			}
			else if(email == null) {
				response.sendError(400, "email required");
				return;
			}
			else if(profile_img == null) {
				response.sendError(400, "profile_img required");
				return;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UserBean user = new UserBean(username, password, name, nickname, email,profile_img);
		try {
			UserDAO userdao = new UserDAO(ConnectionProvider.getConnection());
			if(userdao.count(username) > 0) {
				response.sendError(400, "already existing username");
				return;
			}
			userdao.update(user);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(user));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
