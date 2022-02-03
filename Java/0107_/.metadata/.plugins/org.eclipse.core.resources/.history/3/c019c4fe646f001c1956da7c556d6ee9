package class_learning;
import java.util.ArrayList;
import java.util.List;


public class Car_main2 
{
	public static void main(String[] args) 
	{
		Car car1 = new Car(5,5,"a","b"); // car와 car 객체는 서로 다른 메모리 공간에 위치해 있다.
		Car car2 = new Car(50,50,"aa", "bb");
		Car car3 = new Car(500,500,"aaa", "bbb");
		Car car4 = new Car(5000,5000,"aaaa", "bbbb");
		Car car5 = new Car(50000,50000,"aaaaa", "bbbbb");
		
//		/* 객체 배열 */
//		Car[] cars = new Car[5];
//		cars[0] = car1;
//		cars[1] = car2;
//		cars[2] = car3;
//		cars[3] = car4;
//		cars[4] = car5;
		
		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		
		for (Car i :cars)
		{
			System.out.println(i.color);
			System.out.println(i.name);
			System.out.println(i.doorNumber);
			System.out.println(i.windowNumber);
		}
	}
}
