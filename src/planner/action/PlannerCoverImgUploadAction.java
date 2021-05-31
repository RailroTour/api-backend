package planner.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import common.Action;
import common.ConnectionProvider;
import planner.dao.PlannerCoverImgDAO;

public class PlannerCoverImgUploadAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");

		try {
			if(email == null) {
				response.sendError(400, "Login required");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		int max=1024*1024*10;
		MultipartRequest multi = null;
		String path = "C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\planner\\";
		String server_path = "/ggp02250/tomcat/webapps/ROOT/WebContent/upload_images/planner/";
		File dir = new File(path);
		// �뵒�젆�넗由щ뱾�씠 �엳�뒗吏� �솗�씤
		if(dir.isDirectory()){//�뵒�젆�넗由ш� �엳�쑝硫�
			try {
				multi=new MultipartRequest(request, path, max, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{//�뵒�젆�넗由ш� �뾾�쑝硫�
			dir.mkdirs();
			try {
				multi=new MultipartRequest(request, path, max, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String sysName=multi.getFilesystemName("save"); //�씠誘몄� �씠由�
		String planner_id=multi.getParameter("planner_id");
		
		try {
			PlannerCoverImgDAO cover_img_update = new PlannerCoverImgDAO(ConnectionProvider.getConnection());
			int cnt = cover_img_update.update(Integer.parseInt(planner_id), "./upload_images/planner/"+sysName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
