package class_learning;
import java.util.ArrayList;
import java.util.List;


public class Car_main 
{
	public static void main(String[] args) 
	{
		List<Car> cars = new ArrayList<>();
		
		for(int i = 0; i < 30; ++i)
		{
			Car car = new Car();
			car.setColor("보라색 : " + (int)(Math.random()*10));
			car.setName("나무꾼 : " + (int)(Math.random()*100));
			car.setWindowNumber((int)(Math.random()*1000));
			car.setDoorNumber((int)(Math.random()*10000));
			cars.add(car);
		}
		
		for(Car i : cars)
		{
			System.out.println("색상 : "+i.getColor());
			System.out.println("이름 : "+i.getName());
			System.out.println("문의 갯수 : "+i.getDoorNumber());
			System.out.println("색상 : "+i.getColor());
			System.out.println("----------------------");
		}

	}
}
