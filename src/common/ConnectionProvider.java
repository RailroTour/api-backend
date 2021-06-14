package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static final String PROPERTIES = "?useSSL=false";

	private static final String DB_SCHEMES = "ggp02250";
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://ggp02250.cafe24.com:3306/" + DB_SCHEMES+"?serverTimezone=UTC";
	
	private static final String USER = "ggp02250";
	private static final String PASS = "Ssdd4670!!";


	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName(JDBC_DRIVER);
		}catch(ClassNotFoundException e) {
			e.getMessage();
		}
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
}
