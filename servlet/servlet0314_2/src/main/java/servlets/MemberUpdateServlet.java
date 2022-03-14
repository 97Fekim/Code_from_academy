package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bluedb", "root", "1234");
			System.out.println(" �߰� post connection ��ü " + conn);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mno, email, mname, cre_date from members "
					+ "where mno = " + request.getParameter("no"));
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>ȸ�����</title></head>");
			out.println("<body><h1>ȸ�����</h1>");
			out.println("<form action='add' method='post'>");
			out.println("�̸� : <input type='text' name='name'><br>");
			out.println("�̸��� : <input type='text' name='email'><br>");
			out.println("��ȣ : <input type='password' name='password'><br>");
			out.println("<input type='submit' value='�߰�'>");
			out.println("<input type='reset' value='���'>");
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
		
	}

}
