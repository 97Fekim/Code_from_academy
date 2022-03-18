package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			MemberDAO  memberDao = (MemberDAO) sc.getAttribute("memberDao");
			System.out.println("memberDao: " + memberDao);
			request.setAttribute("members", memberDao.selectList());
			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberList.jsp");
			rd.include(request, response); //�����ϴ� ,�ٽ� �´� 
			
		} catch (Exception e) {
			request.setAttribute("error",e);
			RequestDispatcher rd= request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		} 
	}


}
