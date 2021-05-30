package RecommendPlanner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

public class RecommendPlannerGetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<RecommendPlannerBean> list= new ArrayList<RecommendPlannerBean>();
		try {
			RecommendPlannerDAO dao = new RecommendPlannerDAO(ConnectionProvider.getConnection());
			for(int i = 14; i<18; i++) {
				list = dao.list(list, i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
