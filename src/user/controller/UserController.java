package user.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;
import user.action.UserAddAction;
import user.action.UserDeleteAction;
import user.action.UserGetAction;
import user.action.UserPutAction;

@WebServlet("/api/user")
public class UserController extends HttpServlet {
	Action action;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = new UserGetAction();
		action.execute(request, response);
		System.out.println("user get");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 파일 경로 저장.
		ServletContext context = getServletContext(); // 어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨.
		String saveDir = context.getRealPath(""); // 절대경로를 가져옴
		int maxsize = 3 * 1024 * 1024;// 3MB
		String encoding = "euc-kr";
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxsize, encoding,
				new DefaultFileRenamePolicy());
		System.out.println("절대경로 >> " + saveDir);
		String file = multi.getFilesystemName("profile_img");
		System.out.println("whole path: "+saveDir +file);
		request.setAttribute("profile_img", saveDir + file);
		//
		action = new UserAddAction();
		action.execute(request, response);
		System.out.println("user post");
	}

	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");


		// 파일 경로 저장.
		ServletContext context = getServletContext(); // 어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨.
		String saveDir = context.getRealPath(""); // 절대경로를 가져옴
		int maxsize = 3 * 1024 * 1024;// 3MB
		String encoding = "euc-kr";
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxsize, encoding,
				new DefaultFileRenamePolicy());
		System.out.println("절대경로 >> " + saveDir);
		String file = multi.getFilesystemName("profile_img");
		request.setAttribute("profile_img", saveDir + file);
		//

		action = new UserPutAction();
		action.execute(request, response);
		
	}

	public void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("user delete");
		action = new UserDeleteAction();
		action.execute(request, response);
	}
}
