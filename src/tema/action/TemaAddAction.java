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

public class TemaAddAction implements Action{
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		
		String name = request.getParameter("name");
		
		
		try {
			if(name == null) {
				response.sendError(400, "name required");
				return;
			}
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		TemaBean tema = new TemaBean(name);
		try {
			TemaDAO temaadd = new TemaDAO(ConnectionProvider.getConnection());
			
			temaadd.insert(tema);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(tema));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}


}
