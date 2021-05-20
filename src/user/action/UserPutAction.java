package user.action;

import java.io.IOException;
import java.sql.SQLException;
import com.oreilly.servlet.MultipartRequest;
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
		int max=1024*1024*10;
		try {
			MultipartRequest multi = new MultipartRequest(request, "C:\\Users\\carto\\Documents\\GitHub\\api-backend/WebContent/profile/"+username, max, "UTF-8");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(id == null) {
				response.sendError(400, "id required");
				return;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		UserBean user = new UserBean(Integer.parseInt(id), username, password, name, nickname, email);
//		try {
//			UserDAO userdao = new UserDAO(ConnectionProvider.getConnection());
//			if(userdao.count(username) > 0) {
//				response.sendError(400, "already existing username");
//				return;
//			}
//			userdao.update(user);
//			
//			response.setContentType("application/json");
//			response.setCharacterEncoding("UTF-8");
//			response.getWriter().print(JsonConverter.objectToJson(user));
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
	}

}
