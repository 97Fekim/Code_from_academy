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
			out.println("<html><head><title>ȸ�����</title></head>");
			out.println("<body><h1>ȸ�� ���</h1>");
			out.println("<p><a href = 'add'>�ű�ȸ��</a></p>");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
