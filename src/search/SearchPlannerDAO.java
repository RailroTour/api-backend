package search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import planner.dto.MyPlannerBean;

public class SearchPlannerDAO {
	private Connection conn = null;
	
	public SearchPlannerDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int count(String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyPlannerBean> list = new ArrayList<MyPlannerBean>();
		try {
			String sql = "select count(*) as cnt from planner where title LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			}
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
		return 0;
	}
	
	public List<MyPlannerBean> list(String keyword, int start_index) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyPlannerBean> list = new ArrayList<MyPlannerBean>();
		try {
			String sql = "select user.id as user_id,\r\n"
					+ "user.nickname,\r\n"
					+ "planner.id as planner_id,\r\n"
					+ "planner.title,\r\n"
					+ "planner.days,\r\n"
					+ "planner.tema_id,\r\n"
					+ "tema.name as tema_name,\r\n"
					+ "planner.img_path,\r\n"
					+ "planner.start_day, \r\n"
					+ "planner.view,\r\n"
					+ "GROUP_CONCAT(sigungu_code.sigungu_name order by planner_area.visit_day asc SEPARATOR '-') AS trip_course\r\n"
					+ "from user\r\n"
					+ "inner join planner on user.id = planner.user_id\r\n"
					+ "inner join tema on planner.tema_id = tema.id\r\n"
					+ "inner join planner_area on planner.id = planner_area.planner_id\r\n"
					+ "left outer join sigungu_code on planner_area.sigungu_id = sigungu_code.id\r\n"
					+ "where planner.title LIKE ? group by planner.id order by planner.register_date desc limit ?, 9";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start_index);
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
