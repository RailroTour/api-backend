package RecommendPlanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import planner.dto.Planner2JoinBean;

public class RecommendPlannerDAO {
	private Connection conn = null;
	
	public RecommendPlannerDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<RecommendPlannerBean> list(List<RecommendPlannerBean> list, int tema_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select planner.id as planner_id, tema.name, tema.id as tema_id, planner.img_path, planner.`view`, user.nickname, planner.days, planner.title\r\n"
					+ "from user inner join planner on user.id = planner.user_id\r\n"
					+ "inner join tema on tema.id = planner.tema_id \r\n"
					+ "where planner.tema_id = ?\r\n"
					+ "order by planner.`view` desc\r\n"
					+ "limit 3;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tema_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new RecommendPlannerBean(
						rs.getInt("planner_id"),
						rs.getString("name"),
						rs.getInt("tema_id"),
						rs.getString("img_path"),
						rs.getInt("view"),
						rs.getString("nickname"),
						rs.getInt("days"),
						rs.getString("title")
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
