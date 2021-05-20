package endpoint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import tripcart.action.TripCartAddAction;
import tripcart.action.TripCartDeleteAction;
import tripcart.action.TripCartGetAction;
import tripcart.action.TripCartPutAction;

@WebServlet("/api/review")
public class ReviewController extends HttpServlet{
	
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new ReviewGetAction();
		action.execute(request, response);
		System.out.println("get");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new ReviewAddAction();
		action.execute(request, response);
		System.out.println("post");
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new ReviewDeleteAction();
		action.execute(request, response);
		System.out.println("delete");
	}
}
