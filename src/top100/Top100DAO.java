package top100;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import planner.dto.MyPlannerBean;
import review.ReviewBean;

public class Top100DAO {
	private Connection conn = null;
	
	public Top100DAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Top100Bean> getList(int contenttypeid, int pageNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Top100Bean> list = new ArrayList<Top100Bean>();
		try {
			String sql = "select review.content_id, review.content_type_id, count(*) as review_cnt, sum(likes) as likes_cnt from review where content_type_id = ? group by content_id order by sum(likes) desc limit ?, 50";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contenttypeid);
			pstmt.setInt(2, (pageNo-1)*50);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Top100Bean(
						rs.getInt("content_id"),
						rs.getInt("content_type_id"),
						rs.getInt("review_cnt"),
						rs.getInt("likes_cnt")
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
	
	public List<String> getTags(int contenttypeid, int contentid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			String sql = "select review_tags.hashtag, count(review_tags.hashtag) as cnt \r\n"
					+ "from review_tags \r\n"
					+ "inner join review on review.id = review_tags.review_id \r\n"
					+ "where review.content_id = ? and review.content_type_id = ? \r\n"
					+ "group by review_tags.hashtag \r\n"
					+ "order by count(review_tags.hashtag) desc limit 5;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentid);
			pstmt.setInt(2, contenttypeid);
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
	
	public List<MyPlannerBean> getPlanner(int pageNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyPlannerBean> list = new ArrayList<MyPlannerBean>();
		try {
			String sql = "select user.id as user_id,\r\n"
					+ "user.nickname,\r\n"
					+ "planner.id as planner_id,\r\n"
					+ "planner.title,\r\n"
					+ "planner.days,\r\n"
					+ "planner.tema_id,\r\n"
					+ "tema.name as tema_name,\r\n"
					+ "planner.img_path,\r\n"
					+ "planner.start_day,\r\n"
					+ "planner.view,\r\n"
					+ "GROUP_CONCAT(sigungu_code.sigungu_name order by planner_area.visit_day asc SEPARATOR '-') AS trip_course\r\n"
					+ "from user\r\n"
					+ "inner join planner on user.id = planner.user_id\r\n"
					+ "inner join tema on planner.tema_id = tema.id\r\n"
					+ "inner join planner_area on planner.id = planner_area.planner_id\r\n"
					+ "left outer join sigungu_code on planner_area.sigungu_id = sigungu_code.id\r\n"
					+ "group by planner.id order by planner.`view` desc limit ?, 50";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*50);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new MyPlannerBean(
					rs.getInt("user_id"),
					rs.getString("nickname"),
					rs.getInt("planner_id"),
					rs.getString("title"),
					rs.getInt("days"),
					rs.getInt("tema_id"),
					rs.getString("tema_name"),
					rs.getString("img_path"),
					rs.getString("start_day"),
					rs.getString("trip_course"),
					rs.getInt("view")
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
}
