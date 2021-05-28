package user.action;

import java.io.IOException;
import java.sql.SQLException;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import user.dao.UserDAO;
import user.dto.UserBean;

public class UserPutAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 세션 이메일 불러오기
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		try {
			UserDAO user = new UserDAO(ConnectionProvider.getConnection());
			UserBean userbean = user.get(email);
			// 파일 경로 저장.
			String saveFolder = "C:\\Users\\carto\\Documents\\GitHub\\api-backend/Webcontent/upload_images/profile/";
			int maxsize = 3 * 1024 * 1024;// 3MB
			String encoding = "utf-8";
			MultipartRequest multi = new MultipartRequest(request, saveFolder, maxsize, encoding,
					new DefaultFileRenamePolicy());

			String file = multi.getFilesystemName("profile_img");
			String nickname = multi.getParameter("nickname");
			String name = multi.getParameter("name");
			
			UserDAO dao = new UserDAO(ConnectionProvider.getConnection());
			if(file != null) {
				dao.update(name, nickname, "./upload_images/profile/"+file, email);
			}
			else {
				dao.nofile_update(name, nickname, email);
			}
			
			userbean = user.get(email);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(userbean));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
