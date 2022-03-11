package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import responses.HttpServletResponseUser;

@SuppressWarnings("serial")
@WebServlet("/calc")
public class CalulatorServlet extends HttpServlet {
  
	List<Integer> list = new ArrayList<>();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  int a = Integer.parseInt(request.getParameter("a"));
		  int b = Integer.parseInt(request.getParameter("b")); 
		  int c = Integer.parseInt(request.getParameter("c"));
		  response.setContentType("text/plain");
		  response.setCharacterEncoding("euc-kr"); 
		  PrintWriter writer = response.getWriter();
		  
		  // 1) 계산기 예제 
		  writer.println("a = " + a + "," + "b = " + b + " 의 계산 결과 입니다.");
		  writer.println("a + b = " + (a+b)); writer.println("a - b = " + (a-b));
		  writer.println("a * b = " + (a*b)); writer.println("a / b = " + (a/b));
		  writer.println();
		  
		  // 2) 구구단 예제 
		  for(int i=0; i<500; ++i) { 
		  		writer.println(c + " * " + (i+1) + " = " + (c*(i+1))); 
		  }
		
		  // 3) 리스트에 담아서 출력 예제 
		  list.add(a+b);
		  list.add(a-b);
		  list.add(a*b);
		  list.add(a/b);
		  for(int i : list)
			  System.out.println(i);
		  
		// 4) 
		HttpServletResponseUser response1 = new HttpServletResponseUser();
		response1.setContentType("html/css");
		response1.setCharacterEncoding("euc-kr");
		
		System.out.println("ContentType : " + response1.getContentType());
		System.out.println("CharacterEncoding : " + response1.getCharacterEncoding());
		
	
	}
}