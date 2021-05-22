package planner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import planner.action.Planner2AddAction;
import planner.action.Planner2GetAction;
import planner.action.PlannerAddAction;
import planner.action.PlannerDeleteAction;
import planner.action.PlannerGetAction;
import planner.action.PlannerPutAction;

@WebServlet("/api/planner2/*")
public class Planner2Controller extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/planner2/get")) {
			action = new Planner2GetAction();
			System.out.println("planner1 get");
		}
//		else if(servletpath.equals("/api-backend/api/planner2/put")) {
//			action = new Planner2PutAction();
//			System.out.println("planner1 put");
//		}
		action.execute(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/planner2/post")) {
			action = new Planner2AddAction();
			System.out.println("planner2 post");
		}
//		else if(servletpath.equals("/api-backend/api/planner2/delete")) {
//			action = new Planner2DeleteAction();
//			System.out.println("planner1 delete");
//		}
		action.execute(request, response);
	}
}
