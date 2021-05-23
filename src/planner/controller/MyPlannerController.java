package planner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import planner.action.MyPlannerGetAction;
import planner.action.Planner2GetAction;


@WebServlet("/api/myplanner/*")
public class MyPlannerController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/myplanner/get")) {
			action = new MyPlannerGetAction();
			System.out.println("myplanner get");
		}
//		else if(servletpath.equals("/api-backend/api/planner2/put")) {
//			action = new Planner2PutAction();
//			System.out.println("planner1 put");
//		}
		action.execute(request, response);
	}
}
