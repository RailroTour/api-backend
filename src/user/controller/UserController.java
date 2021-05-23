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
		System.out.print(servletpath);
		request.setCharacterEncoding("utf-8");

		if (servletpath.equals("/api-backend/api/user/get")) {
			action = new UserGetAction();
			System.out.println("get");
		} else if (servletpath.equals("/api-backend/api/user/put")) {
			// 세션 이메일 불러오기
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			
			try {
				UserDAO user = new UserDAO(ConnectionProvider.getConnection());
				UserBean userbean = user.get(email);

				// 파일 경로 저장.
				String saveFolder = "C:\\Users\\carto\\Documents\\GitHub\\api-backend/Webcontent/profile_img/"
						+ userbean.username;
				int maxsize = 3 * 1024 * 1024;// 3MB
				String encoding = "utf-8";
				MultipartRequest multi = new MultipartRequest(request, saveFolder, maxsize, encoding,
						new DefaultFileRenamePolicy());
				System.out.println("절대경로 >> " + saveFolder);

				String file = multi.getFilesystemName("profile_img");
				request.setAttribute("profile_img", saveFolder + file);
			} catch (Exception e) {
				e.printStackTrace();
			}

			action = new UserPutAction();
			System.out.println("put");
		}
		action.execute(request, response);

	}

	// post, delete
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		if (servletpath.equals("/api-backend/api/user/post")) {

			action = new UserAddAction();
			System.out.println("post");
		} else if (servletpath.equals("/api-backend/api/user/delete")) {
			action = new UserDeleteAction();
			System.out.println("delete");
		}
		action.execute(request, response);

	}
}