package planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import planner.dto.MyPlannerBean;
import planner.dto.Planner2JoinBean;

public class MyPlannerDAO {
	private Connection conn = null;
	
	public MyPlannerDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<MyPlannerBean> list(String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyPlannerBean> list = new ArrayList<MyPlannerBean>();
		try {
			String sql = "select user.id as user_id, \r\n"
					+ "user.nickname, \r\n"
					+ "planner.id as planner_id, \r\n"
					+ "planner.title, \r\n"
					+ "planner.days, \r\n"
					+ "planner.tema_id, \r\n"
					+ "tema.name as tema_name, \r\n"
					+ "planner.img_path, \r\n"
					+ "planner.start_day, planner.view, \r\n"
					+ "GROUP_CONCAT(sigungu_code.sigungu_name order by planner_area.visit_day asc SEPARATOR '-') AS trip_course \r\n"
					+ "from user \r\n"
					+ "inner join planner on user.id = planner.user_id \r\n"
					+ "inner join tema on planner.tema_id = tema.id \r\n"
					+ "inner join planner_area on planner.id = planner_area.planner_id \r\n"
					+ "left outer join sigungu_code on planner_area.sigungu_id = sigungu_code.id\r\n"
					+ "where user.email = ? group by planner.id order by planner.register_date desc;\r\n";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new MyPlannerBean(
					rs.getInt("user_id"),
					rs.getString("nickname"),
					rs.getInt("planner_id"),
					rs.getString("title"),
					rs.getInt("days"),
					rs.getInt("tema_id"),
					rs.getString("tema_name"),
					rs.getString("img_path"),
					rs.getString("start_day"),
					rs.getString("trip_course"),
					rs.getInt("view")
				));
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
