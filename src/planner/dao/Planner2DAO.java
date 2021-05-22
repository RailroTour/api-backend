package planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import planner.dto.Planner2Bean;
import planner.dto.PlannerBean;

public class Planner2DAO {
	private Connection conn = null;
	
	public Planner2DAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(Planner2Bean planner2) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into planner_area(planner_id, visit_day, sigungu_id) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, planner2.getPlanner_id());
			pstmt.setInt(2, planner2.getVisit_day());
			pstmt.setInt(3, planner2.getSigungu_id());

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
