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
//get, put
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		if (servletpath.equals("api-backend/api/user/get")) {
		action = new PlannerGetAction();
		
		System.out.println("get");
		}
		else if (servletpath.equals("api-backend/api/user/put")) {
			action = new PlannerPutAction();
			System.out.println("put");
		}
		
		action.execute(request, response);
	}
	//post, delete
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		if (servletpath.equals("api-backend/api/user/post")) {
		action = new PlannerAddAction();
		System.out.println("post");
		}
		else if (servletpath.equals("api-backend/api/user/delete")) {
			action = new PlannerDeleteAction();
			System.out.println("delete");
		}
		action.execute(request, response);
	}
	


}
