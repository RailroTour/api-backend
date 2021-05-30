package RecommendPlanner;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import realtime.RealTimePlannerGetAction;

@WebServlet("/api/recommendplanner/*")
public class RecommendPlannerController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/recommendplanner/get")) {
			action = new RecommendPlannerGetAction();
			System.out.println("recommendplanner get");
		}
		action.execute(request, response);
	}
}
