package top100;

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

public class Top100PlannerGetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pageNo = request.getParameter("pageNo");
		
		try {
			if(pageNo == null) {
				response.sendError(400, "pageNo required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<MyPlannerBean> planner = null;
		try {
			Top100DAO dao = new Top100DAO(ConnectionProvider.getConnection());
			planner = dao.getPlanner(Integer.parseInt(pageNo));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(planner));
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
