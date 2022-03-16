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
		out.println("<html><head><title>회원등록</title></head>");
		out.println("<body><h1>회원등록</h1>");
		out.println("<form action='add' method='post'>");
		out.println("이름 : <input type='text' name='name'><br>");
		out.println("이메일 : <input type='text' name='email'><br>");
		out.println("암호 : <input type='password' name='password'><br>");
		out.println("<input type='submit' value='추가'>");
		out.println("<input type='reset' value='취소'>");
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
			System.out.println(" 추가 post connection 객체 " + conn);
			stmt = conn.prepareStatement("insert into members (email, pwd, mname, cre_date, mod_date)" + 
					" values(?,?,?,now(),now())");	// ?는 준비한 후 나중에 채운다(prepare)
			stmt.setString(1,  req.getParameter("email"));		// 1번 물음표를 채운다
			stmt.setString(2,  req.getParameter("password"));	// 2번 물음표를 채운다
			stmt.setString(3,  req.getParameter("name"));		// 3번 물음표를 채운다
			stmt.executeUpdate(); // 최종 적용(update) 한다.
			
			/* 결과 출력 */
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<html><head><title>회원등록 결과</title></head>");
			
			// meta 태그를 이용한 refresh
			out.println(",<meta http-equiv='Refresh' content='1; url=list'>");	// 1초간 멈추고 list로 이동함
			out.println("<body><p>등록 성공입니다.</p></body></html>");
			
		} catch(Exception e) {
			throw new ServletException(e);
			
		} finally {
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			try {if(conn!=null) stmt.close();} catch(Exception e) {}
		}
	}
}
