package trending;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oauth.dto.KakaoUserBean;
import user.dto.UserBean;

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
	
	public List<TrendingKeywordBean> list() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select keyword, COUNT(*) as frequency from trending_keyword group by keyword order by frequency DESC limit 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			List<TrendingKeywordBean> keyword_list = new ArrayList<TrendingKeywordBean>();
			while (rs.next()) {
				keyword_list.add(new TrendingKeywordBean(
					rs.getString("keyword"),
					rs.getInt("frequency")
				));
			}
			return keyword_list;
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
