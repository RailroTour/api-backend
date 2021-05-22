package planner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import planner.action.PlannerAddAction;
import planner.action.PlannerDeleteAction;
import planner.action.PlannerGetAction;
import planner.action.PlannerPutAction;
import planner.action.SigunguGetAction;

@WebServlet("/api/sigungu/*")
public class SigunguController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/sigungu/get")) {
			action = new SigunguGetAction();
			System.out.println("sigungu get");
		}
		//사용할일 없음
//		else if(servletpath.equals("/api-backend/api/sigungu/put")) {
//			action = new PlannerPutAction();
//			System.out.println("sigungu put");
//		}
		action.execute(request, response);
	}
	//사용할일 없음
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String servletpath = request.getRequestURI();
//		if(servletpath.equals("/api-backend/api/sigungu/post")) {
//			action = new PlannerAddAction();
//			System.out.println("sigungu post");
//		}
//		else if(servletpath.equals("/api-backend/api/sigungu/delete")) {
//			action = new PlannerDeleteAction();
//			System.out.println("sigungu delete");
//		}
//		action.execute(request, response);
//	}
}
