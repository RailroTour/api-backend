package community;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

public class CommunityPutAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int max = 1024 * 1024 * 10;
		MultipartRequest multi = null;
		String server_path = "/ggp02250/tomcat/webapps/api-backend/upload_images/community/";
		String dev_path = "C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\community\\";
		File dir = new File(server_path);
		// 디렉토리들이 있는지 확인
		if (dir.isDirectory()) {// 디렉토리가 있으면
			try {
				multi = new MultipartRequest(request,
						server_path, max,
						"UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {// 디렉토리가 없으면
			dir.mkdirs();
			try {
				multi = new MultipartRequest(request,
						server_path, max,
						"UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		String id = multi.getParameter("id");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		try {

			if (title == null) {
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
			community = new CommunityBean(Integer.parseInt(id),title,content);
		}
		else {
			String community_img = "./upload_images/community/" + multi.getFilesystemName("community_img");
			System.out.println(community_img);
			community = new CommunityBean(Integer.parseInt(id),title,content,community_img);
		}
		
		
		try {
			CommunityDAO communitydao = new CommunityDAO(ConnectionProvider.getConnection());
			
			communitydao.update(community);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(community));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
