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
		try {
			if(id == null) {
				response.sendError(400, "id required");
				return;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UserBean user = new UserBean(Integer.parseInt(id), username, password, name, nickname, email);
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
