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
	
	// ������
	public DBConnectionPool(String driver, String url, String username, String password) throws Exception {
		this.url = url;
		this.username = username;
		this.password = password;
		Class.forName(driver);
	}
	
	// �޼��� Connection ��ü ��ȯ
	public Connection getConnection() throws Exception {
		if(connList.size() > 0) {	// List�� Connection ��ü�� ������
			Connection conn = connList.remove(0);	// ó�� Connection ��ü�� List���� �����ϸ鼭 ��ȯ���� Connection ��ü�� ����ϱ� ����
			if(conn.isValid(10))					// 10���� ��ȿ�ϸ� �Լ� ����
				return conn;
		}
		
		return DriverManager.getConnection(url, username, password);
	}
	
	// Servlet ���� Connection �� ����ϸ� List�� ��ȯ�� (ConnectionPool �� ����)
	public void returnConnection(Connection conn) throws Exception {
		connList.add(conn);
	}
	
	// ����(�ڿ� ����)
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
