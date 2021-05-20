package tripcart.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import tripcart.dao.TripCartDAO;
import tripcart.dto.TripCartBean;


public class TripCartDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String contentid = request.getParameter("contentid");
		System.out.println(request.getParameter("contentid"));
		try {
			if(contentid == null) {
				response.sendError(400, "contentid required");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			TripCartDAO tripcartdao = new TripCartDAO(ConnectionProvider.getConnection());
			tripcartdao.delete(Integer.parseInt(contentid), email);
			
			response.setStatus(204);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
