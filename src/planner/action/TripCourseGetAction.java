package planner.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import planner.dao.TripCourseDAO;
import planner.dto.TripCourseBean;

public class TripCourseGetAction implements Action{

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
		
		TripCourseDAO tripcoursedao = null;
		List<TripCourseBean> list = null;
		try {
			tripcoursedao = new TripCourseDAO(ConnectionProvider.getConnection());
			list = tripcoursedao.list(Integer.parseInt(planner_id));
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
