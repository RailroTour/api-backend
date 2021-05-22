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
import planner.dao.Planner2DAO;
import planner.dto.Planner2JoinBean;

public class Planner2GetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		
		String planner_id = request.getParameter("planner_id");
		try {
			if(email == null) {
				response.sendError(400, "Login required");
				return;
			}
			else if(planner_id == null) {
				response.sendError(400, "planner_id required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Planner2JoinBean> list = null;
		Planner2DAO dao = null;
		try {
			dao = new Planner2DAO(ConnectionProvider.getConnection());
			list = dao.list(Integer.parseInt(planner_id));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
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
