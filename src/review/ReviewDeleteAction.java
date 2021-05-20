package review;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import tripcart.dao.TripCartDAO;

public class ReviewDeleteAction implements Action{
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer content_id = Integer.parseInt(request.getParameter("content_id"));
		
		try {
			if(id == null) {
				response.sendError(400, "id required");
				return;
			}
			else if(content_id == null) {
				response.sendError(400, "content_id required");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ReviewDAO reviewdao = new ReviewDAO(ConnectionProvider.getConnection());
			reviewdao.delete(id,content_id);
			
			response.setStatus(404);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}



