package top100;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import review.ReviewRatioGetAction;


@WebServlet("/api/top100/*")
public class Top100Controller extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/top100/get")) {
			action = new Top100GetAction();
			System.out.println("reviewRatio get");
		}
		action.execute(request, response);
	}
}
