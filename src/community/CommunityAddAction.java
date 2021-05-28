package community;


import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;



public class CommunityAddAction implements Action{
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		 
		
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		//System.out.print(email);
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		//email = "thals8744@naver.com";
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
		
		CommunityBean community = new CommunityBean(title, content);
		try {
			CommunityDAO communityadd = new CommunityDAO(ConnectionProvider.getConnection());
			
			communityadd.insert(community,email);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(community));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}


}



