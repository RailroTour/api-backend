package review;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

public class ReviewHashTagAddAction implements Action {
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Integer review_id = Integer.parseInt(request.getParameter("review_id"));
		String hashtag = request.getParameter("hashtag");

		try {

			if (review_id == null) {
				response.sendError(400, "review_id required");
				return;
			} else if (hashtag == null) {
				response.sendError(400, "hashtag required");
				return;
			} 

		} catch (IOException e) {
			e.printStackTrace();
		}
		ReviewHashTagBean review_hashtag = new ReviewHashTagBean(review_id, hashtag);
		try {
			ReviewHashTagDAO hashtagadd = new ReviewHashTagDAO(ConnectionProvider.getConnection());
			
			hashtagadd.insert(review_hashtag);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(review_hashtag));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
