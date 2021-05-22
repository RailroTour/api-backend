package planner.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;
import planner.dao.SigunguDAO;
import planner.dto.SigunguBean;

public class SigunguGetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		SigunguDAO sigungudao = null;
		List<SigunguBean> list = null;
		try {
			sigungudao = new SigunguDAO(ConnectionProvider.getConnection());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(email == null) {
			try {
				response.sendError(400, "Login required");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String area_code = request.getParameter("area_code");
		if(area_code == null) {
			try {
				response.sendError(400, "area_code required");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(area_code.equals("0")) { //전체 목록
			list = sigungudao.list();
		}
		else { // 특정 목록
			list = sigungudao.get(Integer.parseInt(area_code));
		}
		
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
