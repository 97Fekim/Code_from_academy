package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.PreparableStatement;


@SuppressWarnings("serial")
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bluedb", "root", "1234");
			System.out.println(" �߰� post connection ��ü " + conn);
			stmt = conn.prepareStatement("insert into members (email, pwd, mname, cre_date, mod_date)" + 
					" values(?,?,?,now(),now())");	// ?�� �غ��� �� ���߿� ä���(prepare)
			stmt.setString(1,  req.getParameter("email"));		// 1�� ����ǥ�� ä���
			stmt.setString(2,  req.getParameter("password"));	// 2�� ����ǥ�� ä���
			stmt.setString(3,  req.getParameter("name"));		// 3�� ����ǥ�� ä���
			stmt.executeUpdate(); // ���� ����(update) �Ѵ�.
			
			/* ��� ��� */
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<html><head><title>ȸ����� ���</title></head>");
			
			// meta �±׸� �̿��� refresh
			out.println(",<meta http-equiv='Refresh' content='1; url=list'>");	// 1�ʰ� ���߰� list�� �̵���
			out.println("<body><p>��� �����Դϴ�.</p></body></html>");
			
		} catch(Exception e) {
			throw new ServletException(e);
			
		} finally {
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			try {if(conn!=null) stmt.close();} catch(Exception e) {}
		}
	}
}
