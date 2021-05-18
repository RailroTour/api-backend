package trending;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oauth.dto.KakaoUserBean;

public class TrendingKeywordDAO {
	private Connection conn = null;
	
	public TrendingKeywordDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into trending_keyword(keyword) values(?)";
			pstmt = conn.prepareStatement(sql, new String[] {"id"});
			
			pstmt.setString(1, keyword);
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
