package planner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import planner.action.PlannerAddAction;
import planner.action.PlannerCoverImgUploadAction;
import planner.action.PlannerDeleteAction;

@WebServlet("/api/planner_coverimg/*")
public class PlannerCoverImgController extends HttpServlet{
	Action action;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/planner_coverimg/post")) {
			action = new PlannerCoverImgUploadAction();
			System.out.println("coverimg post");
		}

		action.execute(request, response);
	}
}
