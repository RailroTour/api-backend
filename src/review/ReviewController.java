package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import planner.action.MyPlannerGetAction;
import tripcart.action.TripCartAddAction;
import tripcart.action.TripCartDeleteAction;
import tripcart.action.TripCartGetAction;
import tripcart.action.TripCartPutAction;

@WebServlet("/api/review/*")
public class ReviewController extends HttpServlet{
	
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/review/get")) {
			action = new ReviewGetAction();
			System.out.println("review get");
		}
		action.execute(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/review/post")) {
			action = new ReviewAddAction();
			System.out.println("review post");
		}
		else if(servletpath.equals("/api-backend/api/review/put")) {
			action = new ReviewDeleteAction();
			System.out.println("review delete");
		}
		action.execute(request, response);
	}

}
