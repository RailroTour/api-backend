package review;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.oreilly.servlet.MultipartRequest;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;


public class ReviewAddAction implements Action{
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		 
		
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		//System.out.print(email);
		
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
		File dir = new File("C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\review\\");
		// 디렉토리들이 있는지 확인
		if(dir.isDirectory()){//디렉토리가 있으면
			try {
				multi=new MultipartRequest(request, "C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\review\\", max, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{//디렉토리가 없으면
			dir.mkdirs();
			try {
				multi=new MultipartRequest(request, "C:\\Users\\carto\\Documents\\GitHub\\api-backend\\WebContent\\upload_images\\review\\", max, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ReviewBean review = new ReviewBean();
		for(int i=0; i<5; i++) {
			if(multi.getFilesystemName("file"+i)!=null) {
				System.out.println(multi.getFilesystemName("file"+i));
				review.getImg_paths().add("./upload_images/review/"+multi.getFilesystemName("file"+i));
			}
			else {
				break;
			}
		}
		review.setContent(multi.getParameter("contents"));
		
		String[] tags = multi.getParameter("tags").split(",");
		for(int i=0; i<tags.length; i++){
			review.getTags().add(tags[i]);
		}
		
		review.setLike(Integer.parseInt(multi.getParameter("like")));
		review.setContent_id(Integer.parseInt(multi.getParameter("contentid")));
		review.setContent_type_id(Integer.parseInt(multi.getParameter("contenttypeid")));
		
		try {
			ReviewDAO dao = new ReviewDAO(ConnectionProvider.getConnection());
			review.setId(dao.insert(review, email)); //기본 정보 추가
			
			for(int i=0; i<review.getTags().size(); i++) { //태그 추가
				dao.insertTags(review.getId(), review.getTags().get(i));
			}
			
			for(int i=0; i<review.getImg_paths().size(); i++) { //이미지 추가
				dao.insertImgs(review.getId(), review.getImg_paths().get(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(review));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}



