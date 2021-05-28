package user.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.apache.catalina.startup.UserDatabase;
import org.apache.jasper.tagplugins.jstl.core.If;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;
import common.ConnectionProvider;
import user.action.UserAddAction;
import user.action.UserDeleteAction;
import user.action.UserGetAction;
import user.action.UserPutAction;
import user.dao.UserDAO;
import user.dto.UserBean;

import javax.servlet.http.HttpSession;

@WebServlet("/api/user/*")
public class UserController extends HttpServlet {
	Action action;

	// get, put
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");

		if (servletpath.equals("/api-backend/api/user/get")) {
			action = new UserGetAction();
			System.out.println("user get");
		} 
		action.execute(request, response);

	}

	// post, delete
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");

		if (servletpath.equals("/api-backend/api/user/post")) {

			action = new UserAddAction();
			System.out.println("user post");
		} else if (servletpath.equals("/api-backend/api/user/delete")) {

			action = new UserDeleteAction();
			System.out.println("user delete");
		} else if (servletpath.equals("/api-backend/api/user/put")) {
			action = new UserPutAction();
			System.out.println("user put");
		}
		action.execute(request, response);

	}

}
