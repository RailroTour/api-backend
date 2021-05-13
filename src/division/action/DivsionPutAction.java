package division.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

import division.dao.DivisionDAO;
import division.dto.DivisionBean;


public class DivsionPutAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		try {
			if(id == null) {
				response.sendError(400, "id required");
				return;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DivisionBean division = new DivisionBean(Integer.parseInt(id), name);
		try {
			DivisionDAO divisiondao = new DivisionDAO(ConnectionProvider.getConnection());
			
			divisiondao.update(division);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(division));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
