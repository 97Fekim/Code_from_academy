package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/calc")
public class CalulatorServlet extends HttpServlet {
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		int c = Integer.parseInt(request.getParameter("c"));
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		// 1) ���� ����
		writer.println("a = " + a + "," + "b = " + b + " �� ��� ��� �Դϴ�.");
		writer.println("a + b = " + (a+b));
		writer.println("a - b = " + (a-b));
		writer.println("a * b = " + (a*b));
		writer.println("a / b = " + (a/b));
		writer.println();
		
		// 2) ������ ����
		for(int i=0; i<9; ++i) {
			writer.println(c + " * " + (i+1) + " = " + (c*(i+1)));
		}
	}
}
