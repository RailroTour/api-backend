package custom_search;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import planner.dto.MyPlannerBean;

public class CustomSearchGetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String days = request.getParameter("days");
		String tema_id = request.getParameter("tema_id");
		
		try {
			if(days == null) {
				response.sendError(400, "days required");
				return;
			}
			else if(tema_id == null) {
				response.sendError(400, "tema_id required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<MyPlannerBean> list = null;
		try {
			CustomSearchDAO dao = new CustomSearchDAO(ConnectionProvider.getConnection());
			list = dao.list(Integer.parseInt(days), Integer.parseInt(tema_id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
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
