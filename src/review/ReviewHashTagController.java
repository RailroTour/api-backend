package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;


@WebServlet("/api/review/hashtag")
public class ReviewHashTagController extends HttpServlet{
	
	Action action;
	//get
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		if(servletpath.equals("/api-backend/api/review/hashtag/get")) {
			action = new ReviewHashTagGetAction();
			System.out.println("get");
		}
		
		action.execute(request, response);
		
	}
	//post, delete
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		if(servletpath.equals("/api-backend/api/review/hashtag/post")) {
			action = new ReviewHashTagAddAction();
			System.out.println("post");
		}
		else if(servletpath.equals("/api-backend/api/review/hashtag/delete")) {
			action = new ReviewHashTagDeleteAction();
			System.out.println("delete");
		}
		action.execute(request, response);
		
	}
	
}
