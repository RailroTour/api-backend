package tripcart.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import tripcart.dao.TripCartDAO;
import tripcart.dto.TripCartBean;


public class TripCartGetAction implements Action {
	
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
			TripCartDAO tripcartdao = new TripCartDAO(ConnectionProvider.getConnection());
			TripCartBean tripcart = tripcartdao.get(Integer.parseInt(id));
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(tripcart));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
