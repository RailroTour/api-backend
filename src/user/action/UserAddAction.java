package user.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;


import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import user.dao.UserDAO;
import user.dto.UserBean;

public class UserAddAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		UserBean user = new UserBean(
				request.getParameter("username"),
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("nickname"),
				request.getParameter("email")
		);

		try {
			UserDAO useradd = new UserDAO(ConnectionProvider.getConnection());
			useradd.insert(user);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(user));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
