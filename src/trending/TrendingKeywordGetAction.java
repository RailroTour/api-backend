package trending;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONArray;
import org.json.JSONObject;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

public class TrendingKeywordGetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			TrendingKeywordDAO trendingkeywordDAO = new TrendingKeywordDAO(ConnectionProvider.getConnection());
			List<TrendingKeywordBean> keyword_list = trendingkeywordDAO.list();
			
//			JSONObject obj = new JSONObject();
//			JSONArray jArray = new JSONArray();
//			for(int i=0; i<keyword_list.size(); i++) {
//				jArray.put(JsonConverter.objectToJson(keyword_list.get(i)));
//			}
//			System.out.println(jArray);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(keyword_list));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
