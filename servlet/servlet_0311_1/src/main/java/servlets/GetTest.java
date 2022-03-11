package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/GetTest")
public class GetTest extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		System.out.println("name : " + name);
		System.out.println("phone number : " + phone);
		System.out.println("address : " + address);
		
		List<String> list = new ArrayList<String>();
		list.add(name);
		list.add(phone);
		list.add(address);
		
		System.out.println();
		System.out.println("-------list print (in get method) ------");
		for(String s : list)
			System.out.println(s);
		
	}
	
	List<Jumin> list = new ArrayList<Jumin>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Jumin a = new Jumin();
		a.setAddress(address);
		a.setName(name);
		a.setPhone(phone);
		list.add(a);
		
		System.out.println("-------list print(in post method) ------");
		for(Jumin i : list) {
			System.out.println("이름 : "+i.getName());
			System.out.println("전화번호 : "+i.getPhone());
			System.out.println("주소 : "+i.getAddress());
		}
	}
}
