package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ServiceDongsamuso")
public class ServiceDongsamuso extends HttpServlet {
	
	Map<Integer, Dongsamuso> getStore = new HashMap<Integer, Dongsamuso>();
	Map<Integer, Dongsamuso> postSstore = new HashMap<Integer, Dongsamuso>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int age = Integer.parseInt(request.getParameter("age"));
		int id = Integer.parseInt(request.getParameter("id"));
		String address = request.getParameter("address");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String residence = request.getParameter("residence");
		
		Dongsamuso d = new Dongsamuso();
		d.setAddress(address);
		d.setAge(age);
		d.setGender(gender);
		d.setId(id);
		d.setName(name);
		d.setResidence(residence);
		
		getStore.put(d.getId(), d);	// Map에 <주민등록번호, 주민정보> 로 입력
		
		int maleCnt = 0;
		int femaleCnt = 0;
		
		int maleSum = 0;
		int femaleSum = 0;
		for(int key : getStore.keySet())
		{
			if(getStore.get(key).getGender().equals("male")) {
				maleSum += getStore.get(key).getAge();
				maleCnt ++;
			}
			else {
				femaleSum += getStore.get(key).getAge();
				femaleCnt ++;
			}
		}
		System.out.println("--------get동사무소 저장 완료--------");
		System.out.println("남자 주민의 수 : " + maleCnt);
		System.out.println("남자 주민의 나이 총합 : " + maleSum);
		System.out.println("여자 주민의 수 : " + femaleCnt);
		System.out.println("여자 주민의 나이 총합 : " + femaleSum);
		System.out.println("-----------------------------");
		System.out.println();
		
		// 다시 홈페이지로 돌아가기		
		RequestDispatcher rd = request.getRequestDispatcher("DongsamusoHome.jsp");
		rd.forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int age = Integer.parseInt(request.getParameter("age"));
		int id = Integer.parseInt(request.getParameter("id"));
		String address = request.getParameter("address");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String residence = request.getParameter("residence");
		
		Dongsamuso d = new Dongsamuso();
		d.setAddress(address);
		d.setAge(age);
		d.setGender(gender);
		d.setId(id);
		d.setName(name);
		d.setResidence(residence);
		
		postSstore.put(d.getId(), d);
		
		int maleCnt = 0;
		int femaleCnt = 0;
		
		int maleSum = 0;
		int femaleSum = 0;
		for(int key : postSstore.keySet())
		{
			if(postSstore.get(key).getGender().equals("male")) {
				maleSum += postSstore.get(key).getAge();
				maleCnt ++;
			}
			else {
				femaleSum += postSstore.get(key).getAge();
				femaleCnt ++;
			}
		}
		
		
		System.out.println("--------post동사무소 저장 완료--------");
		System.out.println("남자 주민의 수 : " + maleCnt);
		System.out.println("남자 주민의 나이 총합 : " + maleSum);
		System.out.println("여자 주민의 수 : " + femaleCnt);
		System.out.println("여자 주민의 나이 총합 : " + femaleSum);
		System.out.println("-----------------------------");
		System.out.println();
		
		// 다시 홈페이지로 돌아가기		
		RequestDispatcher rd = request.getRequestDispatcher("DongsamusoHome.jsp");
		rd.forward(request, response);
	}

}
