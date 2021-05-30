package realtime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import planner.dto.MyPlannerBean;

public class RealTimePlannerDAO {
	private Connection conn = null;
	
	public RealTimePlannerDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<RealTimePlannerBean> getNewList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RealTimePlannerBean> list = new ArrayList<RealTimePlannerBean>();
		try {
			String sql = "select planner.id, planner.title, planner.img_path, user.nickname from planner inner join user on planner.user_id = user.id order by planner.register_date desc limit 2";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new RealTimePlannerBean(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("img_path"),
						rs.getString("nickname")
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
