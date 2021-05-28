package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewRatioDAO {
	private Connection conn = null;
	
	public ReviewRatioDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int getLike(int contentid, int contenttypeid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		int likes = 0;
		try {
			String sql = "select count(*) as like_cnt from review where content_id=? and content_type_id=? and likes=1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentid);
			pstmt.setInt(2, contenttypeid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				likes=rs.getInt("like_cnt");
			}
			return likes;
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
	
	public int getDislike(int contentid, int contenttypeid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		int likes = 0;
		try {
			String sql = "select count(*) as dislike_cnt from review where content_id=? and content_type_id=? and likes=0";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentid);
			pstmt.setInt(2, contenttypeid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				likes=rs.getInt("dislike_cnt");
			}
			return likes;
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
