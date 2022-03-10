package servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitServlet
 */
@SuppressWarnings("serial")
@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
       
  
	/* ���α׷� ���۵� �� ������ ����Ǵ� �޼ҵ� */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("���� �ʱ�ȭ....");
	}

	/* ���α׷��� ����� �� ����Ǵ� �޼ҵ� */
	public void destroy() {
		System.out.println("���� ������....");
	}

	/* service => doGet, doPost �� ����
	 * �� service �� doGet, doPost���� ������. 
	 * service�� get,post�� ���� ���� ���� ���� */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���� ����...");
	}

}
