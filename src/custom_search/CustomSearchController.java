package custom_search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import review.ReviewGetAction;

@WebServlet("/api/custom_search/*")
public class CustomSearchController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletpath = request.getRequestURI();
		if(servletpath.equals("/api-backend/api/custom_search/get")) {
			action = new CustomSearchGetAction();
			System.out.println("custom_search get");
		}
		action.execute(request, response);
	}
}
