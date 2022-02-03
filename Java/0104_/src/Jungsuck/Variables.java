package Jungsuck;

public class Variables 
{
	public static void main(String[] args) 
	{
		/* 기초 자료형 */
		int a = 7;
		float f = 111.111f;
		double d = 1111.1111d;
		System.out.println(a+f+d);
		
		/* 참조 자료형 */
		Class_Truck truck1 = new Class_Truck(1, "Fe1", 1, 1);
		Class_Truck truck2 = new Class_Truck(2, "Fe2", 2, 2);
		Class_Truck truck3 = new Class_Truck(3, "Fe3", 3, 3);
		Class_Truck truck4 = new Class_Truck(4, "Fe4", 4, 4);
		
		/* 클래스 배열 */
		Class_Truck[] trucks = new Class_Truck[4];
		trucks[0] = truck1;
		trucks[1] = truck2;
		trucks[2] = truck3;
		trucks[3] = truck4;
		
		/* 클래스 배열의 멤버 출력 */
		for(int i = 0; i < 4; ++i)
		{	
			System.out.println("트럭"+ (i+1) + "의 문의 갯수 : " + trucks[i].getDoor());
			System.out.println("트럭"+ (i+1) + "의 운전자 이름 : " + trucks[i].getName());
			System.out.println("트럭"+ (i+1) + "의 가격 : " + trucks[i].getPrice());
			System.out.println("트럭"+ (i+1) + "의 핸들 : " + trucks[i].getHandle());
			System.out.println('\n');
		}
		
		for(Class_Truck i: trucks)
		{
			System.out.println(i.getDoor());
			System.out.println(i.getName());
			System.out.println(i.getPrice());
			System.out.println(i.getHandle());
			System.out.println('\n');
		}
		
		
	}
}
