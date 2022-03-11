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
		writer.println("ȸ������ ����!");
		writer.println("ȸ�� ��ȣ : " + member1.getId());
		writer.println("ȸ�� �̸� : " + member1.getName());
		
	}
}
