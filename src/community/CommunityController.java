package community;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;




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
			
			/*ServletContext context = getServletContext(); //어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨. 
			String saveDir = context.getRealPath("community_img"); //절대경로를 가져옴
			int maxsize = 3 * 1024 * 1024;// 3MB
			String encoding = "utf-8";
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxsize, encoding,
					new DefaultFileRenamePolicy());
			
			String file = multi.getFilesystemName("community_img");
			System.out.println("파일이름 나 : "+file);
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			 
	          System.out.println(content);
	          System.out.println(title);*/
			action = new CommunityAddAction();
			System.out.println("post");
			action.execute(request, response);
			
		} else if (servletpath.equals("/api-backend/api/community/put")) {
			action = new CommunityPutAction();
			System.out.println("put");
			action.execute(request, response);
			
		}
		
		
		
	}
	
}
