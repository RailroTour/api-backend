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
			String sql = "insert into community_board(username, title, content, register_date, community_img,available,views) values((select username from user where email=?),?,?,now(),?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, community.getTitle());
			pstmt.setString(3, community.getContent());
			pstmt.setString(4, community.getCommunity_img());
			pstmt.setInt(5, 1);
			pstmt.setInt(6, 0);

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
	//글쓴이 말고 현재 로그인 한 유저를 불러온다. 삭제 본인만 할 수 있게 username 호출 
	public String getLoginusername(String email) {
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
	//조회수 만드는 함수 
		public int upcount(int id) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "update community_board set views=views+1 where id=?";
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
	//조회수 가져오기
		public int getView(int id) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select views from community_board where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					return rs.getInt("views");
				}
				else {
					return rs.getInt("views");
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
			upcount(id);
			if (rs.next()) {
				return new CommunityBean(rs.getInt("id"), rs.getString("username"), rs.getString("title"),
						rs.getString("content"), rs.getString("register_date"), rs.getString("community_img"),rs.getInt("views"));
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
			String sql = "update community_board set title=?, content=?, register_date=now(), community_img=? where id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, community.getTitle());
			pstmt.setString(2, community.getContent());
			pstmt.setString(3, community.getCommunity_img());
			pstmt.setInt(4, community.getId());
			

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

	public int delete(int id) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from community_board where id=?";
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
	//데이터 id 값 차례로 재설정 
	public int initialize_id(int id) {
		
		PreparedStatement pstmt = null;
		try {
			
			String sql = "update community_board set id=id-1 where id>?";
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
//데이터 개수 세는 함수 
	public int count() {

		PreparedStatement pstmt = null;

		try {
			String sql = "select * from community_board";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = pstmt.executeQuery();
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			return count;

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

	public List<CommunityBean> get() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from community_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<CommunityBean> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new CommunityBean(rs.getInt("id"), rs.getString("username"), rs.getString("title"),
						rs.getString("content"), rs.getString("register_date"), rs.getString("community_img"),rs.getInt("views")));
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
	//게시글 번호 부여 메소드
	public int getNext() {
		//현재 게시글을 내림차순으로 조회하여 가장 마지막 글의 번호를 구한다
		String sql = "select id from community_board order by id desc";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; //첫 번째 게시물인 경우
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	public ArrayList<CommunityBean> getList(int pageNumber){
		String sql = "select * from community_board where id < ? and available = 1 order by id desc limit 10";
		ArrayList<CommunityBean> list = new ArrayList<CommunityBean>();
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new CommunityBean(rs.getInt("id"), rs.getString("username"), rs.getString("title"),
						rs.getString("content"), rs.getString("register_date"), rs.getString("community_img"),rs.getInt("views")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//페이징 처리 메소드
		public boolean nextPage(int pageNumber) {
			String sql = "select * from community_board where id < ? and available = 1";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = null;
				pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					return true;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

}
