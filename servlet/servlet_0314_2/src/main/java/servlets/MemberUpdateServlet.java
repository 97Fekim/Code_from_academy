package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bluedb", "root", "1234");
			System.out.println(" 추가 post connection 객체 " + conn);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mno, email, mname, cre_date from members "
					+ "where mno = " + request.getParameter("no"));
			
			rs.next();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>회원정보</title></head>");
			out.println("<body><h1>회원등록</h1>");
			out.println("<form action='update' method='post'>");
			
			out.println("번호 : <input type='text' name='no' value='" +
						request.getParameter("no") + "' readonly><br>");
			out.println("이름 : <input type='text' name='name'" +
					" value = '" + rs.getString("MNAME") + "'><br>");
			out.println("이메일 : <input type='text' name='email'" +
					" value='" + rs.getString("email") + "'><br>");
			out.println("암호 : <input type='password' name='password'><br>");
			out.println("<input type='submit' value='저장'>");
			out.println("<input type='reset' value='취소'>");
			out.println("</form>");
			out.println("</body></html>");
		} catch(Exception e) {
			throw new ServletException(e);
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bluedb", "root", "1234");
			System.out.println(" 추가 post connection 객체 " + conn);
			
			stmt = conn.prepareStatement(
					"update members set email=?, mname=?, mod_date=now() where mno=?"
					);
			
			response.setContentType("text/html; charset=UTF-8");
			
			stmt.setString(1, request.getParameter("email"));
			stmt.setString(2,  request.getParameter("name"));
			stmt.setInt(3, Integer.parseInt(request.getParameter("no")));
			stmt.executeUpdate();
			response.sendRedirect("list");
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>회원정보</title></head>");
			out.println("<body><h1>회원등록</h1>");
			out.println("<form action='update' method='post'>");
			
			
			
			
		} catch(Exception e) {
			throw new ServletException(e);
		} finally {
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		
	}

}
