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

public class UserGetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		
		try {
			if(email == null) {
				response.sendError(400, "email required");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			UserDAO userdao = new UserDAO(ConnectionProvider.getConnection());
			UserBean user = userdao.get(email);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(user));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
