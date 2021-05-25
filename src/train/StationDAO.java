package train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import planner.dto.PlannerBean;

public class StationDAO {
	private Connection conn = null;
	
	public StationDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<StationBean> list() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StationBean> list = new ArrayList<StationBean>();
		try {
			String sql = "select * from train_node order by citycode asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new StationBean(
					rs.getInt("id"),
					rs.getInt("citycode"),
					rs.getString("cityname"),
					rs.getString("nodeid"),
					rs.getString("nodename")
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
