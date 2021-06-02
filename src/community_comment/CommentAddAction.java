package community_comment;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;



public class CommentAddAction implements Action{
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		// System.out.print(email);


		//email = "cartoonpoet@naver.com";

		
	
		
		String board_id= request.getParameter("board_id");
		String content = request.getParameter("content");
		try {
			if (email == null) {
				response.sendError(400, "Login required");
				return;
			}
			else if (content == null) {
				response.sendError(400, "content required");
				return;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		CommentBean comment =null;
		
		comment = new CommentBean(Integer.parseInt(board_id),content);
		
		
	
		try {
			CommentDAO commentadd = new CommentDAO(ConnectionProvider.getConnection());

			commentadd.insert(comment, email);
			response.setStatus(204);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(comment));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}

}
