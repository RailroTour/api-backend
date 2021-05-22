package planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import planner.dto.Planner2Bean;
import planner.dto.Planner2JoinBean;
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
	
	public List<Planner2JoinBean> list(int planner_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Planner2JoinBean> list = new ArrayList<Planner2JoinBean>();
		try {
			String sql = "select * from planner_area Inner Join sigungu_code on planner_area.sigungu_id = sigungu_code.id WHERE planner_id = ? ORDER BY planner_area.visit_day asc, sigungu_code.area_code asc, sigungu_code.sigungu_code asc;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, planner_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Planner2JoinBean(
						rs.getInt("id"),
						rs.getInt("planner_id"),
						rs.getInt("visit_day"),
						rs.getInt("area_code"),
						rs.getInt("sigungu_code"),
						rs.getString("sigungu_name")
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
