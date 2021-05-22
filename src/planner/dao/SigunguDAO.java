package planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import planner.dto.PlannerBean;
import planner.dto.SigunguBean;

public class SigunguDAO {
	private Connection conn = null;
	
	public SigunguDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<SigunguBean> get(int area_code) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SigunguBean> list = new ArrayList<SigunguBean>();
		try {
			String sql = "select * from sigungu_code where area_code=? order by area_code asc, sigungu_code asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, area_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new SigunguBean(
						rs.getInt("id"),
						rs.getInt("area_code"),
						rs.getString("area_name"),
						rs.getInt("sigungu_code"),
						rs.getString("sigungu_name"),
						rs.getString("thumb")
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
	
	public List<SigunguBean> list() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SigunguBean> list = new ArrayList<SigunguBean>();
		try {
			String sql = "select * from sigungu_code order by area_code asc, sigungu_code asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new SigunguBean(
						rs.getInt("id"),
						rs.getInt("area_code"),
						rs.getString("area_name"),
						rs.getInt("sigungu_code"),
						rs.getString("sigungu_name"),
						rs.getString("thumb")
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
