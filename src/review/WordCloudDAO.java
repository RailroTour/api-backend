package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordCloudDAO {
	private Connection conn = null;
	
	public WordCloudDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<WordCloudBean> getWordCloud(int contentid, int contenttypeid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<WordCloudBean> list = new ArrayList<WordCloudBean>();
		try {
			String sql = "select hashtag, COUNT(*) as cnt from review_tags inner join review on review.id = review_tags.review_id\r\n"
					+ "WHERE review.content_id = ? and review.content_type_id = ? GROUP by review_tags.hashtag  order by cnt desc limit 10";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentid);
			pstmt.setInt(2, contenttypeid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new WordCloudBean(rs.getString("hashtag"), rs.getInt("cnt")));
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
