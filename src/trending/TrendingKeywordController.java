package trending;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import division.action.DivisionAddAction;
import division.action.DivisionDeleteAction;
import division.action.DivisionGetAction;
import division.action.DivsionPutAction;
import oauth.action.OauthLoginAction;
import oauth.action.OauthLogoutAction;


@WebServlet("/trending/keyword")
public class TrendingKeywordController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("get");
		action = new TrendingKeywordGetAction();
		action.execute(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("post");
		action = new TrendingKeywordAddAction();
		action.execute(request, response);
		
	}
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	}
}
