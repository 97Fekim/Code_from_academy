package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetGradeServlet")
public class GetGradeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math =Integer.parseInt(request.getParameter("math"));
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(kor);
		list.add(eng);
		list.add(math);
				
		int sum = 0;
		for(int i : list)
			sum += i;
		
		sum /= list.size();
		
		System.out.println("Æò±Õ Á¡¼ö´Â : " + sum);
	}
}
