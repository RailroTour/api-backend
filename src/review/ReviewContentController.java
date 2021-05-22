package review;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;

@WebServlet("/api/review/content")
public class ReviewContentController extends HttpServlet {
	Action action;

	// get, put(X)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");

		if (servletpath.equals("/api-backend/api/review/content/get")) {
			action = new ReviewGetAction();
			System.out.println("get");
		}
		action.execute(request, response);

	}

	// post, delete
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletpath = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		if (servletpath.equals("/api-backend/api/review/content/post")) {
			// 파일 경로 저장.
			ServletContext context = getServletContext(); // 어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨.
			String saveDir = context.getRealPath(""); // 절대경로를 가져옴
			int maxsize = 3 * 1024 * 1024;// 3MB
			String encoding = "utf-8";
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxsize, encoding,
					new DefaultFileRenamePolicy());
			System.out.println("절대경로 >> " + saveDir);
			String file = multi.getFilesystemName("image_path");
			request.setAttribute("image_path", saveDir + file);
			//
			action = new ReviewAddAction();
			System.out.println("post");
		} else if (servletpath.equals("/api-backend/api/review/content/delete")) {
			action = new ReviewDeleteAction();
			System.out.println("delete");
		}

		action.execute(request, response);

	}

}
