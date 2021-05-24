package oauth.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import oauth.action.PlannerAuthAction;
import planner.action.MyPlannerGetAction;


@WebServlet("/api/planneroauth/*")
public class PlannerAuthController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/planneroauth/get")) {
			action = new PlannerAuthAction();
			System.out.println("planneroauth get");
		}

		action.execute(request, response);
	}
}
