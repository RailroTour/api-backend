package endpoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReviewDAO {
	private Connection conn = null;
	
	public ReviewDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(ReviewBean review, String email) {

		PreparedStatement pstmt = null;
		try {
			String sql = "insert into review(user_id, content_id, content_type_id, image_path,content, register_date) values((select id from user where email=?),?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setInt(2, review.getContent_id());
			pstmt.setInt(3, review.getContent_type_id());
			pstmt.setString(4, review.getImage_path());
			pstmt.setString(5, review.getContent());
			
			
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
	
	public JSONArray get(String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from review where user_id =(select id from user where email=?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			JSONArray arr = new JSONArray();
			while (rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("user_id", rs.getInt("user_id"));
				obj.put("content_id", rs.getInt("content_id"));
				obj.put("content_type_id", rs.getInt("content_type_id"));
				obj.put("image_path", rs.getString("image_path"));
				obj.put("content", rs.getString("content"));
				obj.put("register_date", rs.getString("register_date"));
				
				arr.put(obj);
			
				return arr;
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
	
	public int delete(int id, int content_id) {
		
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from review where id=? and content_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, content_id);
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
