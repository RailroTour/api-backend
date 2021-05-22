package tema.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

import tema.dao.TemaDAO;
import tema.dto.TemaBean;

public class TemaGetAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			TemaDAO temadao = new TemaDAO(ConnectionProvider.getConnection());
			List<TemaBean> tema = temadao.get();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(tema));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}


}
