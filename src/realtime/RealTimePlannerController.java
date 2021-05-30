package realtime;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import planner.action.MyPlannerGetAction;

@WebServlet("/api/realtimeplanner/*")
public class RealTimePlannerController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/realtimeplanner/get")) {
			action = new RealTimePlannerGetAction();
			System.out.println("realtimeplanner get");
		}
		action.execute(request, response);
	}
}
