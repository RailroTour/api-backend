package top100;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import review.ReviewDAO;

public class Top100GetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String contenttypeid = request.getParameter("contenttypeid");
		String pageNo = request.getParameter("pageNo");
		
		try {
			if(contenttypeid == null) {
				response.sendError(400, "contenttypeid required");
				return;
			}
			else if(pageNo == null) {
				response.sendError(400, "pageNo required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Top100Bean> list = null;
		try {
			Top100DAO dao = new Top100DAO(ConnectionProvider.getConnection());
			list = dao.getList(Integer.parseInt(contenttypeid), Integer.parseInt(pageNo));
			
			for(int i=0; i<list.size(); i++) {
				list.get(i).setTags(dao.getTags(list.get(i).getContenttypeid(), list.get(i).getContentid()));
			}
			
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
