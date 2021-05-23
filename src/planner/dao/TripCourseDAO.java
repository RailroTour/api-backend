package planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import planner.dto.SigunguBean;
import planner.dto.TripCourseBean;

public class TripCourseDAO {
	private Connection conn = null;
	
	public TripCourseDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<TripCourseBean> list(int planner_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TripCourseBean> list = new ArrayList<TripCourseBean>();
		try {
			String sql = "select sigungu_code.sigungu_name,\r\n"
					+ "planner_elements.content_type_id,\r\n"
					+ "planner_elements.content_id,\r\n"
					+ "planner_area.visit_day,\r\n"
					+ "planner_elements.order_num \r\n"
					+ "from planner_area\r\n"
					+ "inner join sigungu_code on planner_area.sigungu_id = sigungu_code.id \r\n"
					+ "inner join planner_elements on planner_area.id = planner_elements.planner_area_id\r\n"
					+ "where planner_area.planner_id = ?\r\n"
					+ "order by planner_area.visit_day asc, planner_elements.order_num asc;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, planner_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new TripCourseBean(
						rs.getString("sigungu_name"),
						rs.getInt("content_type_id"),
						rs.getInt("content_id"),
						rs.getInt("visit_day"),
						rs.getInt("order_num")
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
