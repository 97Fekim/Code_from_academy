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
       
  
	/* 프로그램 시작될 때 무조건 실행되는 메소드 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 초기화....");
	}

	/* 프로그램이 종료될 때 실행되는 메소드 */
	public void destroy() {
		System.out.println("서블릿 마무리....");
	}

	/* service => doGet, doPost 로 전달
	 * 즉 service 가 doGet, doPost보다 먼저다. 
	 * service와 get,post를 같이 쓰는 경우는 없다 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 서비스...");
	}

}
