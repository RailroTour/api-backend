package user.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;
import user.action.UserAddAction;
import user.action.UserDeleteAction;
import user.action.UserGetAction;
import user.action.UserPutAction;

@WebServlet("/api/user/*")
public class UserController extends HttpServlet {
	Action action;
	//get, put
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getServletPath();
		request.setCharacterEncoding("utf-8");
		if (servletpath == "/api/user/get") {
			action = new UserGetAction();
			System.out.println("get");
		} else if (servletpath == "/api/user/put") {
			// 파일 경로 저장.
			ServletContext context = getServletContext(); // 어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨.
			String saveDir = context.getRealPath(""); // 절대경로를 가져옴
			int maxsize = 3 * 1024 * 1024;// 3MB
			String encoding = "utf-8";
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxsize, encoding,
					new DefaultFileRenamePolicy());
			System.out.println("절대경로 >> " + saveDir);
			String file = multi.getFilesystemName("profile_img");
			request.setAttribute("profile_img", saveDir + file);
			//
			action = new UserPutAction();
			System.out.println("put");
		}
		action.execute(request, response);
	}
	//post, delete
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getServletPath();
		request.setCharacterEncoding("utf-8");
		if (servletpath == "/api/user/post") {
			action = new UserAddAction();
			System.out.println("post");
		}
		else if(servletpath == "/api/user/delete") {
			action = new UserDeleteAction();
			System.out.println("delete");
		}
		action.execute(request, response);
	}

}
