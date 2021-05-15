package oauth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import division.dto.DivisionBean;
import oauth.dto.KakaoUserBean;
import user.dto.UserBean;

public class OauthDAO {
	private Connection conn = null;
	
	public OauthDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int SignUp_Check(KakaoUserBean kakaouser) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) as cnt from social_user where social_user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kakaouser.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
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
		return 0;
	}
	
	public String getRandomPassword( int length ){ //랜덤 비번생성
        char[] charaters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        StringBuilder sb = new StringBuilder("");
        Random rn = new Random();
        for( int i = 0 ; i < length ; i++ ){
            sb.append( charaters[ rn.nextInt( charaters.length ) ] );
        }
        return sb.toString();
    }
	
	public int SocialUser_SignUp(KakaoUserBean kakaouser) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into user(username, password, name, nickname, email, register_date) values(?,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql, new String[] {"id"});
			
			pstmt.setString(1, kakaouser.getEmail().split("@")[0]);
			pstmt.setString(2, getRandomPassword(10));
			pstmt.setString(3, kakaouser.getNickname());
			pstmt.setString(4, kakaouser.getNickname());
			pstmt.setString(5, kakaouser.getEmail());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			int inserted_id = 0;
			if(rs.next()) {
				inserted_id = rs.getInt(1);
			}
			
			sql = "insert into social_user(user_id, social_user_id, social_type_id) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, inserted_id);
			pstmt.setString(2, kakaouser.getId());
			pstmt.setInt(3, 1);
			pstmt.executeUpdate();
			
			return inserted_id;
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
