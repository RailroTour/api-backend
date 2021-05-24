package oauth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oauth.dto.KakaoUserBean;
import user.dto.UserBean;

public class PlannerAuthDAO {
	private Connection conn = null;
	
	public PlannerAuthDAO(Connection conn) {
		this.conn = conn;
	}
	
	public UserBean getPlannerUser(int planner_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where id = (select user_id from planner where id=?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, planner_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new UserBean(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("nickname"),
						rs.getString("email"),
						rs.getString("register_date"),
						rs.getString("profile_img")
				);
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
		return null;
	}
}
