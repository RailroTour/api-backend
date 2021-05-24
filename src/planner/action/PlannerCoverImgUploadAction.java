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

		
	
		File dir = new File("C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\planner\\");
		// 디렉토리들이 있는지 확인
		if(dir.isDirectory()){//디렉토리가 있으면
			try {
				multi=new MultipartRequest(request, "C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\planner\\", max, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{//디렉토리가 없으면
			dir.mkdirs();
			try {
				multi=new MultipartRequest(request, "C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\planner\\", max, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String sysName=multi.getFilesystemName("save"); //이미지 이름
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
