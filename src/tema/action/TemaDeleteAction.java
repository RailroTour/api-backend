package tema.action;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

import tema.dao.TemaDAO;
import tema.dto.TemaBean;

public class TemaDeleteAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		try {
			if(id == null) {
				response.sendError(400, "id required");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			TemaDAO temadao = new TemaDAO(ConnectionProvider.getConnection());
			temadao.delete(Integer.parseInt(id));
			
			response.setStatus(404);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
