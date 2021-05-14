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



@WebServlet("/api/planner")
public class PlannerController extends HttpServlet{
	
Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new PlannerGetAction();
		action.execute(request, response);
		System.out.println("get");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new PlannerAddAction();
		action.execute(request, response);
		System.out.println("post");
	}
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new PlannerPutAction();
		action.execute(request, response);
		System.out.println("put");
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new PlannerDeleteAction();
		action.execute(request, response);
		System.out.println("delete");
	}


}
