package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import user.dto.UserBean;

public class UserDAO {
	private Connection conn = null;

	public UserDAO(Connection conn) {
		this.conn = conn;
	}

	public int insert(UserBean user) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into user(username, password, name, nickname, email, register_date, profile_img) values(?, ?, ?, ?, ?, now(),?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getNickname());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getProfile_img());

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

	public int count(String username) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) AS cnt from user where username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);

			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("cnt");
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

	public UserBean get(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new UserBean(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("name"), rs.getString("nickname"), rs.getString("email"),
						rs.getString("register_date"), null

				);
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

	public UserBean get(String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new UserBean(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("nickname"),
					rs.getString("email"),
					rs.getString("register_date"),
					rs.getString("profile_img")
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
	
	
	public int update(UserBean user) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update user set username=?, password=?, name=?, nickname=?, email=?, profile_img=? where id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getNickname());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getProfile_img());

			return pstmt.executeUpdate();
		} catch (

		SQLException e) {
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

	public int delete(String email) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from user where email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
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
