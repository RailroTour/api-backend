package community_comment;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;



import java.util.List;
import java.util.ArrayList;

public class CommentDAO {
	private Connection conn = null;

	public CommentDAO(Connection conn) {
		this.conn = conn;
	}

	public int insert(CommentBean comment, String email) {

		PreparedStatement pstmt = null;
		try {
			String sql = "insert into community_comment(board_id, content, register_date, username) values(?,?,now(),(select username from user where email=?))";
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, comment.getBoard_id());
			pstmt.setString(2, comment.getContent());
			pstmt.setString(3, email);
		

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	//댓글을 쓴 글쓴이 불러오기
	public String getWriter(int comment_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select username from community_comment where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("username");
			}
			else {
				return rs.getString("username");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
		
	}
	//댓글 삭제 본인만 할 수 있게 현재 로그인 하신 username 호출 
		public String getusername(String email) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select username from user where email=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					return rs.getString("username");
				}
				else {
					return rs.getString("username");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return null;
			
		}
		public List<CommentBean> get() {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select * from community_comment order by id desc";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				List<CommentBean> list = new ArrayList<>();
				while (rs.next()) {
					list.add(new CommentBean(rs.getInt("id"), rs.getInt("board_id"), rs.getString("username"),
							rs.getString("content"), rs.getString("register_date")));
				}
				return list;

			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
						// TODO: handle exception
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
						// TODO: handle exception
					}
				}
			}
			return null;
		}
		
		public int delete(int id) {
			PreparedStatement pstmt = null;
			try {
				String sql = "delete from community_comment where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
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
