package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import user.action.UserAddAction;
import user.action.UserDeleteAction;
import user.action.UserGetAction;
import user.action.UserPutAction;

@WebServlet("/api/user")
public class UserController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new UserGetAction();
		action.execute(request, response);
		System.out.println("user get");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new UserAddAction();
		action.execute(request, response);
		System.out.println("user post");
	}
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new UserPutAction();
		action.execute(request, response);
		System.out.println("user put");
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new UserDeleteAction();
		action.execute(request, response);
		System.out.println("user delete");
	}
}
