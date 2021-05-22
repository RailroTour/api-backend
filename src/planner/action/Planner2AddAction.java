package planner.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import planner.dao.Planner2DAO;
import planner.dto.Planner2Bean;

public class Planner2AddAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		
		String planner_id = request.getParameter("planner_id");
		String visit_day = request.getParameter("visit_day");
		String sigungu_id = request.getParameter("sigungu_id");
		try {
			if(email == null) {
				response.sendError(400, "Login required");
				return;
			}
			else if(planner_id == null) {
				response.sendError(400, "planner_id required");
				return;
			}
			else if(visit_day == null) {
				response.sendError(400, "visit_day required");
				return;
			}
			else if(sigungu_id == null) {
				response.sendError(400, "sigungu_id required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Planner2Bean planner2 = new Planner2Bean(Integer.parseInt(planner_id), Integer.parseInt(visit_day), Integer.parseInt(sigungu_id));
		Planner2DAO dao = null;
		try {
			dao = new Planner2DAO(ConnectionProvider.getConnection());
			planner2.setId(dao.insert(planner2));
			try {
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(JsonConverter.objectToJson(planner2));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
