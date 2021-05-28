package community;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;



public class CommunityGetAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			CommunityDAO communitydao = new CommunityDAO(ConnectionProvider.getConnection());
			List<CommunityBean> community = communitydao.get();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(community));
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
