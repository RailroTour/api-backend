package review;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
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
		String contentid = request.getParameter("contentid");
		String contenttypeid = request.getParameter("contenttypeid");

		try {
			ReviewDAO reviewdao = new ReviewDAO(ConnectionProvider.getConnection());
			
			List<ReviewBean> list = reviewdao.get(Integer.parseInt(contentid), Integer.parseInt(contenttypeid), email);
			
			for(int i=0; i<list.size(); i++) {
				list.get(i).setImg_paths(reviewdao.getImgs(Integer.parseInt(contentid), Integer.parseInt(contenttypeid), list.get(i).getId()));
			}
			
			for(int i=0; i<list.size(); i++) {
				list.get(i).setTags(reviewdao.getTags(Integer.parseInt(contentid), Integer.parseInt(contenttypeid), list.get(i).getId()));
			}
			

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(list));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
