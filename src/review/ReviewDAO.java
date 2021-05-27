package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReviewDAO {
	private Connection conn = null;
	
	public ReviewDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(ReviewBean review, String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into review(user_id, content_id, content_type_id, content, register_date, likes) "
					+ "values((select id from user where email=?),?,?,?,now(),?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, email);
			pstmt.setInt(2, review.getContent_id());
			pstmt.setInt(3, review.getContent_type_id());
			pstmt.setString(4, review.getContent());
			pstmt.setInt(5, review.getLike());
			
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
	
	public int insertTags(int review_id, String tag) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO railro_tour.review_tags\r\n"
					+ "(review_id, hashtag)\r\n"
					+ "VALUES(?, ?);";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, review_id);
			pstmt.setString(2, tag);
			
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
	
	public int insertImgs(int review_id, String img) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO review_img(review_id, img_path) VALUES(?, ?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, review_id);
			pstmt.setString(2, img);
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
	public List<ReviewBean> get(int contentid, int contenttypeid, String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewBean> list = new ArrayList<ReviewBean>();
		try {
			String sql = "select review.id, review.user_id, review.content_id, review.content_type_id, review.content, review.register_date, review.likes, user.nickname, if(user.email = ?, 1, 0) AS mine\r\n"
					+ " from review inner join user on user.id = review.user_id where content_id = ? and content_type_id = ? order by register_date desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, contentid);
			pstmt.setInt(3, contenttypeid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new ReviewBean(
						rs.getInt("id"),
						rs.getInt("user_id"),
						rs.getInt("content_id"),
						rs.getInt("content_type_id"),
						rs.getString("content"),
						rs.getString("register_date"),
						rs.getInt("likes"),
						rs.getInt("mine"),
						rs.getString("nickname")
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
	
	public List<String> getTags(int contentid, int contenttypeid, int review_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			String sql = "select review_tags.review_id, review_tags.hashtag from review_tags Inner join review on review.id = review_tags.review_id where review.content_id = ? and review.content_type_id = ? and review.id = ? order by review.register_date desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentid);
			pstmt.setInt(2, contenttypeid);
			pstmt.setInt(3, review_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("hashtag"));
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
	
	public List<String> getImgs(int contentid, int contenttypeid, int review_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			String sql = "select review_img.review_id, review_img.img_path from review Inner join review_img on review.id = review_img.review_id where review.content_id = ? and review.content_type_id = ? and review.id = ? order by review.register_date desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentid);
			pstmt.setInt(2, contenttypeid);
			pstmt.setInt(3, review_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("img_path"));
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
	
	public int delete(int id) {
		
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from review where id=?";
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
