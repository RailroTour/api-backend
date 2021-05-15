package oauth.dao;

import java.sql.Connection;

public class OauthDAO {
	private Connection conn = null;
	
	public OauthDAO(Connection conn) {
		this.conn = conn;
	}
	
	
}
