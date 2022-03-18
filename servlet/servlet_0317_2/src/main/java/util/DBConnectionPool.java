package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionPool {
	String url;
	String username;
	String password;
	List<Connection> connList = new ArrayList<>();
	
	// 생성자
	public DBConnectionPool(String driver, String url, String username, String password) throws Exception {
		this.url = url;
		this.username = username;
		this.password = password;
		Class.forName(driver);
	}
	
	// 메서드 Connection 객체 반환
	public Connection getConnection() throws Exception {
		if(connList.size() > 0) {	// List에 Connection 객체가 있으면
			Connection conn = connList.remove(0);	// 처음 Connection 객체를 List에서 삭제하면서 반환받은 Connection 객체를 사용하기 위해
			if(conn.isValid(10))					// 10개가 유효하면 함수 종료
				return conn;
		}
		
		return DriverManager.getConnection(url, username, password);
	}
	
	// Servlet 에서 Connection 다 사용하면 List에 반환함 (ConnectionPool 에 저장)
	public void returnConnection(Connection conn) throws Exception {
		connList.add(conn);
	}
	
	// 종료(자원 정리)
	public void claseAll() {
		for(Connection conn: connList) {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
