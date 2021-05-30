package top100;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;

@WebServlet("/api/top100Planner/*")
public class Top100PlannerController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/top100Planner/get")) {
			action = new Top100PlannerGetAction();
			System.out.println("top100Planner get");
		}
		action.execute(request, response);
	}
}
