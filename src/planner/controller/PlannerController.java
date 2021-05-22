package planner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import planner.action.*;



@WebServlet("/api/planner/*")
public class PlannerController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/planner/get")) {
			action = new PlannerGetAction();
			System.out.println("planner1 get");
		}
		else if(servletpath.equals("/api-backend/api/planner/put")) {
			action = new PlannerPutAction();
			System.out.println("planner1 put");
		}
		action.execute(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/planner/post")) {
			action = new PlannerAddAction();
			System.out.println("planner1 post");
		}
		else if(servletpath.equals("/api-backend/api/planner/delete")) {
			action = new PlannerDeleteAction();
			System.out.println("planner1 delete");
		}
		action.execute(request, response);
	}
//	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		action = new PlannerPutAction();
//		action.execute(request, response);
//		System.out.println("put");
//	}
//	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		action = new PlannerDeleteAction();
//		action.execute(request, response);
//		System.out.println("delete");
//	}


}
