package planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import planner.dto.Planner2Bean;
import planner.dto.Planner3Bean;

public class Planner3DAO {
	private Connection conn = null;
	
	public Planner3DAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(Planner3Bean planner3) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into planner_elements(planner_area_id, order_num, content_id, content_type_id) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, planner3.getPlanner_area_id());
			pstmt.setInt(2, planner3.getOrder_num());
			pstmt.setInt(3, planner3.getContent_id());
			pstmt.setInt(4, planner3.getContent_type_id());

			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
			
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
