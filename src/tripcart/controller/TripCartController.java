package tripcart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import tripcart.action.*;


@WebServlet("/api/tripcart")
public class TripCartController extends HttpServlet{
	Action action;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new TripCartGetAction();
		action.execute(request, response);
		System.out.println("tripcart get");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new TripCartAddAction();
		action.execute(request, response);
		System.out.println("tripcart post");
	}
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new TripCartPutAction();
		action.execute(request, response);
		System.out.println("tripcart put");
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new TripCartDeleteAction();
		action.execute(request, response);
		System.out.println("tripcart delete");
	}

}
