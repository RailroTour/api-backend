package planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import planner.dto.Planner3Bean;
import planner.dto.PlannerInfoBean;

public class PlannerInfoDAO {
	private Connection conn = null;
	
	public PlannerInfoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public PlannerInfoBean get(int planner_id){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			String sql = "select user.nickname, user.profile_img, planner.img_path, planner.title, planner.start_day, planner.days, tema.name, planner.view\r\n"
					+ "from user\r\n"
					+ "inner join planner on user.id = planner.user_id \r\n"
					+ "inner join tema on planner.tema_id = tema.id where planner.id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, planner_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new PlannerInfoBean(
						rs.getString("nickname"),
						rs.getString("title"),
						rs.getString("start_day"),
						rs.getInt("days"),
						rs.getString("name"),
						rs.getInt("view"),
						rs.getString("img_path"),
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
	
	public int update(int planner_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update planner set view=view+1 where id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, planner_id);

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
