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


public class PlannerPutAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String user_id = request.getParameter("user_id");
		String title = request.getParameter("title");
		String disclosure = request.getParameter("disclosure");
		String days = request.getParameter("days");
		String tema_id = request.getParameter("tema_id");
		String img_path = request.getParameter("img_path");
		
		
		try {
			if(id == null) {
				response.sendError(400, "id required");
				return;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PlannerBean planner = new PlannerBean(Integer.parseInt(id), Integer.parseInt(user_id), title, Boolean.parseBoolean(disclosure),Integer.parseInt(days),Integer.parseInt(tema_id),img_path);
		try {
			PlannerDAO plannerdao = new PlannerDAO(ConnectionProvider.getConnection());
			
			plannerdao.update(planner);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(planner));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
