package planner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import planner.action.PlannerGetAction;
import planner.action.PlannerInfoGetAction;
import planner.action.PlannerPutAction;


@WebServlet("/api/plannerinfo/*")
public class PlannerInfoController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/plannerinfo/get")) {
			action = new PlannerInfoGetAction();
			System.out.println("plannerinfo get");
		}

		action.execute(request, response);
	}
}
