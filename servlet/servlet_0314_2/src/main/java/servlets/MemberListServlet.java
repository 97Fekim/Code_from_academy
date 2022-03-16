package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn= DriverManager.getConnection("jdbc:mysql://localhost/bluedb","root","1234");
			System.out.println(conn);
			stmt = conn.createStatement();
			rs =stmt.executeQuery("select MNO, MNAME, EMAIL,CRE_DATE FROM MEMBERS ORDER BY MNO ASC" );
			response.setContentType("text/html ;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원 목록</h1>");
			out.println("<p><a href = 'add'>신규회원</a></p>");
			while(rs.next()) {
				out.println(
						rs.getInt("mno") + "," +
						"<a href = 'update?no=" + rs.getInt("mno") + "'>" + 
						rs.getString("mname") + "</a>," + 
						rs.getString("email") + "," +
						rs.getDate("cre_date") + "<br>"
						);
			}
			out.println("</body></html>");
		} catch(Exception e) {
			throw new ServletException();
			
			// 자원(resource) 정리 (close/메모리 해제) 나중에 생성된 것부터 삭제(해제)
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
