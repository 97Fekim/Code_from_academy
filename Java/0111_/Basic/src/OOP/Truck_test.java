package OOP;

public class Truck_test
{

	public static void main(String[] args)
	{
		Truck truck1 = new Truck();
		
		truck1.setDriverName("Fekiaa");
		
		System.out.println(truck1.isDriverMarried());
		
		int[] nArray = new int[10];
		
		for(int i = 0; i < 10; ++i)
			nArray[i] = (int)(Math.random()*100);
		
		
	}

}
