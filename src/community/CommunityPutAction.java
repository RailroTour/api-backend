package community;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

public class CommunityPutAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		try {
			if(title == null) {
				response.sendError(400, "title required");
				return;
			}
			else if(content == null) {
				response.sendError(400, "content required");
				return;
				
			}
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CommunityBean community = new CommunityBean(title,content);
		try {
			CommunityDAO communitydao = new CommunityDAO(ConnectionProvider.getConnection());
			
			communitydao.update(community);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(community));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
