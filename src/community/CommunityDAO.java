package community;


import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;


import java.util.List;
import java.util.ArrayList;






public class CommunityDAO {
	
	private Connection conn = null;
	
	public CommunityDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(CommunityBean community, String email) {

		PreparedStatement pstmt = null;
		try {
			String sql = "insert into community_board(username, title, content, register_date) values((select username from user where email=?),?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, community.getTitle());
			pstmt.setString(3, community.getContent());
			
			
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
	
	public CommunityBean get(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from community_board where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new  CommunityBean(rs.getInt("id"), rs.getString("username"), rs.getString("title"),
						rs.getString("content"), rs.getString("register_date"));
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
	public int update(CommunityBean community) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update community_board title=?, content=?, register_date=now() where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, community.getTitle());
			pstmt.setString(2, community.getContent());
			
			pstmt.setInt(3, community.getId());

			
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
	
	public int delete(int id) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from community_board where id=?";
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
	
	public List<CommunityBean> get(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from community_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<CommunityBean> list= new ArrayList<>();
			while(rs.next()) {
				list.add(new CommunityBean(rs.getInt("id"), rs.getString("username"), rs.getString("title"),
						rs.getString("content"), rs.getString("register_date")));
			}
			return list;
					
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
			if(pstmt != null) {
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

}
