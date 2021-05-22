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
import planner.action.Planner3AddAction;
import planner.action.Planner3DeleteAction;
import planner.action.Planner3GetAction;


@WebServlet("/api/planner3/*")
public class Planner3Controller extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/planner3/get")) {
			action = new Planner3GetAction();
			System.out.println("planner3 get");
		}
		action.execute(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/planner3/post")) {
			action = new Planner3AddAction();
			System.out.println("planner3 post");
		}
		else if(servletpath.equals("/api-backend/api/planner3/delete")) {
			action = new Planner3DeleteAction();
			System.out.println("planner3 delete");
		}
		action.execute(request, response);
	}
}
