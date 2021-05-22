package review;

import common.Action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import common.ConnectionProvider;

public class ReviewHashTagGetAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		try {
			if(id == null) {
				response.sendError(400, "email required");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ReviewHashTagDAO hashtagdao = new ReviewHashTagDAO(ConnectionProvider.getConnection());
			ReviewHashTagBean hashtag = hashtagdao.get(Integer.parseInt(id));
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(hashtag);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
