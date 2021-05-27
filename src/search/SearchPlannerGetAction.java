package search;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import planner.dto.MyPlannerBean;

public class SearchPlannerGetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String keyword = request.getParameter("keyword");
		String pageNo = request.getParameter("pageNo");
		try {
			if(keyword == null) {
				response.sendError(400, "keyword required");
				return;
			}
			else if(pageNo == null) {
				response.sendError(400, "keyword required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<MyPlannerBean> list = null;
		try {
			SearchPlannerDAO dao = new SearchPlannerDAO(ConnectionProvider.getConnection());
			list = dao.list(keyword, (Integer.parseInt(pageNo)-1)*9);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(list));
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
	}

}
