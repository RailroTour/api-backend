package oauth.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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


@WebServlet("/oauth/login")
public class OauthController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new OauthLogoutAction();
		action.execute(request, response);
		response.sendRedirect("../index.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("post");
		action = new OauthLoginAction();
		action.execute(request, response);
		
	}
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("DELETE");
		action = new OauthLogoutAction();
		action.execute(request, response);
	}
}
