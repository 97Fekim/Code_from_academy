package responses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/CarTest")
public class CarTest extends HttpServlet {
	
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int a = Integer.parseInt(request.getParameter("price"));
		String b = request.getParameter("name"); 
		int c = Integer.parseInt(request.getParameter("doorNumber"));
		String d = request.getParameter("driver");
		PrintWriter writer = response.getWriter();
		
		// 문제 2
//		List<Car> list = new ArrayList<Car>();
//		
//		for(int i=0; i<5; ++i)
//			list.add(new Car());
//		
//		for(int i=0; i<5; ++i) {
//			list.get(i).setName(b);
//			list.get(i).setDriver(d);
//			list.get(i).setPrice(a);
//			list.get(i).setDoorNumber(c);			
//		}
//		
//		for(Car car : list) {
//			writer.println(car.getDoorNumber());
//			writer.println(car.getName());
//			writer.println(car.getDriver());
//			writer.println(car.getPrice());
//			writer.println();
//		}
		
		// 문제3
		Car car = new Car();
		car.setDoorNumber(c);
		car.setDriver(d);
		car.setName(b);
		car.setPrice(a);
		car.setCount(++car.cur);
		
		System.out.println("name : " + car.getName());
		System.out.println("Driver : " + car.getDriver());
		System.out.println("doornumber : " + car.getDoorNumber());
		System.out.println("price : " + car.getPrice());
		System.out.println("count : " + car.getCount());
		System.out.println();

		
	}
}
