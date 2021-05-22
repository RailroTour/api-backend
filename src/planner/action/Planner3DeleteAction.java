package planner.action;

import java.io.IOException;
import java.sql.SQLException;

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

public class Planner3DeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		
		String planner_area_id = request.getParameter("planner_area_id");
		String order_num = request.getParameter("order_num");
		String content_id = request.getParameter("content_id");
		String content_type_id = request.getParameter("content_type_id");
		try {
			if(email == null) {
				response.sendError(400, "Login required");
				return;
			}
			else if(planner_area_id == null) {
				response.sendError(400, "planner_area_id required");
				return;
			}
			else if(order_num == null) {
				response.sendError(400, "order_num required");
				return;
			}
			else if(content_id == null) {
				response.sendError(400, "content_id required");
				return;
			}
			else if(content_type_id == null) {
				response.sendError(400, "content_type_id required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Planner3DAO planner3dao = null;
		Planner3Bean data = new Planner3Bean(
				Integer.parseInt(planner_area_id), 
				Integer.parseInt(order_num), 
				Integer.parseInt(content_id), 
				Integer.parseInt(content_type_id)
		);
		try {
			planner3dao = new Planner3DAO(ConnectionProvider.getConnection());
			planner3dao.delete(data);
			planner3dao.order_sort(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(data));
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
