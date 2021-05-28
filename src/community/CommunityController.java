package community;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;
import common.ConnectionProvider;
import user.dao.UserDAO;
import user.dto.UserBean;


@WebServlet("/api/community/*")
public class CommunityController extends HttpServlet{
	
	Action action;
	//get,delete
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		
		if (servletpath.equals("/api-backend/api/community/get")) {
			action = new CommunityGetAction();
			System.out.println("get");
		} else if (servletpath.equals("/api-backend/api/community/delete")) {
			action = new CommunityDeleteAction();
			System.out.println("delete");
		}
		
		action.execute(request, response);
		
	}
	//post, put
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		
		if (servletpath.equals("/api-backend/api/community/post")) {
			
			ServletContext context = getServletContext(); //어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨. 
			String saveDir = context.getRealPath("community_img"); //절대경로를 가져옴
			int maxsize = 3 * 1024 * 1024;// 3MB
			String encoding = "utf-8";
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxsize, encoding,
					new DefaultFileRenamePolicy());
			
			String file = multi.getFilesystemName("profile_img");
			System.out.println("파일이름 : "+file);
			 String fileName = request.getParameter("community_img");
			 String title = request.getParameter("title");
	          System.out.println(fileName);
	          System.out.println(title);
			action = new CommunityAddAction();
			System.out.println("post");
		} else if (servletpath.equals("/api-backend/api/community/put")) {
			action = new CommunityPutAction();
			System.out.println("put");
		}
		
		action.execute(request, response);
		
	}
	
}
