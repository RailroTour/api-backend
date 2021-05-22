package review;

import common.Action;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.ConnectionProvider;
import planner.dao.PlannerDAO;

public class ReviewHashTagDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		try {
			if(id == null) {
				response.sendError(400, "id required");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ReviewHashTagDAO hastagdao = new ReviewHashTagDAO(ConnectionProvider.getConnection());
			hastagdao.delete(Integer.parseInt(id));
			
			response.setStatus(204);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
