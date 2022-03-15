package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/update")
public class ExamUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn= DriverManager.getConnection("jdbc:mysql://localhost/reddb","root","1234");
			System.out.println(conn);
			stmt = conn.createStatement();
			
			rs =stmt.executeQuery("select * FROM green where no="+request.getParameter("no"));
			response.setContentType("text/html ;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html><head><title>회원조회</title></head>");
			out.println("<body><h1>회원 조회</h1>");
			
			rs.next();
			out.println(
					"<form action='update' method='post'>"
					+ "번호: <input type='text' name='no' value='" + request.getParameter("no") +"'>"+ 
					 "이름: <input type='text' name='name' value='" + rs.getString("name") +"'>"+ 
						 	"<input type='submit' value='전송'" +"></form>"
					);

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
		System.out.println("여기는 update doPost, value = " + request.getParameter("name") + " " + request.getParameter("no"));
		
		request.setCharacterEncoding("UTF-8");	// 한글 깨짐 대책
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn= DriverManager.getConnection("jdbc:mysql://localhost/reddb","root","1234");
			System.out.println(conn);
			stmt = conn.prepareStatement("update green set name=? where no =?");
			stmt.setInt(2, Integer.parseInt(request.getParameter("no")));
			stmt.setString(1, request.getParameter("name"));
			stmt.executeUpdate();
			response.sendRedirect("list");
			
			response.setContentType("text/html ;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html><head><title>회원조회</title></head>");
			out.println("<body><h1>회원 조회</h1>");
			
			
		} catch(Exception e) {
			throw new ServletException();
			
			// 자원(resource) 정리 (close/메모리 해제) 나중에 생성된 것부터 삭제(해제)
		} finally {
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
}
