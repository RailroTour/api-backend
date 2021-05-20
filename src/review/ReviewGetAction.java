package review;

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

public class ReviewGetAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		
		try {
			if(email == null) {
				response.sendError(400, "email required");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ReviewDAO reviewdao = new ReviewDAO(ConnectionProvider.getConnection());
			JSONArray review = reviewdao.get(email);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(review);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
