package today;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	
	String sql = "";
	
	public DBConn() {
		String url = "jdbc:mysql://localhost:3306/springgreen5";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색실패");
		}catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패");
		}
	}

	//conClose()
	public void connClose() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {}
	}
	
	//pstmtClose()
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {}			
	}
	
	// rsClose()
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			pstmtClose();
		} catch (Exception e) {}
	}
		
}