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
import planner.dto.Planner3Bean;
import planner.dto.PlannerBean;

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
	
	public int delete(Planner3Bean planner3) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from planner_elements where planner_area_id=? and order_num=? and content_id=? and content_type_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, planner3.getPlanner_area_id());
			pstmt.setInt(2, planner3.getOrder_num());
			pstmt.setInt(3, planner3.getContent_id());
			pstmt.setInt(4, planner3.getContent_type_id());
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
	
	public int order_sort(Planner3Bean planner3) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update planner_elements set order_num=order_num-1 where planner_area_id=? and order_num>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, planner3.getPlanner_area_id());
			pstmt.setInt(2, planner3.getOrder_num());

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
	
	public List<Planner3Bean> list(int Planner_area_id){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Planner3Bean> list = new ArrayList<Planner3Bean>();
		try {
			String sql = "select * from planner_elements where planner_area_id=? order by order_num asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Planner_area_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Planner3Bean(
						rs.getInt("id"),
						rs.getInt("planner_area_id"),
						rs.getInt("order_num"),
						rs.getInt("content_id"),
						rs.getInt("content_type_id")
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
