package review;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;


public class ReviewAddAction implements Action{
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		 
		
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		//System.out.print(email);
		
		Integer content_id = Integer.parseInt(request.getParameter("content_id"));
		Integer content_type_id = Integer.parseInt(request.getParameter("content_type_id"));
		
		String image_path = (String)request.getAttribute("image_path");
		String content = request.getParameter("content");
		
		try {
			
			if(content_id == null) {
				response.sendError(400, "content_id required");
				return;
			}
			else if(content_type_id == null) {
				response.sendError(400, "content_type_id from session required");
				return;
			}
			else if(image_path == null) {
				response.sendError(400, "image_path required");
				return;
			}
			else if(content == null) {
				response.sendError(400, "content required");
				return;
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ReviewBean review = new ReviewBean(content_id, content_type_id,image_path,content);
		try {
			ReviewDAO reviewadd = new ReviewDAO(ConnectionProvider.getConnection());
			
			reviewadd.insert(review,email);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(review));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}


}



