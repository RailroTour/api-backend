package tripcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tripcart.dto.TripCartBean;
import user.dto.UserBean;

public class TripCartDAO {
	
	private Connection conn = null;
	
	public TripCartDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(TripCartBean tripcart, String email) {
		
		
		
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into trip_cart(user_id, division_id, serial_num) values((select id from user where email=?), ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setInt(2, tripcart.getDivision_id());
			pstmt.setInt(3, tripcart.getSerial_num());
			
			
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
	public TripCartBean get(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from trip_cart where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new TripCartBean(
					rs.getInt("id"),
					rs.getInt("user_id"),
					rs.getInt("division_id"),
					rs.getInt("serial_num")
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
	public int update(TripCartBean tripcart) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update trip_cart set id=?, user_id=?, division_id=?, serial_num=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tripcart.getId());
			pstmt.setInt(2, tripcart.getUser_id());
			pstmt.setInt(3, tripcart.getDivision_id());
			pstmt.setInt(4, tripcart.getSerial_num());
			
			
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
			String sql = "delete from trip_cart where id=?";
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
