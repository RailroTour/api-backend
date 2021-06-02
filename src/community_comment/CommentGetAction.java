package community_comment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;


public class CommentGetAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			CommentDAO commentdao = new CommentDAO(ConnectionProvider.getConnection());
			List<CommentBean> comment= commentdao.get();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(comment));
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}}

}
