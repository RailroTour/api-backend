package user.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import user.dao.UserDAO;
import user.dto.UserBean;

public class UserDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		try {
			if(email == null) {
				response.sendError(401, "Login required");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			UserDAO userdao = new UserDAO(ConnectionProvider.getConnection());
			int num = userdao.delete(email);
			System.out.println("삭제된 계정 개수 : "+num);
			response.setStatus(204);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			try {
				response.getWriter().print(JsonConverter.objectToJson(num));
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
