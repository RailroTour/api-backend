package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static final String PROPERTIES = "?useSSL=false";

	private static final String DB_SCHEMES = "railro_tour";
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://railro-tour-rds.cxjrhe2kspyk.ap-northeast-2.rds.amazonaws.com:3306/" + DB_SCHEMES;
	
	private static final String USER = "admin";
	private static final String PASS = "ssdd4670";


	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName(JDBC_DRIVER);
		}catch(ClassNotFoundException e) {
			e.getMessage();
		}
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
}
