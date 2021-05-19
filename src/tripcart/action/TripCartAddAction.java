package tripcart.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;


import common.Action;
import common.ConnectionProvider;
import common.JsonConverter;

import tripcart.dao.*;
import tripcart.dto.*;



public class TripCartAddAction implements Action {
	@SuppressWarnings("unused")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		 
		
		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("email");
		//System.out.print(email);
		
		Integer division_id = Integer.parseInt(request.getParameter("division_id"));
		Integer serial_num = Integer.parseInt(request.getParameter("serial_num"));
		
		try {
			
			if(division_id == null) {
				response.sendError(400, "division_id required");
				return;
			}
			else if(email == null) {
				response.sendError(400, "email from session required");
				return;
			}
			else if(serial_num == null) {
				response.sendError(400, "serial_num required");
				return;
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		TripCartBean tripcart = new TripCartBean(division_id, serial_num);
		try {
			TripCartDAO tripcartadd = new TripCartDAO(ConnectionProvider.getConnection());
			
			tripcartadd.insert(tripcart,email);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JsonConverter.objectToJson(tripcart));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}


}
