package review;

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

public class WordCloudGetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String contentid = request.getParameter("contentid");
		String contenttypeid = request.getParameter("contenttypeid");
		
		try {
			if(contentid == null) {
				response.sendError(400, "contentid required");
				return;
			}
			else if(contenttypeid == null) {
				response.sendError(400, "contenttypeid required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<WordCloudBean> data = null;
		try {
			WordCloudDAO dao = new WordCloudDAO(ConnectionProvider.getConnection());
			data = dao.getWordCloud(Integer.parseInt(contentid), Integer.parseInt(contenttypeid));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(data));
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
