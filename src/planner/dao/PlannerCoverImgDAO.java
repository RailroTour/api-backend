package planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.dto.UserBean;

public class PlannerCoverImgDAO {
	private Connection conn = null;
	
	public PlannerCoverImgDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int update(int planner_id, String img_path) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update planner set img_path=? where id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, img_path);
			pstmt.setInt(2, planner_id);

			return pstmt.executeUpdate();
		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}
