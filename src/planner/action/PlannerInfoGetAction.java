package planner.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import planner.dao.PlannerInfoDAO;
import planner.dto.PlannerInfoBean;

public class PlannerInfoGetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String planner_id = request.getParameter("planner_id");
		
		try {
			if(planner_id == null) {
				response.sendError(400, "planner_id required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PlannerInfoDAO plannerinfo = null;
		PlannerInfoBean data = null;
		try {
			plannerinfo = new PlannerInfoDAO(ConnectionProvider.getConnection());
			data = plannerinfo.get(Integer.parseInt(planner_id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(data));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
