package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import planner.dto.PlannerBean;

public class ReviewHashTagDAO {
private Connection conn = null;
	
	public ReviewHashTagDAO(Connection conn) {
		this.conn = conn;
	}
	public int insert(ReviewHashTagBean hashtag) {

		PreparedStatement pstmt = null;
		try {
			String sql = "insert into review_tags (id, review_id, hashtag) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hashtag.getId());
			pstmt.setInt(2, hashtag.getReview_id());
			pstmt.setString(3, hashtag.getHashtag());
			
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
	public ReviewHashTagBean get(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from review_tags where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new ReviewHashTagBean(
					rs.getInt("id"),
					rs.getInt("review_id"),
					rs.getString("hashtag")
				
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
	public int delete(int id) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from review_tags where id=?";
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
