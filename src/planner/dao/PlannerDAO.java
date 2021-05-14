package planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import planner.dto.PlannerBean;

public class PlannerDAO {
private Connection conn = null;
	
	public PlannerDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(PlannerBean planner) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into planner(user_id, title, disclosure, register_date, days, tema_id,img_path) values(?, ?, ?, now(), ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, planner.getUser_id());
			pstmt.setString(2, planner.getTitle());
			pstmt.setBoolean(3, planner.getDisclosure());
			pstmt.setInt(5, planner.getDays());
			pstmt.setInt(6, planner.getTema_id());
			pstmt.setString(7, planner.getImg_path());
			
			return pstmt.executeUpdate();
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
	
	public PlannerBean get(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from planner where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new PlannerBean(
					rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getString("title"),
					rs.getBoolean("disclosure"),
					rs.getString("register_date"),
					rs.getInt("days"),
					rs.getInt("tema_id"),
					rs.getString("img_path")
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
	
	public int update(PlannerBean planner) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update planner user_id=?, title=?, disclosure=?, register_date=now(), days=?, tema_id=?, img_path=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, planner.getUser_id());
			pstmt.setString(2, planner.getTitle());
			pstmt.setBoolean(3, planner.getDisclosure());
			pstmt.setInt(5, planner.getDays());
			pstmt.setInt(6, planner.getTema_id());
			pstmt.setString(7, planner.getImg_path());
			
			return pstmt.executeUpdate();
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
	
	public int delete(int id) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from planner where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
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

}
