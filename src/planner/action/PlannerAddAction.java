package planner.action;


import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.print.attribute.standard.PagesPerMinute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;


import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import planner.dao.PlannerDAO;
import planner.dto.PlannerBean;



public class PlannerAddAction implements Action{
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");

		String title = request.getParameter("title");
		Boolean disclosure = Boolean.parseBoolean(request.getParameter("disclosure"));
		Integer days = Integer.parseInt(request.getParameter("days"));
		Integer tema_id = Integer.parseInt(request.getParameter("tema_id"));
		String img_path = request.getParameter("img_path");
		try {
			if(email == null) {
				response.sendError(400, "email from session required");
				return;
			}
			else if(title == null) {
				response.sendError(400, "title required");
				return;
			}
			else if(disclosure == null) {
				response.sendError(400, "disclosure required");
				return;
			}
			else if(days == null) {
				response.sendError(400, "days required");
				return;
			}
			else if(tema_id == null) {
				response.sendError(400, "tema_id required");
				return;
			}
			else if(img_path == null) {
				response.sendError(400, "img_path required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PlannerBean planner = new PlannerBean(title, disclosure, days, tema_id,img_path);
		try {
			PlannerDAO planneradd = new PlannerDAO(ConnectionProvider.getConnection());
			planneradd.insert(planner,email);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(planner));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
