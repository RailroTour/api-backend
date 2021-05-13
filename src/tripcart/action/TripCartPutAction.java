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


public class TripCartPutAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String user_id = request.getParameter("user_id");
		String division_id = request.getParameter("division_id");
		String serial_num = request.getParameter("serial_num");
		
		try {
			if(id == null) {
				response.sendError(400, "id required");
				return;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		TripCartBean tripcart = new TripCartBean(Integer.parseInt(id), Integer.parseInt(user_id), Integer.parseInt(division_id), Integer.parseInt(serial_num));
		try {
			TripCartDAO tripcartdao = new TripCartDAO(ConnectionProvider.getConnection());
			
			tripcartdao.update(tripcart);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(tripcart));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
