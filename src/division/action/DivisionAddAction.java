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


public class DivisionAddAction implements Action {
	
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		
		
		try {
			if(name == null) {
				response.sendError(400, "name required");
				return;
			}
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DivisionBean division = new DivisionBean(id,name);
		try {
			DivisionDAO divisionadd = new DivisionDAO(ConnectionProvider.getConnection());
			
			divisionadd.insert(division);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(division));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}


	

}
