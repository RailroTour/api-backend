package planner.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import planner.dao.Planner3DAO;
import planner.dto.Planner3Bean;

public class Planner3GetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		
		String planner_area_id = request.getParameter("planner_area_id");
		
		try {
			if(email == null) {
				response.sendError(400, "Login required");
				return;
			}
			else if(planner_area_id == null) {
				response.sendError(400, "planner_area_id required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Planner3DAO planner3dao = null;
		List<Planner3Bean> planner3 = null;
		try {
			planner3dao = new Planner3DAO(ConnectionProvider.getConnection());
			planner3 = planner3dao.list(Integer.parseInt(planner_area_id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(planner3));
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
