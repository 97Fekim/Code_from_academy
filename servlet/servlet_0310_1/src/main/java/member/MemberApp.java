package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/MemberApp")
public class MemberApp extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService service = new MemberServiceImpl();
		
		Long a = Long.parseLong(request.getParameter("id"));
		String b = request.getParameter("name"); 
		
		response.setContentType("html/css");
		response.setCharacterEncoding("euc-kr");
		
		Member member1 = new Member(a,b,Grade.VIP);
		
		service.join(member1);

		PrintWriter writer = response.getWriter();
		writer.println("회원가입 성공!");
		writer.println("회원 번호 : " + member1.getId());
		writer.println("회원 이름 : " + member1.getName());
		
	}
}
