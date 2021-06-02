package community;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

public class CommunityAddAction implements Action {
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		// System.out.print(email);


		//email = "thals8744@naver.com";

		int max = 1024 * 1024 * 10;
		MultipartRequest multi = null;
		File dir = new File("C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\community\\");
		// 디렉토리들이 있는지 확인
		if (dir.isDirectory()) {// 디렉토리가 있으면
			try {
				multi = new MultipartRequest(request,
						"C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\community\\", max,
						"UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {// 디렉토리가 없으면
			dir.mkdirs();
			try {
				multi = new MultipartRequest(request,
						"C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\community\\", max,
						"UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		try {
			if (email == null) {
				response.sendError(400, "Login required");
				return;
			}

			else if (title == null) {
				response.sendError(400, "title required");
				return;
			} else if (content == null) {
				response.sendError(400, "content required");
				return;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		CommunityBean community =null;
		if(multi.getFilesystemName("community_img")==null) {
			community = new CommunityBean(title,content);
		}
		else {
			String community_img = "./upload_images/community/" + multi.getFilesystemName("community_img");
			System.out.println(community_img);
			community = new CommunityBean(title,content,community_img);
		}

	
		try {
			CommunityDAO communityadd = new CommunityDAO(ConnectionProvider.getConnection());

			communityadd.insert(community, email);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(community));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}

}
