package tema.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import tema.dto.TemaBean;
public class TemaDAO {
	
private Connection conn = null;
	
	public TemaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(TemaBean tema) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into tema(name) values(?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, tema.getName());
					
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
	
	
	
	public TemaBean get(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tema where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new TemaBean(
					rs.getInt("id"),
					rs.getString("name")
	
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
	
	public int update(TemaBean tema) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update tema set name=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tema.getName());
		
			
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
			String sql = "delete from tema where id=?";
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
