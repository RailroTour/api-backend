package search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;


@WebServlet("/api/searchPlannerCount/*")
public class SearchPlannerCountController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/searchPlannerCount/get")) {
			action = new SearchPlannerCountGetAction();
			System.out.println("searchPlannerCount get");
		}

		action.execute(request, response);
	}
}
