package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("delete " + request.getParameter("no"));
		Connection conn = null;
		Statement stmt = null;

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bluedb", "root", "1234");
			System.out.println(conn);
			stmt = conn.createStatement();

			stmt.executeUpdate("delete from members where mno=" + request.getParameter("no"));
			response.sendRedirect("list");

		} catch (Exception e) {
			throw new ServletException();

			// 자원(resource) 정리 (close/메모리 해제) 나중에 생성된 것부터 삭제(해제)
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {

			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}

		}
	}

}
