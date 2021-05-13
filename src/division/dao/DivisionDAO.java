package division.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import division.dto.DivisionBean;


public class DivisionDAO {
private Connection conn = null;
	
	public DivisionDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(DivisionBean division) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into division(name) values(?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, division.getName());
					
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
	
	
	
	public DivisionBean get(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from division where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new DivisionBean(
					rs.getInt("id"),
					rs.getString("name")
	
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
	
	public int update(DivisionBean division) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update division set name=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, division.getName());
		
			
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
			String sql = "delete from division where id=?";
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
