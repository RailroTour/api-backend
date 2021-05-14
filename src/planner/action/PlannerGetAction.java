package planner.action;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

import planner.dao.PlannerDAO;
import planner.dto.PlannerBean;
import tripcart.dao.TripCartDAO;
import tripcart.dto.TripCartBean;

public class PlannerGetAction implements Action{
	
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
			PlannerDAO plannerdao = new PlannerDAO(ConnectionProvider.getConnection());
			PlannerBean planner = plannerdao.get(Integer.parseInt(id));
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(planner));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
