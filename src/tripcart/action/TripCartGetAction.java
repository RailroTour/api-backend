package tripcart.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import tripcart.dao.TripCartDAO;
import tripcart.dto.TripCartBean;


public class TripCartGetAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		
		try {
			if(email == null) {
				response.sendError(400, "id required");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			TripCartDAO tripcartdao = new TripCartDAO(ConnectionProvider.getConnection());
			JSONArray tripcart = tripcartdao.get(email);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(tripcart);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
