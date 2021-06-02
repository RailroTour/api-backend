package community_comment;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;


public class CommentDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println("comment id: "+id);
		
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
			CommentDAO commentdao = new CommentDAO(ConnectionProvider.getConnection());
			commentdao.delete(Integer.parseInt(id));
			
			response.setStatus(204);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
