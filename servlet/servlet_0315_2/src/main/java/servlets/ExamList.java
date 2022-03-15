package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/list")
public class ExamList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn= DriverManager.getConnection("jdbc:mysql://localhost/reddb","root","1234");
			System.out.println(conn);
			stmt = conn.createStatement();
			rs =stmt.executeQuery("select * FROM green");
			response.setContentType("text/html ;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>ȸ�����</title></head>");
			out.println("<body><h1>ȸ�� ���</h1>");
			while(rs.next()) {
				out.println(
						"<a href='update?no=" + rs.getInt("no") + "'>" + rs.getInt("no") + "</a>," +
						rs.getString("name") + "<br>"
						);
			}
			out.println("</body></html>");
		} catch(Exception e) {
			throw new ServletException();
			
			// �ڿ�(resource) ���� (close/�޸� ����) ���߿� ������ �ͺ��� ����(����)
		} finally {
			try {
				if(rs!=null) 
					rs.close();
			} catch(Exception e){
				
			}
			
			try {
				if(stmt != null)
					stmt.close();
			} catch(Exception e) {
				
			}
			
			try {
				if(conn != null) 
					conn.close();
			} catch(Exception e) {
				
			}
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
