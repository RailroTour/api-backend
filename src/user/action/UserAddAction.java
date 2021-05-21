package user.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		//String profile_img = request.getParameter("profile_img");
		String profile_img = (String)request.getAttribute("profile_img");
		
		try {
			if(username == null) {
				response.sendError(400, "username required");
				return;
			}
			else if(password == null) {
				response.sendError(400, "password required");
				return;
			}
			else if(name == null) {
				response.sendError(400, "name");
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
			UserDAO useradd = new UserDAO(ConnectionProvider.getConnection());
			if(useradd.count(username) > 0) {
				response.sendError(400, "already existing username");
				return;
			}
			useradd.insert(user);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(user));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
